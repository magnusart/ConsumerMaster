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
import com.magnusart.crm.model.e.VehicleEntity;

/**
 * A Consumer to Vehicle relation
 * 
 * @author Magnus Andersson
 * @since 21 sep 2010
 */
@Entity
@Table(name = "vehicle_relations", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"status", "vehicle_fk" }) })
public class VehicleRelationEntity extends RelationEntity {

	/**
	 * Status of Consumer to Vehicle relation
	 * 
	 * @author Magnus Andersson
	 * @since 21 sep 2010
	 */
	public enum VehicleRelationStatus {
		DRIVES, OWNS
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "vehicle_fk")
	private VehicleEntity vehicle;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private VehicleRelationStatus status;

	/**
	 * @return the vehicle
	 */
	public VehicleEntity getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle
	 *            the vehicle to set
	 */
	public void setVehicle(final VehicleEntity vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the status
	 */
	public VehicleRelationStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(final VehicleRelationStatus status) {
		this.status = status;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof VehicleRelationEntity)) {
			return false;
		}
		final VehicleRelationEntity other = (VehicleRelationEntity) obj;
		if (status != other.status) {
			return false;
		}
		if (vehicle == null) {
			if (other.vehicle != null) {
				return false;
			}
		} else if (!vehicle.equals(other.vehicle)) {
			return false;
		}
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "VehicleRelationEntity [vehicle=" + vehicle + ", status="
				+ status + ", getStartEndInfo()=" + getStartEndInfo() + "]";
	}

}
