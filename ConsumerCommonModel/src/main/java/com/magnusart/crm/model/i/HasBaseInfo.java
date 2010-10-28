package com.magnusart.crm.model.i;

import com.magnusart.crm.model.e.embeddable.BaseInfoEmbeddable;
import com.magnusart.crm.model.e.listeners.BaseInfoFiller;

/**
 * Indicates that this entity has base information.
 * 
 * @see BaseInfoFiller
 * @author Magnus Andersson
 * @since 2 okt 2010
 */
public interface HasBaseInfo {
	/**
	 * 
	 * @return the BaseInfoEmbeddable
	 */
	BaseInfoEmbeddable getBaseInfo();
}
