package astronet.ec.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Antena.class)
public abstract class Antena_ {

	public static volatile ListAttribute<Antena, Cliente> cliente;
	public static volatile SingularAttribute<Antena, String> serie;
	public static volatile SingularAttribute<Antena, Integer> id;
	public static volatile SingularAttribute<Antena, String> modelo;

}

