package astronet.ec.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Instalacion")
public class Instalacion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ins_id")
	@NotNull
	private int id;
	
	@Column(name = "ins_tipoServicio")
	@NotNull
	private String tipoServicio;
	
	@Column(name = "ins_nombre")
	@NotNull
	private String nombre;
	
	@Column(name = "ins_direccion")
	@NotNull
	private String direccion;
	
	@Column(name = "ins_telefono")
	@NotNull
	private String telefono;
	
	@Column(name = "ins_coordenadas")
	@NotNull
	private String coordenadas;
	
	@Column(name = "ins_observaciones")
	@NotNull
	private String observaciones;
	
	@Column(name = "ins_tecnico")
	@NotNull
	private String tecnico;
	
	@Column(name = "ins_realizado")
	@NotNull
	private boolean realizado;
	
	/*
	 * Relacion Instalacion con Empleado
	 */
	@OneToOne
	@JoinColumn(name="empinstalacion_fk")
	//@JsonIgnore
	private Empleado empleado ;
	
	@Transient
	private int codigoEmpTemp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	
	
	
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public int getCodigoEmpTemp() {
		return codigoEmpTemp;
	}
	public void setCodigoEmpTemp(int codigoEmpTemp) {
		this.codigoEmpTemp = codigoEmpTemp;
	}
	public boolean isRealizado() {
		return realizado;
	}
	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}
	


}
