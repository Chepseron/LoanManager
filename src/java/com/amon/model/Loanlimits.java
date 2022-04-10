/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asabul
 */
@Entity
@Table(name = "loanlimits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loanlimits.findAll", query = "SELECT l FROM Loanlimits l"),
    @NamedQuery(name = "Loanlimits.findByIdloanlimits", query = "SELECT l FROM Loanlimits l WHERE l.idloanlimits = :idloanlimits"),
    @NamedQuery(name = "Loanlimits.findByIdloanlimits", query = "SELECT l FROM Loanlimits l WHERE l.customerid = :customerid"),
    @NamedQuery(name = "Loanlimits.findByLoanlimit", query = "SELECT l FROM Loanlimits l WHERE l.loanlimit = :loanlimit")})
public class Loanlimits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idloanlimits")
    private Integer idloanlimits;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loanlimit")
    private long loanlimit;
    @JoinColumn(name = "customerid", referencedColumnName = "phonenumber")
    @ManyToOne(optional = false)
    private Customer customerid;

    public Loanlimits() {
    }

    public Loanlimits(Integer idloanlimits) {
        this.idloanlimits = idloanlimits;
    }

    public Loanlimits(Integer idloanlimits, long loanlimit) {
        this.idloanlimits = idloanlimits;
        this.loanlimit = loanlimit;
    }

    public Integer getIdloanlimits() {
        return idloanlimits;
    }

    public void setIdloanlimits(Integer idloanlimits) {
        this.idloanlimits = idloanlimits;
    }

    public long getLoanlimit() {
        return loanlimit;
    }

    public void setLoanlimit(long loanlimit) {
        this.loanlimit = loanlimit;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idloanlimits != null ? idloanlimits.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loanlimits)) {
            return false;
        }
        Loanlimits other = (Loanlimits) object;
        if ((this.idloanlimits == null && other.idloanlimits != null) || (this.idloanlimits != null && !this.idloanlimits.equals(other.idloanlimits))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.model.Loanlimits[ idloanlimits=" + idloanlimits + " ]";
    }
    
}
