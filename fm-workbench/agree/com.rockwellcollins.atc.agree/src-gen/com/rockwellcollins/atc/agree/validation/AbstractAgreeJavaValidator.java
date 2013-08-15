package com.rockwellcollins.atc.agree.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.osate.xtext.aadl2.properties.validation.PropertiesJavaValidator;

public class AbstractAgreeJavaValidator extends PropertiesJavaValidator {

    @Override
    protected List<EPackage> getEPackages() {
        List<EPackage> result = new ArrayList<EPackage>();
        result.add(com.rockwellcollins.atc.agree.agree.AgreePackage.eINSTANCE);
        result.add(EPackage.Registry.INSTANCE.getEPackage("http://aadl.info/AADL/2.0"));
        return result;
    }

}
