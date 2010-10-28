package com.magnusart.crm.business;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.drools.runtime.StatefulKnowledgeSession;

import com.magnusart.crm.business.bpm.ProcessEngine;
import com.magnusart.crm.business.bpm.validations.FaultyConsumerRelation;

/**
 * Session Bean implementation class ConsumerInput
 */
@Stateless
@LocalBean
public class ConsumerInput {

	private ProcessEngine engine;
	private FaultyConsumerRelation validation;
	private EntityManager em;

	@EJB
	void insertEngine(final ProcessEngine engine) {
		this.engine = engine;
	}

	@PersistenceContext(unitName = "CRM")
	void insertEntityManager(final EntityManager em) {
		this.em = em;
	}

	/**
	 * Default constructor.
	 */
	public ConsumerInput() {

	}

	/**
	 * Create consumer Service
	 * 
	 * @param createConsumer
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean createConsumer() {
		final StatefulKnowledgeSession ksession = engine.getSession();
		// ksession.insert(createConsumer);
		ksession.insert(validation);
		engine.run();

		// if (createConsumer.isValidated() && createConsumer.isPersistable()) {
		// em.persist(createConsumer.getEntity());
		// em.flush();
		// }

		return true;
	}

}
