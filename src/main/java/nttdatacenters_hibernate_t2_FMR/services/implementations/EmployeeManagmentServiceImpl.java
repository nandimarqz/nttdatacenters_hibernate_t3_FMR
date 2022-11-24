package nttdatacenters_hibernate_t2_FMR.services.implementations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdatacenters_hibernate_t2_FMR.exceptions.EmployeeNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingEmployee;
import nttdatacenters_hibernate_t2_FMR.persistence.Employee;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations.EmployeeDaoImpl;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.EmployeeDaoI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.EmployeeManagmentServiceI;

/**
 * Implementacion de la interfaz EmployeeManagmentServiceI
 * 
 * @author nandi
 *
 */
public class EmployeeManagmentServiceImpl implements EmployeeManagmentServiceI {

	/** DAO de los empleados */
	EmployeeDaoI empDao;
	
	/** Logger para la clase */
	private static final Logger EMSLOG = LoggerFactory.getLogger(EmployeeManagmentServiceImpl.class);

	/**
	 * Constructor Servicio
	 */
	public EmployeeManagmentServiceImpl() {

		EMSLOG.debug("Creado el servicio de gestion de empleados");
		// Se inyecta el DAO de los empleados
		empDao = new EmployeeDaoImpl();

	}

	@Override
	public void insertNewEmployee(Employee employee) throws ExistingEmployee {

		// Si el empleado que se pasa por parametro no es nulo, su id es nulo, y su DNI
		// no es nulo
		if (employee != null && employee.getId() == null && employee.getDni() != null) {

			// Si el resultado que devuelve el metodo no es nulo lanza una excepcion
			// Si es nulo significa que no existe un cliente con el mismo dni entra en la
			// condicion e inserta el empleado
			if (empDao.getEmployeeByDNI(employee.getDni()) == null) {
				
				EMSLOG.debug("Insertando empleado con dni:{}", employee.getDni());
				// Consume el dao e inserta el empleado pasado por parametro
				empDao.insert(employee);

			} else {

				EMSLOG.error("El empleado que se quiere insertar ya existe");
				throw new ExistingEmployee("El empleado que desea insertar ya existe");

			}

		}

	}

	@Override
	public void updateEmployee(Employee employee) throws EmployeeNotFound {

		// Si el empleado que se pasa por parametro no es nulo y el id del empleado
		// tampoco es nulo entra en la condicion
		if (employee != null && employee.getId() != null) {

			// Si el resultado que devuelve el metodo del dao es distinto a nulo entra en la
			// condicion y lo actualiza
			// Si es nulo no entra en la condicion y lanza una excepcion
			if (empDao.searchById(employee.getId()) != null) {

				EMSLOG.debug("Actualizando el empleado con id:{}", employee.getEmployeeId());
				// Consume el dao y actualiza el empleado
				empDao.update(employee);

			} else {

				EMSLOG.error("El empleado que se intenta actualizar no existe");
				throw new EmployeeNotFound("El empleado que se intenta actualizar no existe");

			}

		}

	}

	@Override
	public void deleteEmployee(Employee employee) {

		// Si el empleado pasado por parametro no es nulo y su id tampoco entra en la
		// condicion
		if (employee != null && employee.getId() != null) {

			EMSLOG.debug("Elimiando el empleado con DNI:{}",employee.getDni());
			// Consume el dao y borra el empleado
			empDao.delete(employee);

		}

	}

	@Override
	public void deleteEmployeeByd(Long id) {

		// Si el id pasado por parametro no es nulo entra en la condicion y borra el
		// empleado con el id pasado por parametro
		if (id != null) {

			EMSLOG.debug("Elminando el empleado con id:{}", id);
			empDao.deleteById(id);

		}

	}

	@Override
	public Employee getEmployeeById(Long id) {

		// Crea un empleado a null
		Employee e = null;

		// Si el id pasado por parametro no es nulo entra en la condicion
		if (id != null) {

			EMSLOG.debug("Obteniendo el empleado con id:{}", id);
			// Consume el dao e iguala la variable al resultado del metodo
			e = empDao.searchById(id);

		}

		// Devuelve el empleado
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() {

		EMSLOG.debug("Obteniendo todos los empleados");
		// Crea una lista a null
		List<Employee> employees = null;

		// Consume el dao e iguala la lista al resultado del metodos
		employees = empDao.searchAll();

		// Devuelve la lista
		return employees;
	}

}
