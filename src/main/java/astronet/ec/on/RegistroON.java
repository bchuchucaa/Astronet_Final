package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.ClienteDAO;
import astronet.ec.dao.EmpleadoDAO;
import astronet.ec.dao.RegistroDAO;
import astronet.ec.modelo.Agendamiento;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Registro;

@Stateless
public class RegistroON {
	
	@Inject
	private RegistroDAO regdao;
	
	@Inject
	private ClienteDAO clidao;
	
	@Inject
	private EmpleadoDAO empdao;
	
	
	public void guardar(Registro reg) {
		regdao.save(reg);
	}
	
	public Registro getRegistro(int id) {
		Registro aux = regdao.read3(id);
		System.out.println("Prueba: " + " " + regdao.read3(id));
		System.out.println("Se llamo al registro");
		return aux;
	}
	
	public List<Registro> getListadoRegistro() {
		
		return regdao.listarRegistros();
	}
	
	public List<Registro>listadoRegistrosVT(){
		return regdao.listarRegistrosVT();
	}
	
	public Registro getListadoClienteId(int id){
		return regdao.getBusquedaClienteId(id);
	}
	
		
	public Cliente consultarCliente(int codigoCliente) throws Exception {
		
		
		Cliente cli= clidao.read(codigoCliente);
		if(cli==null)
			throw new Exception("Cliente no existe");
		
		return cli;
	}

	
public Empleado consultarEmpleado(int codigoEmpleado) throws Exception {
		
		//holaaaaaaas
		Empleado emp= empdao.read(codigoEmpleado);
		if(emp==null)
			throw new Exception("Empleado no existe");
		
		return emp;
	}

public Registro consultarRegistro(int codigoRegistro) throws Exception {
	
	
	Registro reg= regdao.read(codigoRegistro);
	if(reg==null)
		throw new Exception("Registro no existe");
	
	return reg;
}

public void actualizar(Registro reg) {
	regdao.update(reg);
}


}
