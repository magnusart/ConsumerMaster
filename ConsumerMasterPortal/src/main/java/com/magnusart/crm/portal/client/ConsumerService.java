package com.magnusart.crm.portal.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.magnusart.crm.portal.shared.ConsumerDetails;

@RemoteServiceRelativePath("consumerService")
public interface ConsumerService extends RemoteService {

	ConsumerDetails createConsumer(ConsumerDetails consumer);

}
