/*
 * generated by Xtext 2.11.0
 */
package edu.uah.rsesc.aadlsimulator.xtext.ui;

import com.google.inject.Injector;
import edu.uah.rsesc.aadlsimulator.xtext.ui.internal.XtextActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class InputConstraintExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return XtextActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return XtextActivator.getInstance().getInjector(XtextActivator.EDU_UAH_RSESC_AADLSIMULATOR_XTEXT_INPUTCONSTRAINT);
	}
	
}