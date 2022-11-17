package nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces;

import nttdatacenters_hibernate_t2_FMR.persistence.Department;

public interface DepartmentDaoI extends DaoI<Department> {

	public Department getDepartmentByName(String name);
	
}
