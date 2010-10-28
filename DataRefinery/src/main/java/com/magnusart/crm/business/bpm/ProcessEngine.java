package com.magnusart.crm.business.bpm;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;
import org.drools.runtime.StatefulKnowledgeSession;

/**
 * Session Bean implementation class ConsumerProcessEngine
 */
@Stateless
@LocalBean
public class ProcessEngine {

	private final KnowledgeBuilder kbuilder;
	private StatefulKnowledgeSession ksession;
	private String runFlow;

	/**
	 * Default constructor.
	 */
	public ProcessEngine() {
		kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
	}

	public void setUpEngine(final Configuration configuration) {

		runFlow = configuration.getFlowName();

		// Add flows
		for (final Resource res : configuration.getFlows()) {
			kbuilder.add(res, ResourceType.DRF);
		}

		// Add rules
		for (final Resource res : configuration.getRules()) {
			kbuilder.add(res, ResourceType.DRL);
		}

		if (kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors());
		}

		final KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

		ksession = kbase.newStatefulKnowledgeSession();
	}

	public StatefulKnowledgeSession getSession() {
		return ksession;
	}

	public void run() {
		ksession.fireAllRules();
		ksession.startProcess(runFlow);

		ksession.dispose();
	}
}
