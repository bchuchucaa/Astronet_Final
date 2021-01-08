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
@Table(name = "ActivacionPPPoE")

public class ActivacionPPPoE implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "pppOE_id")
	@GeneratedValue(generator = "secuenciapppOE")
	@SequenceGenerator(name = "secuenciapppOE", initialValue = 6)
	@NotNull
	private int id;

	@Column(name = "pppOE_idPPPoE")
	private String idPPPOe;

	@Column(name = "pppOE_password")
	private String password;
	
	/*
	 * Relacion PPPoE con tipoActivacion
	 */
	@OneToOne
	@JoinColumn(name="pppoeTipoActivacion_fk")
	@JsonIgnore
	private TipoActivacion tipoActivacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdPPPOe() {
		return idPPPOe;
	}

	public void setIdPPPOe(String idPPPOe) {
		this.idPPPOe = idPPPOe;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipoActivacion getTipoActivacion() {
		return tipoActivacion;
	}

	public void setTipoActivacion(TipoActivacion tipoActivacion) {
		this.tipoActivacion = tipoActivacion;
	}

	@Override
	public String toString() {
		return "ActivacionPPPoE [id=" + id + ", idPPPOe=" + idPPPOe + ", password=" + password + ", tipoActivacion="
				+ tipoActivacion + "]";
	}
	
	

}
