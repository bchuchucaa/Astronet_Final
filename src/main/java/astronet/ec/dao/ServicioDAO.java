package astronet.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Servicio;

@Stateless
public class ServicioDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(Servicio ser) {
		if (this.read(ser.getId()) != null) 
			
			this.update(ser);
		else 
			System.out.println("hola datos "+ser);
			this.create(ser);
		
	}
	
	public void create(Servicio ser) {
		em.persist(ser);
		
	}
	
	public Servicio read(int id) {
		return em.find(Servicio.class, id);
	}
	
	public void update(Servicio ser) {
		em.merge(ser);
	}
	
	public void delete(int id) {
		Servicio ser = read(id);
		em.remove(ser);
	}

	public List<Servicio> getServicios(Cliente cliente) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Servicio> criteriaQuery = criteriaBuilder.createQuery(Servicio.class);
		// Se establece la clausula FROM
		Root<Servicio> root = criteriaQuery.from(Servicio.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("cliente"), cliente)); // criteriaQuery.multiselect(root.get(atr))
		// // Se configuran los predicados,
		// combinados por AND
		System.out.println("************8");
		
		return em.createQuery(criteriaQuery).getResultList();
		
	}

}
