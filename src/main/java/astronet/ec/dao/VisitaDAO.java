package astronet.ec.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import astronet.ec.modelo.Visita;

public class VisitaDAO {
	@Inject
	private EntityManager em;
	
	public void save(Visita Visita) {
		if (this.read(Visita.getId())!=null) {
			this.update(Visita);
		}else 
			this.create(Visita);
		
	}
	
	public void update(Visita Visita) {
		//System.out.println("registro "+cli.getRegistro().get(0).toString());
		em.merge(Visita);
		
	}

	public void delete(int id) {
		Visita equ = read(id);
		em.remove(equ);
	}
	
	public Visita read(int id) {
		return em.find(Visita.class, id);
	}
	
	public void create(Visita Visita) {
		em.persist(Visita);
		
	}
	
	public List<Visita> find(){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Visita> criteriaQuery = criteriaBuilder.createQuery(Visita.class);
		// Se establece la clausula FROM
		criteriaQuery.select(criteriaQuery.from(Visita.class));
		System.out.println("Sech");
		return em.createQuery(criteriaQuery).getResultList();
		
	}
}
