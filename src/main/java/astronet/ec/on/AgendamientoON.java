package astronet.ec.on;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import astronet.ec.dao.AgendamientoDAO;
import astronet.ec.modelo.Agendamiento;
import astronet.ec.modelo.Registro;
@Stateless
public class AgendamientoON {
	
	
	@Inject
	private AgendamientoDAO agdao;
	
	
	public void guardar(Agendamiento ag) {
		agdao.save(ag);
	}

	public List<Agendamiento> getAgendamiento(String nombre) {
			return agdao.getActividades(nombre);
	}
	
	public void actualizar(Agendamiento ag) {
		agdao.update(ag);
	}
	

	public List<Agendamiento> getAgenda() {
		List<Agendamiento> aux = agdao.getAgendamiento();
		return aux;
	}
	public List<Registro>listadoRegistroSolF(){
		return agdao.getAgendamientoSol();
	}
	
}