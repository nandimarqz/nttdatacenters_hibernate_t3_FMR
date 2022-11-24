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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Esta tabla hace referencia a la tabla NTTDATA_T1_HIBERNATE_CUSTOMER en la
 * base de datos
 * 
 * @author nandi
 *
 */
@Entity
@Table(name = "NTTDATA_T1_HIBERNATE_CUSTOMER")
public class Customer extends AbstracEntity {

	private static final long serialVersionUID = 1L;

	/** ID del cliente en base de datos */
	private Long customerId;

	/** Nombre del cliente */
	private String name;

	/** Primer apellido del cliente */
	private String firstSurname;

	/** Segundo apellido del cliente */
	private String secondSurname;

	/** DNI del cliente */
	private String dni;

	/** Contratos del cliente */
	private List<Contract> contracts;

	/** Empleados por los que ha sido atendido */
	private List<Employee> employeesSeen;

	/***/

	/**
	 * Devuelve el ID del clietne
	 * 
	 * @return Long
	 */
	@Column(name = "ID_CUSTOMER")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_CUSTOMER_SEC", allocationSize = 1)
	public Long getCustomerId() {

		return customerId;
	}

	/**
	 * Establece el ID del cliente por el id pasado por parametro
	 * 
	 * @param id
	 */
	public void setCustomerId(Long id) {
		this.customerId = id;
	}

	/**
	 * Devuelve el nombre del cliente
	 * 
	 * @return String
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del cliente por el nombre pasado por parametro
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve el primer apellido del cliente
	 * 
	 * @return String
	 */
	@Column(name = "FIRST_SURNAME")
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * Establece el primer apellido del cliente por el apellido pasado por parametro
	 * 
	 * @param firstSurname
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * Devuelve el segundo apellido del cliente
	 * 
	 * @return String
	 */
	@Column(name = "SECOND_SURNAME")
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * Establece el segundo apellido del cliente por el apellido pasado por
	 * parametro
	 * 
	 * @param secondSurname
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * Devuelve el DNI del cliente
	 * 
	 * @return String
	 */
	@Column(name = "DNI", unique = true, nullable = false, length = 9)
	public String getDni() {
		return dni;
	}

	/**
	 * Establece el DNI del cliente por el DNI pasado por parametro
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Devuelve la lista de contratos del cliente
	 * 
	 * @return lista de contratos del cliente
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	@OnDelete(action = OnDeleteAction.CASCADE)
	public List<Contract> getContracts() {
		return contracts;
	}

	/**
	 * Establece la lista de contratos del cliente
	 * 
	 * @param contracts
	 */
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	/**
	 * Devuelve la lista de empleados que ha atendido al cliente
	 * 
	 * @return lista de empleados por los que ha sido atendido
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "NTTDATA_HIBERNATE_T2_ATENDIDOS", joinColumns = @JoinColumn(name = "ID_CLIENTE"), inverseJoinColumns = @JoinColumn(name = "ID_EMPLEADO"))
	public List<Employee> getEmployeesSeen() {
		return employeesSeen;
	}

	// Establece la lista de empleados que ha atendido al cliente
	public void setEmployeesSeen(List<Employee> employeesSeen) {
		this.employeesSeen = employeesSeen;
	}

	@Override
	@Transient
	public Long getId() {

		return this.customerId;
	}

	@Override
	@Transient
	public void setId(Long id) {
		this.setCustomerId(id); 

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
		Customer other = (Customer) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Customer [id=" + customerId + ", name=" + name + ", firstSurname=" + firstSurname + ", secondSurname="
				+ secondSurname + ", dni=" + dni + "]";
	}

}
