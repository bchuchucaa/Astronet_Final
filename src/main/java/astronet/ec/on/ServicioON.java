package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.ServicioDAO;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Servicio;
import astronet.ec.modelo.Telefono;

@Stateless
public class ServicioON {
	
	@Inject
	private ServicioDAO serdao;
	
	public void guardar(Servicio ser) {
		serdao.save(ser);
	}
	
	public void update(Servicio ser) {
		serdao.update(ser);
	}
	
	
	
	public List<Servicio> getServicios(Cliente cliente){
		List<Servicio> aux = serdao.getServicios(cliente);
		return aux;
	}

}
