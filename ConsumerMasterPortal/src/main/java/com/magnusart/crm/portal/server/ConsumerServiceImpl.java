package com.magnusart.crm.portal.server;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.magnusart.crm.business.ConsumerBusinessServices;
import com.magnusart.crm.portal.client.ConsumerService;
import com.magnusart.crm.portal.shared.ConsumerDetails;

/**
 * The Consumer Servie for GWT
 * 
 * @author Magnus Andersson
 * @since 17 okt 2010
 */
public class ConsumerServiceImpl extends RemoteServiceServlet implements
		ConsumerService {

	private static final long serialVersionUID = 1L;

	@EJB
	ConsumerBusinessServices services;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);

		try {
			// get the inital context
			final Context ctx = new InitialContext();

			services = (ConsumerBusinessServices) ctx
					.lookup("ConsumerBusinessServices");
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ConsumerDetails createConsumer(final ConsumerDetails consumer) {
		System.out.println(consumer.toString());
		final String answer = services.testService(consumer.toString());
		System.out.println(answer);
		return consumer;
	}

}
