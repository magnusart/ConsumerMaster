package com.magnusart.crm.model.e.listeners;

import java.util.Date;

import javax.persistence.PrePersist;

import com.magnusart.crm.model.e.embeddable.StartEndDateInfoEmbeddable;
import com.magnusart.crm.model.i.HasStartEndDate;

/**
 * Listener that fills out the start date of an entity before Persist if empty
 * 
 * @author Magnus Andersson
 * @since 3 okt 2010
 */
public class StartDateFiller {

	/**
	 * Sets the start date if not set already
	 * 
	 * @param startEnd
	 *            StartEndDateEmbeddable
	 */
	@PrePersist
	public static void setStartDate(final HasStartEndDate startEnd) {
		final StartEndDateInfoEmbeddable i = startEnd.getStartEndInfo();
		if (i.getStartDate() == null) {
			i.setStartDate(new Date());
		}
	}

}
