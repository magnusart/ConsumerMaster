package com.magnusart.crm.model.e.vehicles;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.magnusart.crm.model.e.VehicleEntity;
import com.magnusart.crm.model.e.relations.AccessoryRelationEntity;

@Entity
@Table(name = "volvos")
public class VolvoEntity extends VehicleEntity {

	@Column(nullable = false)
	private long fyon;

	@Column(nullable = false, name = "serial_num")
	private String serialNum;

	@Column(nullable = false)
	private String model;

	@Column(nullable = false, name = "model_year")
	private String modelYear;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "volvo_accessories_join", uniqueConstraints = { @UniqueConstraint(columnNames = {
			"vehicle_id_fk", "accessory_id_fk" }) }, joinColumns = { @JoinColumn(name = "vehicle_id_fk", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "accessory_id_fk", nullable = false) })
	protected Collection<AccessoryRelationEntity> accessoryRelations = new ArrayList<AccessoryRelationEntity>();

	/**
	 * @return the fyon
	 */
	public long getFyon() {
		return fyon;
	}

	/**
	 * @param fyon
	 *            the fyon to set
	 */
	public void setFyon(final long fyon) {
		this.fyon = fyon;
	}

	/**
	 * @return the serialNum
	 */
	public String getSerialNum() {
		return serialNum;
	}

	/**
	 * @param serialNum
	 *            the serialNum to set
	 */
	public void setSerialNum(final String serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(final String model) {
		this.model = model;
	}

	/**
	 * @return the modelYear
	 */
	public String getModelYear() {
		return modelYear;
	}

	/**
	 * @param modelYear
	 *            the modelYear to set
	 */
	public void setModelYear(final String modelYear) {
		this.modelYear = modelYear;
	}

	/**
	 * @return the accessoryRelationIds
	 */
	public Collection<AccessoryRelationEntity> getAccessoryRelationIds() {
		return accessoryRelations;
	}

}
