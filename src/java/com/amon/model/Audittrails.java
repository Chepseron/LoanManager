/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author asabul
 */
@Entity
@Table(name = "audittrails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Audittrails.findAll", query = "SELECT a FROM Audittrails a"),
    @NamedQuery(name = "Audittrails.findByIdaudittrails", query = "SELECT a FROM Audittrails a WHERE a.idaudittrails = :idaudittrails"),
    @NamedQuery(name = "Audittrails.findByCreatedOn", query = "SELECT a FROM Audittrails a WHERE a.createdOn = :createdOn"),
    @NamedQuery(name = "Audittrails.findByAction", query = "SELECT a FROM Audittrails a WHERE a.action = :action"),
    @NamedQuery(name = "Audittrails.findByUserid", query = "SELECT a FROM Audittrails a WHERE a.userid = :userid")})
public class Audittrails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaudittrails")
    private Integer idaudittrails;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "action")
    private String action;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "userid")
    private String userid;

    public Audittrails() {
    }

    public Audittrails(Integer idaudittrails) {
        this.idaudittrails = idaudittrails;
    }

    public Audittrails(Integer idaudittrails, Date createdOn, String action, String userid) {
        this.idaudittrails = idaudittrails;
        this.createdOn = createdOn;
        this.action = action;
        this.userid = userid;
    }

    public Integer getIdaudittrails() {
        return idaudittrails;
    }

    public void setIdaudittrails(Integer idaudittrails) {
        this.idaudittrails = idaudittrails;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaudittrails != null ? idaudittrails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Audittrails)) {
            return false;
        }
        Audittrails other = (Audittrails) object;
        if ((this.idaudittrails == null && other.idaudittrails != null) || (this.idaudittrails != null && !this.idaudittrails.equals(other.idaudittrails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.model.Audittrails[ idaudittrails=" + idaudittrails + " ]";
    }
    
}
