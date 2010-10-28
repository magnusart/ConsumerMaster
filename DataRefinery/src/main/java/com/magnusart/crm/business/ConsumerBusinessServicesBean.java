package com.magnusart.crm.business;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class ConsumerBusinessServices
 */
@Stateless(name = "ConsumerBusinessServices")
public class ConsumerBusinessServicesBean implements ConsumerBusinessServices {

	/** {@inheritDoc} */
	@Override
	public String testService(final String message) {
		return "Hello " + message;
	}

}
