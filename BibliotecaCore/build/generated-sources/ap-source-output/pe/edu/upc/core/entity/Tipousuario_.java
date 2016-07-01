package pe.edu.upc.core.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.upc.core.entity.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-01T14:17:10")
@StaticMetamodel(Tipousuario.class)
public class Tipousuario_ { 

    public static volatile SingularAttribute<Tipousuario, Integer> idTipoUsuario;
    public static volatile SingularAttribute<Tipousuario, String> nombreTUsuario;
    public static volatile CollectionAttribute<Tipousuario, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Tipousuario, String> observacion;

}