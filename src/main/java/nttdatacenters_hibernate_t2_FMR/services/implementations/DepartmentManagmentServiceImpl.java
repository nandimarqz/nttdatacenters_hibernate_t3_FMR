package nttdatacenters_hibernate_t2_FMR.services.implementations;

import java.util.List;

import nttdatacenters_hibernate_t2_FMR.exceptions.DepartmentNotFound;
import nttdatacenters_hibernate_t2_FMR.exceptions.ExistingDepartment;
import nttdatacenters_hibernate_t2_FMR.persistence.Department;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations.DepartmentDaoImpl;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.DepartmentDaoI;
import nttdatacenters_hibernate_t2_FMR.services.interfaces.DepartmentManagmentServiceI;

public class DepartmentManagmentServiceImpl implements DepartmentManagmentServiceI {

	private DepartmentDaoI depDao;
	
	
	public DepartmentManagmentServiceImpl() {
		
		depDao = new DepartmentDaoImpl();
		
	}
	
	@Override
	public void insertNewDepartment(Department department) throws ExistingDepartment {
		
		if(department != null && department.getId() == null && department.getName() != null) {
			
			department.setName(department.getName().toUpperCase());
			
			if(depDao.getDepartmentByName(department.getName()) == null) {
				
				depDao.insert(department);
				
			}else {
				
				throw new ExistingDepartment("El departamento que intenta insertar ya existe");
				
			}
			
		}
		
	}

	@Override
	public void updateDepartment(Department department) throws DepartmentNotFound {
		
		if(department != null && department.getId() != null) {
			
			if(depDao.searchById(department.getId()) != null) {
				
				depDao.update(department);
				
			}else {
				
				throw new DepartmentNotFound("El departamento que se intenta actualizar no existe");
				
			}
			
		}
		
	}

	@Override
	public void deleteDepartment(Department department) {
		
		if(department != null && department.getId() != null) {
			
			depDao.delete(department);
			
		}
		
	}

	@Override
	public void deleteDepartmentByd(Long id) {
		
		if(id != null) {
			
			depDao.deleteById(id);
			
		}
		
	}

	@Override
	public Department getDepartmentById(Long id) {
		
		Department d = null;
		
		if(id != null) {
			
			d = depDao.searchById(id);
			
		}
		
		return d;
	}

	@Override
	public List<Department> getAllDepartments() {
		
		List<Department> deps = null;
		
		deps = depDao.searchAll();
		
		return deps;
	}

}
