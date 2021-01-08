package astronet.modelotmp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Serviciotmp {

	private int id;
	private String numeroContrato;
	private String fechaContrato;
	private String plan;
	private String ip;
	private String password;
	private String observaciones;
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
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	@Override
	public String toString() {
		return "Serviciotmp [id=" + id + ", numeroContrato=" + numeroContrato + ", fechaContrato=" + fechaContrato
				+ ", plan=" + plan + ", ip=" + ip + ", password=" + password + ", observaciones=" + observaciones + "]";
	}
	
}
