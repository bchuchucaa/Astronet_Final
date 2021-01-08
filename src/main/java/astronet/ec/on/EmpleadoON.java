package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.EmpleadoDAO;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;

@Stateless
public class EmpleadoON {
	
	@Inject
	private EmpleadoDAO empdao;
	
	public void guardar(Empleado emp) {
		empdao.save(emp);
	}
	
	public void eliminarByID(int id) {
		empdao.deleteEmpleadoByID(id);
	}
	public List<Empleado> getEmpleado() {
		return empdao.getEmpleado();
	}
	
	public Empleado getEmpleado(int id) {
		Empleado aux = empdao.read3(id);
		System.out.println("Prueba: " + " " + empdao.read3(id));
		return aux;
	}
	
	public Empleado login(String email, String password) {
		return empdao.login(email, password);
	}
	
	public Empleado read(int id) {
		return empdao.read(id);
	}
	
	public List<Empleado> getListadoEmpleado() {
		return empdao.tecnicoDepartamento();
	}

	public List<Empleado>getListadoTecnico(){
	return empdao.listarEmpleado();
	}
	
	public Empleado getEmpleadobyName(String name) {
		Empleado aux = empdao.buscarByName(name);
		System.out.println("Prueba: " + " " + empdao.buscarByName(name));
		return aux;
	}
	
	
}
