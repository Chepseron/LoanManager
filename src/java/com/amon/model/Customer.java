/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author asabul
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByPhonenumber", query = "SELECT c FROM Customer c WHERE c.phonenumber = :phonenumber"),
    @NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Customer.findBySecondname", query = "SELECT c FROM Customer c WHERE c.secondname = :secondname"),
    @NamedQuery(name = "Customer.findByIdnumber", query = "SELECT c FROM Customer c WHERE c.idnumber = :idnumber")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "phonenumber")
    private Integer phonenumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "secondname")
    private String secondname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idnumber")
    private String idnumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private Collection<Loanlimits> loanlimitsCollection;

    public Customer() {
    }

    public Customer(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Customer(Integer phonenumber, String firstname, String secondname, String idnumber) {
        this.phonenumber = phonenumber;
        this.firstname = firstname;
        this.secondname = secondname;
        this.idnumber = idnumber;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    @XmlTransient
    public Collection<Loanlimits> getLoanlimitsCollection() {
        return loanlimitsCollection;
    }

    public void setLoanlimitsCollection(Collection<Loanlimits> loanlimitsCollection) {
        this.loanlimitsCollection = loanlimitsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phonenumber != null ? phonenumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.phonenumber == null && other.phonenumber != null) || (this.phonenumber != null && !this.phonenumber.equals(other.phonenumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.model.Customer[ phonenumber=" + phonenumber + " ]";
    }
    
}
