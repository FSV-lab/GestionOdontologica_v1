/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferch
 */
@Entity
@Table(name = "pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p")
    , @NamedQuery(name = "Pacientes.findByPacIdentificacion", query = "SELECT p FROM Pacientes p WHERE p.pacIdentificacion = :pacIdentificacion")
    , @NamedQuery(name = "Pacientes.findByPacNombres", query = "SELECT p FROM Pacientes p WHERE p.pacNombres = :pacNombres")
    , @NamedQuery(name = "Pacientes.findByPacApellidos", query = "SELECT p FROM Pacientes p WHERE p.pacApellidos = :pacApellidos")
    , @NamedQuery(name = "Pacientes.findByPacFechaNacimiento", query = "SELECT p FROM Pacientes p WHERE p.pacFechaNacimiento = :pacFechaNacimiento")
    , @NamedQuery(name = "Pacientes.findByPacsexo", query = "SELECT p FROM Pacientes p WHERE p.pacsexo = :pacsexo")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "PacIdentificacion")
    private String pacIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PacNombres")
    private String pacNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PacApellidos")
    private String pacApellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PacFechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date pacFechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Pacsexo")
    private String pacsexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citPaciente")
    private Collection<Citas> citasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traPaciente")
    private Collection<Tratamientos> tratamientosCollection;

    public Pacientes() {
    }

    public Pacientes(String pacIdentificacion) {
        this.pacIdentificacion = pacIdentificacion;
    }

    public Pacientes(String pacIdentificacion, String pacNombres, String pacApellidos, Date pacFechaNacimiento, String pacsexo) {
        this.pacIdentificacion = pacIdentificacion;
        this.pacNombres = pacNombres;
        this.pacApellidos = pacApellidos;
        this.pacFechaNacimiento = pacFechaNacimiento;
        this.pacsexo = pacsexo;
    }

    public String getPacIdentificacion() {
        return pacIdentificacion;
    }

    public void setPacIdentificacion(String pacIdentificacion) {
        this.pacIdentificacion = pacIdentificacion;
    }

    public String getPacNombres() {
        return pacNombres;
    }

    public void setPacNombres(String pacNombres) {
        this.pacNombres = pacNombres;
    }

    public String getPacApellidos() {
        return pacApellidos;
    }

    public void setPacApellidos(String pacApellidos) {
        this.pacApellidos = pacApellidos;
    }

    public Date getPacFechaNacimiento() {
        return pacFechaNacimiento;
    }

    public void setPacFechaNacimiento(Date pacFechaNacimiento) {
        this.pacFechaNacimiento = pacFechaNacimiento;
    }

    public String getPacsexo() {
        return pacsexo;
    }

    public void setPacsexo(String pacsexo) {
        this.pacsexo = pacsexo;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    @XmlTransient
    public Collection<Tratamientos> getTratamientosCollection() {
        return tratamientosCollection;
    }

    public void setTratamientosCollection(Collection<Tratamientos> tratamientosCollection) {
        this.tratamientosCollection = tratamientosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacIdentificacion != null ? pacIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.pacIdentificacion == null && other.pacIdentificacion != null) || (this.pacIdentificacion != null && !this.pacIdentificacion.equals(other.pacIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Pacientes[ pacIdentificacion=" + pacIdentificacion + " ]";
    }
    
}
