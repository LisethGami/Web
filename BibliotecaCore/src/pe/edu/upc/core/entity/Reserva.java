/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.core.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User-Pc
 */
@Entity
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdReserva", query = "SELECT r FROM Reserva r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reserva.findByFechaIni", query = "SELECT r FROM Reserva r WHERE r.fechaIni = :fechaIni"),
    @NamedQuery(name = "Reserva.findByFechaFin", query = "SELECT r FROM Reserva r WHERE r.fechaFin = :fechaFin"),
    @NamedQuery(name = "Reserva.findByFlgEntregadoPorAlumno", query = "SELECT r FROM Reserva r WHERE r.flgEntregadoPorAlumno = :flgEntregadoPorAlumno"),
    @NamedQuery(name = "Reserva.findByFlgRecibidoPorAlumno", query = "SELECT r FROM Reserva r WHERE r.flgRecibidoPorAlumno = :flgRecibidoPorAlumno"),
    @NamedQuery(name = "Reserva.findByObservacion", query = "SELECT r FROM Reserva r WHERE r.observacion = :observacion")})
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReserva")
    private Integer idReserva;
    @Column(name = "fechaIni")
    @Temporal(TemporalType.DATE)
    private Date fechaIni;
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "flgEntregadoPorAlumno")
    private Boolean flgEntregadoPorAlumno;
    @Column(name = "flgRecibidoPorAlumno")
    private Boolean flgRecibidoPorAlumno;
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "LIBRO_idLibro", referencedColumnName = "idLibro")
    @ManyToOne(optional = false)
    private Libro lIBROidLibro;
    @JoinColumn(name = "USUARIO_codUsuario", referencedColumnName = "codUsuario")
    @ManyToOne(optional = false)
    private Usuario uSUARIOcodUsuario;

    public Reserva() {
    }

    public Reserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getFlgEntregadoPorAlumno() {
        return flgEntregadoPorAlumno;
    }

    public void setFlgEntregadoPorAlumno(Boolean flgEntregadoPorAlumno) {
        this.flgEntregadoPorAlumno = flgEntregadoPorAlumno;
    }

    public Boolean getFlgRecibidoPorAlumno() {
        return flgRecibidoPorAlumno;
    }

    public void setFlgRecibidoPorAlumno(Boolean flgRecibidoPorAlumno) {
        this.flgRecibidoPorAlumno = flgRecibidoPorAlumno;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Libro getLIBROidLibro() {
        return lIBROidLibro;
    }

    public void setLIBROidLibro(Libro lIBROidLibro) {
        this.lIBROidLibro = lIBROidLibro;
    }

    public Usuario getUSUARIOcodUsuario() {
        return uSUARIOcodUsuario;
    }

    public void setUSUARIOcodUsuario(Usuario uSUARIOcodUsuario) {
        this.uSUARIOcodUsuario = uSUARIOcodUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upc.core.entity.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
