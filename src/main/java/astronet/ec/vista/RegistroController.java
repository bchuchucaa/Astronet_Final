package astronet.ec.vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import astronet.ec.modelo.Agendamiento;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Registro;
import astronet.ec.on.AgendamientoON;
import astronet.ec.on.ClienteON;
import astronet.ec.on.EmpleadoON;
import astronet.ec.on.RegistroON;

@ManagedBean
@ViewScoped
public class RegistroController{

	private Registro registro = new Registro();
	private Empleado empleado = new Empleado();
	private Agendamiento agendamiento = new Agendamiento();

	private Cliente cliente = new Cliente();
	private List<Registro> registros;
	private List<Registro> registrosvisita;

	private List<Empleado> empleados;
	private List<Cliente> clientes;

	public String problemas;
	public String soluciones;
	private String empleados1;
	private int codigoCliente;
	private int codigoEmpleado;
	


	@Inject
	private RegistroON regon;

	@Inject
	private EmpleadoON empon;

	@Inject
	private ClienteON clion;
	

	@Inject
	private AgendamientoON agon;

	public Agendamiento getAgendamiento() {
		return agendamiento;
	}

	public void setAgendamiento(Agendamiento agendamiento) {
		this.agendamiento = agendamiento;
	}



	@Inject
	private FacesContext fc;
	


	@PostConstruct
	public void init() {
		empleados = empon.getListadoEmpleado();
		clientes = clion.getListadoCliente();
		registros=regon.getListadoRegistro();
		registrosvisita=regon.listadoRegistrosVT();
		
	}

	public Registro getRegistro() {
		return registro;
	}

	public List<Registro> getRegistrosvisita() {
		return registrosvisita;
	}

	public void setRegistrosvisita(List<Registro> registrosvisita) {
		this.registrosvisita = registrosvisita;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public String getProblemas() {
		return problemas;
	}

	public String getSoluciones() {
		return soluciones;
	}

	public void setSoluciones(String soluciones) {
		this.soluciones = soluciones;
	}

	public void setProblemas(String problemas) {
		this.problemas = problemas;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public String getEmpleados1() {
		return empleados1;
	}

	public void setEmpleados1(String empleados1) {
		this.empleados1 = empleados1;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String cargarDatosRegistro() {
		try {
			System.out.println("Llegando:::::111");
			regon.guardar(registro);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// Matriz de objetos
	public static class problema {
		public String carLabel;
		public String carValue;

		public problema(String carLabel, String carValue) {
			this.carLabel = carLabel;
			this.carValue = carValue;
		}

		public String getCarLabel() {
			return carLabel;
		}

		public String getCarValue() {
			return carValue;
		}
	}

	public problema[] listaProblema;

	public problema[] getProblemas1() {
		listaProblema = new problema[6];

		listaProblema[0] = new problema("SERVICIO INTERMITENTE", "1");
		listaProblema[1] = new problema("SIN SERVICIO", "2");
		listaProblema[2] = new problema("PROBLEMAS EN CAPACIDAD", "3");
		listaProblema[3] = new problema("ROUTER DESCONFIGURADO", "4");
		listaProblema[4] = new problema("SERVICIO LENTO", "5");
		listaProblema[5] = new problema("CORTE DE SERVICIO", "6");

		return listaProblema;
	}

	// Matriz de Objetos para solucion
	public static class solucion {

		public String carLabel;
		public String carValue;

		public solucion(String carLabel, String carValue) {
			this.carLabel = carLabel;
			this.carValue = carValue;
		}

		public String getCarLabel() {
			return carLabel;
		}

		public String getCarValue() {
			return carValue;
		}

	}

	public solucion[] listaSolucion;

	public solucion[] getSolucion() {
		listaSolucion = new solucion[3];

		listaSolucion[0] = new solucion("SOLUCIONADO", "1");
		listaSolucion[1] = new solucion("NODO CAIDO", "2");
		listaSolucion[2] = new solucion("VISITA TECNICA", "3");

		return listaSolucion;
	}

	public String tecnicoCampo() {
		empleados1 = "" + empon.getListadoEmpleado();
		return empleados1;
	}

	public void consultarCliente() {

		Cliente cli;
		try {

			cli = regon.consultarCliente(registro.getIdClienteTemp());
			registro.setCliente(cli);
		} catch (Exception e) {
			registro.setCliente(null);
			// TODO Auto-generated catch block
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			fc.addMessage("txtCliente1", msg);

			e.printStackTrace();
		}
	}

	public void consultarEmpleado() {

		Empleado emp;
		try {
			emp = regon.consultarEmpleado(registro.getIdEmpleadoTemp());
			registro.setEmpleado(emp);
		} catch (Exception e) {
			registro.setEmpleado(null);
			// TODO Auto-generated catch block
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			fc.addMessage("txtEmpleado1", msg);

			e.printStackTrace();
		}
	}



	public void dato() {
	
	}
	
	
}
