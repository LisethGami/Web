package pe.edu.upc.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.upc.core.entity.Libro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-01T14:17:10")
@StaticMetamodel(Autor.class)
public class Autor_ { 

    public static volatile SingularAttribute<Autor, Integer> idAutor;
    public static volatile SingularAttribute<Autor, String> apellido;
    public static volatile SingularAttribute<Autor, String> nombre;
    public static volatile CollectionAttribute<Autor, Libro> libroCollection;

}