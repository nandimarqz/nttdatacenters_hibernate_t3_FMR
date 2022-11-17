package nttdatacenters_hibernate_t2_FMR.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "NTTDATA_T2_HIBERNATE_EMPLOYEE")
public class Employee extends AbstracEntity{

	private static final long serialVersionUID = 1L;

	/** ID del empleado en base de datos */
	private Long employeeId;
	
	/** Nombre del empleado */
	private String name;
	
	/** Primer apellido del empleado */
	private String firstSurname;
	
	/** Segundo apellido del empleado */
	private String secondSurname;
	
	/** DNI del empleado */
	private String dni;
	
	/** Departamento al que pertenece */
	private Department department;
	
	/** Departamento liderado */
	private Department departmentLed;
	
	/** Clientes atendidos por el empleado */
	private List<Customer> customersServed;



	@Column(name="ID")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_EMPLOYEE_SEC", allocationSize = 1 )
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="FIRST_SURNAME")
	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	@Column(name="SECOND_SURNAME")
	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	@Column(name="DNI", unique=true, nullable=false, length=9)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_DEPARTAMENTO")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "boss")
	public Department getDepartmentLed() {
		return departmentLed;
	}

	public void setDepartmentLed(Department departmentLed) {
		this.departmentLed = departmentLed;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "employeesSeen",cascade = CascadeType.ALL)
	public List<Customer> getCustomersServed() {
		return customersServed;
	}

	public void setCustomersServed(List<Customer> customersServed) {
		this.customersServed = customersServed;
	}

	@Override
	@Transient
	public Long getId() {

		return employeeId;
	}

	@Override
	@Transient
	public void setId(Long id) {

		this.employeeId = id;
		
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", firstSurname=" + firstSurname
				+ ", secondSurname=" + secondSurname + ", dni=" + dni + ", department=" + department
				+ ", departmentLed=" + departmentLed + ", customersServed=" + customersServed + "]";
	}
	
	

}
