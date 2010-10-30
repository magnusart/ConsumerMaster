package com.magnusart.crm.portal.server;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.magnusart.crm.CommandBus;
import com.magnusart.crm.business.commands.CreatePersonCommand;
import com.magnusart.crm.business.reports.AbstractReport;
import com.magnusart.crm.business.reports.PersonReport;
import com.magnusart.crm.business.reports.ReportHandler;
import com.magnusart.crm.portal.client.ConsumerService;
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
		ConsumerService, ReportHandler {

	private static final long serialVersionUID = 1L;

	@EJB
	private CommandBus commandBus;

	private PersonReport personReport = null;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		final HandlerManager eventBus = commandBus.getEventBus();
		eventBus.addHandler(AbstractReport.TYPE, this);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConsumerDetails createConsumer(final ConsumerDetails consumer) {

		if (consumer instanceof PersonDetails) {
			final CreatePersonCommand command = new CreatePersonCommand(
					(PersonDetails) consumer);
			commandBus.executeCommand(command);

		} else if (consumer instanceof CompanyDetails) {
			// Do nothing yet
		} else {
			assert false : "Should always be either Company or Person details";
		}

		if (personReport != null) {
			System.out.println("We got an Person Report!");
		}

		return consumer;
	}

	@Override
	public void onPersonReport(final PersonReport report) {
		personReport = report;
	}

}
