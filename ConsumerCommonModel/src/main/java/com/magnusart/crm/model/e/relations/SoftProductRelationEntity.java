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
import com.magnusart.crm.model.e.SoftProductEntity;

/**
 * Soft product relation type
 * 
 * @author Magnus Andersson
 * @since 2 okt 2010
 */
@Entity
@Table(name = "soft_product_relations", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"status", "soft_product_fk" }) })
public class SoftProductRelationEntity extends RelationEntity {

	/**
	 * Soft Product Status
	 * 
	 * @author Magnus Andersson
	 * @since 3 okt 2010
	 */
	public enum SoftProductStatus {
		DRAFTED, VERIFIED
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "soft_product_fk")
	private SoftProductEntity softProduct;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private SoftProductStatus status;

	/**
	 * @return the softProduct
	 */
	public SoftProductEntity getSoftProduct() {
		return softProduct;
	}

	/**
	 * @param softProduct
	 *            the softProduct to set
	 */
	public void setSoftProduct(final SoftProductEntity softProduct) {
		this.softProduct = softProduct;
	}

	/**
	 * @return the status
	 */
	public SoftProductStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(final SoftProductStatus status) {
		this.status = status;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((softProduct == null) ? 0 : softProduct.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SoftProductRelationEntity)) {
			return false;
		}
		final SoftProductRelationEntity other = (SoftProductRelationEntity) obj;
		if (softProduct == null) {
			if (other.softProduct != null) {
				return false;
			}
		} else if (!softProduct.equals(other.softProduct)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "SoftProductRelationEntity [softProduct=" + softProduct
				+ ", status=" + status + "]";
	}

}
