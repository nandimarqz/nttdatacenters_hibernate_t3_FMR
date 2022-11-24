package nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces;

import java.util.List;

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
	
	/**
	 * Devuelve una lista con los clientes que tienen contratos con la mensualidad mayor
	 * a la cantidad pasada por parametro
	 * 
	 * @param monthlyPrice
	 * @return Lista de clientes
	 */
	public List<Customer> getCustomerByContractMonthlyGt(Double monthlyPrice);
}
