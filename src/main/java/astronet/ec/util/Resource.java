package astronet.ec.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resource {
	
	@Produces
	@PersistenceContext
	private EntityManager em;
	
	
	@Produces
	@RequestScoped
	public FacesContext prodiceFC() {
		return FacesContext.getCurrentInstance();
	}

	
}