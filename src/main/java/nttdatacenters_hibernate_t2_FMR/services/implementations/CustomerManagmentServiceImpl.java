package nttdatacenters_hibernate_t2_FMR.services.implementations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdatacenters_hibernate_t2_FMR.exceptions.CustomerNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingCustomer;
import nttdatacenters_hibernate_t2_FMR.persistence.Customer;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations.CustomerDaoImpl;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.CustomerDaoI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.CustomerManagmentServiceI;

/**
 * Implementacion de la interfaz CustomerManagmentServiceI
 * 
 * @author nandi
 *
 */
public class CustomerManagmentServiceImpl implements CustomerManagmentServiceI {

	/** DAO de los clientes */
	private CustomerDaoI customerDao;

	/** Logger para la clase */
	private static final Logger CUSTOMERDAOLOG = LoggerFactory.getLogger(CustomerManagmentServiceImpl.class);

	/**
	 * Constructor Servicio
	 */
	public CustomerManagmentServiceImpl() {
		
		CUSTOMERDAOLOG.debug("Creando el servicio de gestion de clientes");
		// Se inyecta el DAO de los clientes
		customerDao = new CustomerDaoImpl();

	}

	@Override
	public void insertNewCustomer(Customer customer) throws ExistingCustomer {

		// Si el DNI cliente pasado por parametro no es nulo y el id del cliente es nulo
		// entra en la condicion
		if (customer != null && customer.getId() == null && customer.getDni() != null) {
			CUSTOMERDAOLOG.debug("Insertando un nuevo cliente DNI: {}", customer.getDni());

			// Si el cliente que obtiene el dao es igual a null es que no existe ningun
			// cliente con su dni
			// Entra en la condicion y lo inserta si es distinto a null lanza una excepcion
			if (customerDao.getCustomerByDNI(customer.getDni()) == null) {

				// Consume el dao e inserta el cliente
				customerDao.insert(customer);

			} else {

				CUSTOMERDAOLOG.info("Existe un cliente con el DNI: {}", customer.getDni());
				throw new ExistingCustomer("Ya existe un cliente con el mismo DNI el cliente no se insertara");

			}

		}

	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerNotFound {

		// Si el el id del cliente no es nulo
		// entra en la condicion
		if (customer != null && customer.getId() != null) {
			CUSTOMERDAOLOG.debug("Actualizando el cliente con DNI: {}", customer.getDni());

			// Si el cliente que devuelve el dao con el id del cliente pasado por parametro
			// es distinto a null
			// entra en la condicion y actualiza el cliente
			if (customerDao.searchById(customer.getId()) != null) {

				// Consume el dao e actualiza el cliente
				customerDao.update(customer);

			} else {

				CUSTOMERDAOLOG.info("No se ha encontrado cliente con DNI: {}", customer.getDni());
				throw new CustomerNotFound("No se encuentra el cliente que se quiere actualizar");

			}

		}

	}

	@Override
	public void deleteCustomer(Customer customer) {

		// Si el cliente pasado por parametro no es nulo y el id del cliente no es nulo
		// entra en la condicion
		if (customer != null && customer.getId() != null) {
			CUSTOMERDAOLOG.debug("Eliminando el cliente con DNI: {}", customer.getDni());
			// Consume el DAO y borra el cliente
			customerDao.delete(customer);

		}

	}

	@Override
	public Customer getCustomerById(Long customerId) {

		Customer customer = null;

		// Si el id pasado por paraemtro no es null entra en la condicion
		if (customerId != null) {
			CUSTOMERDAOLOG.debug("Obteniendo el cliente con ID: {}", customerId);

			// Consume el dao y obtiene el cliente
			customer = customerDao.searchById(customerId);

		}

		// Devuelve el cliente
		return customer;

	}

	@Override
	public List<Customer> getAllCustomers() {

		CUSTOMERDAOLOG.debug("Obteniendo todos los clientes");

		List<Customer> customerList = null;

		// Consume el DAO y obtiene todos los clientes
		customerList = customerDao.searchAll();

		return customerList;
	}

	@Override
	public Customer getCustomerByDNI(String dni) throws CustomerNotFound {

		Customer customer = null;

		// Si el dni pasado por parametro no es nulo y la longitud del dni es 9 entra en
		// la condicion
		if (dni != null && dni.length() == 9) {
			CUSTOMERDAOLOG.debug("Obteniendo el cliente con DNI: {}", dni);

			if (customerDao.getCustomerByDNI(dni) != null) {

				// Consume el dao y obtiene el cliente
				customer = customerDao.getCustomerByDNI(dni);

			} else {

				CUSTOMERDAOLOG.info("No se ha encontrado cliente con DNI: {}", dni);
				throw new CustomerNotFound("No se ha encontrado el cliente con DNI: " + dni);

			}

		}

		// Devuelve el cliente
		return customer;
	}

	@Override
	public void deleteCustomerById(Long customerId) {

		// Si el id no es null entra en la condicion
		if (customerId != null) {
			CUSTOMERDAOLOG.debug("Eliminando el cliente con Id: {}", customerId);

			// Consume el dao y borra el cliente con el id
			customerDao.deleteById(customerId);

		}

	}

	@Override
	public List<Customer> getCustomerByContractMonthlyGt(Double monthlyPrice) {
		
		//Crea una lista de clientes a null
		List<Customer> customers = null;
		
		//Si el precio mensual pasado por parametro es distinto a null entra en la condicion
		if(monthlyPrice != null) {
			
		//Consume el DAO y obtiene la lista que devuelve y la guarda en una variable
		 customers = customerDao.getCustomerByContractMonthlyGt(monthlyPrice);
			
		}
		
		//Devuelve la lista 
		return customers;
	}

}
