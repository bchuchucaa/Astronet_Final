package astronet.ec.vista;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import astronet.ec.modelo.Empleado;
import astronet.ec.on.EmpleadoON;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private Empleado empleadoUser;//EmpleadoUsuario	
	private int idUser;
	
	//@ManagedProperty(value ="#{login}" )//"#{login}" <- 
	//private EmpleadoController empCon;
	@Inject
	private EmpleadoON empon;
	//@PostConstruct
	public void init() {
		System.out.println("Parametro Usuario: "+this.idUser);		
		this.empleadoUser=empon.read(this.idUser);
	}
	
	
//	ZONA GET/SET	
	public Empleado getEmpleadoUser() {
		return empleadoUser;
	}
	public void setEmpleadoUser(Empleado empleadoUser) {
		this.empleadoUser = empleadoUser;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}	

	
	
//	FIN ZONA GET/SET

//	ZONA METODOS	
	
//	FIN ZONA METODOS
	
}
