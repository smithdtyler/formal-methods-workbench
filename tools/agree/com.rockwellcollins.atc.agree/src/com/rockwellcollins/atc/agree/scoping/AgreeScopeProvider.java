/*
 * generated by Xtext
 */
package com.rockwellcollins.atc.agree.scoping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageRename;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.Subcomponent;
import org.osate.annexsupport.AnnexUtil;

import com.rockwellcollins.atc.agree.AgreeXtext;
import com.rockwellcollins.atc.agree.Nenola;
import com.rockwellcollins.atc.agree.Nenola.Contract;
import com.rockwellcollins.atc.agree.Nenola.RecordContract;
import com.rockwellcollins.atc.agree.agree.AgreeContract;
import com.rockwellcollins.atc.agree.agree.AgreeContractLibrary;
import com.rockwellcollins.atc.agree.agree.AgreeContractSubclause;
import com.rockwellcollins.atc.agree.agree.AgreePackage;
import com.rockwellcollins.atc.agree.agree.AssertEqualStatement;
import com.rockwellcollins.atc.agree.agree.ComponentRef;
import com.rockwellcollins.atc.agree.agree.ConnectionStatement;
import com.rockwellcollins.atc.agree.agree.DoubleDotRef;
import com.rockwellcollins.atc.agree.agree.EnumStatement;
import com.rockwellcollins.atc.agree.agree.EventExpr;
import com.rockwellcollins.atc.agree.agree.ExistsExpr;
import com.rockwellcollins.atc.agree.agree.FlatmapExpr;
import com.rockwellcollins.atc.agree.agree.FnDef;
import com.rockwellcollins.atc.agree.agree.FoldLeftExpr;
import com.rockwellcollins.atc.agree.agree.FoldRightExpr;
import com.rockwellcollins.atc.agree.agree.ForallExpr;
import com.rockwellcollins.atc.agree.agree.GetPropertyExpr;
import com.rockwellcollins.atc.agree.agree.InputStatement;
import com.rockwellcollins.atc.agree.agree.LibraryFnDef;
import com.rockwellcollins.atc.agree.agree.LiftStatement;
import com.rockwellcollins.atc.agree.agree.LinearizationDef;
import com.rockwellcollins.atc.agree.agree.NamedElmExpr;
import com.rockwellcollins.atc.agree.agree.NodeDef;
import com.rockwellcollins.atc.agree.agree.OrderStatement;
import com.rockwellcollins.atc.agree.agree.OutputStatement;
import com.rockwellcollins.atc.agree.agree.RecordDef;
import com.rockwellcollins.atc.agree.agree.RecordLitExpr;
import com.rockwellcollins.atc.agree.agree.RecordUpdateExpr;
import com.rockwellcollins.atc.agree.agree.SelectionExpr;
import com.rockwellcollins.atc.agree.agree.SpecStatement;
import com.rockwellcollins.atc.agree.agree.SynchStatement;
import com.rockwellcollins.atc.agree.agree.ThisRef;
import com.rockwellcollins.atc.agree.agree.TimeFallExpr;
import com.rockwellcollins.atc.agree.agree.TimeOfExpr;
import com.rockwellcollins.atc.agree.agree.TimeRiseExpr;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping on how and when
 * to use it
 *
 */
public class AgreeScopeProvider extends org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider {

	private Set<NamedElement> getNamedElementsFromSpecs(EList<SpecStatement> specs) {
		Set<NamedElement> nelms = new HashSet<>();
		for (SpecStatement spec : specs) {
			if (spec instanceof NamedElement) {
				nelms.add((NamedElement) spec);
			}

			if (spec instanceof OutputStatement) {
				OutputStatement eq = (OutputStatement) spec;
				nelms.addAll(eq.getLhs());
			} else if (spec instanceof InputStatement) {
				nelms.addAll(((InputStatement) spec).getLhs());
			} else if (spec instanceof EnumStatement) {
				nelms.addAll(((EnumStatement) spec).getEnums());
			}
		}
		return nelms;
	}


	private Set<NamedElement> getNamedElements(EObject ctx) {

		Set<NamedElement> components = new HashSet<>();
		if (ctx instanceof AadlPackage) {
			PublicPackageSection pubSec = ((AadlPackage) ctx).getPublicSection();
			for (Element el : pubSec.getOwnedElements()) {
				if (el instanceof DataImplementation || el instanceof DataType) {
					components.add((NamedElement) el);
				}
			}

			for (AnnexLibrary annex : AnnexUtil.getAllActualAnnexLibraries(((AadlPackage) ctx),
					AgreePackage.eINSTANCE.getAgreeContractLibrary())) {

				AgreeContract contract = (AgreeContract) ((AgreeContractLibrary) annex).getContract();
				components.addAll(getNamedElementsFromSpecs(contract.getSpecs()));

			}

			components.add((AadlPackage) ctx);

		} else {

			for (AnnexSubclause annex : AnnexUtil.getAllAnnexSubclauses((Classifier) ctx,
					AgreePackage.eINSTANCE.getAgreeContractSubclause())) {
				AgreeContract contract = (AgreeContract) ((AgreeContractSubclause) annex).getContract();
				components.addAll(getNamedElementsFromSpecs(contract.getSpecs()));

			}

			if (ctx instanceof ComponentImplementation) {
				components.addAll(((ComponentImplementation) ctx).getAllSubcomponents());
				components.addAll(((ComponentImplementation) ctx).getAllConnections());
				components.addAll(getNamedElements(((ComponentImplementation) ctx).getType()));

			} else if (ctx instanceof ComponentType) {
				List<Feature> fs = ((ComponentType) ctx).getAllFeatures();
				components.addAll(fs);

			}

			components.addAll(getNamedElements(getAadlContainer(ctx)));

		}

		return components;

	}


	private EObject getAadlContainer(EObject o) {

		EObject container = o.eContainer();
		if (container == null) {
			return null;
		} else if (container instanceof AadlPackage) {
			return container;
		} else if (container instanceof Classifier) {
			return container;
		} else {
			return getAadlContainer(o.eContainer());
		}
	}

	private AadlPackage getContainingPackage(EObject o) {

		EObject container = o.eContainer();
		if (container == null) {
			return null;
		} else if (container instanceof AadlPackage) {
			return (AadlPackage) container;
		} else {
			return getContainingPackage(o.eContainer());
		}
	}


	IScope scope_NamedElement(AgreeContract ctx, EReference ref) {
		EObject container = getAadlContainer(ctx);
		AadlPackage pkg = getContainingPackage(container);

		List<NamedElement> elems = new ArrayList<>();

		for (PackageRename rename : EcoreUtil2.getAllContentsOfType(pkg, PackageRename.class)) {
			if (rename.isRenameAll()) {
				AadlPackage renamedPackage = rename.getRenamedPackage();
				elems.addAll(getNamedElements(renamedPackage));
			}
		}

		elems.addAll(getNamedElements(container));

		return Scopes.scopeFor(elems, getScope(ctx.eContainer().eContainer(), ref));
	}

	IScope scope_NamedElement(NodeDef ctx, EReference ref) {
		Set<Element> components = new HashSet<>();
		components.addAll(ctx.getArgs());
		components.addAll(ctx.getRets());
		components.addAll(ctx.getNodeBody().getLocs());
		IScope outer = new FilteringScope(getScope(ctx.eContainer(), ref),
				input -> (AgreePackage.eINSTANCE.getNodeDef().isSuperTypeOf(input.getEClass())
						|| AgreePackage.eINSTANCE.getRecordDef().isSuperTypeOf(input.getEClass())
						|| AgreePackage.eINSTANCE.getConstStatement().isSuperTypeOf(input.getEClass())
						|| Aadl2Package.eINSTANCE.getAadlPackage().isSuperTypeOf(input.getEClass())
						|| Aadl2Package.eINSTANCE.getComponentClassifier().isSuperTypeOf(input.getEClass())));
		return Scopes.scopeFor(components, outer);
	}

	IScope scope_NamedElement(ConnectionStatement ctx, EReference ref) {
		EObject container = ctx.getContainingClassifier();
		IScope outerScope = IScope.NULLSCOPE;
		if (container instanceof ComponentImplementation) {
			ComponentImplementation compImpl = (ComponentImplementation) container;
			outerScope = Scopes.scopeFor(compImpl.getAllConnections(), getScope(ctx.eContainer(), ref));
		}
		return outerScope;
	}

	IScope scope_NamedElement(OrderStatement ctx, EReference ref) {
		EObject container = ctx.getContainingClassifier();

		IScope outerScope = IScope.NULLSCOPE;
		if (container instanceof ComponentImplementation) {
			ComponentImplementation compImpl = (ComponentImplementation) container;
			outerScope = Scopes.scopeFor(compImpl.getAllSubcomponents(), getScope(ctx.eContainer(), ref));
		}
		return outerScope;
	}

	IScope scope_NamedElement(SynchStatement ctx, EReference ref) {
		EObject container = ctx.getContainingClassifier();
		while (!(container instanceof ComponentClassifier)) {
			container = container.eContainer();
		}

		if (container instanceof ComponentImplementation) {
			return Scopes.scopeFor(((ComponentImplementation) container).getAllSubcomponents(),
					getScope(ctx.eContainer(), ref));
		}

		return IScope.NULLSCOPE;
	}

	IScope scope_NamedElement(FnDef ctx, EReference ref) {
		return Scopes.scopeFor(ctx.getArgs(), getScope(ctx.eContainer(), ref));
	}

	IScope scope_NamedElement(LinearizationDef ctx, EReference ref) {
		return Scopes.scopeFor(ctx.getArgs(), getScope(ctx.eContainer(), ref));
	}


	IScope scope_NamedElement(LibraryFnDef ctx, EReference ref) {
		return Scopes.scopeFor(ctx.getArgs(), getScope(ctx.eContainer(), ref));
	}

	IScope scope_NamedElement(SpecStatement ctx, EReference ref) {
		return getScope(ctx.eContainer(), ref);
	}

	IScope scope_NamedElement(AssertEqualStatement ctx, EReference ref) {
		return getScope(ctx.eContainer(), ref);
	}

	// Expressions

	private List<NamedElement> getAadlComponentElements(EObject ctx) {
		List<NamedElement> components = new ArrayList<>();
		if (ctx instanceof ComponentType) {
			components.addAll(((ComponentType) ctx).getAllFeatures());

		} else if (ctx instanceof ComponentImplementation) {
			components.addAll(((ComponentImplementation) ctx).getAllSubcomponents());
			components.addAll(((ComponentImplementation) ctx).getAllConnections());
			components.addAll(getAadlComponentElements(((ComponentImplementation) ctx).getType()));
		}
		return components;
	}

	IScope scope_NamedElement(EventExpr ctx, EReference ref) {
		EObject container = ctx.getContainingClassifier();
		return Scopes.scopeFor(getAadlComponentElements(container));
	}

	IScope scope_NamedElement(TimeOfExpr ctx, EReference ref) {
		EObject container = ctx.getContainingClassifier();
		return Scopes.scopeFor(getAadlComponentElements(container));
	}

	IScope scope_NamedElement(TimeRiseExpr ctx, EReference ref) {
		EObject container = ctx.getContainingClassifier();
		return Scopes.scopeFor(getAadlComponentElements(container));
	}

	IScope scope_NamedElement(TimeFallExpr ctx, EReference ref) {
		EObject container = ctx.getContainingClassifier();
		return Scopes.scopeFor(getAadlComponentElements(container));
	}

	IScope scope_NamedElement(ForallExpr ctx, EReference ref) {
		IScope prevScope = prevScope(ctx, ref);
		List<EObject> bs = new ArrayList<EObject>();
		bs.add(ctx.getBinding());
		for (IEObjectDescription ieod : prevScope.getAllElements()) {
			if (!ieod.getName().toString().equals(ctx.getBinding().getName())) {
				bs.add(ieod.getEObjectOrProxy());
			}
		}
		return Scopes.scopeFor(bs);
	}

	IScope scope_NamedElement(ExistsExpr ctx, EReference ref) {
		IScope prevScope = prevScope(ctx, ref);
		List<EObject> bs = new ArrayList<EObject>();
		bs.add(ctx.getBinding());
		for (IEObjectDescription ieod : prevScope.getAllElements()) {
			if (!ieod.getName().toString().equals(ctx.getBinding().getName())) {
				bs.add(ieod.getEObjectOrProxy());
			}
		}
		return Scopes.scopeFor(bs);
	}

	IScope scope_NamedElement(FlatmapExpr ctx, EReference ref) {
		IScope prevScope = prevScope(ctx, ref);
		List<EObject> bs = new ArrayList<EObject>();
		bs.add(ctx.getBinding());
		for (IEObjectDescription ieod : prevScope.getAllElements()) {
			if (!ieod.getName().toString().equals(ctx.getBinding().getName())) {
				bs.add(ieod.getEObjectOrProxy());
			}
		}
		return Scopes.scopeFor(bs);
	}

	IScope scope_NamedElement(FoldLeftExpr ctx, EReference ref) {
		IScope prevScope = prevScope(ctx, ref);

		List<EObject> bs = new ArrayList<EObject>();

		bs.add(ctx.getAccumulator());
		bs.add(ctx.getBinding());
		for (IEObjectDescription ieod : prevScope.getAllElements()) {
			if (!ieod.getName().toString().equals(ctx.getBinding().getName())
					&& !ieod.getName().toString().equals(ctx.getAccumulator().getName())) {
				bs.add(ieod.getEObjectOrProxy());
			}
		}
		return Scopes.scopeFor(bs);
	}

	IScope scope_NamedElement(FoldRightExpr ctx, EReference ref) {
		IScope prevScope = prevScope(ctx, ref);

		List<EObject> bs = new ArrayList<EObject>();

		bs.add(ctx.getAccumulator());
		bs.add(ctx.getBinding());
		for (IEObjectDescription ieod : prevScope.getAllElements()) {
			if (!ieod.getName().toString().equals(ctx.getBinding().getName())
					&& !ieod.getName().toString().equals(ctx.getAccumulator().getName())) {
				bs.add(ieod.getEObjectOrProxy());
			}
		}
		return Scopes.scopeFor(bs);
	}


	protected IScope scope_GetPropertyExpr_prop(GetPropertyExpr ctx, EReference ref) {

		IScope prevScope = prevScope(ctx, ref);

		ComponentRef cr = ctx.getComponentRef();
		if (cr instanceof ThisRef) {
			List<Property> ps = new ArrayList<>();

			EObject container = ctx.getContainingClassifier();
			while (container != null) {
				if (container instanceof Classifier) {
					List<PropertyAssociation> pas = ((Classifier) container).getAllPropertyAssociations();
					for (PropertyAssociation pa : pas) {
						ps.add(pa.getProperty());
					}
					container = ((Classifier) container).eContainer();
				} else if (container instanceof AadlPackage) {
					for (PropertySet propSet : EcoreUtil2.getAllContentsOfType(container, PropertySet.class)) {
						for (Property p : propSet.getOwnedProperties()) {
							ps.add(p);
						}
//								=======
//										EList<EObject> refs  = null;
//
//								if (container instanceof NestedDotID) {
//									NestedDotID parent = (NestedDotID) container;
//									refs = parent.eCrossReferences();
//
//									if (refs.size() != 1) {
//										return new HashSet<>(); // this will throw a parsing error
//									}
//									container = refs.get(0); // figure out what this type this portion
//
//									// of the nest id is so we can figure out
//									// what we could possibly link to
//
//									if (container instanceof ThreadSubcomponent) {
//										container = ((ThreadSubcomponent) container).getComponentType();
//										result.addAll(getAadlElements(container));
//									} else if (container instanceof Subcomponent) {
//										container = ((Subcomponent) container).getComponentImplementation();
//										if (container == null) { // no implementation is provided
//											container = refs.get(0);
//											container = ((Subcomponent) container).getClassifier();
//										}
//										result.addAll(getAadlElements(container));
//									} else if (container instanceof DataPort) {
//										container = ((DataPort) container).getDataFeatureClassifier();
//										result.addAll(getAadlElements(container));
//									} else if (container instanceof EventDataPort) {
//										container = ((EventDataPort) container).getDataFeatureClassifier();
//										result.addAll(getAadlElements(container));
//									} else if (container instanceof AadlPackage) {
//										result.addAll(getAadlElements(container));
//									} else if (container instanceof FeatureGroupImpl) {
//										container = ((FeatureGroupImpl) container).getAllFeatureGroupType();
//										result.addAll(getAadlElements(container));
//									} else if (container instanceof Arg || container instanceof ConstStatement) {
//										Type type;
//
//										if (container instanceof Arg) {
//											type = ((Arg) container).getType();
//										} else {
//											type = ((ConstStatement) container).getType();
//										}
//
//										if (type instanceof RecordType) {
//											DoubleDotRef elID = ((RecordType) type).getRecord();
//											NamedElement namedEl = elID.getElm();
//
//											if (namedEl instanceof ComponentImplementation) {
//												ComponentImplementation componentImplementation = (ComponentImplementation) namedEl;
//												EList<Subcomponent> subs = componentImplementation.getAllSubcomponents();
//												result.addAll(subs);
//											} else if (namedEl instanceof RecordDefExpr) {
//												result.addAll(((RecordDefExpr) namedEl).getArgs());
//												>>>>>>> origin/develop
					}
					container = null;
				} else {
					container = container.eContainer();
				}
			}

			return Scopes.scopeFor(ps, prevScope);

		} else if (cr instanceof DoubleDotRef) {
			NamedElement ne = ((DoubleDotRef) cr).getElm();
			if (ne instanceof Subcomponent) {
				List<PropertyAssociation> pas = ((Subcomponent) ne).getOwnedPropertyAssociations();
				List<Property> ps = new ArrayList<>();
				for (PropertyAssociation pa : pas) {
					ps.add(pa.getProperty());
				}
				return Scopes.scopeFor(ps, prevScope);
			}
		}

		return IScope.NULLSCOPE;
	}


	protected IScope scope_DoubleDotRef_elm(DoubleDotRef ctx, EReference ref) {

		IScope prevScope = prevScope(ctx, ref);
		EObject container = ((GetPropertyExpr) ctx.eContainer()).getContainingComponentImpl();
		if (container instanceof ComponentImplementation) {
			return Scopes.scopeFor(((ComponentImplementation) ctx).getAllSubcomponents(), prevScope);
		}
		return prevScope;
	}



	private List<NamedElement> getFieldsOfNE(NamedElement leaf) {

		if (leaf instanceof RecordDef) {
			List<NamedElement> result = new LinkedList<>();
			result.addAll(((RecordDef) leaf).getArgs());
			return result;

		} else if (leaf instanceof DataImplementation) {
			List<NamedElement> result = new LinkedList<>();
			ComponentImplementation componentImplementation = (ComponentImplementation) leaf;
			List<Subcomponent> subs = componentImplementation.getAllSubcomponents();
			result.addAll(subs);
			return result;

		} else {

			return new ArrayList<NamedElement>(getNamedElements(leaf));

		}

	}



	IScope scope_RecordLitExpr_args(RecordLitExpr ctx, EReference ref) {
		IScope prevScope = prevScope(ctx, ref);
		NamedElement recDef = ctx.getRecordType().getElm();
		Set<Element> components = new HashSet<>();
		if (recDef instanceof DataImplementation) {
			components.addAll(((DataImplementation) recDef).getAllSubcomponents());
			return Scopes.scopeFor(components, prevScope);
		} else if (recDef instanceof RecordDef) {
			components.addAll(((RecordDef) recDef).getArgs());
			return Scopes.scopeFor(components, prevScope);
		}
		return prevScope;
	}

	IScope scope_RecordUpdateExpr_key(RecordUpdateExpr ctx, EReference ref) {
		IScope prevScope = prevScope(ctx, ref);
		Contract typ = AgreeXtext.inferContract(ctx.getRecord());
		if (typ instanceof RecordContract) {
			NamedElement ne = ((RecordContract) typ).namedElement;
			return Scopes.scopeFor(getFieldsOfNE(ne), prevScope);
		} else {
			return IScope.NULLSCOPE;
		}
	}

	private IScope prevScope(EObject ctx, EReference ref) {
		EObject container = ctx.eContainer();
		while (container instanceof SelectionExpr) {
			container = container.eContainer();
		}
		IScope prevScope = getScope(container, ref);
		return prevScope;

	}

	protected IScope scope_NamedElmExpr_elm(NamedElmExpr ctx, EReference ref) {
		return prevScope(ctx, ref);
	}

	protected IScope scope_SelectionExpr_field(SelectionExpr ctx, EReference ref) {

		Contract typ = AgreeXtext.inferContract(ctx.getTarget());

		if (typ instanceof RecordContract) {
			NamedElement ne = ((RecordContract) typ).namedElement;
			return Scopes.scopeFor(getFieldsOfNE(ne));
		} else if (typ instanceof Nenola.NodeContract) {
			NamedElement ne = ((Nenola.NodeContract) typ).namedElement;
			return Scopes.scopeFor(getFieldsOfNE(ne));

		}


		return IScope.NULLSCOPE;

	}



	IScope scope_LiftStatement_subcomp(LiftStatement ctx, EReference ref) {
		IScope prevScope = prevScope(ctx, ref);
		ComponentImplementation container = ctx.getContainingComponentImpl();
		return Scopes.scopeFor(container.getAllSubcomponents(), prevScope);
	}




}
