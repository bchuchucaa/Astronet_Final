package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.VisitaDAO;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Visita;

@Stateless

public class VisitaON {
	
	@Inject
	private VisitaDAO VisitaDao;
	
	private List<Visita> listadoVisita;
	
	public void guardar(Visita Visita) {

		VisitaDao.save(Visita);
		
	}
	
	public Visita consultarVIsita(int codigoVisita) throws Exception {
	
	
	Visita vis= VisitaDao.read(codigoVisita);
	if(vis==null)
		throw new Exception("VIsita no existe");
	
	return vis;
}
	 
	
	
	
	
	public void guardarVisita(Visita Visita) {
		VisitaDao.create(Visita);
	}
	
	public void actualizar (Visita Visita) {
		VisitaDao.update(Visita);
	}
	

	public List<Visita> getListadoVisita() {
		return VisitaDao.find();
	}

	public void setListadoVisita(List<Visita> listadoVisita) {
		this.listadoVisita = VisitaDao.find();
	}

	public List<Visita> listaVerificada(){
		return VisitaDao.listarVisitas();
	}
	
}
