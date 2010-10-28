package com.magnusart.crm.model.e;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
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
 * The Soft Product Entity
 * 
 * @author Magnus Andersson
 * @since 3 okt 2010
 */
@Entity
@EntityListeners({ BaseInfoFiller.class })
@DiscriminatorColumn(name = "soft_product_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "soft_products")
public abstract class SoftProductEntity implements HasBaseInfo {

	public static final String BUYERS_CONTRACT_TYPE = "BUYERS_CONTRACT";

	public static final String RSA_CONTRACT_TYPE = "RSA_CONTRACT";

	@Id
	@SequenceGenerator(name = "soft_prod_seq", sequenceName = "soft_prod_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "soft_prod_seq")
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
		return "SoftProductEntity [id=" + id + ", version=" + version
				+ ", baseInfo=" + baseInfo + "]";
	}
}
