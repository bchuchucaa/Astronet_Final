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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Equipo")

public class Equipo implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "equi_id")
	@GeneratedValue(generator = "secuenciaEquipo")
	@SequenceGenerator(name = "secuenciaEquipo", initialValue = 14)
	private int id;

	@Column(name = "equi_nombre")
	private String nombre;

	@Column(name = "equi_modelo")
	private String modelo;

	@Column(name = "equi_tipoEquipo")
	private String tipoEquipo;

	@Column(name = "equi_marca")
	private String marca;

	/*
	 * Relacion Equipo Nodo
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "equipoNodo_fk")
	private List<Nodo> nodos;

	/*
	 * Relacion Equipo Nodo
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn
	private List<EquipoServicio> equipoServicio;

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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoEquipo() {
		return tipoEquipo;
	}

	public void setTipoEquipo(String tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}

	public List<EquipoServicio> getEquipoServicio() {
		return equipoServicio;
	}

	public void setEquipoServicio(List<EquipoServicio> equipoServicio) {
		this.equipoServicio = equipoServicio;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", modelo=" + modelo + ", tipoEquipo=" + tipoEquipo
				+ ", marca=" + marca + ", nodos=" + nodos + ", equipoServicio=" + equipoServicio + "]";
	}

}
