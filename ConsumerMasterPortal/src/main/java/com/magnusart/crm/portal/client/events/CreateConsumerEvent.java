package com.magnusart.crm.portal.client.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Event fired when creating a new consumer.
 * 
 * @author Magnus Andersson
 * @since 17 okt 2010
 */
public class CreateConsumerEvent extends GwtEvent<ChangeConsumerEventHandler> {

	/**
	 * The type.
	 */
	public static Type<ChangeConsumerEventHandler> TYPE = new Type<ChangeConsumerEventHandler>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void dispatch(final ChangeConsumerEventHandler handler) {
		handler.onCreateConsumer(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Type<ChangeConsumerEventHandler> getAssociatedType() {
		return TYPE;
	}

}
