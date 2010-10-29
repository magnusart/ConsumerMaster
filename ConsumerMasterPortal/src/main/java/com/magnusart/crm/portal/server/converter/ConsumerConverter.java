package com.magnusart.crm.portal.server.converter;

import com.magnusart.crm.model.e.consumers.CompanyEntity;
import com.magnusart.crm.model.e.consumers.PersonEntity;
import com.magnusart.crm.portal.shared.CompanyDetails;
import com.magnusart.crm.portal.shared.PersonDetails;

/**
 * Utility for converting from and to Consumer Types.
 * 
 * @author Magnus Andersson
 * @since 30 okt 2010
 */
public class ConsumerConverter {
	private ConsumerConverter() {
		// No public constructor
	}

	/**
	 * Converts a ConsumerDetails object into a ConsumerEntity object.
	 * 
	 * @param consumer
	 *            The ConsumerDetails object to be converted to a
	 *            ConsumerEntity.
	 * @return Converted Object
	 */
	public static PersonEntity convert(final PersonDetails consumer) {
		return null;
	}

	/**
	 * Converts a ConsumerEntity object into a ConsumerDetails object.
	 * 
	 * @param consumer
	 *            The ConsumerEntity object to be converted to a
	 *            ConsumerDetails.
	 * @return Converted Object
	 */
	public static PersonDetails convert(final PersonEntity consumer) {
		return null;
	}

	public static CompanyEntity convert(final CompanyDetails consumer) {
		// TODO Auto-generated method stub
		return null;
	}
}
