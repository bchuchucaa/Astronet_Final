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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Plan")
public class Plan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "plan_id")
	@GeneratedValue(generator = "secuenciaPlan")
	@SequenceGenerator(name = "secuenciaPlan", initialValue = 14)
	@NotNull
	private int id;
	
	@Column(name = "plan_tipoPlan")
	private String tipoPlan;
	
	@Column(name = "plan_costo")
	private double costo;
	
	@Column(name = "plan_capacidad")
	private double capacidad;
	
	@Column(name = "plan_tipoServicio")
	private String tipoServicio;
	
	/*
	 * Relacion Cliente con Servicio
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "planServicio_fk")
	private List<Servicio> servicios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoPlan() {
		return tipoPlan;
	}

	public void setTipoPlan(String tipoPlan) {
		this.tipoPlan = tipoPlan;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	
	

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", tipoPlan=" + tipoPlan + ", costo=" + costo + ", capacidad=" + capacidad
				+ ", tipoServicio=" + tipoServicio + ", servicios=" + servicios + "]";
	}
	
	

}
