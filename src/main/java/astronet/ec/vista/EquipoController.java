package astronet.ec.vista;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import astronet.ec.dao.EquipoDAO;
import astronet.ec.modelo.Equipo;
import astronet.ec.on.EquipoOn;

@ManagedBean
@ViewScoped

public class EquipoController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private EquipoOn eqOn;
	
	@Inject
	private EquipoDAO equDao;
	

	private String antenaElegida;
	private List<Equipo> listadoAntenas;
	
	public EquipoOn getEqOn() {
		return eqOn;
	}
	public void setEqOn(EquipoOn eqOn) {
		this.eqOn = eqOn;
	}
	public String getAntenaElegida() {
		return antenaElegida;
	}
	public void setAntenaElegida(String antenaElegida) {
		this.antenaElegida = antenaElegida;
	}
	public List<Equipo> getListadoAntenas() {
		return equDao.find();
	}
	public void setListadoAntenas(List<Equipo> listadoAntenas) {
		this.listadoAntenas = listadoAntenas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
