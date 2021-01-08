package astronet.ec.vista;



import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import astronet.ec.modelo.Cliente;
import astronet.ec.on.ClienteON;

@ManagedBean
@SessionScoped
public class BeanListCliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	
	private List<Cliente> listadoclientes;
	private List<Cliente> listaFiltrada;
	

	   
	   public BeanListCliente() {
		super();
	}
	   
		public String getName() {
		      return name;
		   }
		   
		   public void setName(String name) {
		      this.name = name;
		   }

		   public String getWelcomeMessage() {
		      return "Hello " + name;
		   }

		public List<Cliente> getListadoclientes() {
			return listadoclientes;
		}

		public void setListadoclientes(List<Cliente> listadoclientes) {
			this.listadoclientes = listadoclientes;
		}

		public List<Cliente> getListaFiltrada() {
			return listaFiltrada;
		}

		public void setListaFiltrada(List<Cliente> listaFiltrada) {
			this.listaFiltrada = listaFiltrada;
		}
		

	   
	   @Inject
		private ClienteON clion;
	   
	   @PostConstruct
	   public void init() {
		   listadoclientes = clion.getListadoCliente();
		   
		   name="del puctas madre si o si ";
	   }




}
