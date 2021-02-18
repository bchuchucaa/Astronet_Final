package astronet.ec.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import astronet.ec.dao.EquipoDAO;
import astronet.ec.dao.VisitaDAO;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Equipo;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Telefono;
import astronet.ec.modelo.Visita;
import astronet.ec.on.ClienteON;
import astronet.ec.on.EmpleadoON;
import astronet.ec.on.EquipoOn;
import astronet.ec.on.RegistroON;
import astronet.ec.on.TelefonoON;
import astronet.ec.on.VisitaON;

@ManagedBean
@ViewScoped

public class VisitaController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@Inject
	private VisitaON vison;
	@Inject
	private EmpleadoON empon;
	@Inject
	private ClienteON clion;

	@Inject
	private RegistroON regon;
	@Inject
	private VisitaON visitaOn;
	@Inject
	private TelefonoON telOn;

	private String antenaElegida;
	private Cliente cliente;
	private List<Visita> listadoVisitas;
	private List<Visita> listadoVerificado;

	private Empleado empleado = new Empleado();
	private List<Empleado> tecnicos;
	private String tecnicoElegido;
	private Registro registro = new Registro();
	private List<Empleado> empleados;

	@PostConstruct
	public void init() {
	listadoVisitas= vison.getListadoVisita();
	empleados = empon.getListadoEmpleado();
	tecnicos = empon.getListadoTecnico();
	listadoVerificado= vison.listaVerificada();
	}


	
	public List<Visita> getListadoVerificado() {
		return listadoVerificado;
	}



	public void setListadoVerificado(List<Visita> listadoVerificado) {
		this.listadoVerificado = listadoVerificado;
	}



	public TelefonoON getTelOn() {
		return telOn;
	}



	public void setTelOn(TelefonoON telOn) {
		this.telOn = telOn;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public VisitaON getVison() {
		return vison;
	}



	public void setVison(VisitaON vison) {
		this.vison = vison;
	}



	public EmpleadoON getEmpon() {
		return empon;
	}



	public void setEmpon(EmpleadoON empon) {
		this.empon = empon;
	}



	public ClienteON getClion() {
		return clion;
	}



	public void setClion(ClienteON clion) {
		this.clion = clion;
	}



	public RegistroON getRegon() {
		return regon;
	}



	public void setRegon(RegistroON regon) {
		this.regon = regon;
	}



	public VisitaON getVisitaOn() {
		return visitaOn;
	}



	public void setVisitaOn(VisitaON visitaOn) {
		this.visitaOn = visitaOn;
	}



	public String getAntenaElegida() {
		return antenaElegida;
	}



	public void setAntenaElegida(String antenaElegida) {
		this.antenaElegida = antenaElegida;
	}



	public Empleado getEmpleado() {
		return empleado;
	}



	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
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



	public Registro getRegistro() {
		return registro;
	}



	public void setRegistro(Registro registro) {
		this.registro = registro;
	}



	public List<Empleado> getEmpleados() {
		return empleados;
	}



	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public List<Visita> getListadoVisitas() {
		return listadoVisitas;
	}


	public void setListadoVisitas(List<Visita> listadoVisitas) {
		this.listadoVisitas = listadoVisitas;
	}
	public String cambio(int codiguito, int registrito, int clientito) {
		empleado = empon.getEmpleadobyName(tecnicoElegido);
		Cliente cli= clion.getCliente(clientito);
		Registro reg= regon.getRegistro(registrito);
		Visita g= new Visita();	
		g.setId(codiguito);
		g.setCliente(cli);
		g.setEmpleado(empleado);
		g.setRegistro(reg);
	 	visitaOn.actualizar(g);
		System.out.println("adrian"+registrito);
		System.out.println("wilo maricon"+ codiguito);
		System.out.println("cabron"+clientito);
		return null;
	}

	public List<Telefono> listaTel(int clientito){
		Cliente cli =clion.getCliente(clientito);	
		List<Telefono> telefono= telOn.getTelefonos(cli);
		System.out.println("wilson gay"+ clientito);
		return telefono;
	} 
}