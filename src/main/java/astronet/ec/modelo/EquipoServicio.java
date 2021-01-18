package astronet.ec.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "EquipoServicio")
@SequenceGenerator(
	    name="EquipoServicioSeq",
	    sequenceName = "EquipoServicio_SEQ",
	    initialValue = 6000,
	    allocationSize = 1
)

public class EquipoServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "equi_serv_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EquipoServicioSeq")
	@NotNull
	private int id;

	@Column(name = "equipoServi_serial")
	private String serial;

	@Column(name = "equipoServi_passwd")
	private String password;

	@Column(name = "equipoServi_ip")
	private String ip;

	/*
	 * Relacion EquipoServicio con Equipo
	 */
	@OneToOne
	@JoinColumn
	@JsonIgnore
	private Equipo equipo;

	/*
	 * Relacion EquipoServicio con Servicio
	 */
	@OneToOne
	@JoinColumn
	@JsonIgnore
	private Servicio servicio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EquipoServicio [id=" + id + ", serial=" + serial + ", password=" + password + ", ip=" + ip + ", equipo="
				+ equipo + ", servicio=" + servicio + "]";
	}

}
