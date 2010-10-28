package com.magnusart.crm.model.e.listeners;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.magnusart.crm.model.e.embeddable.BaseInfoEmbeddable;
import com.magnusart.crm.model.i.HasBaseInfo;

/**
 * Listener that fills out the base info of an entity before Persist and Update.
 * 
 * @author Magnus Andersson
 * @since 2 okt 2010
 */
public class BaseInfoFiller {
	private static final String DEFAULT_SYSTEM = "UNKNOWN SYSTEM";
	private static final String DEFAULT_USER = "UNKNOWN USER";

	/**
	 * Sets information at creation of new entities. If no User or System is
	 * set, then default values {@value #DEFAULT_USER} and
	 * {@value #DEFAULT_SYSTEM} are applied respectively.
	 * 
	 * @param e
	 *            Base info entity
	 */
	@PrePersist
	public static void atCreation(final HasBaseInfo e) {

		final BaseInfoEmbeddable b = e.getBaseInfo();

		if (!emptyOrNull(b.getCreatedByUser())) {
			b.setCreatedByUser(DEFAULT_USER);
		}

		if (!emptyOrNull(b.getCreatedBySystem())) {
			b.setCreatedBySystem(DEFAULT_SYSTEM);
		}

		b.setCreationDate(new Date());

		atChange(e);
	}

	/**
	 * Updates information at changes to the database. If no User or System is
	 * set, then default values {@value #DEFAULT_USER} and
	 * {@value #DEFAULT_SYSTEM} are applied respectively.
	 * 
	 * @param e
	 *            BaseInfoEmbeddable
	 */
	@PreUpdate
	public static void atChange(final HasBaseInfo e) {

		final BaseInfoEmbeddable b = e.getBaseInfo();

		if (!emptyOrNull(b.getChangedByUser())) {
			b.setChangedByUser(DEFAULT_USER);
		}

		if (!emptyOrNull(b.getChangedBySystem())) {
			b.setChangedBySystem(DEFAULT_SYSTEM);
		}

		b.setLastCangeDate(new Date());
	}

	private static boolean emptyOrNull(final String s) {
		return "".equals(s);
	}
}
