package com.magnusart.crm.model.e.consumers;


/**
 * Common Consumer Information
 * 
 * @author Magnus Andersson
 * @since 27 sep 2010
 */
public interface ConsumerInformation {

	/**
	 * 
	 * @return The canonical name of this Consumer ie Firstname + Lastname or
	 *         Companyname
	 */
	String getCanonicalName();

}
