package nttdatacenters_hibernate_t2_FMR;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdatacenters_hibernate_t2_FMR.exceptions.CustomerNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingContractType;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingCustomer;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingDepartment;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingEmployee;
import nttdatacenters_hibernate_t2_FMR.persistence.CType;
import nttdatacenters_hibernate_t2_FMR.persistence.Contract;
import nttdatacenters_hibernate_t2_FMR.persistence.ContractType;
import nttdatacenters_hibernate_t2_FMR.persistence.Customer;
import nttdatacenters_hibernate_t2_FMR.persistence.Department;
import nttdatacenters_hibernate_t2_FMR.persistence.Employee;
import nttdatacenters_hibernate_t2_FMR.services.implementations.ContractManagmentServiceImpl;
import nttdatacenters_hibernate_t2_FMR.services.implementations.ContractTypeManagmentServiceImpl;
import nttdatacenters_hibernate_t2_FMR.services.implementations.CustomerManagmentServiceImpl;
import nttdatacenters_hibernate_t2_FMR.services.implementations.DepartmentManagmentServiceImpl;
import nttdatacenters_hibernate_t2_FMR.services.implementations.EmployeeManagmentServiceImpl;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.ContractManagmentServiceI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.ContractTypeManagmentServiceI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.CustomerManagmentServiceI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.DepartmentManagmentServiceI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.EmployeeManagmentServiceI;

/**
 * Clase principal 
 * 
 * @author nandi
 *
 */
public class Main {
	
	/** Logger para la clase */
	private static final Logger MAINLOG = LoggerFactory.getLogger(Main.class);

	/**
	 * Metodo principal 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MAINLOG.debug("Inicio del programa");

		String user = "FernandoMarqz";
		Date date = Date.valueOf(LocalDate.of(2022, 11, 16));

		/** Inyecta el servicio de gestion de clientes */
		CustomerManagmentServiceI customerService = new CustomerManagmentServiceImpl();
		EmployeeManagmentServiceI employeeService = new EmployeeManagmentServiceImpl();
		DepartmentManagmentServiceI departmentService = new DepartmentManagmentServiceImpl();
		ContractManagmentServiceI contractService = new ContractManagmentServiceImpl();
		ContractTypeManagmentServiceI contractTypeService = new ContractTypeManagmentServiceImpl();

		/** Cliente 1 */
		Customer c1 = new Customer();
		c1.setDni("11111111L");
		c1.setName("Fernando");
		c1.setFirstSurname("Márquez");
		c1.setSecondSurname("Rodríguez");
		c1.setUpdatedUser(user);
		c1.setUpdatedDate(date);

		/** Cliente 2 */
		Customer c2 = new Customer();
		c2.setDni("22222222L");
		c2.setName("Juan Alejandro");
		c2.setFirstSurname("Téllez");
		c2.setSecondSurname("Rubio");
		c2.setUpdatedUser(user);
		c2.setUpdatedDate(date);

		/**
		 * Cliente 3 (Este cliente cuando se inserte no deberia insertarse, ya que tiene
		 * el DNI del Cliente 1)
		 */
		Customer c3 = new Customer();
		c3.setDni("11111111L");
		c3.setName("Pepe");
		c3.setFirstSurname("Villuela");
		c3.setSecondSurname("Torres");
		c3.setUpdatedUser(user);
		c3.setUpdatedDate(date);

		/** Tipos de contrato */
		ContractType ct1 = new ContractType();
		ct1.setType(CType.ELECTRCIDAD);
		ct1.setUpdatedDate(date);
		ct1.setUpdatedUser(user);

		ContractType ct2 = new ContractType();
		ct2.setType(CType.AGUA);
		ct2.setUpdatedDate(date);
		ct2.setUpdatedUser(user);

		ContractType ct3 = new ContractType();
		ct3.setType(CType.GAS);
		ct3.setUpdatedDate(date);
		ct3.setUpdatedUser(user);

		/** Contratos Cliente 1 */
		
		Contract contract1 = new Contract();
		contract1.setContractType(ct1);
		contract1.setEffectiveDate(Date.valueOf(LocalDate.of(2022, 11, 16)));
		contract1.setExpirationDate(Date.valueOf(LocalDate.of(2022, 11, 30)));
		contract1.setCustomer(c1);
		contract1.setMonthlyPrice(1000);
		contract1.setUpdatedDate(date);
		contract1.setUpdatedUser(user);


		Contract contract2 = new Contract();
		contract2.setContractType(ct2);
		contract2.setEffectiveDate(Date.valueOf(LocalDate.of(2022, 11, 16)));
		contract2.setExpirationDate(Date.valueOf(LocalDate.of(2022, 12, 5)));
		contract2.setCustomer(c1);
		contract2.setMonthlyPrice(1500);
		contract2.setUpdatedDate(date);
		contract2.setUpdatedUser(user);


		/** Contratos del cliente 2 */

		Contract contract3 = new Contract();
		contract3.setContractType(ct1);
		contract3.setEffectiveDate(Date.valueOf(LocalDate.of(2022, 11, 16)));
		contract3.setExpirationDate(Date.valueOf(LocalDate.of(2022, 11, 30)));
		contract3.setCustomer(c2);
		contract3.setMonthlyPrice(500);
		contract3.setUpdatedDate(date);
		contract3.setUpdatedUser(user);


		Contract contract4 = new Contract();
		contract4.setContractType(ct2);
		contract4.setEffectiveDate(Date.valueOf(LocalDate.of(2022, 12, 16)));
		contract4.setExpirationDate(Date.valueOf(LocalDate.of(2023, 1, 5)));
		contract4.setCustomer(c2);
		contract4.setMonthlyPrice(2500);
		contract4.setUpdatedDate(date);
		contract4.setUpdatedUser(user);


		Contract contract5 = new Contract();
		contract5.setContractType(ct3);
		contract5.setEffectiveDate(Date.valueOf(LocalDate.of(2022, 11, 16)));
		contract5.setExpirationDate(Date.valueOf(LocalDate.of(2023, 1, 15)));
		contract5.setCustomer(c2);
		contract5.setMonthlyPrice(200);
		contract5.setUpdatedDate(date);
		contract5.setUpdatedUser(user);
		
		List<Contract> ct1C = new LinkedList<>();
		ct1C.add(contract1);
		ct1C.add(contract3);
		
		ct1.setContracts(ct1C);
		
		List<Contract> ct2C = new LinkedList<>();
		ct2C.add(contract2);
		ct2C.add(contract4);
		
		ct2.setContracts(ct2C);
		
		List<Contract> ct3C = new LinkedList<>();
		ct3C.add(contract5);
		
		ct3.setContracts(ct3C);


		/** Creacion de departamentos */
		Department dp1 = new Department();
		dp1.setName("rrhh");
		dp1.setUpdatedDate(date);
		dp1.setUpdatedUser(user);

		Department dp2 = new Department();
		dp2.setName("Developers");
		dp2.setUpdatedDate(date);
		dp2.setUpdatedUser(user);

		Department dp3 = new Department();
		dp3.setName("backend");
		dp3.setUpdatedDate(date);
		dp3.setUpdatedUser(user);
		dp3.setRootDepartment(dp2);

		
		Department dp4 = new Department();
		dp4.setName("fronted");
		dp4.setUpdatedDate(date);
		dp4.setUpdatedUser(user);
		dp4.setRootDepartment(dp2);
		
		List<Department> dp2Children = new LinkedList<>();
		
		dp2Children.add(dp3);
		dp2Children.add(dp4);
		
		dp2.setChildrenDepartments(dp2Children);

		/** Creacion de empleados */
		Employee emp1 = new Employee();
		emp1.setDni("33333333L");
		emp1.setName("David");
		emp1.setFirstSurname("Rodriguez");
		emp1.setSecondSurname("Aguilar");
		emp1.setUpdatedUser(user);
		emp1.setUpdatedDate(date);
		emp1.setDepartmentLed(dp1);
		emp1.setDepartment(dp1);
		dp1.setBoss(emp1);


		Employee emp2 = new Employee();
		emp2.setDni("4444444L");
		emp2.setName("Victor");
		emp2.setFirstSurname("Carrasco");
		emp2.setSecondSurname("Artacho");
		emp2.setUpdatedUser(user);
		emp2.setUpdatedDate(date);
		emp2.setDepartmentLed(dp2);
		emp2.setDepartment(dp2);
		dp2.setBoss(emp2);

		List<Employee> c1Emps = new LinkedList<>();
		c1Emps.add(emp1);
		
		c1.setEmployeesSeen(c1Emps);
	
		List<Employee> c2Emps = new LinkedList<>();
		c2Emps.add(emp1);
		c2Emps.add(emp2);
		
		c2.setEmployeesSeen(c2Emps);
		
		// Consume el servicio de gestion de clientes e inserta los clientes
		try {
			customerService.insertNewCustomer(c1);
			customerService.insertNewCustomer(c2);
			customerService.insertNewCustomer(c3);
		} catch (ExistingCustomer e) {

			MAINLOG.error(e.getMessage());
			System.out.println(e.getMessage());
		}

		try {
			contractTypeService.insertNewContractType(ct1);
			contractTypeService.insertNewContractType(ct2);
			contractTypeService.insertNewContractType(ct3);
		} catch (ExistingContractType e) {

			MAINLOG.error(e.getMessage());
			e.printStackTrace();
		}


		try {
			departmentService.insertNewDepartment(dp1);
			departmentService.insertNewDepartment(dp2);
			departmentService.insertNewDepartment(dp3);
			departmentService.insertNewDepartment(dp4);
		} catch (ExistingDepartment e) {

			MAINLOG.error(e.getMessage());
			e.printStackTrace();
		}

		try {
			employeeService.insertNewEmployee(emp1);
			employeeService.insertNewEmployee(emp2);
		} catch (ExistingEmployee e) {

			MAINLOG.error(e.getMessage());
			e.printStackTrace();
		}
		
 		System.out.println(employeeService.getAllEmployees());
		System.out.println(employeeService.getAllEmployees());

		contractTypeService.deleteContractTypeByd(1L);
		
		try {
			customerService.deleteCustomer(customerService.getCustomerByDNI("11111111L"));
		} catch (CustomerNotFound e) {
			
			MAINLOG.error(e.getMessage());
			e.printStackTrace();
		}
		
		employeeService.deleteEmployee(employeeService.getEmployeeById(2L));
		
		try {
			Customer c = customerService.getCustomerByDNI("22222222L");
			
			c.setName("Pepe");
			
			customerService.updateCustomer(c);
		} catch (CustomerNotFound e) {

			MAINLOG.error(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println(contractService.getAllContracts());
		
		MAINLOG.debug("Fin del programa");

	}
}
