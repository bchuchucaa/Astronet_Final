
package astronet.ec.dao;
import java.util.List;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Equipo;
import astronet.ec.modelo.Plan;
import astronet.ec.modelo.Telefono;

@Stateless
public class EquipoDAO {

	@Inject
	private EntityManager em;

	public void save(Equipo equipo) {
		if (this.read(equipo.getId())!=null) {
			this.update(equipo);
		}else
			this.create(equipo);

	}

	public void update(Equipo equipo) {
		//System.out.println("registro "+cli.getRegistro().get(0).toString());
		em.merge(equipo);

	}

	public void delete(int id) {
		Equipo equ = read(id);
		em.remove(equ);
	}

	public Equipo read(int id) {
		return em.find(Equipo.class, id);
	}

	public void create(Equipo equipo) {
		em.persist(equipo);

	}
	public List<Equipo> find(){
		String tipoEquipo = "Antena";
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Equipo> criteriaQuery = criteriaBuilder.createQuery(Equipo.class);
		// Se establece la clausula FROM
		Root<Equipo> root = criteriaQuery.from(Equipo.class);

		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("tipoEquipo"), tipoEquipo)); // criteriaQuery.multiselect(root.get(atr))
		return em.createQuery(criteriaQuery).getResultList();
	}

	public Equipo getAntenaByName(String name) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Equipo> criteriaQuery = criteriaBuilder.createQuery(Equipo.class);
		// Se establece la clausula FROM
		Root<Equipo> root = criteriaQuery.from(Equipo.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("modelo"), name)); // criteriaQuery.multiselect(root.get(atr))
		// // Se configuran los predicados,
		// combinados por AND
		System.out.println("************8");

		return em.createQuery(criteriaQuery).getSingleResult();

	}

	public List<Equipo> findEquiposFibra(){
		String tipoEquipo = "RouterFibra";
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Equipo> criteriaQuery = criteriaBuilder.createQuery(Equipo.class);
		// Se establece la clausula FROM
		Root<Equipo> root = criteriaQuery.from(Equipo.class);

		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("tipoEquipo"), tipoEquipo)); // criteriaQuery.multiselect(root.get(atr))
		return em.createQuery(criteriaQuery).getResultList();
	}

}
