/*
Copyright (c) 2018, Rockwell Collins.
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

package com.rockwellcollins.atc.tcg.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.modelsupport.util.AadlUtil;

import com.rockwellcollins.atc.tcg.TcgException;

public class TcgUtils {

	public static String getNestedMessages(Throwable e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		while (e != null) {
			if (e.getMessage() != null && !e.getMessage().isEmpty()) {
				pw.println(e.getMessage());
			}
			e = e.getCause();
		}
		pw.close();
		return sw.toString();
	}

	public static ComponentImplementation getComponentImplFromString(String qualifiedName) {
		HashSet<IFile> files = org.osate.aadl2.modelsupport.modeltraversal.TraverseWorkspace.getAadlFilesInWorkspace();
		for (IFile file : files) {
			ModelUnit target = (ModelUnit) AadlUtil.getElement(file);
			if (target instanceof AadlPackage) {
				Classifier cl = org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil.get(target,
						org.osate.aadl2.Aadl2Package.eINSTANCE.getComponentImplementation(), qualifiedName);
				if (cl instanceof ComponentImplementation) {
					return (ComponentImplementation) cl;
				}
			}
		}
		throw new TcgException("Error: test suite implementation under test: [" + qualifiedName
				+ "] does not correspond to any " + "system implementation in the workspace.\n");
	}
}
