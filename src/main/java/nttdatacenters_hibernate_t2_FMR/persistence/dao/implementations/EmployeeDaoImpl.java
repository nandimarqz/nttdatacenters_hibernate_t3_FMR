package nttdatacenters_hibernate_t2_FMR.persistence.dao.implementations;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import nttdatacenters_hibernate_t2_FMR.persistence.Employee;
import nttdatacenters_hibernate_t2_FMR.persistence.dao.interfaces.EmployeeDaoI;
import nttdatacenters_hibernate_t2_FMR.utils.EntityManagerUtil;

public class EmployeeDaoImpl extends DaoImpl<Employee> implements EmployeeDaoI {

	/** EntityManager para gestionar consultas, inserciones , etc */
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();
	
	public EmployeeDaoImpl() {
		super();
		this.setClazz(Employee.class);
	}

	@Override
	public Employee getEmployeeByDNI(String dni) {
		
		String qlString = "FROM Employee WHERE DNI = "  + "'" + dni + "'";
		
		Query query = entityManager.createQuery(qlString);
		
		Employee e = null;
		
		if(!query.getResultList().isEmpty()) {
			
			e = (Employee) query.getResultList().get(0);
			
		}
		
		return e;
	}
	
//	@Override
//	public void deleteById(Long id) {
//				
//		Employee employee = super.searchById(id);
//		
//		super.delete(employee);
//		
//		
//	}
}
