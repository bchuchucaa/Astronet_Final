package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.RolDAO;
import astronet.ec.modelo.RolEmpleado;

@Stateless
public class RolEmpleadoON {
	@Inject
	private RolDAO roldao;
	
	public void guardar(RolEmpleado rolEmple) {
		roldao.save(rolEmple);
	}
	
	public RolEmpleado read(int id) {
		return roldao.read(id);
	}
	
	public void eliminar(int id) {
		roldao.deleteRolEmpleado(roldao.read(id));
	}
	
	public void editar(RolEmpleado rolEmple) {
		roldao.update(rolEmple);
	}
	
	public List<RolEmpleado> listarRoles(){
		List <RolEmpleado> rolesEmpleados=this.roldao.listarRoles();
		return rolesEmpleados;			
	}
	
}
