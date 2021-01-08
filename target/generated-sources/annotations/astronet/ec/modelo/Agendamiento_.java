package astronet.ec.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Agendamiento.class)
public abstract class Agendamiento_ {

	public static volatile SingularAttribute<Agendamiento, String> fecha;
	public static volatile SingularAttribute<Agendamiento, String> tecnicoAsigna;
	public static volatile SingularAttribute<Agendamiento, String> tecnicoResponsable;
	public static volatile SingularAttribute<Agendamiento, String> observaciones;
	public static volatile SingularAttribute<Agendamiento, Integer> id;
	public static volatile SingularAttribute<Agendamiento, Registro> registro;

}

