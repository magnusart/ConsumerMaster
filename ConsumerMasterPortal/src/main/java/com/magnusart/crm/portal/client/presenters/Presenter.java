package com.magnusart.crm.portal.client.presenters;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Presenter in the MVP pattern.
 * 
 * @author Magnus Andersson
 * @since 17 okt 2010
 */
public abstract interface Presenter {
	public abstract void go(final HasWidgets container);
}
