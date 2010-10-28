package com.magnusart.crm.business.bpm.validations;

import com.magnusart.crm.business.bpm.Validation;
import com.magnusart.crm.model.e.ConsumerEntity;
import com.magnusart.crm.model.e.RelationEntity;

public class FaultyConsumerRelation implements Validation {

	private final ConsumerEntity consumer;
	private final RelationEntity relation;

	public FaultyConsumerRelation(final ConsumerEntity consumer,
			final RelationEntity relation) {
		this.consumer = consumer;
		this.relation = relation;
	}

	/**
	 * @return the consumer
	 */
	public ConsumerEntity getConsumer() {
		return consumer;
	}

	/**
	 * @return the relation
	 */
	public RelationEntity getRelation() {
		return relation;
	}

}
