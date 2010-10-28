package com.magnusart.crm.business.bpm.validations;

import com.magnusart.crm.business.bpm.Validation;
import com.magnusart.crm.model.e.RelationEntity;
import com.magnusart.crm.model.e.VehicleEntity;

public class FaultyVehicleRelation implements Validation {

	private final VehicleEntity vehicle;
	private final RelationEntity relation;

	public FaultyVehicleRelation(final VehicleEntity vehicle, final RelationEntity relation) {
		this.vehicle = vehicle;
		this.relation = relation;
	}

	/**
	 * @return the vehicle
	 */
	public VehicleEntity getVehicle() {
		return vehicle;
	}

	/**
	 * @return the relation
	 */
	public RelationEntity getRelation() {
		return relation;
	}
}