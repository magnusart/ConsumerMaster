package com.magnusart.crm.model.i;

import com.magnusart.crm.model.e.embeddable.StartEndDateInfoEmbeddable;

/**
 * Indicates that the entity has a start and end date.
 * 
 * @author Magnus Andersson
 * @since 3 okt 2010
 */
public interface HasStartEndDate {

	/**
	 * 
	 * @return the StartEndDateInfoEmbeddable
	 */
	StartEndDateInfoEmbeddable getStartEndInfo();
}
