package nttdatacenters_hibernate_t2_FMR.services.interfaces;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.DepartmentNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingDepartment;
import nttdatacenters_hibernate_t2_FMR.persistence.Department;

public interface DepartmentManagmentServiceI {

	public void insertNewDepartment(Department department) throws ExistingDepartment;
	
	public void updateDepartment(Department department) throws DepartmentNotFound;
	
	public void deleteDepartment(Department department);
	
	public void deleteDepartmentByd(Long id);
	
	public Department getDepartmentById(Long id);
	
	public List<Department> getAllDepartments();
	
}
