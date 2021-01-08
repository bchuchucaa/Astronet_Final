package astronet.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import astronet.ec.modelo.Empleado;

import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Servicio;


@Stateless
public class EmpleadoDAO {

	@Inject
	private EntityManager em;

	public void save(Empleado emp) {
		if (this.read(emp.getId()) != null) {
			this.update(emp);
		} else
			this.create(emp);
	}

	public void create(Empleado emp) {
		em.persist(emp);		

	}

	public Empleado read(int id) {
		return em.find(Empleado.class, id);
	}

	public void update(Empleado emp) {
		try {
			em.merge(emp);
		} catch (Exception e) {
			System.out.println("ERROR: EN ACTUALIZACION");
			e.printStackTrace();
		}		
	}

	public void deleteEmpleado(Empleado empleado) {
		em.remove(empleado);		
	}

	public void deleteEmpleadoByID(int id) {
		Empleado em = this.read(id);
		if (em != null)
			this.deleteEmpleado(em);
	}

	public Empleado read3(int id) {
		String jpql = "SELECT emp FROM Empleado emp   WHERE emp.id = :a";
		Query q = em.createQuery(jpql, Empleado.class);
		q.setParameter("a", id);
		Empleado emp = (Empleado) q.getSingleResult();
		System.out.println("Se llamo a este read3");
		return emp;

	}

	public Empleado login(String email, String password) {
		System.out.println(email);
		String jpql = "SELECT emp FROM Empleado emp WHERE emp.email LIKE?1 AND emp.password LIKE?2";
		Query q = em.createQuery(jpql, Empleado.class);
		q.setParameter(1, email);
		q.setParameter(2, password);
		Empleado empl = (Empleado) q.getSingleResult();

		return empl;
	}

	public List<Empleado> getEmpleado() {
		String jpql = "SELECT empleado FROM Empleado empleado ";
		Query q = em.createQuery(jpql, Empleado.class);
		List<Empleado> empleados = q.getResultList();

		return empleados;
	}

	public List<Empleado> tecnicoDepartamento() {
		String jpql = "SELECT em FROM Empleado em";
		Query q = em.createQuery(jpql, Empleado.class);
		List<Empleado> empleado = q.getResultList();
		for (Empleado empleado2 : empleado) {
			empleado2.getId();
			empleado2.getNombre();
		}

		return empleado;
	}
	public List<Empleado> listarEmpleado() {
		String estado="TECNICO";
		String jpql = "SELECT em FROM Empleado em WHERE em.departamento = :a";
		Query q = em.createQuery(jpql, Empleado.class);
		q.setParameter("a", estado);
		List<Empleado> tecnicos = q.getResultList();
		return tecnicos;
	}
	
	public Empleado buscarByName(String name) {
		String jpql = "SELECT emp FROM Empleado emp   WHERE emp.nombre = :a";
		Query q = em.createQuery(jpql, Empleado.class);
		q.setParameter("a", name);
		Empleado emp = (Empleado) q.getSingleResult();
		System.out.println("Se llamo a buscar x nombre");
		return emp;

	}
}
