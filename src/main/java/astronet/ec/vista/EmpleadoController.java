package astronet.ec.vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Instalacion;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.RolEmpleado;
import astronet.ec.on.EmpleadoON;
import astronet.ec.on.RolEmpleadoON;
import astronet.ec.util.SessionUtils;

@ManagedBean(name = "empleadoControllerBean")
@ViewScoped
public class EmpleadoController {

	@Inject
	private EmpleadoON empon;
	private String nombre;
	private int id;
	private int idUser;

	private Empleado empleado;
	private Empleado empUser;	
	private Instalacion instalacion;
	private Registro registro;
	private List<Empleado> empleados;
	private List<String> departamentosList = new ArrayList<String>();
	@Inject
	private RolEmpleadoON rolEmpOn;
	private RolEmpleado rolEmpleado;
	private Map<String, Integer> mapaRoles;
	private List<RolEmpleado> listaRolesEmpleados;
	private String rolSelected;

	// @PostConstruct //importante que esto este comentado caso contrario genera
	// errores
	public void init() {

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

	// ZONA GET/SET
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
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
				empleado.setNombre(empleado.getNombre().toUpperCase());//Mayusculas
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
		this.rolEmpleado.setNombre(this.rolEmpleado.getNombre().toUpperCase());//poner en mayusculas
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

}