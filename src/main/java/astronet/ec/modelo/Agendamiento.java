package astronet.ec.modelo;

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
@Table(name = "Agendamiento")
public class Agendamiento {
	
	@Id
	@Column(name = "agd_id")
	@GeneratedValue
	@NotNull
	private int id;
	
	@Column(name = "agd_fechaH")
	private String fecha;
	
	@Transient
	private int codigoRegistroTemp;
	
	/*
	 * Relacion Agendamiento con Registro
	 */
	@OneToOne
	@JoinColumn(name="regagendamiento_fk")
	@JsonIgnore
	private Registro registro ;
	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	@Override
	public String toString() {
		return "Agendamiento [id=" + id + ", fecha=" + fecha + ", codigoRegistroTemp=" + codigoRegistroTemp
				+ ", registro=" + registro + "]";
	}

}