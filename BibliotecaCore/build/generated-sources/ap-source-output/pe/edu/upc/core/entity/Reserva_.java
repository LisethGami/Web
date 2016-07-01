package pe.edu.upc.core.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.upc.core.entity.Libro;
import pe.edu.upc.core.entity.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-01T14:17:10")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Boolean> flgEntregadoPorAlumno;
    public static volatile SingularAttribute<Reserva, Boolean> flgRecibidoPorAlumno;
    public static volatile SingularAttribute<Reserva, Date> fechaIni;
    public static volatile SingularAttribute<Reserva, Usuario> uSUARIOcodUsuario;
    public static volatile SingularAttribute<Reserva, Libro> lIBROidLibro;
    public static volatile SingularAttribute<Reserva, Date> fechaFin;
    public static volatile SingularAttribute<Reserva, Integer> idReserva;
    public static volatile SingularAttribute<Reserva, String> observacion;

}