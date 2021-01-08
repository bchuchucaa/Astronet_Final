package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.PlanDAO;
import astronet.ec.modelo.Equipo;
import astronet.ec.modelo.Plan;

@Stateless

public class PlanON {
	
	@Inject
	private PlanDAO PlanDao;
	
	private List<Plan> listadoPlan;
	
	public void guardar(Plan Plan) {

		PlanDao.save(Plan);
		
	}
	
	public Plan buscarPlan(int id) {
		return PlanDao.read(id);
	}
	
	public void guardarPlan(Plan Plan) {
		PlanDao.create(Plan);
	}
	
	public void actualizar (Plan Plan) {
		PlanDao.update(Plan);
	}
	

	public List<Plan> getListadoPlan() {
		return PlanDao.find();
	}

	public void setListadoPlan(List<Plan> listadoPlan) {
		this.listadoPlan = PlanDao.find();
	}
	
	public Plan getPlanByName(String name) {
		return PlanDao.getPlanByName(name);
	}
}
