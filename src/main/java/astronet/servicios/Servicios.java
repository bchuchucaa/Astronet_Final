package astronet.servicios;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import astronet.ec.modelo.Agendamiento;

import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Empleado;
import astronet.ec.modelo.Instalacion;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Servicio;
import astronet.ec.on.AgendamientoON;
import astronet.ec.on.ClienteON;
import astronet.ec.on.EmpleadoON;
import astronet.ec.on.InstalacionON;
import astronet.ec.on.RegistroON;
import astronet.ec.on.ServicioON;

@Path("/astronet")
public class Servicios {
	
	@Inject
	private EmpleadoON empon;
	
	@Inject
	private InstalacionON inson;
	
	@Inject
	private AgendamientoON agon;
	
	@Inject
	private RegistroON regon;
	
	@Inject
	private ServicioON seron;
	
	@Inject
	private ClienteON clion;
	


	Registro registro;
	/**
	 * Metodo del login
	 * @param un
	 * @param pass
	 * @return
	 */
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public Empleado login(Empleado empleado) {
		Empleado u = new Empleado();
		try {
			empleado = empon.login(empleado.getEmail(), empleado.getPassword());
			u.setId(empleado.getId());
			System.out.println("fun ");
			u.setEmail(empleado.getEmail());
			u.setPassword(empleado.getPassword());
			u.setNombre(empleado.getNombre());
			u.setDepartamento(empleado.getDepartamento());
			u.setCelular(empleado.getCelular());
			
		} catch (Exception e) {
			u.setEmail(e.getMessage());
		}
		return u;
	}
	
	
	/**
	 * Metodo para ver el listado de todas las instalaciones
	 * @return
	 */
	@GET
	@Path("listInst")
	@Produces("application/json")
	
	public List<Instalacion> listarInstalacion(){
		return inson.getListadoInstalacion();
	}
	
	/**
	 *Metodo para listar todas las visitas tecnicas 
	 * @return
	 */
	@GET
	@Path("listRgVT")
	@Produces("application/json")
	public List<Registro> listarRgVT(){
		return regon.listadoRegistrosVT();
	}
	
		
	@GET
	@Path("listAG")
	@Produces("application/json")
	public List<Agendamiento> listarAgendamiento(@QueryParam("nombre") String nombre){
		return  agon.getAgendamiento(nombre);
	}
	
	@GET
	@Path("listIns")
	@Produces("application/json")
	public List<Instalacion> listarInstalacion(@QueryParam("nombre") String nombre){
		return inson.getInstalacion(nombre);
	}
	/**
	 * @GET
	@Path("/listarAn")
	@Produces("application/json")
	public List<Antena> getAntena(){
			return anton.getListadoAntena();
		}
	 * @return
	 */
	
	
	@GET
	@Path("/buscarIdVis")
	@Produces("application/json")
	public Registro getBuscarVis(@QueryParam("id") int id){
		//registro=regon.getListadoClienteId(id);
			System.out.println("id"+id);
			return regon.getListadoClienteId(id);
		}
	

	@GET
	@Path("/buscarInsId")
	@Produces("application/json")
	public Instalacion getBuscarInsId(@QueryParam("id") int id){
			return inson.getListadoInstalacionId(id);
		}
	
	/**
	 * 
	 * @param cliente
	 * @return
	 
	@PUT
	@Path("/actualizar")
	@Produces("application/json")
	@Consumes("application/json")
	public  Response update(Cliente cliente) {
			
			Response.ResponseBuilder builder = null;
			Map<String, String> data = new HashMap<>();
			Servicio ser=new Servicio();
			Registro reg=new Registro();
			reg.setCliente(cliente);
			
			

			
			try {
							
				ser.setId(cliente.getServicio().get(0).getId());
				ser.setNumeroContrato(cliente.getServicio().get(0).getNumeroContrato());
				ser.setFechaContrato(cliente.getServicio().get(0).getFechaContrato());
				ser.setPlan(cliente.getServicio().get(0).getPlan());
				ser.setIp(cliente.getServicio().get(0).getIp());
				ser.setPassword(cliente.getServicio().get(0).getPassword());
				ser.setObservaciones(cliente.getServicio().get(0).getObservaciones());
				
				
				ser.setId(ser.getId());
				ser.setNumeroContrato(ser.getNumeroContrato());
				ser.setFechaContrato(ser.getFechaContrato());
				ser.setPlan(ser.getPlan());
				ser.setIp(ser.getIp());
				ser.setPassword(ser.getPassword());
				ser.setObservaciones(ser.getObservaciones());
				System.out.println("hola funciona "+cliente.getId() +" hola 2 "+cliente);
				//ser.getCliente().setId(cliente.getId());
				
				
				seron.actualizar(ser);
				//regon.actualizar(reg);
					clion.actualizar(cliente);
					//regon.actualizar(reg);
			
				System.out.println(cliente.getNombre());
				data.put("Mensaje: ", "Dato actualizado");
				builder = Response.status(Response.Status.OK).entity(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				data.put("Mensaje: ", e.getMessage());
				builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
			}
			
			return builder.build();
			
			
		}
	
	
	
	@POST 
	@Path("/create")
	@Produces("application/json")
	@Consumes("application/json")
	public  Response insertPersona(Cliente docente) {
			System.out.println(docente.toString()+ "AQUI LLEGO lgo ");
			Response.ResponseBuilder builder = null;
			Map<String, String> data = new HashMap<>();
			
			
			
			try {
				
				Calendar fecha = new GregorianCalendar();
				int anio = fecha.get(Calendar.YEAR);
		        int mes = fecha.get(Calendar.MONTH);
		        int dia = fecha.get(Calendar.DAY_OF_MONTH);
		        String fechaA =dia + "/" + (mes+1) + "/" + anio;
		     
		       System.out.println("id "+docente.getId());        
				docente.getServicio().get(0).setFechaContrato(fechaA);
								
					clion.guardarCliente(docente);
					data.put("codigo", "100");
					data.put("Mensaje: ", "Cliente ingresado");
					builder = Response.status(Response.Status.OK).entity(data);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				data.put("codigo", "50");
				data.put("Mensaje: ", e.getMessage());
				builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
			}
			
			return builder.build();
			
			
		}
	
	
	
	@PUT
	@Path("/actualizarVisita")
	@Produces("application/json")
	@Consumes("application/json")
	public  Response updateReg(Agendamiento agendamiento) {
			
			Response.ResponseBuilder builder = null;
			Map<String, String> data = new HashMap<>();
						
						
			try {
						
				agon.actualizar(agendamiento);
				System.out.println(agendamiento.isRealizado());
				data.put("Mensaje: ", "Dato actualizado");
				builder = Response.status(Response.Status.OK).entity(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				data.put("Mensaje: ", e.getMessage());
				builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
			}
			
			return builder.build();
			
			
		}
		*/
	
	@PUT
	@Path("/actualizarInstalacion")
	@Produces("application/json")
	@Consumes("application/json")
	public  Response updateIns(Instalacion ins) {
			
			Response.ResponseBuilder builder = null;
			Map<String, String> data = new HashMap<>();
						
				Empleado empleado= new Empleado();		
			try {
				
				empleado.setId(ins.getEmpleado().getId());	
				empleado.setCedula(ins.getEmpleado().getCedula());
				empleado.setNombre(ins.getEmpleado().getNombre());
				empleado.setCelular(ins.getEmpleado().getCelular());
				empleado.setEmail(ins.getEmpleado().getEmail());
				empleado.setPassword(ins.getEmpleado().getPassword());
				empleado.setDepartamento(ins.getEmpleado().getDepartamento());
				System.out.println("empleado id "+empleado.getId());
				ins.getEmpleado().setId(empleado.getId());
				//empon.actualizar(empleado);
				inson.actualizar(ins);
				System.out.println(ins.isRealizado());
				data.put("Mensaje: ", "Dato actualizado");
				builder = Response.status(Response.Status.OK).entity(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				data.put("Mensaje: ", e.getMessage());
				builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
			}
			
			return builder.build();
			
			
		}


}
