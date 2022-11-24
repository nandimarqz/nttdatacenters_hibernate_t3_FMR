package nttdatacenters_hibernate_t2_FMR.services.implementations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdatacenters_hibernate_t2_FMR.exceptions.ContractTypeNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingContractType;
import nttdatacenters_hibernate_t2_FMR.persistence.ContractType;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations.ContractTypeDaoImpl;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.ContractTypeDaoI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.ContractTypeManagmentServiceI;

/**
 * Implementacion del la interfaz ContractTypeManagmentServiceI
 * 
 * @author nandi
 *
 */
public class ContractTypeManagmentServiceImpl implements ContractTypeManagmentServiceI {

	/** DAO de los tipos de contrato */
	private ContractTypeDaoI ctDao;
	
	/** Logger para la clase */
	private static final Logger CTMSILOG = LoggerFactory.getLogger(ContractTypeManagmentServiceImpl.class);

	/**
	 * Constructor del Servicio
	 */
	public ContractTypeManagmentServiceImpl() {

		CTMSILOG.debug("Creado el servicio de gestion de tipos de contrato");
		// Se inyecta el DAO de los tipos de contrato
		ctDao = new ContractTypeDaoImpl();

	}

	@Override
	public void insertNewContractType(ContractType contractType) throws ExistingContractType {
		
		CTMSILOG.debug("Insertando un tipo de contrato");

		// Si el tipo de contrato pasado por parametro no es null y el id si es null
		// Entra en la condicion
		if (contractType != null && contractType.getId() == null) {

			// Si el tipo de contrato que obtiene el dao es igual a null es que no existe
			// un tipo de contrato con su tipo, entra en la condicion y lo inserta
			// Si es distinto a null no entra en la condicion y lanza una excepcion
			if (ctDao.getContractTypeByType(contractType.getType()) == null) {

				CTMSILOG.debug("Insertando un nuevo tipo de contrato tipo:{}", contractType.getType());
				// Consume el DAO y lo inserta
				ctDao.insert(contractType);

			} else {

				CTMSILOG.error("El tipo de contrato que se intentaba inserta ya existe");
				throw new ExistingContractType("El tipo de contrato que intenta insertar ya existe");

			}

		}

	}

	@Override
	public void updateContractType(ContractType contractType) throws ContractTypeNotFound {

		// Si el tipo de contrato pasado por parametro es distinto a null y su id
		// tambien lo es entra en la condicion
		if (contractType != null && contractType.getId() != null) {

			// Si el valor que obtiene el dao es distinto a null es que existe el tipo de
			// contrato y entra en la condicion.
			// Si es null no entra en la condicion y lanza una excepcion.
			if (ctDao.searchById(contractType.getId()) != null) {

				CTMSILOG.debug("Actualizando el tipo de contrato con id: {}", contractType.getId());
				// Consume el DAO y actualiza el tipo de contrato
				ctDao.update(contractType);

			} else {

				CTMSILOG.error("El tipo de contrato que intenta acutalizar no existe id:{}", contractType.getTypeId());
				throw new ContractTypeNotFound("El tipo de contrato que intenta actualizar no existe");

			}

		}

	}

	@Override
	public void deleteContractType(ContractType contractType) {

		// Si el tipo de contrato pasado por parametro es distinto a null y su id
		// tampoco lo es entra en la condicion
		if (contractType != null && contractType.getId() != null) {

			CTMSILOG.debug("Borrando el tipo de contrato con id:{}", contractType.getTypeId());
			// consume el DAO y borra el tipo de contrato
			ctDao.delete(contractType);

		}

	}

	@Override
	public void deleteContractTypeByd(Long id) {

		// Si el id pasado por parametro es distinto a null entra en la condicion
		if (id != null) {

			CTMSILOG.debug("Borrando el tipo de contrato con id:{}", id);
			//Consume el dao y borra el tipo de contrato con el id pasado por parametro
			ctDao.deleteById(id);

		}

	}

	@Override
	public ContractType getContractTypeById(Long id) {

		//Crea un tipo de contrato a null
		ContractType ct = null;

		//Si el id pasado por parametro es distinto a null entra ne la condicion
		if (id != null) {

			CTMSILOG.debug("Obteniendo el tipo de contrato con id:{}", id);
			//consume el dao y guarda el resultado en la variable creada
			ct = ctDao.searchById(id);

		}

		//Devuelve el tipo de contrato
		return ct;
	}

	@Override
	public List<ContractType> getAllContractTypes() {

		CTMSILOG.debug("Obteniendo todos los tipos de contrato");
		//Crea la lista de tipos de contrato a null
		List<ContractType> cst = null;

		//Consume el DAO e iguala la variable al resultado del dao
		cst = ctDao.searchAll();
		
		//Devuelve la lista 
		return cst;
	}

}
