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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Servicio")
public class Servicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ser_id")
	@GeneratedValue(generator = "secuenciaServicio")
	@SequenceGenerator(name = "secuenciaServicio", initialValue = 14)
	@NotNull
	private int id;

	@Column(name = "ser_tipoServicio")
	private String tipoServicio;
	
	@Column(name = "ser_numContrato")
	private String numeroContrato;
	
	@Column(name = "ser_fechaContrato")
	//@NotNull
	private String fechaContrato;
	
	@Column(name = "ser_routerVendido")
	//@NotNull
	private String routerVendido;
	
	@Column(name = "ser_observaciones")
	private String observaciones;

	/*
	 * Relacion Servicio con Cliente
	 */
	@OneToOne
	@JoinColumn(name="cliservicio_fk")
	@JsonIgnore
	private Cliente cliente ;
	
	/*
	 * Relacion Servicio con Plan
	 */
	@OneToOne
	@JoinColumn(name="planservicio_fk")
	@JsonIgnore
	private Plan plan ;
	
	/*
	 * Relacion Servicio con EquipoServicio
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn
	@JsonIgnore
	private List<EquipoServicio> equipoServicios;
	
	/*
	 * Relacion Servicio con ServicioFibra
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn
	@JsonIgnore
	private List<ServicioFibra> serviciosFibra;
	
	public List<ServicioFibra> getServiciosFibra() {
		return serviciosFibra;
	}

	public void setServiciosFibra(List<ServicioFibra> serviciosFibra) {
		this.serviciosFibra = serviciosFibra;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public List<EquipoServicio> getEquipoServicios() {
		return equipoServicios;
	}

	public void setEquipoServicios(List<EquipoServicio> equipoServicios) {
		this.equipoServicios = equipoServicios;
	}

	@Transient
	private int idClienteTemp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public String getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(String fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getRouterVendido() {
		return routerVendido;
	}

	public void setRouterVendido(String routerVendido) {
		this.routerVendido = routerVendido;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdClienteTemp() {
		return idClienteTemp;
	}

	public void setIdClienteTemp(int idClienteTemp) {
		this.idClienteTemp = idClienteTemp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
}
