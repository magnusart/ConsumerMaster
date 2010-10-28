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
import com.magnusart.crm.model.e.listeners.BaseInfoFiller;
import com.magnusart.crm.model.i.HasBaseInfo;

/**
 * The Vehicle relation
 * 
 * @author Magnus Andersson
 * @since 21 sep 2010
 */
@Entity
@EntityListeners(BaseInfoFiller.class)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "vehicles")
public abstract class VehicleEntity implements HasBaseInfo {

	@Id
	@SequenceGenerator(name = "vehicle_seq", sequenceName = "vehicle_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_seq")
	@Column(insertable = false, updatable = false)
	private long id;

	@Version
	private int version;

	@Embedded
	private final BaseInfoEmbeddable baseInfo = new BaseInfoEmbeddable();

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
	public BaseInfoEmbeddable getBaseInfo() {
		return baseInfo;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "VehicleEntity [id=" + id + ", version=" + version
				+ ", baseInfo=" + baseInfo + "]";
	}

}
