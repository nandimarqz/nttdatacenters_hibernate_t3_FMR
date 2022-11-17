package nttdatacenters_hibernate_t2_FMR.persistence;

import java.util.List;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

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

	@Column(name = "ID")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_DEPARTMENT_SEC",allocationSize = 1 )
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	@Column(name = "NAME", unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_JEFE", referencedColumnName = "ID")
	public Employee getBoss() {
		return boss;
	}

	public void setBoss(Employee boss) {
		this.boss = boss;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_DEPT_PADRE", referencedColumnName = "ID")
	public Department getRootDepartment() {
		return rootDepartment;
	}

	public void setRootDepartment(Department rootDepartment) {
		this.rootDepartment = rootDepartment;
	}

	@OneToMany(mappedBy = "rootDepartment",cascade = CascadeType.ALL)
	public List<Department> getChildrenDepartments() {
		return childrenDepartments;
	}

	public void setChildrenDepartments(List<Department> childrenDepartments) {
		this.childrenDepartments = childrenDepartments;
	}

	@OneToMany(mappedBy = "department",  cascade = CascadeType.ALL)
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	@Transient
	public Long getId() {

		return departmentId;
	}

	@Override
	@Transient
	public void setId(Long id) {

		this.departmentId = id;

	}

}
