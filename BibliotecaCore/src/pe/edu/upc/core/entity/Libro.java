/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.core.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User-Pc
 */
@Entity
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByIdLibro", query = "SELECT l FROM Libro l WHERE l.idLibro = :idLibro"),
    @NamedQuery(name = "Libro.findByNombreLibro", query = "SELECT l FROM Libro l WHERE l.nombreLibro = :nombreLibro"),
    @NamedQuery(name = "Libro.findByFechaPublicacion", query = "SELECT l FROM Libro l WHERE l.fechaPublicacion = :fechaPublicacion"),
    @NamedQuery(name = "Libro.findByVolumen", query = "SELECT l FROM Libro l WHERE l.volumen = :volumen"),
    @NamedQuery(name = "Libro.findByNroEjemplares", query = "SELECT l FROM Libro l WHERE l.nroEjemplares = :nroEjemplares")})
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLibro")
    private Integer idLibro;
    @Column(name = "nombreLibro")
    private String nombreLibro;
    @Column(name = "fechaPublicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @Column(name = "volumen")
    private Integer volumen;
    @Lob
    @Column(name = "textImgLibro")
    private String textImgLibro;
    @Column(name = "nroEjemplares")
    private Integer nroEjemplares;
    @JoinColumn(name = "AUTOR_idAutor", referencedColumnName = "idAutor")
    @ManyToOne(optional = false)
    private Autor aUTORidAutor;
    @JoinColumn(name = "CATEGORIA_idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categoria cATEGORIAidCategoria;
    @JoinColumn(name = "EDITORIAL_idEditorial", referencedColumnName = "idEditorial")
    @ManyToOne(optional = false)
    private Editorial eDITORIALidEditorial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lIBROidLibro")
    private Collection<Reserva> reservaCollection;

    public Libro() {
    }

    public Libro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public String getTextImgLibro() {
        return textImgLibro;
    }

    public void setTextImgLibro(String textImgLibro) {
        this.textImgLibro = textImgLibro;
    }

    public Integer getNroEjemplares() {
        return nroEjemplares;
    }

    public void setNroEjemplares(Integer nroEjemplares) {
        this.nroEjemplares = nroEjemplares;
    }

    public Autor getAUTORidAutor() {
        return aUTORidAutor;
    }

    public void setAUTORidAutor(Autor aUTORidAutor) {
        this.aUTORidAutor = aUTORidAutor;
    }

    public Categoria getCATEGORIAidCategoria() {
        return cATEGORIAidCategoria;
    }

    public void setCATEGORIAidCategoria(Categoria cATEGORIAidCategoria) {
        this.cATEGORIAidCategoria = cATEGORIAidCategoria;
    }

    public Editorial getEDITORIALidEditorial() {
        return eDITORIALidEditorial;
    }

    public void setEDITORIALidEditorial(Editorial eDITORIALidEditorial) {
        this.eDITORIALidEditorial = eDITORIALidEditorial;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upc.core.entity.Libro[ idLibro=" + idLibro + " ]";
    }
    
}
