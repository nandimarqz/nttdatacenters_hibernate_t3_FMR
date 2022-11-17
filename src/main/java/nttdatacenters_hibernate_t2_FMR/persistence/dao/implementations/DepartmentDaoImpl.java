package nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import nttdatacenters_hibernate_t2_FMR.persistence.Department;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.DepartmentDaoI;
import nttdatacenters_hibernate_t2_FMR.utils.EntityManagerUtil;

public class DepartmentDaoImpl extends DaoImpl<Department> implements DepartmentDaoI{
	
	/** EntityManager para gestionar consultas, inserciones , etc */
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();
	
	public DepartmentDaoImpl() {
		super();
		this.setClazz(Department.class);
	}

	@Override
	public Department getDepartmentByName(String name) {
		
		String qlString = "FROM Department WHERE NAME = " +"'"+name+"'";
		Query query = entityManager.createQuery(qlString);
		
		Department d = null;
		
		if(!query.getResultList().isEmpty()) {
			
			d = (Department)query.getResultList().get(0);
			
		}
		
		return d;
	}
	
	
	

}
