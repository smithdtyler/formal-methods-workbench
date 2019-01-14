package com.collins.fmw.agree.command;


import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.annexsupport.AnnexLinkingService;

import com.google.inject.Injector;
import com.rockwellcollins.atc.agree.AgreeStandaloneSetup;
import com.rockwellcollins.atc.agree.linking.AgreeLinkingService;

// Based on EMV2AnnexLinkingService from Error Model annex
public class AgreeAnnexLinkingService implements AnnexLinkingService {
	final private Injector injector = new AgreeStandaloneSetup().createInjectorAndDoEMFRegistration();

	private ILinkingService linkingService;

	private IQualifiedNameProvider nameProvider;

	protected ILinkingService getLinkingService() {
		if (linkingService == null) {
			linkingService = injector.getInstance(AgreeLinkingService.class);
		}
		return linkingService;
	}

	protected IQualifiedNameProvider getNameProvider() {
		if (nameProvider == null) {
			nameProvider = injector.getInstance(IQualifiedNameProvider.class);
		}
		return nameProvider;
	}

	@Override
	public List<EObject> resolveAnnexReference(String annexName, EObject context, EReference reference, INode node) {
		return getLinkingService().getLinkedObjects(context, reference, node);
	}

	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		return getNameProvider().getFullyQualifiedName(obj);
	}
}