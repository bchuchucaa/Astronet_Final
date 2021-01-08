package astronet.ec.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//@GeneratedValue(generator = "secuenciaEmpleado")
	//@SequenceGenerator(name = "secuenciaEmpleado", initialValue = 6)
	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int id;

	@Column(name = "emp_cedula")
	private String cedula;

	@Column(name = "emp_nombre")
	private String nombre;

	@Column(name = "emp_celular")
	private String celular;

	@Column(name = "emp_email")
	private String email;

	@Column(name = "emp_password")
	private String password;

	@Column(name = "emp_departamento")
	private String departamento;

	/*
	 * Relacion Empleado con Registro
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "empregsitro_fk")
	@JsonIgnore
	private List<Registro> registro;

	/*
	 * Relacion Empleado con Instalacion
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "empinstalacion_fk")
	@JsonIgnore
	private List<Instalacion> instalacion;
	
	
	

	/*
	 * RElacion Empleado con Visita
	 */
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "empvis_fk")
	@JsonIgnore
	private List<Visita> visitas;

	
	public List<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}

	/**
	 * Relacion con roles de los empleados
	 * @return
	 */
	
	@ManyToOne
	@JsonIgnore
	private RolEmpleado rolEmpleado;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public List<Instalacion> getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(List<Instalacion> instalacion) {
		this.instalacion = instalacion;
	}

	public List<Registro> getRegistro() {
		return registro;
	}

	public void setRegistro(List<Registro> registro) {
		this.registro = registro;
	}
		
	public RolEmpleado getRolEmpleado() {
		return rolEmpleado;
	}

	public void setRolEmpleado(RolEmpleado rolEmpleado) {
		this.rolEmpleado = rolEmpleado;
	}
	
	
	public int hashCode() {		
		return Objects.hash(this.id);
	}	

	@Override
	public String toString() {
		return nombre;
	}
		

}