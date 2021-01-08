package astronet.ec.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, String> latitud;
	public static volatile ListAttribute<Cliente, Servicio> servicio;
	public static volatile SingularAttribute<Cliente, String> cedula;
	public static volatile SingularAttribute<Cliente, String> convencional;
	public static volatile SingularAttribute<Cliente, String> nombre;
	public static volatile SingularAttribute<Cliente, String> direccionSecundaria;
	public static volatile ListAttribute<Cliente, Registro> registro;
	public static volatile SingularAttribute<Cliente, String> longitud;
	public static volatile SingularAttribute<Cliente, String> celular;
	public static volatile SingularAttribute<Cliente, String> direccionPrincipal;
	public static volatile SingularAttribute<Cliente, Integer> id;
	public static volatile SingularAttribute<Cliente, Antena> antena;
	public static volatile SingularAttribute<Cliente, String> email;
	public static volatile SingularAttribute<Cliente, String> direccionReferencia;

}

