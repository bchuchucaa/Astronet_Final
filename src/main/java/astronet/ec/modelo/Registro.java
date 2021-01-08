package astronet.ec.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Registro")
public class Registro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "reg_id")
	@NotNull
	private int id;
	
	@Column(name = "reg_fechaHora")
	@NotNull
	private String fechaHora;
	
	@Column(name = "reg_observaciones")
	@NotNull
	private String observaciones;
	
	@Column(name = "reg_problema")
	@NotNull
	private String problema;
	
	@Column(name = "reg_accion")
	@NotNull
	private String accion;

	/*
	 * Relacion Registro con Empleado
	 */
	@OneToOne
	@JoinColumn(name="empregsitro_fk")
	//@JsonIgnore
	private Empleado empleado ;
	
	/*
	 * Relacion Registro con Cliente
	 */
	@OneToOne
	@JoinColumn(name="cliregsitro_fk")
	//@JsonIgnore
	private Cliente cliente;
	
	public Registro(Empleado empleado) {
		super();
		this.empleado = empleado;
		
	}

	/*
	 * Relacion Registro con Agendamiento
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "regagendamiento_fk")
	@JsonIgnore
	private List<Agendamiento> agendamiento;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "agregristro_fk")
	@JsonIgnore
	private List<Visita> visita;

	
	public List<Visita> getVisita() {
		return visita;
	}

	public void setVisita(List<Visita> visita) {
		this.visita = visita;
	}

	@Transient
	private int idClienteTemp;
	
	@Transient 
	private int idEmpleadoTemp;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Registro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}



	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdClienteTemp() {
		return idClienteTemp;
	}

	public void setIdClienteTemp(int idClienteTemp) {
		this.idClienteTemp = idClienteTemp;
	}

	public int getIdEmpleadoTemp() {
		return idEmpleadoTemp;
	}

	public void setIdEmpleadoTemp(int idEmpleadoTemp) {
		this.idEmpleadoTemp = idEmpleadoTemp;
	}


	public List<Agendamiento> getAgendamiento() {
		return agendamiento;
	}

	public void setAgendamiento(List<Agendamiento> agendamiento) {
		this.agendamiento = agendamiento;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((problema == null) ? 0 : problema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registro other = (Registro) obj;
		if (id != other.id)
			return false;
		if (problema == null) {
			if (other.problema != null)
				return false;
		} else if (!problema.equals(other.problema))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", fechaHora=" + fechaHora + ", observaciones=" + observaciones + ", problema="
				+ problema + ", accion=" + accion  + ", empleado=" + empleado + ", cliente="
				+ cliente  + "]";
	}



	

}