package com.magnusart.crm.business;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.magnusart.crm.business.bpm.ProcessEngine;
import com.magnusart.crm.business.bpm.configurations.CreateConsumerConfig;
import com.magnusart.crm.model.e.RelationEntity;
import com.magnusart.crm.model.e.addresses.FacebookAddressEntity;
import com.magnusart.crm.model.e.addresses.PostalAddressEntity;
import com.magnusart.crm.model.e.consumers.PersonEntity;
import com.magnusart.crm.model.e.consumers.PersonEntity.Gender;
import com.magnusart.crm.model.e.relations.SoftProductRelationEntity;
import com.magnusart.crm.model.e.relations.SoftProductRelationEntity.SoftProductStatus;
import com.magnusart.crm.model.e.relations.VehicleRelationEntity;
import com.magnusart.crm.model.e.relations.VehicleRelationEntity.VehicleRelationStatus;
import com.magnusart.crm.model.e.softproducts.BuyersContractEntity;
import com.magnusart.crm.model.e.softproducts.RoadSideAssistanceContractEntity;
import com.magnusart.crm.model.e.vehicles.VolvoEntity;

public class CreateConsumerScenario {

	private static final String PERSISTENCE_UNIT = "CRM_DEV_TEST";
	private ConsumerInput cInput;
	private EntityManager em;

	@Before
	public void setUp() {
		cInput = new ConsumerInput();
		final ProcessEngine engine = new ProcessEngine();
		engine.setUpEngine(new CreateConsumerConfig());
		cInput.insertEngine(engine);

		final EntityManagerFactory emFactory = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT);
		em = emFactory.createEntityManager();
		em.getTransaction().begin();
		em.getTransaction().setRollbackOnly();
		cInput.insertEntityManager(em);
	}

	@Test
	public void happyFlowCreateConsumer() throws Exception {

		final PersonEntity p = setUpPerson();

		// final CreateConsumer cc = new CreateConsumer(p);
		// cInput.createConsumer(cc);

		// assertTrue(cc.isValidated());
		// assertTrue(cc.isPersistable());
	}

	private PersonEntity setUpPerson() {
		final PostalAddressEntity paddress = new PostalAddressEntity();
		paddress.setLine1("Majorsgatan 8");
		paddress.setCity("Gothenburg");
		paddress.setCountry("SWEDEN");
		paddress.setPostalCode("43362");

		final FacebookAddressEntity fbaddress = new FacebookAddressEntity();
		fbaddress.setFacebookUrl("www.facebook.com/magnusart");

		final VolvoEntity volvo = new VolvoEntity();
		volvo.setModel("V70");
		volvo.setFyon(1121312123);
		volvo.setModelYear("1999");
		volvo.setSerialNum("1212232123MLW");

		final VehicleRelationEntity vehicleRel1 = new VehicleRelationEntity();
		vehicleRel1.setVehicle(volvo);
		vehicleRel1.setStatus(VehicleRelationStatus.OWNS);

		final VehicleRelationEntity vehicleRel2 = new VehicleRelationEntity();
		vehicleRel2.setVehicle(volvo);
		vehicleRel2.setStatus(VehicleRelationStatus.DRIVES);

		final BuyersContractEntity buyersContract = new BuyersContractEntity();
		buyersContract.setVehicle(volvo);

		final SoftProductRelationEntity spr1 = new SoftProductRelationEntity();
		spr1.setStatus(SoftProductStatus.VERIFIED);
		spr1.setSoftProduct(buyersContract);

		final RoadSideAssistanceContractEntity rsaContract = new RoadSideAssistanceContractEntity();
		rsaContract.setVehicle(volvo);

		final SoftProductRelationEntity spr2 = new SoftProductRelationEntity();
		spr2.setStatus(SoftProductStatus.DRAFTED);
		spr2.setSoftProduct(rsaContract);

		final PersonEntity person = new PersonEntity();
		person.getAddresses().add(paddress);
		person.getAddresses().add(fbaddress);
		person.setFirstName("Magnus");
		person.setLastName("Andersson");
		person.setAge(27);
		person.setGender(Gender.MALE);
		final Collection<RelationEntity> rel = person.getRelations();
		rel.add(vehicleRel1);
		rel.add(vehicleRel2);
		rel.add(spr1);
		rel.add(spr2);

		return person;
	}

}
