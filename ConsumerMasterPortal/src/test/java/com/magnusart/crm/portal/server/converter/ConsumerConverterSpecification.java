package com.magnusart.crm.portal.server.converter;

import org.junit.Before;
import org.junit.Test;

import com.magnusart.crm.portal.shared.PersonDetails;

/**
 * Utility for converting from and to Consumer Types.
 * 
 * @author Magnus Andersson
 * @since 30 okt 2010
 */
public class ConsumerConverterSpecification {

	private static final String PERSON_FIRST_NAME = "Magnus";
	private static final String PERSON_LAST_NAME = "Andersson";
	private static final String PERSON_AGE = "27";
	private static final String PERSON_MIDDLE_NAME = "Anders";
	private static final String PERSON_ID = "1";
	private PersonDetails personDetailsOne;

	@Before
	public void setUp() throws Exception {
		personDetailsOne = new PersonDetails();
		personDetailsOne.setFirstName(PERSON_FIRST_NAME);
		personDetailsOne.setMiddleName(PERSON_MIDDLE_NAME);
		personDetailsOne.setLastName(PERSON_LAST_NAME);
		personDetailsOne.setAge(PERSON_AGE);
		personDetailsOne.setId(PERSON_ID);
	}

	@Test
	public void consumerDetailsCanBeConvertedToConsumerEntity()
			throws Exception {
		ConsumerConverter.convert(personDetailsOne);
	}
}
