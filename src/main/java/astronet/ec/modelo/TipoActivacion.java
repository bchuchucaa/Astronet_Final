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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TipoActivacion")

public class TipoActivacion  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "tipoActivacion_id")
	@GeneratedValue(generator = "secuenciaTipoAct")
	@SequenceGenerator(name = "secuenciaTipoAct", initialValue = 14)
	@NotNull
	private int id;
	

	@Column(name = "tipoActivacion_nombre")
	private String nombre;
	
	/*
	 * Relacion Activacion con Fibra
	 */
	@OneToOne
	@JoinColumn(name="activFibra_fk")
	@JsonIgnore
	private ServicioFibra fibra;
	
	/*
	 * Relacion tipoActivacion con VLAN
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "tipoActivacionVlan_fk")
	@JsonIgnore
	private List<ActivacionVLAN> activacionesVlan;
	
	/*
	 * Relacion tipoActivacion con PPPoE
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "tipoActivacionPPPoE_fk")
	@JsonIgnore
	private List<ActivacionPPPoE> activacionesPPPoE;

	public List<ActivacionVLAN> getActivacionesVlan() {
		return activacionesVlan;
	}

	public void setActivacionesVlan(List<ActivacionVLAN> activacionesVlan) {
		this.activacionesVlan = activacionesVlan;
	}

	public List<ActivacionPPPoE> getActivacionesPPPoE() {
		return activacionesPPPoE;
	}

	public void setActivacionesPPPoE(List<ActivacionPPPoE> activacionesPPPoE) {
		this.activacionesPPPoE = activacionesPPPoE;
	}

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

	public ServicioFibra getFibra() {
		return fibra;
	}

	public void setFibra(ServicioFibra fibra) {
		this.fibra = fibra;
	}

	@Override
	public String toString() {
		return "TipoActivacion [id=" + id + ", nombre=" + nombre + ", fibra=" + fibra + ", activacionesVlan="
				+ activacionesVlan + ", activacionesPPPoE=" + activacionesPPPoE + "]";
	}
	
	

}
