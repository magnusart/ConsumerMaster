package com.magnusart.crm.business.bpm;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CrmBusinessServices
 */
@Stateless(mappedName = "CrmBusinessServices")
@LocalBean
public class CrmBusinessServices<T extends Command> {

}
