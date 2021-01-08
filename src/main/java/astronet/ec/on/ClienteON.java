package astronet.ec.on;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.ClienteDAO;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.EquipoServicio;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Servicio;
import astronet.ec.modelo.Telefono;
//sicha imports

import java.util.Map;
import org.primefaces.model.SortOrder;

@Stateless
public class ClienteON {

	@Inject
	private ClienteDAO clidao;
	@Inject
	private Registro registro;
	
	//Probando
	

	public void guardar(Cliente cli) {

		clidao.save(cli);
	}
	
	public void guardarCliente(Cliente cli) {
		clidao.create(cli);
	}
	
	public void actualizar (Cliente cli) {
		clidao.update(cli);
	}
	
	
	public List<Cliente> getListadoCliente() {
		return clidao.getCliente();
	}

	public Cliente getCliente(int cedula) {
		Cliente aux = clidao.read3(cedula);
		System.out.println("Prueba: " + " " + clidao.read3(cedula));
		return aux;
	}

	public Cliente getClienteCedula(String cedula) {
		Cliente aux = clidao.buscarCedula(cedula);
		registro.setIdClienteTemp(aux.getId());
		return aux;
	}

	public Cliente getClienteNombre(String nombre) {
		Cliente aux = clidao.buscarNombre(nombre);
		return aux;
	}
	
	
	public void dato() {
		
		System.out.println("hola datos");
	}
	
	public List<EquipoServicio> getServiciosCliente(Cliente cliente){
		 return clidao.getServiciosCliente(cliente);
	}
	
	//SICHA CODE
	/***
	 * metodo para la carga retardia y para obtener paginacion
	 */
	
	
	
	public EquipoServicio getIpsCliente(String cedula) {
		return clidao.getIpsCliente(cedula);
		
	}
    
  
	
	

}
