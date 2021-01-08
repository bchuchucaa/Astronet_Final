package astronet.ec.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Instalacion.class)
public abstract class Instalacion_ {

	public static volatile SingularAttribute<Instalacion, String> tipoServicio;
	public static volatile SingularAttribute<Instalacion, Boolean> realizado;
	public static volatile SingularAttribute<Instalacion, Empleado> empleado;
	public static volatile SingularAttribute<Instalacion, String> direccion;
	public static volatile SingularAttribute<Instalacion, String> observaciones;
	public static volatile SingularAttribute<Instalacion, Integer> id;
	public static volatile SingularAttribute<Instalacion, String> tecnico;
	public static volatile SingularAttribute<Instalacion, String> telefono;
	public static volatile SingularAttribute<Instalacion, String> coordenadas;
	public static volatile SingularAttribute<Instalacion, String> nombre;

}

