package nttdatacenters_hibernate_t2_FMR.persistence;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
import javax.persistence.PreRemove;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "NTTDATA_T2_HIBERNATE_EMPLOYEE")
public class Employee extends AbstracEntity {

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

	/**
	 * Devuelve el ID del empleado
	 * 
	 * @return Long
	 */
	@Column(name = "ID")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_EMPLOYEE_SEC", allocationSize = 1)
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * Establece el id del empleado por el id pasado por parametro
	 * 
	 * @param employeeId
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Devuelve el nombre del empleado
	 * 
	 * @return String
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del empleado por el nombre pasado por parametro
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve el primer apellido del empleado
	 * 
	 * @return String
	 */
	@Column(name = "FIRST_SURNAME")
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * Establece el primer apellido del empleado por el apellido pasado por
	 * parametro
	 * 
	 * @param firstSurname
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * Devuelve el segundo apellido del empleado
	 * 
	 * @return String
	 */
	@Column(name = "SECOND_SURNAME")
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * Establece el segundo apellido del empleado por el apellido pasado por
	 * parametro
	 * 
	 * @param secondSurname
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * Devulve el DNI del empleado
	 * 
	 * @return String
	 */
	@Column(name = "DNI", unique = true, nullable = false, length = 9)
	public String getDni() {
		return dni;
	}

	/**
	 * Establece el DNI del empleado por el DNI pasado por parametro
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Devuelve el departamento al que pertece el empleado
	 * 
	 * @return Department
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_DEPARTAMENTO")
	public Department getDepartment() {
		return department;
	}

	/**
	 * Metodo que se ejecuta antes de borrar un empleado
	 */
	@PreRemove
	private void preRemove() {

		// Si el departamento es distinto a null entra en la condicion
		if (department != null) {

			// Setea el jefe a null
			department.setBoss(null);

			// Si la lista de empleados del departamento es distinto a null entra en la
			// condicion
			if (department.getEmployees() != null) {

				// Se crea un boolean a false
				boolean exist = Boolean.FALSE;
				// Se crea un iterador para la lista de empleados del departamento
				Iterator<Employee> it = department.getEmployees().iterator();

				// Mientras exist sea falta y el iterador tenga valor siguiente entra en el
				// bucle
				while (it.hasNext() && !exist) {

					// Guarda el valor del iterador en una variable empleado
					Employee e = it.next();

					// Si el DNI de la variable empleado es igual al dni del empleado que se va a
					// borrar entra en la condicion
					if (e.getDni().equals(this.dni)) {

						// Exist se pone a true
						exist = Boolean.TRUE;
						// Borra el empleado de la lista
						it.remove();

					}

				}
			}

			// Se setea el departamento a null
			department = null;

			// Si el empleado lidera algun departamento es decir el valor de la vriable es
			// distinto a null entra en la condición
			if (departmentLed != null) {

				// Setea el boss del departamento a null
				departmentLed.setBoss(null);
				// Pone el departamento liderado del empleado a null
				departmentLed = null;
			}
		}

	}

	/**
	 * Establece el departamento del empleado por el departamento pasado por parametro
	 * 
	 * @param department
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * Devuelve el departamento liderado por el empleado
	 * 
	 * @return Department
	 */
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "boss")
	public Department getDepartmentLed() {
		return departmentLed;
	}

	/**
	 * Establece el departamento liderado por el empleado por el departamento pasado por parametro
	 * 
	 * @param departmentLed
	 */
	public void setDepartmentLed(Department departmentLed) {
		this.departmentLed = departmentLed;
	}

	/**
	 * Devuelve la lista de clietntes atendidos
	 * 
	 * @return Lista de clientes atendidos
	 */
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "employeesSeen")
	@OnDelete(action = OnDeleteAction.CASCADE)
	public List<Customer> getCustomersServed() {
		return customersServed;
	}

	/**
	 * Establece la lista de clientes atendidos por el empleado por la lista pasada por parametro
	 * 
	 * @param customersServed
	 */
	public void setCustomersServed(List<Customer> customersServed) {
		this.customersServed = customersServed;
	}

	@Override
	@Transient
	public Long getId() {

		return this.getEmployeeId();
	}

	@Override
	@Transient
	public void setId(Long id) {

		this.employeeId = id;

	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", firstSurname=" + firstSurname
				+ ", secondSurname=" + secondSurname + ", dni=" + dni + ", department=" + department.getName()
				+ ", departmentLed=" + departmentLed.getName() + ", customersServed=" + customersServed + "]";
	}

}
