package astronet.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import astronet.ec.modelo.RolEmpleado;



@Stateless
public class RolDAO {
	
	@Inject
	private EntityManager rol;
		
	public void save(RolEmpleado rol) {
		if (this.read(rol.getId()) != null) {
			this.update(rol);
		} else
			this.create(rol);
	}

	public void create(RolEmpleado rol) {
		this.rol.persist(rol);

	}

	public RolEmpleado read(int id) {
		return this.rol.find(RolEmpleado.class, id);
	}

	public void update(RolEmpleado rol) {
		try {
			this.rol.merge(rol);
		} catch (Exception e) {
			System.out.println("ERROR: ELIMINAR RolEmpleado");
			e.printStackTrace();
		}		
	}

	public void deleteRolEmpleado(RolEmpleado RolEmpleado) {
		this.rol.remove(RolEmpleado);		
	}
	
	
	public List<RolEmpleado> listarRoles() {
		String jpql = "SELECT roles_empleado FROM RolEmpleado roles_empleado ";
		Query q = this.rol.createQuery(jpql, RolEmpleado.class);
		List<RolEmpleado> rolesEmpleados = q.getResultList();

		return rolesEmpleados;
	}
	
	

}
