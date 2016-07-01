package pe.edu.upc.core.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.upc.core.entity.Autor;
import pe.edu.upc.core.entity.Categoria;
import pe.edu.upc.core.entity.Editorial;
import pe.edu.upc.core.entity.Reserva;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-01T14:17:10")
@StaticMetamodel(Libro.class)
public class Libro_ { 

    public static volatile SingularAttribute<Libro, Autor> aUTORidAutor;
    public static volatile SingularAttribute<Libro, Editorial> eDITORIALidEditorial;
    public static volatile SingularAttribute<Libro, Integer> idLibro;
    public static volatile SingularAttribute<Libro, Categoria> cATEGORIAidCategoria;
    public static volatile SingularAttribute<Libro, Integer> volumen;
    public static volatile SingularAttribute<Libro, String> textImgLibro;
    public static volatile SingularAttribute<Libro, String> nombreLibro;
    public static volatile CollectionAttribute<Libro, Reserva> reservaCollection;
    public static volatile SingularAttribute<Libro, Date> fechaPublicacion;
    public static volatile SingularAttribute<Libro, Integer> nroEjemplares;

}