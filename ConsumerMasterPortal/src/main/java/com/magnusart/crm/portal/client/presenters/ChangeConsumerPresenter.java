package com.magnusart.crm.portal.client.presenters;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.magnusart.crm.portal.client.ConsumerServiceAsync;
import com.magnusart.crm.portal.client.events.ChangeConsumerEventHandler;
import com.magnusart.crm.portal.client.events.CreateConsumerEvent;
import com.magnusart.crm.portal.client.events.EditConsumerEvent;
import com.magnusart.crm.portal.client.views.CreateConsumerView.ConsumerType;
import com.magnusart.crm.portal.shared.CompanyDetails;
import com.magnusart.crm.portal.shared.ConsumerDetails;
import com.magnusart.crm.portal.shared.PersonDetails;

/**
 * Presenter class for Consumer entity
 * 
 * @author Magnus Andersson
 * @since 17 okt 2010
 */
public class ChangeConsumerPresenter implements Presenter,
		ChangeConsumerEventHandler {

	public interface Display {
		HandlerRegistration addSaveContactEventHandler(
				ChangeConsumerEventHandler handler);

		void setData(List<String> data);

		ArrayList<String> getData();

		ConsumerType getType();

		Widget asWidget();
	}

	private final ConsumerServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private ConsumerDetails consumer;

	/**
	 * 
	 * @param rpcService
	 * @param eventBus
	 * @param display
	 */
	public ChangeConsumerPresenter(final ConsumerServiceAsync rpcService,
			final HandlerManager eventBus,
			final ChangeConsumerPresenter.Display display) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;

		display.addSaveContactEventHandler(this);
	}

	@Override
	public void go(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	@Override
	public void onCreateConsumer(final CreateConsumerEvent event) {
		ConsumerDetails consumer = null;

		final ArrayList<String> data = display.getData();

		switch (display.getType()) {
		case PERSON:
			assert (data.size() == 4);

			final PersonDetails pers = new PersonDetails();
			pers.setFirstName(data.get(0));
			pers.setMiddleName(data.get(1));
			pers.setLastName(data.get(2));
			pers.setAge(data.get(3));

			consumer = pers;
			break;
		case COMPANY:
			assert (data.size() == 3);

			final CompanyDetails comp = new CompanyDetails();

			comp.setCompanyName(data.get(0));
			comp.setNoOfEmployees(data.get(1));
			comp.setMainContactPersonId(data.get(2));

			consumer = comp;
			break;
		default:
			assert (false);
		}

		assert (consumer != null);

		rpcService.createConsumer(consumer,
				new AsyncCallback<ConsumerDetails>() {

					@Override
					public void onSuccess(final ConsumerDetails result) {
						Window.alert("Consumer created");
					}

					@Override
					public void onFailure(final Throwable caught) {
						Window.alert("Error creating consumer");
					}
				});
	}

	@Override
	public void onEditConsumer(final EditConsumerEvent event) {
		Window.alert("Edit Consumer");

	}

}
