package astronet.ec.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import astronet.ec.modelo.Agendamiento;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Instalacion;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.RolEmpleado;
import astronet.ec.modelo.Telefono;
import astronet.ec.on.ClienteON;
import astronet.ec.on.EmpleadoON;
import astronet.ec.on.RegistroON;
import astronet.ec.on.RolEmpleadoON;
import astronet.ec.on.TelefonoON;
import astronet.ec.util.SessionUtils;
import astronet.ec.vista.ClienteController.problema;
import astronet.ec.vista.ClienteController.solucion;

@ManagedBean
@ViewScoped
public class CallcenterBean  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idR;
	private List<Cliente> listadoCliente;
	public String inputName;

	private String cedula;
	private String apellidos;
	private Telefono nuevoTelefono;
	private String nuevoTipoTelefono;
	public String problemas;
	private Agendamiento agendamiento = new Agendamiento();

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public List<Cliente> getListadoCliente() {
		return listadoCliente;
	}

	public void setListadoCliente(List<Cliente> listadoCliente) {
		this.listadoCliente = listadoCliente;
	}

	public Agendamiento getAgendamiento() {
		return agendamiento;
	}

	public void setAgendamiento(Agendamiento agendamiento) {
		this.agendamiento = agendamiento;
	}

	public problema[] getListaProblema() {
		return listaProblema;
	}

	public void setListaProblema(problema[] listaProblema) {
		this.listaProblema = listaProblema;
	}

	public problema[] getListaSoluOficina() {
		return listaSoluOficina;
	}

	public void setListaSoluOficina(problema[] listaSoluOficina) {
		this.listaSoluOficina = listaSoluOficina;
	}

	public solucion[] getListaSolucion() {
		return listaSolucion;
	}

	public void setListaSolucion(solucion[] listaSolucion) {
		this.listaSolucion = listaSolucion;
	}

	public String getNuevoTipoTelefono() {
		return nuevoTipoTelefono;
	}

	public void setNuevoTipoTelefono(String nuevoTipoTelefono) {
		this.nuevoTipoTelefono = nuevoTipoTelefono;
	}

	public Telefono getNuevoTelefono() {
		return nuevoTelefono;
	}

	public void setNuevoTelefono(Telefono nuevoTelefono) {
		this.nuevoTelefono = nuevoTelefono;
	}

	public ClienteON getClion() {
		return clion;
	}

	public void setClion(ClienteON clion) {
		this.clion = clion;
	}

	public TelefonoON getTelOn() {
		return telOn;
	}

	public void setTelOn(TelefonoON telOn) {
		this.telOn = telOn;
	}

	private String ip;
	private String password;
	private String email;
	private String convencional;
	private List<Telefono> telefonos;

	private String celular;

	private String direccionSecundaria;
	private String direccionReferencia;
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
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

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccionPrincipal() {
		return direccionPrincipal;
	}

	public void setDireccionPrincipal(String direccionPrincipal) {
		this.direccionPrincipal = direccionPrincipal;
	}

	private String direccionPrincipal;

	@Inject
	private EmpleadoON empon;
	@Inject
	private ClienteON clion;
	@Inject
	private TelefonoON telOn;
	private String nombre;
	private int id;
	private int idUser;

	private Empleado empleado;
	private Empleado empUser;
	private Cliente cliente;
	private Instalacion instalacion;
	private Registro registro;
	private List<Empleado> empleados;

	private List<Empleado> tecnicos;
	private String tecnicoElegido;

	private List<String> departamentosList = new ArrayList<String>();
	@Inject
	private RegistroON regon;
	@Inject
	private RolEmpleadoON rolEmpOn;
	
	private RolEmpleado rolEmpleado;
	private Map<String, Integer> mapaRoles;
	private List<RolEmpleado> listaRolesEmpleados;
	private String rolSelected;
	@PostConstruct
	public void init() {
		empleado = new Empleado();
		instalacion = new Instalacion();
		listadoCliente = clion.getListadoCliente();

		registro = new Registro();
		cliente= new Cliente();
		empleados = empon.getEmpleado();
		tecnicos = empon.getListadoTecnico();
		telefonos = new ArrayList<Telefono>();
		agendamiento = new Agendamiento();

		try {
			departamentosList.add("Administrador");
			departamentosList.add("Contabilidad");
			departamentosList.add("Tecnico Radio");
			departamentosList.add("Tecnico Fibra");
			departamentosList.add("Radio");
			departamentosList.add("Fibra");
			this.listaRolesEmpleados = rolEmpOn.listarRoles();
			cargarMapaRoles(this.listaRolesEmpleados);
			empUser = empon.read(idUser);
			this.rolEmpleado = new RolEmpleado();
			empleado = new Empleado();
			instalacion = new Instalacion();
			registro = new Registro();
			// se cargar todos los empleados de la base de datos
			empleados = empon.getEmpleado();
		} catch (Exception e) {
			System.out.println("CONTROL DE ERRORES EN EMPLEADOCONTROLLER");
		}
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public void cargarMapaRoles(List<RolEmpleado> listaRoles) {
		this.mapaRoles = new HashMap<>();
		for (RolEmpleado roles : listaRoles) {
			mapaRoles.put(roles.getNombre(), roles.getId());
		}
	}

	public void loadData() {
		System.out.println("codigo editar " + id);
		if (id == 0)
			return;

		empleado = empon.getEmpleado(id);

	}

	public String getTecnicoElegido() {
		return tecnicoElegido;
	}

	public void setTecnicoElegido(String tecnicoElegido) {
		this.tecnicoElegido = tecnicoElegido;
	}

	public List<Empleado> getTecnicos() {
		return tecnicos;

	}

	// ZONA GET/SET
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public void setTecnicos(List<Empleado> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public String getNombre() {
		nombre = empleado.getNombre();
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Empleado getEmpUser() {
		return empUser;
	}

	public void setEmpUser(Empleado empUser) {
		this.empUser = empUser;
	}

	public List<String> getDepartamentosList() {
		return departamentosList;
	}

	public void setDepartamentosList(List<String> departamentosList) {
		this.departamentosList = departamentosList;
	}

	public RolEmpleado getRolEmpleado() {
		return rolEmpleado;
	}

	public void setRolEmpleado(RolEmpleado rolEmpleado) {
		this.rolEmpleado = rolEmpleado;
	}

	public List<RolEmpleado> getListaRolesEmpleados() {
		return listaRolesEmpleados;
	}

	public void setListaRolesEmpleados(List<RolEmpleado> listaRolesEmpleados) {
		this.listaRolesEmpleados = listaRolesEmpleados;
	}

	public String getRolSelected() {
		return rolSelected;
	}

	public void setRolSelected(String rolSelected) {
		this.rolSelected = rolSelected;
	}

	// FIN ZONA GET/SET

//	ZONA METODOS BEAN

	public String returnInit(int param) {
		System.out.println("pedro: " + param);
		return "viewAdmin?faces-redirect=true&id=" + param;
	}

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

	public String editar(int idUser, int idEmpleado) {
		return "editarEmpleado?faces-redirect=true&idUser=" + idUser + "&idEmpleado=" + idEmpleado;
	}

	public String eliminar(int codigo) {
		empon.eliminarByID(codigo);
		init();
		// return "registrarEmpleado?faces-redirect=true&id=" + codigo;
		return null;
	}

	public String eliminarRol(int codigo) {
		rolEmpOn.eliminar(codigo);
		init();
		// return "registrarEmpleado?faces-redirect=true&id=" + codigo;
		return null;
	}

	/*
	 * Metodo para guardar o actualizar empleado
	 *
	 */

	public String guardarEmpleado() {
		try {
			if (validadorDeCedula(empleado.getCedula())) {
				empleado.setRolEmpleado(rolEmpOn.read(mapaRoles.get(rolSelected)));
				empleado.setNombre(empleado.getNombre().toUpperCase());// Mayusculas
				empon.guardar(empleado);
				return "listadoEmpleado?faces-redirect=true&id=" + this.idUser;
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "La Cédula de indentidad es inválida."));
			}
		} catch (Exception e) {
			System.out.println("ERROR Al Actualizar o Guardar empleado");
			e.printStackTrace();
		}
		return null;
	}

	public String guardarRol() {
		this.rolEmpleado.setNombre(this.rolEmpleado.getNombre().toUpperCase());// poner en mayusculas
		this.rolEmpOn.guardar(this.rolEmpleado);
		this.rolEmpleado = new RolEmpleado();// necesario para eliminar los campos
		this.listaRolesEmpleados = null;
		this.listaRolesEmpleados = this.rolEmpOn.listarRoles();// para volver a listar los roles
		return "registrarRol?faces-redirect=true&id=" + this.idUser;
	}

	/*
	 * Metodo de inciar sesion
	 */
	public String login() {
		String direccion = null;
		/*
		 * String departamento1 = "Radio"; String departamento2 = "FibraAdm"; String
		 * departamento3 = "Tecnico Radio"; String departamento4 = "Tecnico Fibra";
		 * String departamento5 = "Contabilidad";
		 */
		try {
			empleado = empon.login(empleado.getEmail(), empleado.getPassword());
			if (empleado != null) {

				String department = empleado.getDepartamento();
				HttpSession session = SessionUtils.getSession();
				switch (department) {
				case "Radio":
					session.setAttribute("username", empleado);
					registro = new Registro();
					instalacion = new Instalacion();
					System.out.println("login exitoso" + " " + empleado.getId() + " " + empleado.getNombre());
					id = empleado.getId();
					System.out.println("Login saliendo datos " + id);
					registro.setIdEmpleadoTemp(id);
					instalacion.setCodigoEmpTemp(id);
					// return "agendamiento?faces-redirect=true&id=" + codigo;
					direccion = "radio";
					break;
				case "Administrador":
					session.setAttribute("username", empleado);

					System.out.println("login exitoso" + " " + empleado.getId() + " " + empleado.getNombre());
					direccion = "viewAdmin?faces-redirect=true&id=" + empleado.getId();
					// direccion="viewAdmin";
					break;
				case "Tecnico Radio":
					direccion = "viewTechRadio";
					break;
				case "Tecnico Fibra":
					direccion = "viewTechFibra";
					break;
				case "Contabilidad":
					direccion = "viewUserContabilidad";
					break;
				case "Secretaria":
					direccion = "callcenter";
					break;
				default:
					break;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
		}

		return direccion;
	}

	public String logout() {

		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "index.xhtml";

	}

	
	public String cargarDatosRegistro(int codigo) {
		try {
			System.out.println("Llegando:::::111");
			cliente.setId(registro.getCliente().getId());
			registro.getCliente().setId(cliente.getId());
			System.out.println("cliente id " + cliente.getId());
		//	empleado.setId(registro.getEmpleado().getId());
		//	registro.getEmpleado().setId(codigo);
			System.out.println("imprime esto:   " + registro.getFechaHora());					
			Cliente cli = clion.getCliente(registro.getCliente().getId());
			Empleado em= empon.getEmpleado(codigo);
			registro.setCliente(cli);
			registro.setEmpleado(em);
			regon.guardar(registro);

//			Visita g = new Visita(cli, registro, empleado);
//			visitaOn.guardar(g);
			System.out.println("Se guardo correcto correctamente");
			init();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		// return "registro?faces-redirect=true";
	}
	
		// return "registro?faces-redirect=true";
	/*
	 * System.out.println(tecnicoElegido);
		System.out.println("************entro**************");
		empleado = empon.getEmpleadobyName(tecnicoElegido);

		System.out.println("************id**************");
		System.out.println(empleado.getId());
		System.out.println("************salio**************");
		System.out.println("Id del cliente" + registro.getCliente().getId());
		Cliente cli = clion.getCliente(registro.getCliente().getId());
		Visita g = new Visita(cli, registro, empleado);
		visitaOn.guardar(g);
		System.out.println("Se guardo correcto correctamente")
	 */
	
	public EmpleadoON getEmpon() {
		return empon;
	}

	public void setEmpon(EmpleadoON empon) {
		this.empon = empon;
	}

	public RegistroON getRegon() {
		return regon;
	}

	public void setRegon(RegistroON regon) {
		this.regon = regon;
	}

	public int devuelvetuwevada() {
		//Empleado em= new Empleado();
		id = empUser.getId();
		System.out.println("amigo"+id);
		return id;	
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

	public void buscarNombre() {
		cliente = clion.getClienteNombre(cliente.getNombre());
		registro.setIdClienteTemp(cliente.getId());
		fechaHora();
		// datoR();
	}
	
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
	
	public problema[] getOficina1() {
		listaSoluOficina = new problema[3];
		listaSoluOficina[0] = new problema("SOLUCIONADO", "1");
		listaSoluOficina[1] = new problema("NODO CAIDO", "2");
		listaSoluOficina[2] = new problema("VISITA TECNICA", "3");

		return listaSoluOficina;
	}

	public solucion[] listaSolucion;

	public solucion[] getSolucion() {
		listaSolucion = new solucion[3];

		listaSolucion[0] = new solucion("SOLUCIONADOF", "1");
		listaSolucion[1] = new solucion("NODO CAIDO", "2");
		listaSolucion[2] = new solucion("VISITA TECNICA", "3");

		return listaSolucion;
	}
	public solucion[] getAccion() {
		listaSolucion = new solucion[4];
		listaSolucion[0] = new solucion("VISITA TECNICA", "1");
		listaSolucion[1] = new solucion("NODO CAIDO", "2");
		listaSolucion[2] = new solucion("PROBLEMA ENLACE", "3");
		listaSolucion[3] = new solucion("SOLUCIONADOF", "4");

		return listaSolucion;
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


	
	public CallcenterBean() {
		// TODO Auto-generated constructor stub
	}

}
