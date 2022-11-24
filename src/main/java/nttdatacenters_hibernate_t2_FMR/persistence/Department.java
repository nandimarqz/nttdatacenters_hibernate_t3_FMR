package nttdatacenters_hibernate_t2_FMR.persistence;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Esta clase hace referencia a la tabla NTTDATA_T2_HIBERNATE_DEPARTMENT en la
 * base de datos
 * 
 * @author nandi
 *
 */
@Entity
@Table(name = "NTTDATA_T2_HIBERNATE_DEPARTMENT")
public class Department extends AbstracEntity {

	private static final long serialVersionUID = 1L;

	/** ID del departamento */
	private Long departmentId;

	/** Nombre del departametno */
	private String name;

	/** Jefe del departamento */
	private Employee boss;

	/** Departamento padre */
	private Department rootDepartment;

	/** Departamentos hijos */
	private List<Department> childrenDepartments;

	/** Empleados del departamento */
	private List<Employee> employees;

	/**
	 * Delvuelve el ID del departamento
	 * 
	 * @return Long
	 */
	@Column(name = "ID")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_DEPARTMENT_SEC", allocationSize = 1)
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * Establece el id del departamento por el id pasado por parametro
	 * 
	 * @param departmentId
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * Devuelve el nombre del departamento
	 * 
	 * @return String
	 */
	@Column(name = "NAME", unique = true)
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del departamento por el pasado por parametro
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve el empleado jefe del departamento
	 * 
	 * @return Employee
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_JEFE", referencedColumnName = "ID")
	public Employee getBoss() {
		return boss;
	}

	/**
	 * Establece el empleado jefe del departamento
	 * 
	 * @param boss
	 */
	public void setBoss(Employee boss) {
		this.boss = boss;
	}

	/**
	 * Devuelve el departamento padre
	 * 
	 * @return Department
	 */
	@ManyToOne
	@JoinColumn(name = "ID_DEPT_PADRE", referencedColumnName = "ID")
	public Department getRootDepartment() {
		return rootDepartment;
	}

	/**
	 * Establece el departamento padre por el departamento pasado por parametro
	 * 
	 * @param rootDepartment
	 */
	public void setRootDepartment(Department rootDepartment) {
		this.rootDepartment = rootDepartment;
	}

	/**
	 * Devuelve una lista de los departamentos hijos del departamento
	 * 
	 * @return lista de departamentos hijos
	 */
	@OneToMany(mappedBy = "rootDepartment", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	public List<Department> getChildrenDepartments() {
		return childrenDepartments;
	}

	/**
	 * Establece la lista de departamentos hijos del departamento por la lista
	 * pasada por parametro
	 * 
	 * @param childrenDepartments
	 */
	public void setChildrenDepartments(List<Department> childrenDepartments) {
		this.childrenDepartments = childrenDepartments;
	}

	/**
	 * Devuelve la lista de los empleados del departamento
	 * 
	 * @return lista de empleados del departamento
	 */
	@OneToMany(mappedBy = "department")
	public List<Employee> getEmployees() {
		return employees;
	}

	/**
	 * Este metodo se ejecuta antes de borrar un departamento
	 */
	@PreRemove
	private void preRemove() {

		//Si la lista de empleados es distinta a null es que es tiene empleados
		//y entra en la condicion
		if (employees != null) {
			
			//Recorre los empleados y le setea el departamento del empleado a null
			for (Employee e : employees) {

				e.setDepartment(null);

			}

		}

	}

	/**
	 * Establece la lista de empleados del departamento por la lista pasada por parametro
	 * @param employees
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	@Transient
	public Long getId() {

		return this.getId();
	}

	@Override
	@Transient
	public void setId(Long id) {

		this.departmentId = id;

	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + ", boss=" + boss.getDni()
				+ ", childrenDepartments=" + childrenDepartments + "]";
	}
	
	

}
