package com.magnusart.crm.portal.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.magnusart.crm.portal.client.events.ChangeConsumerEventHandler;
import com.magnusart.crm.portal.client.events.CreateConsumerEvent;
import com.magnusart.crm.portal.client.events.EditConsumerEvent;
import com.magnusart.crm.portal.client.presenters.ChangeConsumerPresenter;
import com.magnusart.crm.portal.client.presenters.Presenter;
import com.magnusart.crm.portal.client.views.CreateConsumerView;

public class AppController implements Presenter, ValueChangeHandler<String> {

	private final ConsumerServiceAsync rpcService;
	private final HandlerManager eventBus;
	private HasWidgets container;

	public AppController(final ConsumerServiceAsync rpcService,
			final HandlerManager eventBus) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(CreateConsumerEvent.TYPE,
				new ChangeConsumerEventHandler() {

					@Override
					public void onCreateConsumer(final CreateConsumerEvent event) {
						doCreateConsumer();
					}

					@Override
					public void onEditConsumer(final EditConsumerEvent event) {
						doEditConsumer();
					}
				});
	}

	private void doEditConsumer() {
		History.newItem("edit");
	}

	private void doCreateConsumer() {
		History.newItem("new");
	}

	public void go(final HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem("new");
		} else {
			History.fireCurrentHistoryState();
		}
	}

	@Override
	public void onValueChange(final ValueChangeEvent<String> event) {
		final String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;

			if (token.equals("new")) {
				presenter = new ChangeConsumerPresenter(rpcService, eventBus,
						new CreateConsumerView());
			} else if (token.equals("edit")) {
				presenter = new ChangeConsumerPresenter(rpcService, eventBus,
						new CreateConsumerView());
			}

			if (presenter != null) {
				presenter.go(container);
			}
		}
	}
}
