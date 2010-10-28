package com.magnusart.crm.business;

import javax.ejb.Remote;

/**
 * 
 * @author Magnus Andersson
 * @since 18 okt 2010
 */
@Remote
public interface ConsumerBusinessServices {

	String testService(final String message);

}