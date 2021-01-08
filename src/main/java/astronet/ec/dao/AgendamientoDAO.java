package astronet.ec.dao;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import astronet.ec.modelo.Agendamiento;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Equipo;
import astronet.ec.modelo.Registro;

@Stateless
public class AgendamientoDAO {

	@Inject
	private EntityManager em;


	public void save(Agendamiento ag) {
		if (this.read(ag.getId()) != null) {
			this.update(ag);
		} else

			this.create(ag);
	}

	public void create(Agendamiento ag) {
		em.persist(ag);
	}

	public Agendamiento read(int id) {
		return em.find(Agendamiento.class, id);
	}

	public void update(Agendamiento ag) {
		em.merge(ag);
	}

	public List<Agendamiento> getActividades(String nombre) {
		String jpql = "SELECT ag FROM Agendamiento ag";
		Query q = em.createQuery(jpql, Agendamiento.class);
		q.setParameter("busqueda", nombre);
		List<Agendamiento> agendamientos = q.getResultList();
		return agendamientos;
	}

	public List<Agendamiento> getAgendamiento() {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Agendamiento> criteriaQuery = criteriaBuilder.createQuery(Agendamiento.class);
		// Se establece la clausula FROM
		criteriaQuery.select(criteriaQuery.from(Agendamiento.class));
		System.out.println("Sech");
		return em.createQuery(criteriaQuery).getResultList();
	}

	
	public List<Registro> getAgendamientoSol() {
		String estado="SOLUCIONADOF";
		String jpql = "SELECT reg FROM Registro reg WHERE reg.accion != :a";
		Query q = em.createQuery(jpql, Registro.class);
		q.setParameter("a", estado);
		List<Registro> registros = q.getResultList();
		return registros;
	}

		
}