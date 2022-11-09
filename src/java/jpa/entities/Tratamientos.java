/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferch
 */
@Entity
@Table(name = "tratamientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratamientos.findAll", query = "SELECT t FROM Tratamientos t")
    , @NamedQuery(name = "Tratamientos.findByTraNumero", query = "SELECT t FROM Tratamientos t WHERE t.traNumero = :traNumero")
    , @NamedQuery(name = "Tratamientos.findByTraFechaAsignado", query = "SELECT t FROM Tratamientos t WHERE t.traFechaAsignado = :traFechaAsignado")
    , @NamedQuery(name = "Tratamientos.findByTraFechaInicio", query = "SELECT t FROM Tratamientos t WHERE t.traFechaInicio = :traFechaInicio")
    , @NamedQuery(name = "Tratamientos.findByTraTemporal", query = "SELECT t FROM Tratamientos t WHERE t.traTemporal = :traTemporal")
    , @NamedQuery(name = "Tratamientos.findByTraFechaFin", query = "SELECT t FROM Tratamientos t WHERE t.traFechaFin = :traFechaFin")})
public class Tratamientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TraNumero")
    private Integer traNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TraFechaAsignado")
    @Temporal(TemporalType.DATE)
    private Date traFechaAsignado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "TraDescripcion")
    private String traDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TraFechaInicio")
    @Temporal(TemporalType.DATE)
    private Date traFechaInicio;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "TraObservaciones")
    private String traObservaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TraTemporal")
    private String traTemporal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TraFechaFin")
    @Temporal(TemporalType.DATE)
    private Date traFechaFin;
    @JoinColumn(name = "TraPaciente", referencedColumnName = "PacIdentificacion")
    @ManyToOne(optional = false)
    private Pacientes traPaciente;

    public Tratamientos() {
    }

    public Tratamientos(Integer traNumero) {
        this.traNumero = traNumero;
    }

    public Tratamientos(Integer traNumero, Date traFechaAsignado, String traDescripcion, Date traFechaInicio, String traObservaciones, String traTemporal, Date traFechaFin) {
        this.traNumero = traNumero;
        this.traFechaAsignado = traFechaAsignado;
        this.traDescripcion = traDescripcion;
        this.traFechaInicio = traFechaInicio;
        this.traObservaciones = traObservaciones;
        this.traTemporal = traTemporal;
        this.traFechaFin = traFechaFin;
    }

    public Integer getTraNumero() {
        return traNumero;
    }

    public void setTraNumero(Integer traNumero) {
        this.traNumero = traNumero;
    }

    public Date getTraFechaAsignado() {
        return traFechaAsignado;
    }

    public void setTraFechaAsignado(Date traFechaAsignado) {
        this.traFechaAsignado = traFechaAsignado;
    }

    public String getTraDescripcion() {
        return traDescripcion;
    }

    public void setTraDescripcion(String traDescripcion) {
        this.traDescripcion = traDescripcion;
    }

    public Date getTraFechaInicio() {
        return traFechaInicio;
    }

    public void setTraFechaInicio(Date traFechaInicio) {
        this.traFechaInicio = traFechaInicio;
    }

    public String getTraObservaciones() {
        return traObservaciones;
    }

    public void setTraObservaciones(String traObservaciones) {
        this.traObservaciones = traObservaciones;
    }

    public String getTraTemporal() {
        return traTemporal;
    }

    public void setTraTemporal(String traTemporal) {
        this.traTemporal = traTemporal;
    }

    public Date getTraFechaFin() {
        return traFechaFin;
    }

    public void setTraFechaFin(Date traFechaFin) {
        this.traFechaFin = traFechaFin;
    }

    public Pacientes getTraPaciente() {
        return traPaciente;
    }

    public void setTraPaciente(Pacientes traPaciente) {
        this.traPaciente = traPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traNumero != null ? traNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamientos)) {
            return false;
        }
        Tratamientos other = (Tratamientos) object;
        if ((this.traNumero == null && other.traNumero != null) || (this.traNumero != null && !this.traNumero.equals(other.traNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Tratamientos[ traNumero=" + traNumero + " ]";
    }
    
}
