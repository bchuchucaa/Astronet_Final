package astronet.ec.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Instalacion;
import astronet.ec.on.EmpleadoON;
import astronet.ec.on.InstalacionON;
import astronet.ec.on.RegistroON;

@ManagedBean
@ViewScoped
public class InstalacionController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Instalacion instalacion = new Instalacion();
	private List<Instalacion> listaInstalaciones;
	private List<Empleado> empleados;
	
	private String empleados1;
	
	@ManagedProperty(value = "#{login}")
	private EmpleadoController empCon;
	
	@Inject
	private InstalacionON inson;
	
	@Inject
	private RegistroON regon;
	
	@Inject
	private EmpleadoON empon;
	
	@Inject
	private FacesContext fc;
	
	@PostConstruct
	public void init() {
		instalacion = new Instalacion();
		listaInstalaciones = inson.getListadoInstalacion();
		empleados = empon.getListadoEmpleado();

	}
	
	
	public Instalacion getInstalacion() {
		return instalacion;
	}




	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}




	public List<Instalacion> getListaInstalaciones() {
		return listaInstalaciones;
	}




	public void setListaInstalaciones(List<Instalacion> listaInstalaciones) {
		this.listaInstalaciones = listaInstalaciones;
	}




	public EmpleadoController getEmpCon() {
		return empCon;
	}




	public void setEmpCon(EmpleadoController empCon) {
		this.empCon = empCon;
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
	
	


	/**
	 * Metodo para guardar los datos de la instalacion
	 * 
	 * @return
	 */
	public String crearInstalacion() {

		try {
			inson.crearI(instalacion);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * Metodo de consultar Empleado para la instalacion
	 */
	public void consultarEmpleado1() {

		Empleado emp;
		try {
			emp = regon.consultarEmpleado(instalacion.getCodigoEmpTemp());
			instalacion.setEmpleado(emp);
		} catch (Exception e) {
			instalacion.setEmpleado(null);
			// TODO Auto-generated catch block
			/*
			 * FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			 * e.getMessage(), "Error"); fc.addMessage("txtEmpleado1", msg);
			 */

			e.printStackTrace();
		}
	}
	
	public String datoI() {
		System.out.println("Datos Instalacion " + empCon.getId());
		instalacion.setCodigoEmpTemp(empCon.getId());
		return "instalacion";
	}
	
	
	/*
	 * Metodo para de radioButton del Modo de Servicio
	 */
	public static class ServicioFA {
		public String servicioLabel;
		public String servicioValue;

		public ServicioFA(String servicioLabel, String servicioValue) {
			this.servicioLabel = servicioLabel;
			this.servicioValue = servicioValue;
		}

		public String getServicioLabel() {
			return servicioLabel;
		}

		public void setServicioLabel(String servicioLabel) {
			this.servicioLabel = servicioLabel;
		}

		public String getServicioValue() {
			return servicioValue;
		}

		public void setServicioValue(String servicioValue) {
			this.servicioValue = servicioValue;
		}

	}

	public ServicioFA[] servicioLista;

	public ServicioFA[] getListaServicioRB() {

		servicioLista = new ServicioFA[2];
		servicioLista[0] = new ServicioFA("Fibra Optica", "FO");
		servicioLista[1] = new ServicioFA("Antena", "RE");

		return servicioLista;
	}
	
	public String tecnicoCampo() {
		empleados1 = "" + empon.getListadoEmpleado();

		return empleados1;
	}

}
