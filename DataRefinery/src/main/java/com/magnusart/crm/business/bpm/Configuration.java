package com.magnusart.crm.business.bpm;

import java.util.List;

import org.drools.io.Resource;

public interface Configuration {
	/**
	 * Get the rules for this configuration.
	 * 
	 * @return List of Rule Resources
	 */
	List<Resource> getRules();

	/**
	 * Get the flows for this configuration.
	 * 
	 * @return
	 */
	List<Resource> getFlows();

	/**
	 * 
	 * @return The Flow that should be run upon execution
	 */
	String getFlowName();
}
