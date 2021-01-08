package astronet.ec.vista;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import astronet.ec.dao.TelefonoDAO;
import astronet.ec.modelo.Agendamiento;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Equipo;
import astronet.ec.modelo.Instalacion;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Servicio;
import astronet.ec.modelo.Telefono;
import astronet.ec.on.AgendamientoON;
import astronet.ec.on.ClienteON;
import astronet.ec.on.EmpleadoON;
import astronet.ec.on.EquipoOn;
import astronet.ec.on.InstalacionON;
import astronet.ec.on.RegistroON;
import astronet.ec.on.ServicioON;
import astronet.ec.on.TelefonoON;
import astronet.ec.vista.InstalacionController.ServicioFA;

@ManagedBean
@ViewScoped
public class TelefonoController implements Serializable {

	// private static final long serialVersionUID = 8799656478674716638L;
	private static final long serialVersionUID = 1L;
	private Cliente cliente = new Cliente();

	private List<Telefono> telefonos;
	/**
	 * Declaraacion de variables
	 */
	private String cedula;
	private String nombre;
	private Telefono telefonoNuevo;
	private TelefonoON telOn;

	/**
	 * Fin de la declaracion
	 */



	/**
	 * Inyeccion de las clases ON
	 */
	@Inject
	private TelefonoON telon;
	
	@Inject
	private ClienteON clion;




	/**
	 * Fin de la inyeccion
	 */

	/**
	 * Creacion del Constructor
	 */

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		telefonoNuevo= new Telefono();
		telefonos = new ArrayList<Telefono>();

	}








	/*
	 * Hasta aqui llega la creacion de los getters and setters
	 */

	/**
	 * Metodo para dirigirnos a la pagina editarClientes
	 * 
	 * @param codigo
	 * @return
	 */

	public String editar(int codigo) {

		return "editarClientes?faces-redirect=true&id=" + codigo;
	}

	public String editarRegistro(int codigo) {
		return "agendamiento?faces-redirect=true&id=" + codigo;
	}
	
	

	public Telefono getTelefonoNuevo() {
		return telefonoNuevo;
	}








	public void setTelefonoNuevo(Telefono telefonoNuevo) {
		this.telefonoNuevo = telefonoNuevo;
	}








	/**
	 * Metodo para la creacion de los clientes
	 * 
	 * @return
	 */
	public String guardarCliente() {

		try {
			clion.guardarCliente(cliente);
			// servicio.setIdClienteTemp(cliente.getId());
			// seron.guardar(servicio);
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Metodo para la busqueda de clientes para el registro
	 * 
	 * @return
	 */
	public Cliente buscarCedula(String cedula) {
		try {
			if (cedula!=null) {

				cliente = clion.getClienteCedula(cedula);
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Correctas"));

			}
		}catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));

		}

		return cliente;

	}
	
	//Metodo para agregar nuevos telefonos del cleinte
	public void agregarTelefono() {
		System.out.println("PILAS PARA AGREGAR EL TELEFONO");
	}
	/**
	 * public List<Telefono> getTelefonos(){
	 * System.out.println("Cliente a buscar "+ cedula);
		telefonos=clion.
		return telefonos;
	}
	 */
	
public void deleteTelefono(int id) {
		/**
		 * try {
				System.out.println("THIS IS ID ->"+ id);
				teldao.delete(id);
				System.out.println("Se elimino");
				
			}catch (Exception e) {
				// TODO: handle exception
			}
		 */
			
			
				
				
			
			
	

		
		
		
	}
		


}
