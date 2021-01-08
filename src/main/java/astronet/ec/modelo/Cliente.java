package astronet.ec.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cliente")
@SequenceGenerator(
	    name="ClienteSeq",
	    sequenceName = "Cliente_SEQ",
	    initialValue = 6000,
	    allocationSize = 1
)
public class Cliente implements Serializable {

	/**
	 * HolaMundo
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cli_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ClienteSeq")
	@NotNull
	private int id;

	@Column(name = "cli_cedula")
	private String cedula;

	@Column(name = "cli_nombres")
	private  String nombre;


	@Column(name = "cli_apellidos")

	private  String apellidos;


	@Column(name = "cli_email")
	private String email;

	@Column(name = "cli_dirPrincipal")
	private String direccionPrincipal;

	@Column(name = "cli_dirSecundaria")
	private String direccionSecundaria;

	@Column(name = "cli_dirReferencia")
	private String direccionReferencia;

	@Column(name = "cli_latitud")
	private String latitud;

	@Column(name = "cli_longitud")
	private String longitud;

	/*
	 * Relacion Cliente con Servicio
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cliservicio_fk")
	private List<Servicio> servicios;

	/*
	 * Relacion Cliente con Registro
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cliregsitro_fk")
	@JsonIgnore
	private List<Registro> registros;

	/*
	 * Relacion Cliente con Telefono
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "clitel_fk")
	@JsonIgnore
	private List<Telefono> telefonos;

	
	
	/*
	 * RElacion Cliente con Visita
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "clivis_fk")
	@JsonIgnore
	private List<Visita> visistas;
	

	public List<Visita> getVisistas() {
		return visistas;
	}

	public void setVisistas(List<Visita> visistas) {
		this.visistas = visistas;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccionPrincipal() {
		return direccionPrincipal;
	}

	public void setDireccionPrincipal(String direccionPrincipal) {
		this.direccionPrincipal = direccionPrincipal;
	}

	public String getDireccionSecundaria() {
		return direccionSecundaria;
	}

	public void setDireccionSecundaria(String direccionSecundaria) {
		this.direccionSecundaria = direccionSecundaria;
	}

	public String getDireccionReferencia() {
		return direccionReferencia;
	}

	public void setDireccionReferencia(String direccionReferencia) {
		this.direccionReferencia = direccionReferencia;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}



	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}


	public void addTelefonos(Telefono telefono) {
		this.telefonos.add(telefono);
	}







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}





}
