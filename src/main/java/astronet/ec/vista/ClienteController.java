package astronet.ec.vista;

import java.io.IOException;

import java.io.Serializable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import astronet.ec.modelo.Agendamiento;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Equipo;
import astronet.ec.modelo.EquipoServicio;
import astronet.ec.modelo.Instalacion;
import astronet.ec.modelo.Plan;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Servicio;
import astronet.ec.modelo.Telefono;
import astronet.ec.modelo.Visita;
import astronet.ec.on.AgendamientoON;
import astronet.ec.on.ClienteON;
import astronet.ec.on.EmpleadoON;
import astronet.ec.on.EquipoOn;
import astronet.ec.on.EquipoServicioON;
import astronet.ec.on.InstalacionON;
import astronet.ec.on.PlanON;
import astronet.ec.on.RegistroON;
import astronet.ec.on.ServicioON;
import astronet.ec.on.TelefonoON;
import astronet.ec.on.VisitaON;
import astronet.ec.vista.InstalacionController.ServicioFA;

//SICHA IMPORT

import java.util.Locale;

@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {

	// private static final long serialVersionUID = 8799656478674716638L;
	private static final long serialVersionUID = 1L;
	private Cliente cliente = new Cliente();
	private EmpleadoController ubean = new EmpleadoController();
	private List<Cliente> listadoCliente;
	private List<Servicio> servicios;
	private List<Registro> registros;
	private List<Empleado> empleados;
	private List<Instalacion> listaInstalaciones;
	private Registro registro = new Registro();
	private Empleado empleado = new Empleado();
	private Servicio servicio = new Servicio();
	private Instalacion instalacion = new Instalacion();
	private Agendamiento agendamiento = new Agendamiento();
	private Visita visita = new Visita();

	private Equipo equipo = new Equipo();
	private Servicio servicioTmp;
	private Telefono telefono;
	private List<Telefono> telefonos;
	private Telefono nuevoTelefono;

	private String nuevoNumero;
	private String nuevoTipoTelefono;
	private List<EquipoServicio> serviciosCliente;

	private List<Registro> registrosvisita;
	private List<Agendamiento> agendamientos;
	private List<Empleado> tecnicos;
	private String tecnicoElegido;

	/**
	 * Declaraacion de variables
	 */
	private int id;
	private int idR;
	private String cedula;
	private String nombre;
	private String apellidos;

	private String ip;
	private String password;


	private String serial;
	private String email;
	private String convencional;
	private String celular;
	private String direccionPrincipal;
	public EmpleadoController getUbn() {
		return ubn;
	}

	public void setUbn(EmpleadoController ubn) {
		this.ubn = ubn;
	}

	private String direccionSecundaria;
	private String direccionReferencia;
	private String latitud;
	private String longitud;
	private String jj;
	private String antenaC;
	public String problemas;
	public String soluciones;
	private String empleados1;
	private String servicioRB;
	private EmpleadoController ubn;
	public List<String> listaSugerencias;

	private String servicioElegido;
	private String numContrato;
	private String fecha;
	private String item;
	private String antenaElegida;
	private String planElegida;
	private String observaciones;
	private String routerVendido;

	private Telefono telefonoConveEdit;
	private Telefono telefonoMovilEdit;
	private Servicio servicioEdit;
	private EquipoServicio eqServEdit;

	private String antenaTmp;
	private String planTmp;
	private String router;
	private boolean rendered;

	private List<String> opciones;
	public List<Cliente> filtradoCliente;

	private List<String> tipoServicios;
	private List<Equipo> listadoAntenas;
	private List<Plan> listadoPlanes;

	private List<Plan> listadoPlanesTmp;

	public int idEmpl;

	public String inputName;

	private int codigoReg;

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		telefono = new Telefono();
		registro = new Registro();
		instalacion = new Instalacion();
		servicio = new Servicio();
		agendamiento = new Agendamiento();
		empleados = empon.getListadoEmpleado();
		listadoCliente = clion.getListadoCliente();
		listaInstalaciones = inson.getListadoInstalacion();
		telefonos = new ArrayList<Telefono>();
		equipo = new Equipo();
		serviciosCliente = new ArrayList<EquipoServicio>();
		ubn= new EmpleadoController();
		
	   registros = regon.getListadoRegistro();
	
		nuevoTelefono = new Telefono();

		servicioTmp = new Servicio();
		telefonoConveEdit = new Telefono();
		telefonoMovilEdit = new Telefono();
		servicioEdit = new Servicio();
		eqServEdit = new EquipoServicio();

		telefonos = new ArrayList<Telefono>();
		listadoPlanesTmp = new ArrayList<Plan>();

		listadoPlanes = new ArrayList<Plan>();
		equipo = new Equipo();
		servicioElegido = "Fibra";
		if (servicioElegido.equals("Radio")) {

			listadoAntenas = eqOn.getListadoAntenas();
		} else {
			listadoAntenas = eqOn.getListadoEquiposFibra();
		}
		System.out.println("Servicio: " + servicioElegido);
		listadoPlanesTmp = planOn.getListadoPlan();
		opciones = new ArrayList<String>();
		tipoServicios = new ArrayList<String>();

		listadoPlanes.add(listadoPlanesTmp.get(0));
		listadoPlanes.add(listadoPlanesTmp.get(1));
		listadoPlanes.add(listadoPlanesTmp.get(2));

		opciones.add("Si");
		opciones.add("No");

		tipoServicios.add("Radio");
		tipoServicios.add("Fibra");
		listadoAntenas = eqOn.getListadoAntenas();
		listadoPlanes = planOn.getListadoPlan();
		registrosvisita = regon.listadoRegistrosVT();
		tecnicos = empon.getListadoTecnico();
		agendamientos = agon.getAgenda();
		visita = new Visita();

		System.out.println("Si tomoo las antenaas" + listadoAntenas.size());
		listaSugerencias = new ArrayList<String>();
	}

	public List<Agendamiento> getAgendamientos() {
		return agendamientos;
	}

	public void setAgendamientos(List<Agendamiento> agendamientos) {
		this.agendamientos = agendamientos;
	}

	public List<Registro> getRegistrosvisita() {
		return registrosvisita;
	}

	public List<Empleado> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Empleado> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public String getTecnicoElegido() {
		return tecnicoElegido;
	}

	public void setTecnicoElegido(String tecnicoElegido) {
		this.tecnicoElegido = tecnicoElegido;
	}

	public String getApellidos() {
		return apellidos;
	}
	public void setRegistrosvisita(List<Registro> registrosvisita) {
		this.registrosvisita = registrosvisita;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EquipoServicio clienteip;

	/**
	 * Fin de la declaracion
	 */

	// @ManagedProperty(value = "#{login}")
	// private EmpleadoController empCon;

	/**
	 * Inyeccion de las clases ON
	 */
	@Inject
	private ClienteON clion;

	@Inject
	private RegistroON regon;

	@Inject
	private EmpleadoON empon;

	@Inject
	private InstalacionON inson;

	@Inject
	private ServicioON seron;

	@Inject
	private FacesContext fc;

	@Inject
	private AgendamientoON agon;

	@Inject
	private EquipoOn eqOn;

	@Inject
	private TelefonoON telOn;

	@Inject
	private PlanON planOn;

	@Inject
	private VisitaON visitaOn;

	@Inject
	private EquipoServicioON eqServOn;

	/**
	 * Metodo para la accion para realizar las revisiones
	 */
	public void datosRegistro() {

		if (idR == 0)
			return;
		registro = regon.getRegistro(idR);
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getDireccionPrincipal() {
		return direccionPrincipal;
	}

	public void setDireccionPrincipal(String direccionPrincipal) {
		this.direccionPrincipal = direccionPrincipal;
	}

	public String getDireccionSecundaria() {
		return direccionSecundaria;
	}

	public void setDireccionSecundaria(String direccionSecundaria) {
		this.direccionSecundaria = direccionSecundaria;
	}

	public String getDireccionReferencia() {
		return direccionReferencia;
	}

	public void setDireccionReferencia(String direccionReferencia) {
		this.direccionReferencia = direccionReferencia;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public ClienteON getClion() {
		return clion;
	}

	public void setClion(ClienteON clion) {
		this.clion = clion;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getAntenaElegida() {
		return antenaElegida;
	}

	public void setAntenaElegida(String antenaElegida) {

		this.antenaElegida = antenaElegida;
	}

	public List<Equipo> getListadoAntenas() {
		if (servicioEdit.getTipoServicio() != null) {
			if (servicioEdit.getTipoServicio().equals("radio")) {
				return eqOn.getListadoAntenas();
			} else {
				System.out.println("Servicio: " + servicioEdit.getTipoServicio());
				return eqOn.getListadoEquiposFibra();
			}
		} else {
			return null;
		}
	}

	public void setListadoAntenas(List<Equipo> listadoAntenas) {
		if (servicioElegido.equals("Radio")) {

			this.listadoAntenas = eqOn.getListadoAntenas();

		} else {
			this.listadoAntenas = eqOn.getListadoEquiposFibra();
			System.out.println("Size=" + listadoAntenas.size());
		}
	}

	public String getEmail() {
		return email;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public PlanON getPlanOn() {
		return planOn;
	}

	public void setPlanOn(PlanON planOn) {
		this.planOn = planOn;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConvencional() {
		return convencional;
	}

	public void setConvencional(String convencional) {
		this.convencional = convencional;
	}

	public String getCelular() {
		return celular;
	}

	public List<EquipoServicio> getServiciosCliente() {
		return serviciosCliente;
	}

	public void setServiciosCliente(List<EquipoServicio> serviciosCliente) {
		this.serviciosCliente = serviciosCliente;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getJj() {
		return jj;
	}

	public void setJj(String jj) {
		this.jj = jj;
	}

	public String getProblemas() {
		return problemas;
	}

	public void setProblemas(String problemas) {
		this.problemas = problemas;
	}

	public List<Plan> getListadoPlanesTmp() {
		return listadoPlanesTmp;
	}

	public void setListadoPlanesTmp(List<Plan> listadoPlanesTmp) {
		this.listadoPlanesTmp = listadoPlanesTmp;
	}

	public RegistroON getRegon() {
		return regon;
	}

	public void setRegon(RegistroON regon) {
		this.regon = regon;
	}

	public EmpleadoON getEmpon() {
		return empon;
	}

	public void setEmpon(EmpleadoON empon) {
		this.empon = empon;
	}

	public InstalacionON getInson() {
		return inson;
	}

	public void setInson(InstalacionON inson) {
		this.inson = inson;
	}

	public ServicioON getSeron() {
		return seron;
	}

	public void setSeron(ServicioON seron) {
		this.seron = seron;
	}

	public FacesContext getFc() {
		return fc;
	}

	public void setFc(FacesContext fc) {
		this.fc = fc;
	}

	public AgendamientoON getAgon() {
		return agon;
	}

	public void setAgon(AgendamientoON agon) {
		this.agon = agon;
	}

	public EquipoOn getEqOn() {
		return eqOn;
	}

	public void setEqOn(EquipoOn eqOn) {
		this.eqOn = eqOn;
	}

	public TelefonoON getTelOn() {
		return telOn;
	}

	public void setTelOn(TelefonoON telOn) {
		this.telOn = telOn;
	}

	public problema[] getListaProblema() {
		return listaProblema;
	}

	public void setListaProblema(problema[] listaProblema) {
		this.listaProblema = listaProblema;
	}

	public solucion[] getListaSolucion() {
		return listaSolucion;
	}

	public void setListaSolucion(solucion[] listaSolucion) {
		this.listaSolucion = listaSolucion;
	}

	public solucion[] getListaAccion() {
		return listaAccion;
	}

	public void setListaAccion(solucion[] listaAccion) {
		this.listaAccion = listaAccion;
	}

	public ServicioFA[] getServicioLista() {
		return servicioLista;
	}

	public void setServicioLista(ServicioFA[] servicioLista) {
		this.servicioLista = servicioLista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*
	 * Creacion de getters and setters
	 */
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListadoCliente() {
		return listadoCliente;
	}

	public void setListadoCliente(List<Cliente> listadoCliente) {
		this.listadoCliente = listadoCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getAntenaC() {
		return antenaC;
	}

	public void setAntenaC(String antenaC) {
		this.antenaC = antenaC;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public String getSoluciones() {
		return soluciones;
	}

	public void setSoluciones(String soluciones) {
		this.soluciones = soluciones;
	}

	public String getEmpleados1() {
		return empleados1;
	}

	public void setEmpleados1(String empleados1) {
		this.empleados1 = empleados1;
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}

	public int getCodigoReg() {
		return codigoReg;
	}

	public void setCodigoReg(int codigoReg) {
		this.codigoReg = codigoReg;
	}

	public String getServicioRB() {
		return servicioRB;
	}

	public void setServicioRB(String servicioRB) {
		this.servicioRB = servicioRB;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Instalacion> getListaInstalaciones() {
		return listaInstalaciones;
	}

	public void setListaInstalaciones(List<Instalacion> listaInstalaciones) {
		this.listaInstalaciones = listaInstalaciones;
	}

	public int getIdEmpl() {
		return idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Agendamiento getAgendamiento() {
		return agendamiento;
	}

	public void setAgendamiento(Agendamiento agendamiento) {
		this.agendamiento = agendamiento;
	}

	public int getIdR() {
		return idR;
	}

	public void setIdR(int idR) {
		this.idR = idR;
	}

	/*
	 * Hasta aqui llega la creacion de los getters and setters
	 */

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

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

	public String editarRegistro1(int codigo) {
		return "solucionar?faces-redirect=true&id=" + codigo;
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

	public String buscarCedula() {
		System.out.println("esta es la cedula hpta " + this.cedula);
		try {
			if (this.cedula != null) {

				cliente = clion.getClienteCedula(this.cedula);
				System.out.println("cliente cedula --> " + cliente.getCedula());
				List<Telefono> telefonos2 = telOn.getTelefonos(cliente);
				for (Telefono telefono : telefonos2) {
					System.out.println(telefono.getTipoTelefono());
					System.out.println("-----kiko----");
				}
				registro.setIdClienteTemp(cliente.getId());
				cliente.setTelefonos(telefonos);
				fechaHora();

				// datoR();
				setNuevoTelefono(null);
				setNuevoTipoTelefono(null);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Correctas"));

			}
		} catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));

		}
		System.out.println("veniii" + cliente.getCedula());
		System.out.println("q ha psado cabeza" + empleado.getId());
		return null;

	}

	public String getNuevoNumero() {
		return nuevoNumero;
	}

	public void setNuevoNumero(String nuevoNumero) {
		this.nuevoNumero = nuevoNumero;
	}

	public String getNuevoTipoTelefono() {
		return nuevoTipoTelefono;
	}

	public void setNuevoTipoTelefono(String nuevoTipoTelefono) {
		this.nuevoTipoTelefono = nuevoTipoTelefono;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public List<Telefono> getTelefonos1(Cliente cliente) {

		return telefonos;
	}

	/**
	 * Metodo para la busqueda del cliente por el nombre
	 */
	public void buscarNombre() {
		cliente = clion.getClienteNombre(cliente.getNombre());
		registro.setIdClienteTemp(cliente.getId());
		fechaHora();
		// datoR();
	}

	public String cargarDatosCallCenter() {

		try {
			clion.guardar(cliente);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo para guadar el agendamiento
	 *
	 * @return
	 */

	public String guardarAgendamiento() {
		Registro c = new Registro();
		Agendamiento g = new Agendamiento();
		g.setRegistro(c);
		try {
			this.agendamiento.setRegistro(registro);
			agon.guardar(agendamiento);
			regon.guardar(registro);
			init();
			System.out.println("holaaaa q fue " + c.getId());
			// System.out.println("la clave del id es: "+ registro);
			return "callcenter";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String listAntena() {
		// antenaC = "" + anton.getListadoAntena();
		return antenaC;
	}

	/**
	 * Metod para guardar los registros
	 *
	 * @return"
	 */
	public String cargarDatosRegistro() {
		try {
			System.out.println("Llegando:::::111");
			cliente.setId(registro.getCliente().getId());
			registro.getCliente().setId(cliente.getId());
			System.out.println("cliente id " + cliente.getId());
			empleado.setId(registro.getEmpleado().getId());
			registro.getEmpleado().setId(empleado.getId());
			regon.guardar(registro);
			System.out.println("imprime esto:   " + registro.getFechaHora());
			init();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		// return "registro?faces-redirect=true";
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

	public Telefono getNuevoTelefono() {
		return nuevoTelefono;
	}

	public void setNuevoTelefono(Telefono nuevoTelefono) {
		this.nuevoTelefono = nuevoTelefono;
	}

	public problema[] listaProblema;
	public problema[] listaSoluOficina;

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

	public problema[] getOficina1() {
		listaSoluOficina = new problema[3];
		listaSoluOficina[0] = new problema("SOLUCIONADO", "1");
		listaSoluOficina[1] = new problema("NODO CAIDO", "2");
		listaSoluOficina[2] = new problema("VISITA TECNICA", "3");

		return listaSoluOficina;
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

		listaSolucion[0] = new solucion("SOLUCIONADOF", "1");
		listaSolucion[1] = new solucion("NODO CAIDO", "2");
		listaSolucion[2] = new solucion("VISITA TECNICA", "3");

		return listaSolucion;
	}

	// matriz para la accion de cada registro del callcenter
	public static class accion {

		public String carLabel;
		public String carValue;

		public accion(String carLabel, String carValue) {
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

	public solucion[] listaAccion;

	public solucion[] getAccion() {
		listaSolucion = new solucion[4];
		listaSolucion[0] = new solucion("VISITA TECNICA", "1");
		listaSolucion[1] = new solucion("NODO CAIDO", "2");
		listaSolucion[2] = new solucion("PROBLEMA ENLACE", "3");
		listaSolucion[3] = new solucion("SOLUCIONADOF", "4");

		return listaSolucion;
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

	public List<Plan> getListadoPlanes() {
		if (servicioEdit.getTipoServicio() != null) {
			if (servicioEdit.getTipoServicio().equals("radio")) {
				List<Plan> planRadio = new ArrayList<Plan>();
				planRadio.add(listadoPlanesTmp.get(0));
				planRadio.add(listadoPlanesTmp.get(1));
				planRadio.add(listadoPlanesTmp.get(2));

				return planRadio;
			} else {
				List<Plan> planFibra = new ArrayList<Plan>();
				planFibra.add(listadoPlanesTmp.get(3));
				planFibra.add(listadoPlanesTmp.get(4));
				planFibra.add(listadoPlanesTmp.get(5));

				return planFibra;
			}
		} else
			return null;
	}

	public void setListadoPlanes(List<Plan> listadoPlanes) {
		this.listadoPlanes = listadoPlanes;
	}

	public EquipoServicioON getEqServOn() {
		return eqServOn;
	}

	public void setEqServOn(EquipoServicioON eqServOn) {
		this.eqServOn = eqServOn;
	}

	public Telefono getTelefonoMovilEdit() {
		return telefonoMovilEdit;
	}

	public void setTelefonoMovilEdit(Telefono telefonoMovilEdit) {
		this.telefonoMovilEdit = telefonoMovilEdit;
	}

	public Servicio getServicioEdit() {
		return servicioEdit;
	}

	public void setServicioEdit(Servicio servicioEdit) {
		this.servicioEdit = servicioEdit;
	}

	public String getPlanElegida() {
		return planElegida;
	}

	public String getServicioElegido() {
		return servicioElegido;
	}

	public void setServicioElegido(String servicioElegido) {
		this.servicioElegido = servicioElegido;
	}

	public void setPlanElegida(String planElegida) {
		this.planElegida = planElegida;
	}

	public String getRouterVendido() {
		return routerVendido;
	}

	public void setRouterVendido(String routerVendido) {
		this.routerVendido = routerVendido;
	}

	public List<String> getOpciones() {
		return opciones;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setOpciones(List<String> opciones) {
		this.opciones = opciones;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getAntenaTmp() {
		return antenaTmp;
	}

	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public void setAntenaTmp(String antenaTmp) {
		this.antenaTmp = antenaTmp;
	}

	public Servicio getServicioTmp() {
		return servicioTmp;
	}

	public Telefono getTelefonoConveEdit() {
		return telefonoConveEdit;
	}

	public void setTelefonoConveEdit(Telefono telefonoConveEdit) {
		this.telefonoConveEdit = telefonoConveEdit;
	}

	public void setServicioTmp(Servicio servicioTmp) {
		this.servicioTmp = servicioTmp;
	}

	public String getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	public EquipoServicio getEqServEdit() {
		return eqServEdit;
	}

	public List<String> getTipoServicios() {
		return tipoServicios;
	}

	public void setTipoServicios(List<String> tipoServicios) {
		this.tipoServicios = tipoServicios;
	}

	public void setEqServEdit(EquipoServicio eqServEdit) {
		this.eqServEdit = eqServEdit;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	// Metodo para actualizar los telefonos;

	public String getRouter() {
		return router;
	}

	public void setRouter(String router) {
		this.router = router;
	}

	public String getPlanTmp() {
		return planTmp;
	}

	public void setPlanTmp(String planTmp) {
		this.planTmp = planTmp;
	}

	public void loadData() {
		if (id == 0)
			return;
		cliente = clion.getCliente(id);

		List<Telefono> telefonos2 = telOn.getTelefonos(cliente);
		for (Telefono telefono : telefonos2) {
			if (telefono.getTipoTelefono().equals("Convencional")) {
				setTelefonoConveEdit(telefono);
			}
			if (telefono.getTipoTelefono().equals("Movil")) {
				setTelefonoMovilEdit(telefono);
			}

		}

		List<Servicio> servicios = seron.getServicios(cliente);
		int i = 0;
		for (Servicio servicio : servicios) {
			if (i == 0) {
				setServicioEdit(servicio);
			}
			i++;
		}

		List<EquipoServicio> equipoServicios = eqServOn.getServicios(servicioEdit);
		int j = 0;
		for (EquipoServicio equipoServicio : equipoServicios) {
			if (j == 0) {
				setEqServEdit(equipoServicio);
			}
			j++;
		}

		this.antenaTmp = eqServEdit.getEquipo().getModelo();
		this.planTmp = servicioEdit.getPlan().getTipoPlan();
		this.router = servicioEdit.getRouterVendido();

		if (servicioEdit.getTipoServicio().equals("radio")) {
			setListadoAntenas(eqOn.getListadoAntenas());
		} else {
			System.out.println("Servicio: " + servicioEdit.getTipoServicio());
			setListadoAntenas(eqOn.getListadoEquiposFibra());

		}
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
			// registro.setCliente(null);
			// TODO Auto-generated catch block
			/*
			 * FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			 * e.getMessage(), "Error"); fc.addMessage("txtCliente1", msg);
			 */

			e.printStackTrace();
		}
	}

	public void consultarCliente1() {

		Cliente cli;
		try {

			cli = regon.consultarCliente(servicio.getIdClienteTemp());
			servicio.setCliente(cli);
		} catch (Exception e) {
			// registro.setCliente(null);
			// TODO Auto-generated catch block
			/*
			 * FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			 * e.getMessage(), "Error"); fc.addMessage("txtCliente1", msg);
			 */

			e.printStackTrace();
		}
	}

	public void consultarEmpleado() {

		Empleado emp;
		try {
			emp = regon.consultarEmpleado(registro.getIdEmpleadoTemp());
			registro.setEmpleado(emp);

		} catch (Exception e) {
			// registro.setEmpleado(null);
			// TODO Auto-generated catch block
			/*
			 * FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			 * e.getMessage(), "Error"); fc.addMessage("txtEmpleado1", msg);
			 */

			e.printStackTrace();
		}
	}

	public void fechaHora() {
		Calendar fecha = new GregorianCalendar();

		// Obtenemos el valor del año, mes, día,
		// hora, minuto y segundo del sistema
		// usando el método get y el parámetro correspondiente
		int año = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int hora = fecha.get(Calendar.HOUR_OF_DAY);
		int minuto = fecha.get(Calendar.MINUTE);
		int segundo = fecha.get(Calendar.SECOND);

		String fec = String.valueOf(año) + "/" + String.valueOf(mes + 1) + "/" + String.valueOf(dia) + " "
				+ String.valueOf(hora) + ":" + String.valueOf(minuto) + ":" + String.valueOf(segundo);
		registro.setFechaHora(fec);
		agendamiento.setFecha(fec);

	}

	/*
	 * 
	 * 
	 * public void datoR() { System.out.println("datos locos " + empCon.getId());
	 * registro.setIdEmpleadoTemp(empCon.getId()); }
	 * 
	 * public String datoI() { System.out.println("Datos Instalacion " +
	 * empCon.getId()); instalacion.setCodigoEmpTemp(empCon.getId()); return
	 * "instalacion"; }
	 */
	public boolean validadorDeCedula(String cedula) {
		boolean cedulaCorrecta = false;

		try {

			if (cedula.length() == 10) // ConstantesApp.LongitudCedula
			{
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validación cédula
					// El decimo digito se lo considera dígito verificador
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrio en el proceso de validadcion");
			cedulaCorrecta = false;
		}

		if (!cedulaCorrecta) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Cedula Incorrecta"));

		}
		return cedulaCorrecta;
	}

	public EquipoServicio getClienteip() {
		return clienteip;
	}

	public void setClienteip(EquipoServicio clienteip) {
		this.clienteip = clienteip;
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

	public String crearCliente() {

		Telefono tele = new Telefono();
		Telefono teleMovil = new Telefono();
		Cliente cli = new Cliente();
		String hola = "ww";
		System.out.println(hola);
		cli.setCedula(this.cedula);
		cli.setApellidos(this.apellidos);
		cli.setNombre(this.nombre);
		cli.setDireccionPrincipal(this.direccionPrincipal);
		cli.setDireccionSecundaria(this.direccionSecundaria);
		cli.setDireccionReferencia(this.direccionReferencia);
		cli.setEmail(this.email);
		cli.setLatitud(this.latitud);
		cli.setLongitud(this.longitud);

		clion.guardar(cli);

		tele.setTipoTelefono("Convencional");
		tele.setTelNumero(this.convencional);
		tele.setCliente(cli);
		telOn.guardar(tele);

		teleMovil.setTipoTelefono("Movil");
		teleMovil.setTelNumero(this.celular);
		teleMovil.setCliente(cli);

		telOn.guardar(teleMovil);

		if (servicioElegido.equals("Radio")) {
			Plan planTmp = new Plan();
			Equipo antenaTmp = new Equipo();
			EquipoServicio eqServicio = new EquipoServicio();

			antenaTmp = eqOn.buscarAntena(Integer.parseInt(antenaElegida));
			planTmp = planOn.buscarPlan(Integer.parseInt(planElegida));

			servicioTmp.setTipoServicio("radio");
			servicioTmp.setNumeroContrato(this.numContrato);
			servicioTmp.setCliente(cli);
			servicioTmp.setFechaContrato(this.fecha);
			servicioTmp.setRouterVendido(this.routerVendido);
			servicioTmp.setObservaciones(this.observaciones);
			servicioTmp.setPlan(planTmp);
			seron.guardar(servicioTmp);

			eqServicio.setSerial(this.serial);
			eqServicio.setPassword(this.password);
			eqServicio.setIp(this.ip);

			eqServicio.setEquipo(antenaTmp);
			eqServicio.setServicio(servicioTmp);

			eqServOn.crearI(eqServicio);
		} else {
			Plan planTmp = new Plan();
			Equipo antenaTmp = new Equipo();
			EquipoServicio eqServicio = new EquipoServicio();

			antenaTmp = eqOn.buscarAntena(Integer.parseInt(antenaElegida));
			planTmp = planOn.buscarPlan(Integer.parseInt(planElegida));

			servicioTmp.setTipoServicio("fibra");
			servicioTmp.setNumeroContrato(this.numContrato);
			servicioTmp.setCliente(cli);
			servicioTmp.setFechaContrato(this.fecha);
			servicioTmp.setRouterVendido(this.routerVendido);
			servicioTmp.setObservaciones(this.observaciones);
			servicioTmp.setPlan(planTmp);
			seron.guardar(servicioTmp);

			eqServicio.setSerial(this.serial);
			eqServicio.setPassword(this.password);
			eqServicio.setIp(this.ip);

			eqServicio.setEquipo(antenaTmp);
			eqServicio.setServicio(servicioTmp);

			eqServOn.crearI(eqServicio);

		}

		this.cedula = "";
		this.nombre = "";
		this.apellidos = "";
		this.convencional = "";
		this.celular = "";
		this.direccionPrincipal = "";
		this.direccionSecundaria = "";
		this.direccionReferencia = "";
		this.latitud = "";
		this.longitud = "";
		this.email = "";
		this.antenaElegida = "";
		this.planElegida = "";
		this.ip = "";
		this.password = "";
		this.serial = "";
		this.observaciones = "";

		teleMovil.setTipoTelefono("Movil");
		teleMovil.setTelNumero(this.celular);
		teleMovil.setCliente(cli);
		telOn.guardar(teleMovil);

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
			// instalacion.setEmpleado(null);
			// TODO Auto-generated catch block
			/*
			 * FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			 * e.getMessage(), "Error"); fc.addMessage("txtEmpleado1", msg);
			 */
			// e.printStackTrace();
		}
	}

	public void toggleRendered(ActionEvent event) {
		this.rendered = !rendered;
	}

	public String cargarDatos() {
		try {

			clion.guardar(cliente);
			telOn.guardar(telefonoConveEdit);
			telOn.guardar(telefonoMovilEdit);
			Plan planTmp = new Plan();
			Equipo equipo = new Equipo();

			if (planElegida != null)

				planTmp = planOn.buscarPlan(Integer.parseInt(planElegida));
			else
				planTmp = planOn.getPlanByName(this.planTmp);

			if (antenaElegida != null)

				equipo = eqOn.buscarAntena(Integer.parseInt(this.antenaElegida));
			else
				equipo = eqOn.getAntenaByName(this.antenaTmp);

			this.servicioEdit.setRouterVendido(this.router);
			this.servicioEdit.setPlan(planTmp);

			// seron.guardar(servicioEdit);

			seron.update(this.servicioEdit);

			this.eqServEdit.setEquipo(equipo);

			eqServOn.actualizar(this.eqServEdit);

			this.antenaTmp = "";
			this.planTmp = "";
			this.router = "";
			init();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public void validarCedula(FacesContext context, UIComponent comp, Object value) {
		System.out.println("inside validate method");

		String mno = (String) value;
		try {
			Integer.parseInt(mno);
		} catch (Exception e) {
			((UIInput) comp).setValid(false);
			FacesMessage message = new FacesMessage("Favor ingrese solo numeros");
			context.addMessage(comp.getClientId(context), message);
		}
		int i;
		int vect[] = new int[13];
		if (mno.equals("0000000000")) {
			FacesMessage message = new FacesMessage("No es una cedula valida");
			context.addMessage(comp.getClientId(context), message);
		} else if (mno.length() == 10) {
			System.out.println("Cedula");
			for (i = 0; i < mno.length(); i++) {
				vect[i] = Integer.parseInt(Character.toString(mno.charAt(i)));
			}
			if (vect[2] <= 6 && vect[2] >= 0) {
				int comprobar[] = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
				int suma = 0;
				for (i = 0; i < comprobar.length; i++) {
					vect[i] *= comprobar[i];
					if (vect[i] >= 10) {
						vect[i] -= 9;
					}
					suma += vect[i];
				}
				suma += vect[i];
				suma %= 10;
				if (suma != 0) {
					((UIInput) comp).setValid(false);
					FacesMessage message = new FacesMessage("No es una cedula valida");
					context.addMessage(comp.getClientId(context), message);
				}
			}
		} else {
			((UIInput) comp).setValid(false);
			FacesMessage message = new FacesMessage("Favor ingrese los 10 digitos");
			context.addMessage(comp.getClientId(context), message);
		}
	}

	public void validarNombre(FacesContext context, UIComponent componentToValidate, Object value)
			throws ValidatorException {
		FacesMessage message = null;
		// Retrieve the temporary value from the password field

		String mNombre = (String) value;

		/* Verificamos que no sea null */
		if (mNombre != "") {

			String[] parts = mNombre.split(" ");

			if (parts.length > 2) {
				message = new FacesMessage("No puede tener mas de dos nombres");
				throw new ValidatorException(message);
			}

			for (int i = 0; i < parts.length; i++) {
				int stringSize = parts[i].length();
				boolean isValidSize = (stringSize >= 3 && stringSize <= 30);

				if (!isValidSize && i == 0) {
					message = new FacesMessage("El primer nombre debe tener un minimo de 3 caracteres");
					throw new ValidatorException(message);
				}

				if (!isValidSize && i == 1) {
					message = new FacesMessage("El segundo nombre debe tener un minimo de 3 caracteres");
					throw new ValidatorException(message);
				}
			}

			/* 2ª Condición: que el tamaño sea >= 3 y <= 15 */

		}
	}

	public void validarApellido(FacesContext context, UIComponent componentToValidate, Object value)
			throws ValidatorException {
		FacesMessage message = null;
		// Retrieve the temporary value from the password field

		String mNombre = (String) value;

		/* Verificamos que no sea null */
		if (mNombre != "") {

			String[] parts = mNombre.split(" ");

			if (parts.length == 1) {
				message = new FacesMessage("No puede tener un apellido");
				throw new ValidatorException(message);
			}

			if (parts.length > 2) {
				message = new FacesMessage("No puede tener mas de dos apellidos");
				throw new ValidatorException(message);
			}

			for (int i = 0; i < parts.length; i++) {
				int stringSize = parts[i].length();
				boolean isValidSize = (stringSize >= 3 && stringSize <= 20);

				if (!isValidSize && i == 0) {
					message = new FacesMessage("El primer apellido debe tener entre 3 y 20 caracteres");
					throw new ValidatorException(message);
				}

				if (!isValidSize && i == 1) {
					message = new FacesMessage("El segundo apellido debe tener entre 3 y 20 caracteres");
					throw new ValidatorException(message);
				}
			}

			/* 2ª Condición: que el tamaño sea >= 3 y <= 15 */

		}
	}

	public void validarTelefono(FacesContext context, UIComponent componentToValidate, Object value)
			throws ValidatorException {
		FacesMessage message = null;
		// Retrieve the temporary value from the password field

		String convecional = (String) value;

		if (convecional != "") {

			try {
				Integer.parseInt(convecional);
			} catch (NumberFormatException excepcion) {

				message = new FacesMessage("Ingrese solo numeros");
				throw new ValidatorException(message);

			}

		} /* Verificamos que no sea null */
	}

	// Metodo para actualizar los telefonos;

	public void editTelefono(Telefono telefono) {

		try {
			this.telefono = telefono;
			telOn.updateTelefono(telefono);
			System.out.println("TELEFONO A UPDATE -> " + telefono.getTipoTelefono());

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se actualizo el telefono correctamente"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "No se pudo actualizar el telefono"));

		}

	}

	public void newTelefono() {

		if (nuevoTipoTelefono != null && nuevoNumero != null) {
			try {
				System.out.println("this is new ID FOR TEL -> " + telOn.getMaxId() + 1);
				nuevoTelefono = new Telefono(telOn.getMaxId() + 1, nuevoNumero, nuevoTipoTelefono,
						clion.getClienteCedula(cliente.getCedula()));
				telefonos.add(nuevoTelefono);
				telOn.createTelefono(nuevoTelefono);

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Telefono Agregado Correctamente"));

			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "No se pudo agregar el telefono"));

			}
		}
	}

	public void validarCorreo(FacesContext context, UIComponent componentToValidate, Object value)
			throws ValidatorException {
		FacesMessage message = null;
		// Retrieve the temporary value from the password field
		String correo = null;
		correo = (String) value;
		if (correo != "") {
			Pattern pattern = Pattern.compile(
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher mather = pattern.matcher(correo);
			if (!mather.find()) {
				message = new FacesMessage("Correo Invalido");
				throw new ValidatorException(message);
			}
		} /* Verificamos que no sea null */

	}

	public List<Equipo> listarAntenas(String antenaElegido) {
		if (antenaElegido.equals("Radio")) {
			return eqOn.getListadoAntenas();
		} else {
			return eqOn.getListadoEquiposFibra();
		}
	}

	/**
	 *
	 */

	// SICHA METODS
	/**
	 * funcion global para buscar en data table
	 */

	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
		if (filterText == null || filterText.equals("")) {
			return true;
		}
		int filterInt = getInteger(filterText);

		Cliente cli = (Cliente) value;
		return cli.getCedula().toLowerCase().contains(filterText)
				|| cli.getApellidos().toLowerCase().contains(filterText)
				|| cli.getNombre().toLowerCase().contains(filterText)
				|| cli.getEmail().toLowerCase().contains(filterText)
				|| cli.getLatitud().toLowerCase().contains(filterText)
				|| cli.getLongitud().toLowerCase().contains(filterText)
				|| cli.getDireccionReferencia().toLowerCase().contains(filterText)
				|| cli.getDireccionSecundaria().toLowerCase().contains(filterText);
		/*
		 * || cli.isSold() ? "sold" : "sale").contains(filterText) || cli.getYear() <
		 * filterInt || cli.getPrice() < filterInt;
		 */
	}

	private int getInteger(String string) {
		try {
			return Integer.valueOf(string);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	// Metod to autocomplete

	public List<String> getSugerencias(String enteredValue) {
		List<String> coincidencias = new ArrayList<String>();

		System.out.println("NOMBRE BUSCADO");
		System.out.println(enteredValue);
		Cliente clie;

		for (int i = 0; i < listadoCliente.size(); i++) {

			clie = (Cliente) listadoCliente.get(i);
			String nombre = clie.getNombre() + " " + clie.getApellidos() + "/" + clie.getCedula();
			String apellido = clie.getApellidos();
			String nombres = clie.getNombre();

			try {
				if (nombres.toLowerCase().startsWith(enteredValue.toLowerCase())
						|| apellido.toLowerCase().startsWith(enteredValue.toLowerCase())) {
					System.out.println("Ingresa");

					coincidencias.add(nombre);
				}

			} catch (Exception e) {
				System.out.println("Exception " + e);
			}

		}

		return coincidencias;

	}

	public String findByNames() {
		System.out.println("THIS IS THE IDENTIFICACION OF CLIENT " + inputName);

		try {
			inputName = inputName.substring(inputName.lastIndexOf("/") + 1);

			System.out.println(inputName);
			cliente = clion.getClienteCedula(inputName);
			setTelefonos(telOn.getTelefonos(cliente));
			for (Telefono telefono : telefonos) {
				System.out.println(telefono.getTipoTelefono());
				System.out.println("-----kiko----");
			}
			registro.setIdClienteTemp(cliente.getId());
			cliente.setTelefonos(telefonos);
			fechaHora();
			// datoR();
			setNuevoTelefono(null);
			setNuevoTipoTelefono(null);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Correctas"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("NO HAY TEXTO ");
		}

		return null;
	}

	public void newTelefono(Telefono telefono) {
		System.out.println("Telefono de parametro " + telefono.getTelNumero());
		System.out.println("Telefono de parametro " + telefono.getTipoTelefono());
		this.nuevoTelefono = telefono;
		nuevoTelefono.setCliente(cliente);
		if (nuevoTelefono.getTipoTelefono() != "" && nuevoTelefono.getTelNumero() != ""
				&& nuevoTelefono.getTipoTelefono() != null) {
			try {
				clion.getClienteCedula(cliente.getCedula());
				nuevoTelefono.setId(telOn.getMaxId() + 1);
				telOn.createTelefono(nuevoTelefono);

				System.out.println("ALL RIGHT BABE");
			} catch (Exception e) {
				System.out.println("PILAS PARA AGREGAR EL NUEVO TELEFONO " + nuevoTelefono.getTelNumero());

			}
			this.nuevoTelefono = new Telefono();
		}
	}

	public List<Plan> listarPlan(String antenaElegido) {
		if (antenaElegido.equals("Radio")) {
			List<Plan> planRadio = new ArrayList<Plan>();
			planRadio.add(listadoPlanesTmp.get(0));
			planRadio.add(listadoPlanesTmp.get(1));
			planRadio.add(listadoPlanesTmp.get(2));

			return planRadio;
		} else {
			List<Plan> planFibra = new ArrayList<Plan>();
			planFibra.add(listadoPlanesTmp.get(3));
			planFibra.add(listadoPlanesTmp.get(4));
			planFibra.add(listadoPlanesTmp.get(5));

			return planFibra;
		}

	}
	public void ingresaVisita() {
		System.out.println(tecnicoElegido);
		System.out.println("************entro**************");
		empleado = empon.getEmpleadobyName(tecnicoElegido);

		System.out.println("************id**************");
		System.out.println(empleado.getId());
		System.out.println("************salio**************");
		System.out.println("Id del cliente" + registro.getCliente().getId());
		Cliente cli = clion.getCliente(registro.getCliente().getId());
		Visita g = new Visita(cli, registro, empleado);
		visitaOn.guardar(g);
		System.out.println("Se guardo correcto correctamente");
	}

	public List<Cliente> getFiltradoCliente() {
		return filtradoCliente;
	}

	public void setFiltradoCliente(List<Cliente> filtradoCliente) {
		this.filtradoCliente = filtradoCliente;

	}
}
