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
@Table(name = "ServicioFibra")
public class ServicioFibra  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "fibra_id")
	@GeneratedValue(generator = "secuenciaFibra")
	@SequenceGenerator(name = "secuenciaFibra", initialValue = 6)
	@NotNull
	private int id;
	
	@Column(name = "fibra_olt")
	private String olt;
	
	@Column(name = "fibra_nap")
	private String nap;
	
	@Column(name = "fibra_hilo")
	private String hilo;
	
	@Column(name = "fibra_interface")
	private String interfac;
	
	@Column(name = "fibra_port")
	private String port;
	
	@Column(name = "fibra_vlan")
	private String vlan;

	@Column(name = "fibra_usrVlan")
	private String usrVlan;
	
	@Column(name = "fibra_potencia")
	private double potencia;
	
	@Column(name = "fibra_tecnicoActiva")
	private String tecnicoActiva;

	@Column(name = "fibra_tecnicoCampoActvia")
	private String tecnicoCampoActiva;

	@Column(name = "fibra_mtrDrop")
	private double mtrDrop;
	
	@Column(name = "fibra_confiONT")
	private String confiONT;
	
	@Column(name = "fibra_confiSrvPort")
	private String confiSrvPort;
	
	@Column(name = "fibra_confiONTPort")
	private String confiONTPort;
	
	/*
	 * Relacion ServicioFibra con Servicio
	 */
	@OneToOne
	@JoinColumn(name="servicioFibraServicio_fk")
	@JsonIgnore
	private Servicio servicio;
	
	/*
	 * Relacion Fibra con Activacion
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fibraActivacion_fk")
	private List<TipoActivacion> activaciones;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOlt() {
		return olt;
	}

	public void setOlt(String olt) {
		this.olt = olt;
	}

	public String getNap() {
		return nap;
	}

	public void setNap(String nap) {
		this.nap = nap;
	}

	public String getHilo() {
		return hilo;
	}

	public void setHilo(String hilo) {
		this.hilo = hilo;
	}

	public String getInterfac() {
		return interfac;
	}

	public void setInterfac(String interfac) {
		this.interfac = interfac;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getVlan() {
		return vlan;
	}

	public void setVlan(String vlan) {
		this.vlan = vlan;
	}

	public String getUsrVlan() {
		return usrVlan;
	}

	public void setUsrVlan(String usrVlan) {
		this.usrVlan = usrVlan;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public String getTecnicoActiva() {
		return tecnicoActiva;
	}

	public void setTecnicoActiva(String tecnicoActiva) {
		this.tecnicoActiva = tecnicoActiva;
	}

	public String getTecnicoCampoActiva() {
		return tecnicoCampoActiva;
	}

	public void setTecnicoCampoActiva(String tecnicoCampoActiva) {
		this.tecnicoCampoActiva = tecnicoCampoActiva;
	}

	public double getMtrDrop() {
		return mtrDrop;
	}

	public void setMtrDrop(double mtrDrop) {
		this.mtrDrop = mtrDrop;
	}

	public String getConfiONT() {
		return confiONT;
	}

	public void setConfiONT(String confiONT) {
		this.confiONT = confiONT;
	}

	public String getConfiSrvPort() {
		return confiSrvPort;
	}

	public void setConfiSrvPort(String confiSrvPort) {
		this.confiSrvPort = confiSrvPort;
	}

	public String getConfiONTPort() {
		return confiONTPort;
	}

	public void setConfiONTPort(String confiONTPort) {
		this.confiONTPort = confiONTPort;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public List<TipoActivacion> getActivaciones() {
		return activaciones;
	}

	public void setActivaciones(List<TipoActivacion> activaciones) {
		this.activaciones = activaciones;
	}

	@Override
	public String toString() {
		return "ServicioFibra [id=" + id + ", olt=" + olt + ", nap=" + nap + ", hilo=" + hilo + ", interfac=" + interfac
				+ ", port=" + port + ", vlan=" + vlan + ", usrVlan=" + usrVlan + ", potencia=" + potencia
				+ ", tecnicoActiva=" + tecnicoActiva + ", tecnicoCampoActiva=" + tecnicoCampoActiva + ", mtrDrop="
				+ mtrDrop + ", confiONT=" + confiONT + ", confiSrvPort=" + confiSrvPort + ", confiONTPort="
				+ confiONTPort + ", servicio=" + servicio + ", activaciones=" + activaciones + "]";
	}
	
}
