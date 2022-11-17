package nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces;

import nttdatacenters_hibernate_t2_FMR.persistence.Employee;

public interface EmployeeDaoI extends DaoI<Employee> {
	
	public Employee getEmployeeByDNI(String dni);

}
