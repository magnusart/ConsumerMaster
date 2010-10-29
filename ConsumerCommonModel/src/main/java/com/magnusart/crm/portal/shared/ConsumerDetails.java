package com.magnusart.crm.portal.shared;

import java.io.Serializable;

/**
 * Common consumer data.
 * 
 * @author Magnus Andersson
 * @since 17 okt 2010
 */
public abstract class ConsumerDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String NO_ID = "0";

	// Common data
	private String id;

	public ConsumerDetails(final String id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "ConsumerDetails [id=" + id + "]";
	}

}
