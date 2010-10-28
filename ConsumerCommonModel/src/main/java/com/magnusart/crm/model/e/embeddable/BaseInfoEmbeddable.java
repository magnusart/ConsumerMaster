package com.magnusart.crm.model.e.embeddable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BaseInfoEmbeddable {
	@Column(nullable = false, name = "created_by_user")
	private String createdByUser;

	@Column(nullable = false, name = "changed_by_user")
	private String changedByUser;

	@Column(nullable = false, name = "created_by_system")
	private String createdBySystem;

	@Column(nullable = false, name = "changed_by_system")
	private String changedBySystem;

	@Column(nullable = false, name = "creation_date")
	private Date creationDate;

	@Column(nullable = false, name = "last_change_date")
	private Date lastCangeDate;

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(final Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the lastCangeDate
	 */
	public Date getLastCangeDate() {
		return lastCangeDate;
	}

	/**
	 * @param lastCangeDate
	 *            the lastCangeDate to set
	 */
	public void setLastCangeDate(final Date lastCangeDate) {
		this.lastCangeDate = lastCangeDate;
	}

	/**
	 * @return the createdByUser
	 */
	public String getCreatedByUser() {
		return createdByUser;
	}

	/**
	 * @param createdByUser
	 *            the createdByUser to set
	 */
	public void setCreatedByUser(final String createdByUser) {
		this.createdByUser = createdByUser;
	}

	/**
	 * @return the changedByUser
	 */
	public String getChangedByUser() {
		return changedByUser;
	}

	/**
	 * @param changedByUser
	 *            the changedByUser to set
	 */
	public void setChangedByUser(final String changedByUser) {
		this.changedByUser = changedByUser;
	}

	/**
	 * @return the createdBySystem
	 */
	public String getCreatedBySystem() {
		return createdBySystem;
	}

	/**
	 * @param createdBySystem
	 *            the createdBySystem to set
	 */
	public void setCreatedBySystem(final String createdBySystem) {
		this.createdBySystem = createdBySystem;
	}

	/**
	 * @return the changedBySystem
	 */
	public String getChangedBySystem() {
		return changedBySystem;
	}

	/**
	 * @param changedBySystem
	 *            the changedBySystem to set
	 */
	public void setChangedBySystem(final String changedBySystem) {
		this.changedBySystem = changedBySystem;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((changedBySystem == null) ? 0 : changedBySystem.hashCode());
		result = prime * result
				+ ((changedByUser == null) ? 0 : changedByUser.hashCode());
		result = prime * result
				+ ((createdBySystem == null) ? 0 : createdBySystem.hashCode());
		result = prime * result
				+ ((createdByUser == null) ? 0 : createdByUser.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((lastCangeDate == null) ? 0 : lastCangeDate.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BaseInfoEmbeddable)) {
			return false;
		}
		final BaseInfoEmbeddable other = (BaseInfoEmbeddable) obj;
		if (changedBySystem == null) {
			if (other.changedBySystem != null) {
				return false;
			}
		} else if (!changedBySystem.equals(other.changedBySystem)) {
			return false;
		}
		if (changedByUser == null) {
			if (other.changedByUser != null) {
				return false;
			}
		} else if (!changedByUser.equals(other.changedByUser)) {
			return false;
		}
		if (createdBySystem == null) {
			if (other.createdBySystem != null) {
				return false;
			}
		} else if (!createdBySystem.equals(other.createdBySystem)) {
			return false;
		}
		if (createdByUser == null) {
			if (other.createdByUser != null) {
				return false;
			}
		} else if (!createdByUser.equals(other.createdByUser)) {
			return false;
		}
		if (creationDate == null) {
			if (other.creationDate != null) {
				return false;
			}
		} else if (!creationDate.equals(other.creationDate)) {
			return false;
		}
		if (lastCangeDate == null) {
			if (other.lastCangeDate != null) {
				return false;
			}
		} else if (!lastCangeDate.equals(other.lastCangeDate)) {
			return false;
		}
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "BaseInfoEmbeddable [createdByUser=" + createdByUser
				+ ", changedByUser=" + changedByUser + ", createdBySystem="
				+ createdBySystem + ", changedBySystem=" + changedBySystem
				+ ", creationDate=" + creationDate + ", lastCangeDate="
				+ lastCangeDate + "]";
	}

}
