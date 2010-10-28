package com.magnusart.crm.model.e.relations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.magnusart.crm.model.e.RelationEntity;
import com.magnusart.crm.model.e.consumers.PersonEntity;

/**
 * The Human Relation
 * 
 * @author Magnus Andersson
 * @since 27 sep 2010
 */
@Entity
@Table(name = "human_relations", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"status", "person_fk" }) })
public class HumanRelationEntity extends RelationEntity {

	/**
	 * Valid human relation statuses
	 * 
	 * @author Magnus Andersson
	 * @since 3 okt 2010
	 */
	public enum HumanRelationStatus {
		FATHER_OF, MOTHER_OF, SON_TO, DAUGHTER_TO, FRIEND_OF, COUSIN_TO, RELATIVE
	}

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private HumanRelationStatus status;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "person_fk")
	private PersonEntity person;

	/**
	 * @return the person
	 */
	public PersonEntity getPerson() {
		return person;
	}

	/**
	 * @param person
	 *            the person to set
	 */
	public void setPerson(final PersonEntity person) {
		this.person = person;
	}

	/**
	 * @return the status
	 */
	public HumanRelationStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(final HumanRelationStatus status) {
		this.status = status;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof HumanRelationEntity)) {
			return false;
		}
		final HumanRelationEntity other = (HumanRelationEntity) obj;
		if (person == null) {
			if (other.person != null) {
				return false;
			}
		} else if (!person.equals(other.person)) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "HumanRelationEntity [status=" + status + ", person=" + person
				+ ", getStartEndInfo()=" + getStartEndInfo() + "]";
	}

}
