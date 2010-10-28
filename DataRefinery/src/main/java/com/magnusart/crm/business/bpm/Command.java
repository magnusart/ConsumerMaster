package com.magnusart.crm.business.bpm;

import java.util.ArrayList;
import java.util.List;

public abstract class Command<T> {
	private final T entity;
	private boolean validated = true;
	private boolean persistable = true;
	private final List<Validation> validations = new ArrayList<Validation>();

	protected Command(final T entity) {
		this.entity = entity;
	}

	public T getEntity() {
		return entity;
	}

	/**
	 * @return the validated
	 */
	public boolean isValidated() {
		return validated;
	}

	/**
	 * @param validated
	 *            the validated to set
	 */
	public void setValidated(final boolean validated) {
		this.validated = validated;
	}

	/**
	 * @return the persistable
	 */
	public boolean isPersistable() {
		return persistable;
	}

	/**
	 * @param persistable
	 *            the persistable to set
	 */
	public void setPersistable(final boolean persistable) {
		this.persistable = persistable;
	}

	/**
	 * @return the validations
	 */
	public List<Validation> getValidations() {
		return validations;
	}

}
