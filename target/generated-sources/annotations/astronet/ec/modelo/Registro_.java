package astronet.ec.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Registro.class)
public abstract class Registro_ {

	public static volatile SingularAttribute<Registro, String> accion;
	public static volatile SingularAttribute<Registro, Cliente> cliente;
	public static volatile ListAttribute<Registro, Agendamiento> agendamiento;
	public static volatile SingularAttribute<Registro, Boolean> realizado;
	public static volatile SingularAttribute<Registro, Empleado> empleado;
	public static volatile SingularAttribute<Registro, String> fechaHora;
	public static volatile SingularAttribute<Registro, String> observaciones;
	public static volatile SingularAttribute<Registro, String> problema;
	public static volatile SingularAttribute<Registro, Integer> id;

}

