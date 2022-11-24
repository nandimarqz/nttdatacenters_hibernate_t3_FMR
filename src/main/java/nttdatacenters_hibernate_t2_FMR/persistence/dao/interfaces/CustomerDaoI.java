package nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces;

import nttdatacenters_hibernate_t2_FMR.persistence.Customer;

/**
 * Interfaz para el DAO de clientes
 * 
 * @author nandi
 *
 */
public interface CustomerDaoI extends DaoI<Customer> {

	/**
	 * Devuelve el cliente de la BBDD con el dni pasado por parametro
	 * 
	 * @param dni
	 * @return Customer
	 */
	public Customer getCustomerByDNI(String dni);
}
