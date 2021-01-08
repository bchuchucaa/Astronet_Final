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
@Table(name = "Nodo")

public class Nodo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nodo_id")
	@GeneratedValue(generator = "secuenciaNodo")
	@SequenceGenerator(name = "secuenciaNodo", initialValue = 14)
	@NotNull
	private int id;
	

	@Column(name = "nodo_nombre")
	private String nombre;
	
	/*
	 * Relacion Nodo con Equipo
	 */
	@OneToOne
	@JoinColumn(name="nodoEquipo_fk")
	@JsonIgnore
	private Equipo equipo;

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

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Nodo [id=" + id + ", nombre=" + nombre + ", equipo=" + equipo + "]";
	}
		
	

}
