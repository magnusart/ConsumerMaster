package com.magnusart.crm.business.bpm.configurations;

import java.util.ArrayList;
import java.util.List;

import org.drools.io.Resource;
import org.drools.io.ResourceFactory;

import com.magnusart.crm.business.bpm.Configuration;

public class CreateConsumerConfig implements Configuration {

	/** {@inheritDoc} */
	@Override
	public String getFlowName() {
		return "CreateConsumer";
	}

	/** {@inheritDoc} */
	@Override
	public List<Resource> getRules() {
		final List<Resource> rules = new ArrayList<Resource>();
		final Resource r = ResourceFactory
				.newUrlResource("file:src/main/resources/rules/ValidateRelations.drl");
		rules.add(r);
		// return rules;
		return new ArrayList<Resource>();
	}

	/** {@inheritDoc} */
	@Override
	public List<Resource> getFlows() {
		final List<Resource> flows = new ArrayList<Resource>();
		final Resource r = ResourceFactory
				.newUrlResource("file:src/main/resources/flows/CreateConsumerDummy.rf");
		flows.add(r);
		return flows;
	}

}
