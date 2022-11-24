package nttdatacenters_hibernate_t2_FMR.services.implementations;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdatacenters_hibernate_t2_FMR.exceptions.ContractNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingContract;
import nttdatacenters_hibernate_t2_FMR.persistence.Contract;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations.ContractDaoImpl;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.ContractDaoI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.ContractManagmentServiceI;

/**
 * Implementacion de la interfaz ContractManagmentServiceI
 * 
 * @author nandi
 *
 */
public class ContractManagmentServiceImpl implements ContractManagmentServiceI {

	/** DAO de los contratos */
	private ContractDaoI contractDao;

	/** Logger para la clase */
	private static final Logger CMSILOG = LoggerFactory.getLogger(ContractManagmentServiceImpl.class);

	/**
	 * Constructor servicio
	 */
	public ContractManagmentServiceImpl() {
		
		CMSILOG.debug("Creado el servicio de gestion de contratos");
		// Inyecta el DAO de los contratos
		contractDao = new ContractDaoImpl();

	}

	@Override
	public void insertNewContract(Contract contract) throws ExistingContract {
		CMSILOG.debug("Insertando un nuevo contrato");
		// Crea un booleano a falso
		boolean exist = Boolean.FALSE;

		// si el contrato pasado por parametro es distinto a null y su id es null
		// entra en la condicion
		if (contract != null && contract.getId() == null) {

			// Si los contratos que obtiene el dao de contrato es distinto a null es que el
			// cliente del contrato tiene mas contratos
			if (contractDao.getContractsByCustomer(contract.getCustomer()) != null) {

				// Crea un iterador de los contratos
				Iterator<Contract> it = contractDao.getContractsByCustomer(contract.getCustomer()).iterator();

				// Mientras que exist sea falta y el iterador tenga valor siguiente entra en la
				// condicion
				while (it.hasNext() && !exist) {

					// Crea la variable contrato igualando al valor que devuelve el iterador
					Contract c = it.next();

					// Si el id del tipo de contrato de la variable c es igual que el id del tipo de
					// contrato del contrao pasado por parametro entrra en la condicion
					if (c.getContractType().getId().equals(contract.getContractType().getId())) {

						// Iguala exist a true
						// Significa que ya hay un contrato del mismo tipo de ese cliente
						exist = Boolean.TRUE;

					}

				}

			}

			// Si exist es falso entra en la condicion e inserta el contrato
			// Si es true lanza una excepcion
			if (!exist) {

				// Consume el dao e inserta el cliente
				contractDao.insert(contract);
				CMSILOG.debug("Contrato Insertado {}", contract.getCustomer().getDni());

			} else {
				
				CMSILOG.error("El contrato que se intenta insertar ya existe");
				throw new ExistingContract("El contrato que se intenta insertar ya existe");

			}

		}

	}

	@Override
	public void updateContract(Contract contract) throws ContractNotFound {

		CMSILOG.debug("Actualizando un contrato");
		
		// Si el contrato pasado por parametro es distinto a null y el id tambien lo es
		// Entra en la condicion
		if (contract != null && contract.getId() != null) {

			// Si el contrato que obtiene el dao es distitno a null es que existe y entra en
			// la condicion
			// Si es null lanza una excepcion
			if (contractDao.searchById(contract.getId()) != null) {

				CMSILOG.debug("Actualizando el contrato con id {}", contract.getContractId());
				// Consume el dao y actualiza el contrato
				contractDao.update(contract);

			} else {

				CMSILOG.error("El contrato que intenta actualizar no existe id:{}", contract.getContractId());
				throw new ContractNotFound("El contrato que se intenta actualizar no existe");

			}

		}

	}

	@Override
	public void deleteContract(Contract contract) {

		// Si el contrato pasado por parametro es distinto a null y su id tambien lo es
		// entra en la condicion
		if (contract != null && contract.getId() != null) {

			CMSILOG.debug("Borrando el contrato con id:{}", contract.getContractId());
			// Consume el DAO y borra el contrato
			contractDao.delete(contract);

		}

	}

	@Override
	public void deleteContractByd(Long id) {

		// Si el id pasado por parametro es distinto a nulo entra en la condicion
		if (id != null) {
			CMSILOG.debug("Borrando el contrato con id:{}", id);
			// Consume el dao y borra el contrato con el id pasado por parametro
			contractDao.deleteById(id);

		}

	}

	@Override
	public Contract getContractById(Long id) {

		// Crea un contrato a null
		Contract contract = null;

		// Si el id pasado por parametro es distinto a null entra en la condicion
		if (id != null) {
			CMSILOG.debug("Obteniendo el contrato con id: {}", id);
			// Consume el dao y guarda en la variable creada el contrato que devuelve el DAO
			// que tiene el id pasado por parametro
			contract = contractDao.searchById(id);

		}

		// Devuelve el contrato
		return contract;
	}

	@Override
	public List<Contract> getAllContracts() {

		CMSILOG.debug("Obteniendo todos los contratos");
		
		// Crea una lista de contratos a null
		List<Contract> contracts = null;

		// Consume el dao y guarda en una la lista obtenida en la creada
		contracts = contractDao.searchAll();

		// Devuelve la lista
		return contracts;
	}

}
