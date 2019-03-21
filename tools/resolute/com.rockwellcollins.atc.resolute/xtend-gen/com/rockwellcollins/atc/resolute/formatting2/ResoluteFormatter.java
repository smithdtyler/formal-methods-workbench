/**
 * generated by Xtext
 */
package com.rockwellcollins.atc.resolute.formatting2;

import com.google.inject.Inject;
import com.rockwellcollins.atc.resolute.resolute.AnalysisStatement;
import com.rockwellcollins.atc.resolute.resolute.Arg;
import com.rockwellcollins.atc.resolute.resolute.BaseType;
import com.rockwellcollins.atc.resolute.resolute.BinaryExpr;
import com.rockwellcollins.atc.resolute.resolute.BoolExpr;
import com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.CastExpr;
import com.rockwellcollins.atc.resolute.resolute.ClaimBody;
import com.rockwellcollins.atc.resolute.resolute.ClaimText;
import com.rockwellcollins.atc.resolute.resolute.ConstantDefinition;
import com.rockwellcollins.atc.resolute.resolute.Definition;
import com.rockwellcollins.atc.resolute.resolute.Expr;
import com.rockwellcollins.atc.resolute.resolute.FailExpr;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionBody;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr;
import com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr;
import com.rockwellcollins.atc.resolute.resolute.IntExpr;
import com.rockwellcollins.atc.resolute.resolute.LetBinding;
import com.rockwellcollins.atc.resolute.resolute.LetExpr;
import com.rockwellcollins.atc.resolute.resolute.ListExpr;
import com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr;
import com.rockwellcollins.atc.resolute.resolute.ListType;
import com.rockwellcollins.atc.resolute.resolute.NestedDotID;
import com.rockwellcollins.atc.resolute.resolute.ProveStatement;
import com.rockwellcollins.atc.resolute.resolute.QuantArg;
import com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr;
import com.rockwellcollins.atc.resolute.resolute.RealExpr;
import com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary;
import com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause;
import com.rockwellcollins.atc.resolute.resolute.SetExpr;
import com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr;
import com.rockwellcollins.atc.resolute.resolute.SetType;
import com.rockwellcollins.atc.resolute.resolute.StringExpr;
import com.rockwellcollins.atc.resolute.resolute.ThisExpr;
import com.rockwellcollins.atc.resolute.resolute.UnaryExpr;
import com.rockwellcollins.atc.resolute.services.ResoluteGrammarAccess;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.xtext.aadl2.properties.formatting2.PropertiesFormatter;

@SuppressWarnings("all")
public class ResoluteFormatter extends PropertiesFormatter {
  @Inject
  @Extension
  private ResoluteGrammarAccess _resoluteGrammarAccess;
  
  protected void _format(final ResoluteLibrary resolutelibrary, @Extension final IFormattableDocument document) {
    int i = 0;
    EList<Definition> _definitions = resolutelibrary.getDefinitions();
    for (final Definition definitions : _definitions) {
      {
        if ((i != 0)) {
          final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
            it.setNewLines(2);
          };
          document.<Definition>prepend(definitions, _function);
        }
        this.format(definitions, document);
        i = (i + 1);
      }
    }
  }
  
  protected void _format(final ListType listtype, @Extension final IFormattableDocument document) {
    this.format(listtype.getType(), document);
  }
  
  protected void _format(final SetType settype, @Extension final IFormattableDocument document) {
    this.format(settype.getType(), document);
  }
  
  protected void _format(final BaseType basetype, @Extension final IFormattableDocument document) {
    this.format(basetype.getParamType(), document);
  }
  
  protected void _format(final Arg arg, @Extension final IFormattableDocument document) {
    this.format(arg.getType(), document);
  }
  
  protected void _format(final QuantArg quantarg, @Extension final IFormattableDocument document) {
    this.format(quantarg.getExpr(), document);
  }
  
  protected void _format(final ConstantDefinition constantdefinition, @Extension final IFormattableDocument document) {
    this.format(constantdefinition.getType(), document);
    this.format(constantdefinition.getExpr(), document);
  }
  
  protected void _format(final FunctionDefinition functiondefinition, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(document.prepend(this.textRegionExtensions.regionFor(functiondefinition).keyword("("), _function), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.surround(this.textRegionExtensions.regionFor(functiondefinition).keyword(")"), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
      it.noSpace();
    };
    document.prepend(this.textRegionExtensions.regionFor(functiondefinition).keyword(","), _function_3);
    EList<Arg> _args = functiondefinition.getArgs();
    for (final Arg args : _args) {
      this.format(args, document);
    }
    this.format(functiondefinition.getBody(), document);
  }
  
  protected void _format(final FunctionBody functionbody, @Extension final IFormattableDocument document) {
    this.format(functionbody.getType(), document);
    this.format(functionbody.getExpr(), document);
  }
  
  protected void _format(final ClaimBody claimbody, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setNewLines(1);
    };
    document.append(this.textRegionExtensions.regionFor(claimbody).keyword("<="), _function);
    EList<ClaimText> _claim = claimbody.getClaim();
    for (final ClaimText claim : _claim) {
      this.format(claim, document);
    }
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.setNewLines(1);
    };
    document.<Expr>prepend(claimbody.getExpr(), _function_1);
    this.format(claimbody.getExpr(), document);
  }
  
  protected void _format(final BinaryExpr binaryexpr, @Extension final IFormattableDocument document) {
    this.format(binaryexpr.getRight(), document);
    this.format(binaryexpr.getLeft(), document);
  }
  
  protected void _format(final InstanceOfExpr instanceofexpr, @Extension final IFormattableDocument document) {
    this.format(instanceofexpr.getType(), document);
    this.format(instanceofexpr.getExpr(), document);
  }
  
  protected void _format(final UnaryExpr unaryexpr, @Extension final IFormattableDocument document) {
    this.format(unaryexpr.getExpr(), document);
  }
  
  protected void _format(final CastExpr castexpr, @Extension final IFormattableDocument document) {
    this.format(castexpr.getType(), document);
    this.format(castexpr.getExpr(), document);
  }
  
  protected void _format(final ThisExpr thisexpr, @Extension final IFormattableDocument document) {
    this.format(thisexpr.getSub(), document);
  }
  
  protected void _format(final FailExpr failexpr, @Extension final IFormattableDocument document) {
    this.format(failexpr.getVal(), document);
    EList<ClaimText> _failmsg = failexpr.getFailmsg();
    for (final ClaimText failmsg : _failmsg) {
      this.format(failmsg, document);
    }
  }
  
  protected void _format(final IntExpr intexpr, @Extension final IFormattableDocument document) {
    this.format(intexpr.getVal(), document);
  }
  
  protected void _format(final RealExpr realexpr, @Extension final IFormattableDocument document) {
    this.format(realexpr.getVal(), document);
  }
  
  protected void _format(final BoolExpr boolexpr, @Extension final IFormattableDocument document) {
    this.format(boolexpr.getVal(), document);
  }
  
  protected void _format(final StringExpr stringexpr, @Extension final IFormattableDocument document) {
    this.format(stringexpr.getVal(), document);
  }
  
  protected void _format(final IfThenElseExpr ifthenelseexpr, @Extension final IFormattableDocument document) {
    this.format(ifthenelseexpr.getCond(), document);
    this.format(ifthenelseexpr.getThen(), document);
    this.format(ifthenelseexpr.getElse(), document);
  }
  
  protected void _format(final QuantifiedExpr quantifiedexpr, @Extension final IFormattableDocument document) {
    EList<Arg> _args = quantifiedexpr.getArgs();
    for (final Arg args : _args) {
      this.format(args, document);
    }
    this.format(quantifiedexpr.getExpr(), document);
  }
  
  protected void _format(final BuiltInFnCallExpr builtinfncallexpr, @Extension final IFormattableDocument document) {
    EList<Expr> _args = builtinfncallexpr.getArgs();
    for (final Expr args : _args) {
      this.format(args, document);
    }
  }
  
  protected void _format(final FnCallExpr fncallexpr, @Extension final IFormattableDocument document) {
    EList<Expr> _args = fncallexpr.getArgs();
    for (final Expr args : _args) {
      this.format(args, document);
    }
  }
  
  protected void _format(final ListFilterMapExpr listfiltermapexpr, @Extension final IFormattableDocument document) {
    EList<Arg> _args = listfiltermapexpr.getArgs();
    for (final Arg args : _args) {
      this.format(args, document);
    }
    this.format(listfiltermapexpr.getFilter(), document);
    this.format(listfiltermapexpr.getMap(), document);
  }
  
  protected void _format(final ListExpr listexpr, @Extension final IFormattableDocument document) {
    EList<Expr> _exprs = listexpr.getExprs();
    for (final Expr exprs : _exprs) {
      this.format(exprs, document);
    }
  }
  
  protected void _format(final SetFilterMapExpr setfiltermapexpr, @Extension final IFormattableDocument document) {
    EList<Arg> _args = setfiltermapexpr.getArgs();
    for (final Arg args : _args) {
      this.format(args, document);
    }
    this.format(setfiltermapexpr.getFilter(), document);
    this.format(setfiltermapexpr.getMap(), document);
  }
  
  protected void _format(final SetExpr setexpr, @Extension final IFormattableDocument document) {
    EList<Expr> _exprs = setexpr.getExprs();
    for (final Expr exprs : _exprs) {
      this.format(exprs, document);
    }
  }
  
  protected void _format(final LetExpr letexpr, @Extension final IFormattableDocument document) {
    this.format(letexpr.getBinding(), document);
    this.format(letexpr.getExpr(), document);
  }
  
  protected void _format(final LetBinding letbinding, @Extension final IFormattableDocument document) {
    this.format(letbinding.getType(), document);
    this.format(letbinding.getExpr(), document);
  }
  
  protected void _format(final ResoluteSubclause resolutesubclause, @Extension final IFormattableDocument document) {
    EList<AnalysisStatement> _proves = resolutesubclause.getProves();
    for (final AnalysisStatement proves : _proves) {
      {
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.setNewLines(1);
        };
        document.<AnalysisStatement>surround(proves, _function);
        this.format(proves, document);
      }
    }
  }
  
  protected void _format(final NestedDotID nesteddotid, @Extension final IFormattableDocument document) {
    this.format(nesteddotid.getSub(), document);
  }
  
  protected void _format(final ProveStatement provestatement, @Extension final IFormattableDocument document) {
    this.format(provestatement.getExpr(), document);
  }
  
  public void format(final Object resolutesubclause, final IFormattableDocument document) {
    if (resolutesubclause instanceof ResoluteSubclause) {
      _format((ResoluteSubclause)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof IntegerLiteral) {
      _format((IntegerLiteral)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof RealLiteral) {
      _format((RealLiteral)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ConstantDefinition) {
      _format((ConstantDefinition)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof FunctionDefinition) {
      _format((FunctionDefinition)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof QuantArg) {
      _format((QuantArg)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ResoluteLibrary) {
      _format((ResoluteLibrary)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ClassifierValue) {
      _format((ClassifierValue)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ComputedValue) {
      _format((ComputedValue)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ModalPropertyValue) {
      _format((ModalPropertyValue)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof RangeValue) {
      _format((RangeValue)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof RecordValue) {
      _format((RecordValue)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ReferenceValue) {
      _format((ReferenceValue)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof Arg) {
      _format((Arg)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof BinaryExpr) {
      _format((BinaryExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof BoolExpr) {
      _format((BoolExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof BuiltInFnCallExpr) {
      _format((BuiltInFnCallExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof CastExpr) {
      _format((CastExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ClaimBody) {
      _format((ClaimBody)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof FailExpr) {
      _format((FailExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof FnCallExpr) {
      _format((FnCallExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof FunctionBody) {
      _format((FunctionBody)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof IfThenElseExpr) {
      _format((IfThenElseExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof InstanceOfExpr) {
      _format((InstanceOfExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof IntExpr) {
      _format((IntExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof LetBinding) {
      _format((LetBinding)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof LetExpr) {
      _format((LetExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ListExpr) {
      _format((ListExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ListFilterMapExpr) {
      _format((ListFilterMapExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ProveStatement) {
      _format((ProveStatement)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof QuantifiedExpr) {
      _format((QuantifiedExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof RealExpr) {
      _format((RealExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof SetExpr) {
      _format((SetExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof SetFilterMapExpr) {
      _format((SetFilterMapExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof StringExpr) {
      _format((StringExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ThisExpr) {
      _format((ThisExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof UnaryExpr) {
      _format((UnaryExpr)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ListValue) {
      _format((ListValue)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof Operation) {
      _format((Operation)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof XtextResource) {
      _format((XtextResource)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ArrayRange) {
      _format((ArrayRange)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof BasicPropertyAssociation) {
      _format((BasicPropertyAssociation)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ContainmentPathElement) {
      _format((ContainmentPathElement)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof BaseType) {
      _format((BaseType)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof ListType) {
      _format((ListType)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof SetType) {
      _format((SetType)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof NestedDotID) {
      _format((NestedDotID)resolutesubclause, document);
      return;
    } else if (resolutesubclause instanceof EObject) {
      _format((EObject)resolutesubclause, document);
      return;
    } else if (resolutesubclause == null) {
      _format((Void)null, document);
      return;
    } else if (resolutesubclause != null) {
      _format(resolutesubclause, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(resolutesubclause, document).toString());
    }
  }
}