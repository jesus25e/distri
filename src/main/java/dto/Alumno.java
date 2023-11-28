/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByCodiAlum", query = "SELECT a FROM Alumno a WHERE a.codiAlum = :codiAlum"),
    @NamedQuery(name = "Alumno.findByAppaAlum", query = "SELECT a FROM Alumno a WHERE a.appaAlum = :appaAlum"),
    @NamedQuery(name = "Alumno.findByApmaAlum", query = "SELECT a FROM Alumno a WHERE a.apmaAlum = :apmaAlum"),
    @NamedQuery(name = "Alumno.findByNombAlum", query = "SELECT a FROM Alumno a WHERE a.nombAlum = :nombAlum")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codiAlum")
    private String codiAlum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "appaAlum")
    private String appaAlum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apmaAlum")
    private String apmaAlum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombAlum")
    private String nombAlum;

    public Alumno() {
    }

    public Alumno(String codiAlum) {
        this.codiAlum = codiAlum;
    }

    public Alumno(String codiAlum, String appaAlum, String apmaAlum, String nombAlum) {
        this.codiAlum = codiAlum;
        this.appaAlum = appaAlum;
        this.apmaAlum = apmaAlum;
        this.nombAlum = nombAlum;
    }

    public String getCodiAlum() {
        return codiAlum;
    }

    public void setCodiAlum(String codiAlum) {
        this.codiAlum = codiAlum;
    }

    public String getAppaAlum() {
        return appaAlum;
    }

    public void setAppaAlum(String appaAlum) {
        this.appaAlum = appaAlum;
    }

    public String getApmaAlum() {
        return apmaAlum;
    }

    public void setApmaAlum(String apmaAlum) {
        this.apmaAlum = apmaAlum;
    }

    public String getNombAlum() {
        return nombAlum;
    }

    public void setNombAlum(String nombAlum) {
        this.nombAlum = nombAlum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiAlum != null ? codiAlum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.codiAlum == null && other.codiAlum != null) || (this.codiAlum != null && !this.codiAlum.equals(other.codiAlum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Alumno[ codiAlum=" + codiAlum + " ]";
    }
    
}
