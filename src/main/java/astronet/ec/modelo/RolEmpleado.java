package astronet.ec.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RolEmpleado")
public class RolEmpleado implements Serializable {

	private static final long serialVersionUID = 1L;
	
//	@GeneratedValue(generator = "secuenciaRol")
//	@SequenceGenerator(name = "secuenciaRol", initialValue = 6)
	
	@Id
	@Column(name = "rol_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int id;
	
	@Column(name = "rol_nombre")	
	private String nombre;
	
	@Column(name = "rol_descripcion")
	private String descripcion;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Empleado> listEmpleados;
		
//	ZONA GET /SET
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Empleado> getListEmpleados() {
		return listEmpleados;
	}
	public void setListEmpleados(List<Empleado> listEmpleados) {
		this.listEmpleados = listEmpleados;
	}
	@Override
	public int hashCode() {		
		return Objects.hash(this.id);
	}	
		
	
//	FIN ZONA GET /SET
	
	
}
