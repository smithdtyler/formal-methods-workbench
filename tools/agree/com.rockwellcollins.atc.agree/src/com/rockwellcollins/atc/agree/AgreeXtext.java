package com.rockwellcollins.atc.agree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.ArraySizeProperty;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DataType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Port;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent;
import org.osate.annexsupport.AnnexUtil;

import com.rockwellcollins.atc.agree.Agree.ArraySpec;
import com.rockwellcollins.atc.agree.Agree.EnumSpec;
import com.rockwellcollins.atc.agree.Agree.Prim;
import com.rockwellcollins.atc.agree.Agree.RangeIntSpec;
import com.rockwellcollins.atc.agree.Agree.RangeRealSpec;
import com.rockwellcollins.atc.agree.Agree.RecordSpec;
import com.rockwellcollins.atc.agree.Agree.Spec;
import com.rockwellcollins.atc.agree.agree.AgreeContract;
import com.rockwellcollins.atc.agree.agree.AgreeContractSubclause;
import com.rockwellcollins.atc.agree.agree.AgreePackage;
import com.rockwellcollins.atc.agree.agree.Arg;
import com.rockwellcollins.atc.agree.agree.ArrayLiteralExpr;
import com.rockwellcollins.atc.agree.agree.ArraySubExpr;
import com.rockwellcollins.atc.agree.agree.ArrayType;
import com.rockwellcollins.atc.agree.agree.ArrayUpdateExpr;
import com.rockwellcollins.atc.agree.agree.BinaryExpr;
import com.rockwellcollins.atc.agree.agree.BoolLitExpr;
import com.rockwellcollins.atc.agree.agree.CallExpr;
import com.rockwellcollins.atc.agree.agree.ComponentRef;
import com.rockwellcollins.atc.agree.agree.ConstStatement;
import com.rockwellcollins.atc.agree.agree.DoubleDotRef;
import com.rockwellcollins.atc.agree.agree.EnumLitExpr;
import com.rockwellcollins.atc.agree.agree.EnumStatement;
import com.rockwellcollins.atc.agree.agree.EqStatement;
import com.rockwellcollins.atc.agree.agree.EventExpr;
import com.rockwellcollins.atc.agree.agree.ExistsExpr;
import com.rockwellcollins.atc.agree.agree.Expr;
import com.rockwellcollins.atc.agree.agree.FlatmapExpr;
import com.rockwellcollins.atc.agree.agree.FloorCast;
import com.rockwellcollins.atc.agree.agree.FnDef;
import com.rockwellcollins.atc.agree.agree.FoldLeftExpr;
import com.rockwellcollins.atc.agree.agree.FoldRightExpr;
import com.rockwellcollins.atc.agree.agree.ForallExpr;
import com.rockwellcollins.atc.agree.agree.GetPropertyExpr;
import com.rockwellcollins.atc.agree.agree.IfThenElseExpr;
import com.rockwellcollins.atc.agree.agree.IndicesExpr;
import com.rockwellcollins.atc.agree.agree.InputStatement;
import com.rockwellcollins.atc.agree.agree.IntLitExpr;
import com.rockwellcollins.atc.agree.agree.LatchedExpr;
import com.rockwellcollins.atc.agree.agree.LibraryFnDef;
import com.rockwellcollins.atc.agree.agree.LinearizationDef;
import com.rockwellcollins.atc.agree.agree.NamedElmExpr;
import com.rockwellcollins.atc.agree.agree.NamedID;
import com.rockwellcollins.atc.agree.agree.NodeDef;
import com.rockwellcollins.atc.agree.agree.PreExpr;
import com.rockwellcollins.atc.agree.agree.PrevExpr;
import com.rockwellcollins.atc.agree.agree.PrimType;
import com.rockwellcollins.atc.agree.agree.PropertyStatement;
import com.rockwellcollins.atc.agree.agree.RealCast;
import com.rockwellcollins.atc.agree.agree.RealLitExpr;
import com.rockwellcollins.atc.agree.agree.RecordDef;
import com.rockwellcollins.atc.agree.agree.RecordLitExpr;
import com.rockwellcollins.atc.agree.agree.RecordUpdateExpr;
import com.rockwellcollins.atc.agree.agree.SelectionExpr;
import com.rockwellcollins.atc.agree.agree.SpecStatement;
import com.rockwellcollins.atc.agree.agree.TagExpr;
import com.rockwellcollins.atc.agree.agree.ThisRef;
import com.rockwellcollins.atc.agree.agree.TimeExpr;
import com.rockwellcollins.atc.agree.agree.TimeFallExpr;
import com.rockwellcollins.atc.agree.agree.TimeOfExpr;
import com.rockwellcollins.atc.agree.agree.TimeRiseExpr;
import com.rockwellcollins.atc.agree.agree.Type;
import com.rockwellcollins.atc.agree.agree.UnaryExpr;

public class AgreeXtext {

	public static Spec toSpec(Type t) {

		if (t instanceof PrimType) {

			int lowSign = ((PrimType) t).getLowNeg() == null ? 1 : -1;
			int highSign = ((PrimType) t).getHighNeg() == null ? 1 : -1;

			String lowStr = ((PrimType) t).getRangeLow();
			String highStr = ((PrimType) t).getRangeHigh();

			if (((PrimType) t).getName().equals("int")) {
				if (lowStr == null || highStr == null) {
					return Prim.IntSpec;
				} else {

					long low = Long.valueOf(lowStr) * lowSign;
					long high = Long.valueOf(highStr) * highSign;
					return new RangeIntSpec(low, high);
				}
			} else if (((PrimType) t).getName().equals("real")) {
				if (lowStr == null || highStr == null) {
					return Prim.RealSpec;
				} else {
					double low = Double.valueOf(lowStr) * lowSign;
					double high = Double.valueOf(highStr) * highSign;
					return new RangeRealSpec(low, high);
				}
			} else if (((PrimType) t).getName().equals("bool")) {
				return Prim.BoolSpec;
			} else {
				return Prim.ErrorSpec;
			}

		} else if (t instanceof ArrayType) {
			String size = ((ArrayType) t).getSize();
			Spec baseTypeDef = toSpec(((ArrayType) t).getStem());

			return new ArraySpec(baseTypeDef, Integer.parseInt(size), Optional.empty());

		} else if (t instanceof DoubleDotRef) {
			return toSpecFromNamedElm(((DoubleDotRef) t).getElm());
		} else {
			return Prim.ErrorSpec;
		}

	}

	public static Spec toSpecFromNamedElm(NamedElement ne) {
		if (ne instanceof Classifier) {
			return toSpecFromClassifier((Classifier) ne);

		} else if (ne instanceof RecordDef) {

			EList<Arg> args = ((RecordDef) ne).getArgs();
			List<Agree.Field> fields = new ArrayList<>();
			for (Arg arg : args) {
				String key = arg.getName();
				Spec typeDef = toSpec(arg.getType());
				fields.add(new Agree.Field(arg.getName(), typeDef, Optional.empty()));
			}

			return new RecordSpec(ne.getQualifiedName(), Agree.Topo.Data, fields, ne);

		} else if (ne instanceof EnumStatement) {
			String name = ne.getQualifiedName();
			List<String> enumValues = new ArrayList<String>();

			for (NamedID nid : ((EnumStatement) ne).getEnums()) {
				String enumValue = name + "_" + nid.getName();
				enumValues.add(enumValue);
			}
			return new EnumSpec(name, enumValues, ne);

		} else if (ne instanceof Arg) {
			return toSpec(((Arg) ne).getType());

		} else {
			return Prim.ErrorSpec;
		}
	}

	public static Spec toSpecFromClassifier(Classifier c) {

		if (c instanceof AadlBoolean || c.getName().contains("Boolean")) {
			return Prim.BoolSpec;
		} else if (c instanceof AadlInteger || c.getName().contains("Integer") || c.getName().contains("Natural")
				|| c.getName().contains("Unsigned")) {
			return Prim.IntSpec;
		} else if (c instanceof AadlReal || c.getName().contains("Float")) {
			return Prim.RealSpec;
		} else if (c instanceof DataType) {
			Classifier ext = c.getExtended();
			if (ext != null && (ext instanceof AadlInteger || ext.getName().contains("Integer")
					|| ext.getName().contains("Natural") || ext.getName().contains("Unsigned"))) {

				List<PropertyAssociation> pas = c.getAllPropertyAssociations();
				for (PropertyAssociation choice : pas) {
					Property p = choice.getProperty();

					PropertyExpression v = choice.getOwnedValues().get(0).getOwnedValue();

					String key = p.getQualifiedName();

					if (key.equals("Data_Model::Integer_Range")) {
						if (v instanceof RangeValue) {
							try {
								RangeValue rangeValue = (RangeValue) v;
								long min = intFromPropExp(rangeValue.getMinimum()).get();
								long max = intFromPropExp(rangeValue.getMaximum()).get();
								return new RangeIntSpec(min, max);
							} catch (Exception e) {
								return Prim.ErrorSpec;
							}
						}
					}
				}
				return Prim.IntSpec;

			} else if (ext != null && (ext instanceof AadlReal || ext.getName().contains("Float"))) {

				List<PropertyAssociation> pas = c.getAllPropertyAssociations();
				for (PropertyAssociation choice : pas) {
					Property p = choice.getProperty();

					PropertyExpression v = choice.getOwnedValues().get(0).getOwnedValue();

					String key = p.getQualifiedName();

					if (key.equals("Data_Model::Real_Range")) {
						if (v instanceof RangeValue) {
							try {
								RangeValue rangeValue = (RangeValue) v;
								double min = realFromPropExp(rangeValue.getMinimum()).get();
								double max = realFromPropExp(rangeValue.getMaximum()).get();
								return new RangeRealSpec(min, max);
							} catch (Exception e) {
								return Prim.ErrorSpec;
							}
						}
					}
				}
				return Prim.RealSpec;
			}

			List<PropertyAssociation> pas = c.getAllPropertyAssociations();

			boolean prop_isArray = false;
			int prop_arraySize = 0;
			Spec prop_arrayBaseType = null;

			boolean prop_isEnum = false;
			List<String> prop_enumValues = null;

			for (PropertyAssociation choice : pas) {
				Property p = choice.getProperty();

				PropertyExpression v = choice.getOwnedValues().get(0).getOwnedValue();

				String key = p.getQualifiedName();

				if (key.equals("Data_Model::Data_Representation")) {
					if (v instanceof NamedValue) {
						AbstractNamedValue anv = ((NamedValue) v).getNamedValue();
						if (anv instanceof EnumerationLiteral) {
							EnumerationLiteral el = (EnumerationLiteral) anv;
							prop_isArray = el.getName().equals("Array");
							prop_isEnum = el.getName().equals("Enum");
						}
					}

				} else if (key.equals("Data_Model::Enumerators")) {
					if (v instanceof ListValue) {
						EList<PropertyExpression> peList = ((ListValue) v).getOwnedListElements();
						String prefix = c.getQualifiedName() + "_";
						prop_enumValues = new ArrayList<>();
						for (PropertyExpression pe : peList) {
							if (pe instanceof StringLiteral) {
								String enumString = prefix + ((StringLiteral) pe).getValue();
								prop_enumValues.add(enumString);
							}
						}
					}

				} else if (key.equals("Data_Model::Base_Type")) {
					if (v instanceof ListValue) {
						ListValue l = (ListValue) v;
						PropertyExpression pe = l.getOwnedListElements().get(0);
						if (pe instanceof ClassifierValue) {
							prop_arrayBaseType = toSpecFromClassifier(((ClassifierValue) pe).getClassifier());
						}

					}

				} else if (key.equals("Data_Model::Dimension")) {
					if (v instanceof ListValue) {
						ListValue l = (ListValue) v;
						PropertyExpression pe = l.getOwnedListElements().get(0);
						prop_arraySize = Math.toIntExact(intFromPropExp(pe).orElse((long) -1).longValue());

					}
				}

			}

			if (prop_isArray && prop_arraySize > 0 && prop_arrayBaseType != null) {

				return new ArraySpec(prop_arrayBaseType, prop_arraySize, Optional.of(c));

			} else if (prop_isEnum && prop_enumValues != null) {
				String name = c.getQualifiedName();
				return new EnumSpec(name, prop_enumValues, c);

			}

		} else if (c instanceof ComponentClassifier) {


			Agree.Topo topo = Agree.Topo.Data;
			ComponentCategory cat = ((ComponentClassifier) c).getCategory();

			if (cat.getValue() == ComponentCategory.SYSTEM_VALUE) {
				topo = Agree.Topo.System;
			}

			List<Agree.Field> fields = new ArrayList<>();

			Classifier currClsfr = c;
			while (currClsfr != null) {
				ComponentType ct = null;
				if (currClsfr instanceof ComponentImplementation) {
					EList<Subcomponent> subcomps = ((ComponentImplementation) currClsfr).getAllSubcomponents();
					for (Subcomponent sub : subcomps) {
						String fieldName = sub.getName();
						if (sub.getClassifier() != null) {

							if (sub.getArrayDimensions().size() == 0) {
								Spec typeDef = toSpecFromClassifier(sub.getClassifier());
								Agree.Field field = new Agree.Field(fieldName, typeDef,
										Optional.empty());
								fields.add(field);
							} else if (sub.getArrayDimensions().size() == 1) {
								ArrayDimension ad = sub.getArrayDimensions().get(0);
								int size = Math.toIntExact(getArraySize(ad));

								Spec stem = toSpecFromClassifier(sub.getClassifier());
								Spec typeDef = new ArraySpec(stem, size, Optional.empty());
								Agree.Field field = new Agree.Field(fieldName, typeDef,
										Optional.empty());
								fields.add(field);

							}
						}
					}

					ct = ((ComponentImplementation) currClsfr).getType();
				} else if (c instanceof ComponentType) {
					ct = (ComponentType) currClsfr;
				}

				if (ct != null) {

					EList<Feature> features = ct.getAllFeatures();
					for (Feature feature : features) {
						String fieldName = feature.getName();

						boolean isEvent = feature instanceof EventDataPort || feature instanceof EventPort;
						Agree.Direc direction = null;
						if (feature instanceof Port) {
							int v = ((Port) feature).getDirection().getValue();
							if (v == DirectionType.IN_VALUE) {
								direction = Agree.Direc.In;
							} else if (v == DirectionType.OUT_VALUE) {
								direction = Agree.Direc.Out;
							}
						}

						if (direction != null) {

							Agree.Port port = new Agree.Port(direction, isEvent);

							if (feature.getClassifier() != null) {
								if (feature.getArrayDimensions().size() == 0) {
									Spec typeDef = toSpecFromClassifier(feature.getClassifier());

									Agree.Field field = new Agree.Field(fieldName, typeDef,
											Optional.of(port));

									fields.add(field);
								} else if (feature.getArrayDimensions().size() == 1) {
									ArrayDimension ad = feature.getArrayDimensions().get(0);
									int size = Math.toIntExact(getArraySize(ad));
									Spec stem = toSpecFromClassifier(feature.getClassifier());
									Spec typeDef = new ArraySpec(stem, size, Optional.empty());

									Agree.Field field = new Agree.Field(fieldName, typeDef,
											Optional.of(port));

									fields.add(field);

								}
							}
						}
					}

					for (AnnexSubclause annex : AnnexUtil.getAllAnnexSubclauses(currClsfr,
							AgreePackage.eINSTANCE.getAgreeContractSubclause())) {
						AgreeContract contract = (AgreeContract) ((AgreeContractSubclause) annex).getContract();

						for (SpecStatement spec : contract.getSpecs()) {

							List<Arg> args = new ArrayList<>();
							if (spec instanceof EqStatement) {
								args = ((EqStatement) spec).getLhs();
							} else if (spec instanceof InputStatement) {
								args = ((InputStatement) spec).getLhs();
							}

							for (Arg arg : args) {
								String fieldName = arg.getName();
								Spec typeDef = toSpecFromNamedElm(arg);
								Agree.Field field = new Agree.Field(fieldName, typeDef,
										Optional.empty());

								fields.add(field);
							}
						}

					}
				}

				currClsfr = currClsfr.getExtended();
			}

			String name = c.getQualifiedName();

			return new RecordSpec(name, topo, fields, c);

		}

		return Prim.ErrorSpec;

	}

	public static Spec inferSpecFromNamedElement(NamedElement ne) {

		if (ne instanceof PropertyStatement) {
			return inferSpec(((PropertyStatement) ne).getExpr());

		} else if (ne instanceof NamedID && ne.eContainer() instanceof EnumStatement) {

			EnumStatement enumDef = (EnumStatement) ne.eContainer();
			String name = enumDef.getQualifiedName();
			List<String> enumValues = new ArrayList<String>();

			for (NamedID nid : enumDef.getEnums()) {
				String enumValue = name + "_" + nid.getName();
				enumValues.add(enumValue);
			}
			return new EnumSpec(name, enumValues, enumDef);

		} else if (ne instanceof NamedID) {

			EObject container = ne.eContainer();

			Expr arrExpr = null;

			if (container instanceof ForallExpr) {
				arrExpr = ((ForallExpr) container).getArray();

			} else if (container instanceof ExistsExpr) {
				arrExpr = ((ExistsExpr) container).getArray();

			} else if (container instanceof FlatmapExpr) {
				arrExpr = ((FlatmapExpr) container).getArray();

			} else if (container instanceof FoldLeftExpr) {
				arrExpr = ((FoldLeftExpr) container).getArray();

			} else if (container instanceof FoldRightExpr) {
				arrExpr = ((FoldRightExpr) container).getArray();

			}

			if (arrExpr != null) {
				Spec arrType = inferSpec(arrExpr);
				if (arrType instanceof ArraySpec) {
					return ((ArraySpec) arrType).stemType;
				}
			}

			if (container instanceof FoldLeftExpr) {
				Expr initExpr = ((FoldLeftExpr) container).getInitial();
				Spec initType = inferSpec(initExpr);
				return initType;

			} else if (container instanceof FoldRightExpr) {
				Expr initExpr = ((FoldRightExpr) container).getInitial();
				Spec initType = inferSpec(initExpr);
				return initType;
			}

		} else if (ne instanceof ConstStatement) {
			return toSpec(((ConstStatement) ne).getType());

		} else if (ne instanceof Arg) {
			return toSpec(((Arg) ne).getType());

		} else if (ne instanceof Subcomponent) {

			Subcomponent sub = (Subcomponent) ne;
			Classifier cl = sub.getClassifier();
			List<ArrayDimension> dims = sub.getArrayDimensions();
			Spec clsTypeDef = toSpecFromClassifier(cl);
			if (dims.size() == 0) {
				return clsTypeDef;
			} else if (dims.size() == 1) {
				long size = getArraySize(dims.get(0));
				return new ArraySpec(clsTypeDef, Math.toIntExact(size), Optional.empty());
			}

		} else if (ne instanceof Feature) {

			Classifier cl = ((Feature) ne).getClassifier();
			List<ArrayDimension> dims = ((Feature) ne).getArrayDimensions();
			Spec clsTypeDef = toSpecFromClassifier(cl);
			if (dims.size() == 0) {
				return clsTypeDef;
			} else if (dims.size() == 1) {
				long size = getArraySize(dims.get(0));
				return new ArraySpec(clsTypeDef, Math.toIntExact(size), Optional.empty());

			}

		} else if (ne instanceof PropertyConstant) {
			PropertyExpression pe = ((PropertyConstant) ne).getConstantValue();
			return inferSpecFromPropExp(pe);

		}

		return Prim.ErrorSpec;

	}

	public static boolean hasSpec(NamedElement ne) {
		return inferSpecFromNamedElement(ne) != (Prim.ErrorSpec);
	}

	public static boolean isInLinearizationBody(Expr expr) {
		boolean result = false;
		EObject current = expr;
		while (current != null && current instanceof Expr) {
			EObject container = current.eContainer();
			if (container instanceof LinearizationDef) {
				result = ((LinearizationDef) container).getExprBody().equals(current);
			}
			current = container;
		}
		return result;
	}

	public static List<Type> typesFromArgs(List<Arg> args) {
		ArrayList<Type> list = new ArrayList<>();
		for (Arg arg : args) {
			list.add(arg.getType());
		}
		return list;
	}

	private static long getArraySize(ArrayDimension arrayDimension) {
		ArraySize arraySize = arrayDimension.getSize();
		long size = arraySize.getSize();
		if (size == 0) {
			ArraySizeProperty arraySizeProperty = arraySize.getSizeProperty();
			if (arraySizeProperty instanceof PropertyConstant) {
				PropertyExpression pe = ((PropertyConstant) arraySizeProperty).getConstantValue();
				size = intFromPropExp(pe).orElse((long) -1);
			}
		}
		assert size > 0;
		return size;
	}

	public static Optional<Long> intFromPropExp(PropertyExpression pe) {
		if (pe instanceof IntegerLiteral) {
			return Optional.of(((IntegerLiteral) pe).getValue());

		} else if (pe instanceof NamedValue) {
			NamedValue nv = (NamedValue) pe;
			AbstractNamedValue anv = nv.getNamedValue();
			if (anv instanceof PropertyConstant) {
				return intFromPropExp(((PropertyConstant) anv).getConstantValue());
			}
		}

		return Optional.empty();
	}

	private static Spec inferSpecFromPropExp(PropertyExpression pe) {
		if (pe instanceof IntegerLiteral) {
			return Prim.IntSpec;

		} else if (pe instanceof RealLiteral) {
			return Prim.RealSpec;

		} else if (pe instanceof NamedValue) {
			NamedValue nv = (NamedValue) pe;
			AbstractNamedValue anv = nv.getNamedValue();
			if (anv instanceof PropertyConstant) {
				return inferSpecFromPropExp(((PropertyConstant) anv).getConstantValue());
			}
		}

		return Prim.ErrorSpec;

	}

	public static Spec inferSpec(Expr expr) {

		if (expr instanceof SelectionExpr) {

			Expr target = ((SelectionExpr) expr).getTarget();
			Spec targetType = inferSpec(target);
			String name = ((SelectionExpr) expr).getField().getName();

			if (targetType instanceof Agree.RecordSpec) {
				List<Agree.Field> fields = ((Agree.RecordSpec) targetType).fields;
				for (Agree.Field field : fields) {
					if (field.name.equals(name)) {
						return field.spec;
					}
				}

			}

		} else if (expr instanceof TagExpr) {

			String tag = ((TagExpr) expr).getTag();
			if (tag != null) {
				switch (tag) {
				case "_CLK":
				case "_INSERT":
				case "_REMOVE":
					return Prim.BoolSpec;
				case "_COUNT":
					return Prim.IntSpec;
				}
			}

		} else if (expr instanceof ArraySubExpr) {
			Expr arrExpr = ((ArraySubExpr) expr).getExpr();
			Spec arrType = inferSpec(arrExpr);
			if (arrType instanceof ArraySpec) {
				return ((ArraySpec) arrType).stemType;
			}

		} else if (expr instanceof IndicesExpr) {
			Spec arrType = inferSpec(((IndicesExpr) expr).getArray());
			if (arrType instanceof ArraySpec) {
				int size = ((ArraySpec) arrType).size;
				return new ArraySpec(Prim.IntSpec, size, Optional.empty());
			}

		} else if (expr instanceof ForallExpr) {
			return Prim.BoolSpec;

		} else if (expr instanceof ExistsExpr) {
			return Prim.BoolSpec;

		} else if (expr instanceof FlatmapExpr) {
			Spec innerArrType = inferSpec(((FlatmapExpr) expr).getExpr());
			if (innerArrType instanceof ArraySpec) {
				Spec stemType = ((ArraySpec) innerArrType).stemType;
				Spec arrType = inferSpec(((FlatmapExpr) expr).getArray());

				if (arrType instanceof ArraySpec) {
					int size = ((ArraySpec) arrType).size;
					return new ArraySpec(stemType, size, Optional.empty());
				}
			}

		} else if (expr instanceof FoldLeftExpr) {
			return inferSpec(((FoldLeftExpr) expr).getExpr());

		} else if (expr instanceof FoldRightExpr) {
			return inferSpec(((FoldRightExpr) expr).getExpr());

		} else if (expr instanceof BinaryExpr) {
			Spec leftType = inferSpec(((BinaryExpr) expr).getLeft());
			String op = ((BinaryExpr) expr).getOp();

			switch (op) {
			case "->":
				return leftType;
			case "=>":
			case "<=>":
			case "and":
			case "or":
			case "<>":
			case "!=":
			case "<":
			case "<=":
			case ">":
			case ">=":
			case "=":
				return Prim.BoolSpec;
			case "+":
			case "-":
			case "*":
			case "/":
			case "mod":
			case "div":
			case "^":
				return leftType;
			}

		} else if (expr instanceof UnaryExpr) {
			return inferSpec(((UnaryExpr) expr).getExpr());

		} else if (expr instanceof IfThenElseExpr) {
			return inferSpec(((IfThenElseExpr) expr).getB());

		} else if (expr instanceof PrevExpr) {
			return inferSpec(((PrevExpr) expr).getInit());

		} else if (expr instanceof GetPropertyExpr) {

			ComponentRef cr = ((GetPropertyExpr) expr).getComponentRef();
			NamedElement prop = ((GetPropertyExpr) expr).getProp();
			if (cr instanceof ThisRef) {

				if (prop instanceof Property) {
					PropertyType pt = ((Property) prop).getPropertyType();

					return inferSpecFromNamedElement(pt);

				} else {

					EObject container = expr.getContainingClassifier();
					List<PropertyAssociation> pas = ((Classifier) container).getAllPropertyAssociations();
					for (PropertyAssociation choice : pas) {
						if (choice.getProperty().getName().equals(prop.getName())) {
							PropertyType pt = choice.getProperty().getPropertyType();
							return inferSpecFromNamedElement(pt);
						}
					}
				}

			} else if (cr instanceof DoubleDotRef) {

				EObject container = expr.getContainingComponentImpl();
				if (container instanceof ComponentImplementation) {
					List<Subcomponent> subcomps = ((ComponentImplementation) container).getAllSubcomponents();
					for (Subcomponent choice : subcomps) {

						List<PropertyAssociation> pas = choice.getOwnedPropertyAssociations();
						for (PropertyAssociation pchoice : pas) {

							if (pchoice.getProperty().getName().equals(prop.getName())) {
								PropertyType pt = pchoice.getProperty().getPropertyType();
								return inferSpecFromNamedElement(pt);
							}
						}

					}

				}

			}

		} else if (expr instanceof IntLitExpr) {
			return Prim.IntSpec;

		} else if (expr instanceof RealLitExpr) {
			return Prim.RealSpec;

		} else if (expr instanceof BoolLitExpr) {
			return Prim.BoolSpec;

		} else if (expr instanceof FloorCast) {
			return Prim.IntSpec;

		} else if (expr instanceof RealCast) {
			return Prim.RealSpec;

		} else if (expr instanceof EventExpr) {
			return Prim.BoolSpec;

		} else if (expr instanceof TimeExpr) {
			return Prim.RealSpec;

		} else if (expr instanceof EnumLitExpr) {
			return toSpec(((EnumLitExpr) expr).getEnumType());

		} else if (expr instanceof LatchedExpr) {
			return inferSpec(((LatchedExpr) expr).getExpr());

		} else if (expr instanceof TimeOfExpr) {
			return Prim.RealSpec;

		} else if (expr instanceof TimeRiseExpr) {
			return Prim.RealSpec;

		} else if (expr instanceof TimeFallExpr) {
			return Prim.RealSpec;

		} else if (expr instanceof TimeOfExpr) {
			return Prim.RealSpec;

		} else if (expr instanceof TimeRiseExpr) {
			return Prim.RealSpec;

		} else if (expr instanceof TimeFallExpr) {
			return Prim.RealSpec;

		} else if (expr instanceof PreExpr) {
			return inferSpec(((PreExpr) expr).getExpr());

		} else if (expr instanceof ArrayLiteralExpr) {
			EList<Expr> elems = ((ArrayLiteralExpr) expr).getElems();
			Expr first = elems.get(0);
			int size = elems.size();
			Spec firstType = inferSpec(first);

			return new ArraySpec(firstType, size, Optional.empty());

		} else if (expr instanceof ArrayUpdateExpr) {
			return inferSpec(((ArrayUpdateExpr) expr).getArray());

		} else if (expr instanceof RecordLitExpr) {
			return toSpec(((RecordLitExpr) expr).getRecordType());

		} else if (expr instanceof RecordUpdateExpr) {
			return inferSpec(((RecordUpdateExpr) expr).getRecord());

		} else if (expr instanceof NamedElmExpr) {
			NamedElement ne = ((NamedElmExpr) expr).getElm();
			return inferSpecFromNamedElement(ne);

		} else if (expr instanceof CallExpr) {

			CallExpr fnCall = ((CallExpr) expr);
			DoubleDotRef dotId = fnCall.getRef();
			NamedElement namedEl = dotId.getElm();

			if (isInLinearizationBody(fnCall)) {
				// extract in/out arguments
				if (namedEl instanceof LinearizationDef) {
					return Prim.RealSpec;
				} else if (namedEl instanceof LibraryFnDef) {
					LibraryFnDef fnDef = (LibraryFnDef) namedEl;
					return toSpec(fnDef.getType());
				}

			} else {
				// extract in/out arguments
				if (namedEl instanceof FnDef) {
					FnDef fnDef = (FnDef) namedEl;
					return toSpec(fnDef.getType());
				} else if (namedEl instanceof NodeDef) {
					NodeDef nodeDef = (NodeDef) namedEl;
					List<Type> outDefTypes = typesFromArgs(nodeDef.getRets());
					if (outDefTypes.size() == 1) {
						return toSpec(outDefTypes.get(0));
					}
				} else if (namedEl instanceof LinearizationDef) {
					return Prim.RealSpec;
				} else if (namedEl instanceof LibraryFnDef) {
					LibraryFnDef fnDef = (LibraryFnDef) namedEl;
					return toSpec(fnDef.getType());
				}

			}

		}
		return Prim.ErrorSpec;

	}

	public static Optional<Double> realFromPropExp(PropertyExpression pe) {
		if (pe instanceof RealLiteral) {
			return Optional.of(((RealLiteral) pe).getValue());

		} else if (pe instanceof NamedValue) {
			NamedValue nv = (NamedValue) pe;
			AbstractNamedValue anv = nv.getNamedValue();
			if (anv instanceof PropertyConstant) {
				return realFromPropExp(((PropertyConstant) anv).getConstantValue());
			}
		}

		return Optional.empty();
	}

}