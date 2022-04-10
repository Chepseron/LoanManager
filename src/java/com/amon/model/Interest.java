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
@Table(name = "interest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interest.findAll", query = "SELECT i FROM Interest i"),
    @NamedQuery(name = "Interest.findByIdinterest", query = "SELECT i FROM Interest i WHERE i.idinterest = :idinterest"),
    @NamedQuery(name = "Interest.findByRate", query = "SELECT i FROM Interest i WHERE i.rate = :rate")})
public class Interest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinterest")
    private Integer idinterest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private long rate;

    public Interest() {
    }

    public Interest(Integer idinterest) {
        this.idinterest = idinterest;
    }

    public Interest(Integer idinterest, long rate) {
        this.idinterest = idinterest;
        this.rate = rate;
    }

    public Integer getIdinterest() {
        return idinterest;
    }

    public void setIdinterest(Integer idinterest) {
        this.idinterest = idinterest;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinterest != null ? idinterest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interest)) {
            return false;
        }
        Interest other = (Interest) object;
        if ((this.idinterest == null && other.idinterest != null) || (this.idinterest != null && !this.idinterest.equals(other.idinterest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.model.Interest[ idinterest=" + idinterest + " ]";
    }
    
}
