package com.magnusart.crm.model.e.softproducts;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.magnusart.crm.model.e.SoftProductEntity;
import com.magnusart.crm.model.e.VehicleEntity;

/**
 * Road Side Assistance Entity.
 * 
 * @author Magnus Andersson
 * @since 3 okt 2010
 */
@Entity
@DiscriminatorValue(SoftProductEntity.RSA_CONTRACT_TYPE)
public class RoadSideAssistanceContractEntity extends SoftProductEntity {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "vehicle_fk")
	private VehicleEntity vehicle;

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

}
