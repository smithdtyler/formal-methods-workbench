package com.rockwellcollins.atc.agree.analysis.views;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import jkind.api.results.AnalysisResult;
import jkind.api.results.PropertyResult;
import jkind.api.ui.AnalysisResultTree;
import jkind.excel.Layout;
import jkind.lustre.Program;
import jkind.lustre.values.Value;
import jkind.results.Counterexample;
import jkind.results.InvalidProperty;
import jkind.results.Signal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.osate.aadl2.ComponentImplementation;
import org.osate.ui.dialogs.Dialog;

import com.rockwellcollins.atc.agree.agree.AgreeSubclause;
import com.rockwellcollins.atc.agree.analysis.Util;

public class AgreeMenuListener implements IMenuListener {
    private static GlobalURIEditorOpener globalURIEditorOpener = Util.getGlobalURIEditorOpener();
    private AnalysisResultTree tree;
    private AgreeResultsLinker linker;

    public AgreeMenuListener(AnalysisResultTree tree) {
        this.tree = tree;
    }

    public void setLinker(AgreeResultsLinker linker) {
        this.linker = linker;
    }

    @Override
    public void menuAboutToShow(IMenuManager manager) {
        IStructuredSelection selection = (IStructuredSelection) tree.getViewer().getSelection();
        if (!selection.isEmpty()) {
            AnalysisResult result = (AnalysisResult) selection.getFirstElement();
            addLinkedMenus(manager, result);
        }
    }

    private void addLinkedMenus(IMenuManager manager, AnalysisResult result) {
        ComponentImplementation ci = linker.getComponent(result);
        if (ci != null) {
            manager.add(createHyperlinkAction("Open " + ci.getName(), ci));
        }

        AgreeSubclause contract = linker.getContract(result);
        if (contract != null) {
            manager.add(createHyperlinkAction("Open Contract", contract));
        }

        final String log = linker.getLog(result);
        if (log != null && !log.isEmpty()) {
            manager.add(createWriteConsoleAction("View Log", "Log", log));
        }

        final Program program = linker.getProgram(result);
        if (program != null) {
            manager.add(createWriteConsoleAction("View Lustre", "Lustre", program));
        }

        if (result instanceof PropertyResult) {
            PropertyResult pr = (PropertyResult) result;
            if (pr.getProperty() instanceof InvalidProperty) {
                InvalidProperty ip = (InvalidProperty) pr.getProperty();
                final Counterexample cex = ip.getCounterexample();
                final Layout layout = linker.getLayout(pr.getParent());
                final Map<String, EObject> refMap = linker.getReferenceMap(pr.getParent());

                manager.add(new Action("View Counterexample in Console") {
                    @Override
                    public void run() {
                        viewCexConsole(cex, layout, refMap);
                    }
                });

                manager.add(new Action("View Counterexample in Spreadsheet") {
                    @Override
                    public void run() {
                        viewCexSpreadsheet(cex, layout);
                    }
                });
            }
        }
    }

    private IAction createHyperlinkAction(String text, final EObject eObject) {
        return new Action(text) {
            @Override
            public void run() {
                globalURIEditorOpener.open(EcoreUtil.getURI(eObject), true);
            }
        };
    }

    private Action createWriteConsoleAction(String actionName, final String consoleName,
            final Object content) {
        return new Action(actionName) {
            @Override
            public void run() {
                MessageConsole console = findConsole(consoleName);
                showConsole(console);
                console.clearConsole();
                console.newMessageStream().println(content.toString());
            }
        };
    }

    private void viewCexConsole(Counterexample cex, Layout layout, Map<String, EObject> refMap) {
        MessageConsole console = findConsole("Counterexample");
        showConsole(console);
        console.clearConsole();
        console.addPatternMatchListener(new AgreePatternListener(refMap));
        MessageConsoleStream out = console.newMessageStream();

        for (String category : layout.getCategories()) {
            if (isEmpty(category, cex, layout)) {
                continue;
            }
            
            printHLine(out, cex.getLength());
            out.println("Variables for " + category);
            printHLine(out, cex.getLength());

            out.print(String.format("%-50s", "Variable Name"));
            for (int k = 0; k < cex.getLength(); k++) {
                out.print(String.format("%-8s", k));
            }
            out.println();
            printHLine(out, cex.getLength());

            for (Signal<Value> signal : cex.getSignals()) {
                if (category.equals(layout.getCategory(signal.getName()))) {
                    out.print(String.format("%-50s", "[" + signal.getName() + "]"));
                    for (int k = 0; k < cex.getLength(); k++) {
                        out.print(String.format("%-8s", signal.getValue(k)));
                    }
                    out.println();
                }
            }
            out.println();
        }
    }

    private boolean isEmpty(String category, Counterexample cex, Layout layout) {
        for (Signal<Value> signal : cex.getSignals()) {
            if (category.equals(layout.getCategory(signal.getName()))) {
                return false;
            }
        }
        return true;
    }

    private void printHLine(MessageConsoleStream out, int nVars) {
        out.print("--------------------------------------------------");
        for (int k = 0; k < nVars; k++) {
            out.print("-------");
        }
        out.println();
    }

    private static MessageConsole findConsole(String name) {
        ConsolePlugin plugin = ConsolePlugin.getDefault();
        IConsoleManager conMan = plugin.getConsoleManager();
        IConsole[] existing = conMan.getConsoles();
        for (int i = 0; i < existing.length; i++) {
            if (name.equals(existing[i].getName())) {
                return (MessageConsole) existing[i];
            }
        }
        // no console found, so create a new one
        MessageConsole myConsole = new MessageConsole(name, null);
        conMan.addConsoles(new IConsole[] { myConsole });
        return myConsole;
    }

    private void showConsole(IConsole console) {
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        try {
            IConsoleView view = (IConsoleView) page.showView(IConsoleConstants.ID_CONSOLE_VIEW);
            view.display(console);
            view.setScrollLock(true);
        } catch (PartInitException e) {
        }
    }

    private void viewCexSpreadsheet(Counterexample cex, Layout layout) {
        try {
            File file = File.createTempFile("cex", ".xls");
            cex.toExcel(file, layout);
            openSpreadsheet(file);
        } catch (IOException e) {
            Dialog.showError("Unable to open spreadsheet", e.getMessage());
            e.printStackTrace();
        }
    }

    private void openSpreadsheet(File file) throws IOException {
        if (System.getProperty("os.name").startsWith("Windows")) {
            /*
             * Desktop.open is slow initially on Windows, so we call explorer
             * directly instead
             */
            new ProcessBuilder("explorer", file.toString()).start();
        } else {
            Desktop.getDesktop().open(file);
        }
    }
}
