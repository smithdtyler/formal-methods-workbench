/*
Copyright (c) 2016, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/

package com.rockwellcollins.atc.tcg.extensions;

import java.util.Map;

import jkind.results.Counterexample;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ComponentImplementation;

public class TcgExtractorProxy extends ExtensionProxy implements TcgExtractor {

    private TcgExtractor extractor;

    protected TcgExtractorProxy(IConfigurationElement configElem) {
        super(configElem);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void receiveCex(ComponentImplementation compImpl, EObject property, Counterexample cex,
            Map<String, EObject> refMap) {
        TcgExtractor extractor = getCexExtractor();

        if (extractor != null) {
            extractor.receiveCex(compImpl, property, cex, refMap);
        }
    }

    @Override
    public String getDisplayText() {
        TcgExtractor extractor = getCexExtractor();
        if (extractor != null) {
            return extractor.getDisplayText();
        }
        return null;
    }

    private TcgExtractor getCexExtractor() {
        if (extractor != null) {
            return extractor;
        }
        try {
            extractor = (TcgExtractor) configElem.createExecutableExtension(ATT_CLASS);
        } catch (Exception e) {
            System.err.println("error instantiating tcg extractor in plugin "
                    + configElem.getDeclaringExtension().getContributor().getName());
        }
        return extractor;
    }

}
