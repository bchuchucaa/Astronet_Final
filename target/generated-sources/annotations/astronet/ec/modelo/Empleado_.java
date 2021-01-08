package astronet.ec.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empleado.class)
public abstract class Empleado_ {

	public static volatile SingularAttribute<Empleado, String> password;
	public static volatile SingularAttribute<Empleado, String> cedula;
	public static volatile SingularAttribute<Empleado, String> celular;
	public static volatile SingularAttribute<Empleado, String> departamento;
	public static volatile ListAttribute<Empleado, Instalacion> instalacion;
	public static volatile SingularAttribute<Empleado, Integer> id;
	public static volatile SingularAttribute<Empleado, String> nombre;
	public static volatile SingularAttribute<Empleado, String> email;
	public static volatile ListAttribute<Empleado, Registro> registro;

}

