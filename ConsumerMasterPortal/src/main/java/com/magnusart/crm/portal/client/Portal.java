/**
 * 
 */
package com.magnusart.crm.portal.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author Magnus Andersson
 * @since 16 okt 2010
 */
public class Portal implements EntryPoint {

	/** {@inheritDoc} */
	@Override
	public void onModuleLoad() {
		final ConsumerServiceAsync rpcService = GWT
				.create(ConsumerService.class);
		final HandlerManager eventBus = new HandlerManager(null);
		final AppController appViewer = new AppController(rpcService, eventBus);
		appViewer.go(RootPanel.get());
	}

}
