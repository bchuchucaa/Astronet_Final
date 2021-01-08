package astronet.ec.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ActivacionVLAN")

public class ActivacionVLAN implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "vlan_id")
	@GeneratedValue(generator = "secuenciaVlan")
	@SequenceGenerator(name = "secuenciaVlan", initialValue = 6)
	@NotNull
	private int id;

	@Column(name = "vlan_ip")
	private String vlanIp;
	
	/*
	 * Relacion VLAN con tipoActivacion
	 */
	@OneToOne
	@JoinColumn(name="vlanTipoActivacion_fk")
	@JsonIgnore
	private TipoActivacion tipoActivacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVlanIp() {
		return vlanIp;
	}

	public void setVlanIp(String vlanIp) {
		this.vlanIp = vlanIp;
	}

	public TipoActivacion getTipoActivacion() {
		return tipoActivacion;
	}

	public void setTipoActivacion(TipoActivacion tipoActivacion) {
		this.tipoActivacion = tipoActivacion;
	}

	@Override
	public String toString() {
		return "ActivacionVLAN [id=" + id + ", vlanIp=" + vlanIp + ", tipoActivacion=" + tipoActivacion + "]";
	}
	
	
}
