package com.magnusart.crm.portal.client;

import com.magnusart.crm.portal.shared.ConsumerDetails;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ConsumerServiceAsync {

	void createConsumer(ConsumerDetails consumer, AsyncCallback<ConsumerDetails> callback);

}
