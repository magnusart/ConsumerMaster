package com.magnusart.crm.model.e.relations;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.magnusart.crm.model.e.RelationEntity;

/**
 * The Accessory Relation Entity
 * 
 * @author Magnus Andersson
 * @since 27 sep 2010
 */
@Entity
@Table(name = "accessory_relations")
public class AccessoryRelationEntity extends RelationEntity {
	public enum AccessoryStatus {
		HARDWARE
	}
}
