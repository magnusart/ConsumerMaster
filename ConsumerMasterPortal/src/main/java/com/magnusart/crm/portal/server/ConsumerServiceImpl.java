package com.magnusart.crm.portal.server;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.magnusart.crm.business.ConsumerBusinessServices;
import com.magnusart.crm.business.commands.CreateConsumerCommand;
import com.magnusart.crm.model.e.ConsumerEntity;
import com.magnusart.crm.portal.client.ConsumerService;
import com.magnusart.crm.portal.server.converter.ConsumerConverter;
import com.magnusart.crm.portal.shared.CompanyDetails;
import com.magnusart.crm.portal.shared.ConsumerDetails;
import com.magnusart.crm.portal.shared.PersonDetails;

/**
 * The Consumer Service entry. This is where any server side logic (filtering,
 * conversion, error handling etc) that is specific for the Portal is put.
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
	}

	@Override
	public ConsumerDetails createConsumer(final ConsumerDetails consumer) {

		final CreateConsumerCommand command = new CreateConsumerCommand();

		ConsumerEntity consumerEntity = null;

		if (consumer instanceof PersonDetails) {
			consumerEntity = ConsumerConverter
					.convert((PersonDetails) consumer);
		} else if (consumer instanceof CompanyDetails) {
			consumerEntity = ConsumerConverter
					.convert((CompanyDetails) consumer);
		} else {
			assert false : "Should always be either Company or Person details";
		}

		services.createConsumer(consumerEntity);

		return consumer;
	}

}
