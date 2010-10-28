package com.magnusart.crm.portal.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface ChangeConsumerEventHandler extends EventHandler {
	void onCreateConsumer(CreateConsumerEvent event);

	void onEditConsumer(EditConsumerEvent event);
}
