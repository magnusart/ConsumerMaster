package com.magnusart.crm.model.e;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.magnusart.crm.model.e.embeddable.BaseInfoEmbeddable;
import com.magnusart.crm.model.e.embeddable.StartEndDateInfoEmbeddable;
import com.magnusart.crm.model.e.listeners.BaseInfoFiller;
import com.magnusart.crm.model.e.listeners.StartDateFiller;
import com.magnusart.crm.model.i.HasBaseInfo;
import com.magnusart.crm.model.i.HasStartEndDate;

/**
 * The relation entity
 * 
 * @author Magnus Andersson
 * @since 27 sep 2010
 */
@Entity
@EntityListeners({ BaseInfoFiller.class, StartDateFiller.class })
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "relations")
public abstract class RelationEntity implements HasBaseInfo, HasStartEndDate {

	@Id
	@SequenceGenerator(name = "relation_seq", sequenceName = "relation_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relation_seq")
	@Column(insertable = false, updatable = false)
	private long id;

	@Version
	private int version;

	@Embedded
	private final BaseInfoEmbeddable baseInfo = new BaseInfoEmbeddable();

	@Embedded
	private final StartEndDateInfoEmbeddable startEnd = new StartEndDateInfoEmbeddable();

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final long id) {
		this.id = id;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/** {@inheritDoc} */
	@Override
	public StartEndDateInfoEmbeddable getStartEndInfo() {
		return startEnd;
	}

	/** {@inheritDoc} */
	@Override
	public BaseInfoEmbeddable getBaseInfo() {
		return baseInfo;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "RelationEntity [id=" + id + ", version=" + version
				+ ", baseInfo=" + baseInfo + ", startEnd=" + startEnd + "]";
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((startEnd == null) ? 0 : startEnd.hashCode());
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
		if (!(obj instanceof RelationEntity)) {
			return false;
		}
		final RelationEntity other = (RelationEntity) obj;
		if (startEnd == null) {
			if (other.startEnd != null) {
				return false;
			}
		} else if (!startEnd.equals(other.startEnd)) {
			return false;
		}
		return true;
	}

}
