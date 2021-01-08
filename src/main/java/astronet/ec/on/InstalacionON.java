package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.InstalacionDAO;
import astronet.ec.modelo.Agendamiento;
import astronet.ec.modelo.Instalacion;
import astronet.ec.modelo.Registro;

@Stateless
public class InstalacionON {
	
	@Inject
	private InstalacionDAO insdao;
	
	public void crearI(Instalacion ins) {
		insdao.create(ins);
	}
	
	public Instalacion getListadoInstalacionId(int id){
		return insdao.getBusquedaInstalacionId(id);
	}
	
public List<Instalacion> getListadoInstalacion() {
		
		return insdao.listarInstalaciones();
	}

public void actualizar(Instalacion ins) {
	insdao.update(ins);
}

public List<Instalacion> getInstalacion(String nombre) {
	return insdao.getActividades(nombre);
}

}
