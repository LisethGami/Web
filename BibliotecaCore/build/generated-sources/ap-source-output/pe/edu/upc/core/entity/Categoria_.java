package pe.edu.upc.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.upc.core.entity.Libro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-01T14:17:10")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, Integer> idCategoria;
    public static volatile CollectionAttribute<Categoria, Libro> libroCollection;
    public static volatile SingularAttribute<Categoria, String> nombreCategoria;

}