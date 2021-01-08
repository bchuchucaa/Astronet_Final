package astronet.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import astronet.ec.modelo.Agendamiento;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Servicio;

@Stateless
public class RegistroDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(Registro reg) {
		if (this.read(reg.getId())!=null) {
			this.update(reg);
		}else 
			this.create(reg);
	}
	
	public void create(Registro reg) {
		em.persist(reg);
		
	}
	
	public void update(Registro reg) {
		em.merge(reg);
		
	}
	
	public Registro read(int id) {
		return em.find(Registro.class, id);
		
	}
	

	public Registro read3(int id) {
		String jpql = "SELECT reg FROM Registro reg   WHERE reg.id = :a";
		Query q = em.createQuery(jpql, Registro.class);
		q.setParameter("a", id);
		Registro reg = (Registro) q.getSingleResult();
		return reg;
	}
	
	public List<Registro> listarRegistrosVT() {
		
		String estado="VISITA TECNICA";
		String jpql = "SELECT reg FROM Registro reg WHERE reg.accion = :a";
		Query q = em.createQuery(jpql, Registro.class);
		q.setParameter("a", estado);
		List<Registro> registros = q.getResultList();
		return registros;
	}
	
	public Registro getBusquedaClienteId(int filBusqueda){
		String jpql="SELECT r FROM Registro r   "
				    +" WHERE r.id = :filtro ";
		Query q=em.createQuery(jpql, Registro.class);
		q.setParameter("filtro", filBusqueda);
			
		Registro clientes=(Registro) q.getSingleResult();

		System.out.println(clientes);
		return clientes;
	}
	
	public List<Registro> listarRegistros() {
		String jpql = "SELECT reg FROM Registro reg ORDER BY\n"
				+ "        reg_id";
		Query q = em.createQuery(jpql, Registro.class);
		List<Registro> registros = q.getResultList();
		return registros;
	}
	

	
}
	