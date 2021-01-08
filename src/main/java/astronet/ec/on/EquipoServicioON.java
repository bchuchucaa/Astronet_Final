package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.SerivicioEquipoDAO;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.EquipoServicio;
import astronet.ec.modelo.Servicio;

@Stateless
public class EquipoServicioON {

	@Inject
	private SerivicioEquipoDAO serveqdao;

	public void crearI(EquipoServicio ins) {
		serveqdao.create(ins);
	}

	public void actualizar(EquipoServicio ins) {
		serveqdao.update(ins);
	}
	
	public List<EquipoServicio> getServicios(Servicio servicio){
		List<EquipoServicio> aux = serveqdao.getServicios(servicio);
		return aux;
	}
}
