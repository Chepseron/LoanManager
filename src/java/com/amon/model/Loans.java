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
@Table(name = "loans")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loans.findAll", query = "SELECT l FROM Loans l"),
    @NamedQuery(name = "Loans.findByIdloan", query = "SELECT l FROM Loans l WHERE l.idloan = :idloan"),
    @NamedQuery(name = "Loans.findByCustomerid", query = "SELECT l FROM Loans l WHERE l.customerid = :customerid"),
    @NamedQuery(name = "Loans.findByDatecreated", query = "SELECT l FROM Loans l WHERE l.datecreated = :datecreated"),
    @NamedQuery(name = "Loans.findByDuedate", query = "SELECT l FROM Loans l WHERE l.duedate = :duedate"),
    @NamedQuery(name = "Loans.findByStatus", query = "SELECT l FROM Loans l WHERE l.status = :status"),
    @NamedQuery(name = "Loans.findByPrincipal", query = "SELECT l FROM Loans l WHERE l.principal = :principal"),
    @NamedQuery(name = "Loans.findByInterest", query = "SELECT l FROM Loans l WHERE l.interest = :interest"),
    @NamedQuery(name = "Loans.findByMonths", query = "SELECT l FROM Loans l WHERE l.months = :months"),
    @NamedQuery(name = "Loans.findByPaymentamount", query = "SELECT l FROM Loans l WHERE l.paymentamount = :paymentamount")})
public class Loans implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idloan")
    private Integer idloan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customerid")
    private int customerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duedate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "principal")
    private int principal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interest")
    private int interest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "months")
    private int months;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paymentamount")
    private int paymentamount;

    public Loans() {
    }

    public Loans(Integer idloan) {
        this.idloan = idloan;
    }

    public Loans(Integer idloan, int customerid, Date datecreated, Date duedate, String status, int principal, int interest, int months, int paymentamount) {
        this.idloan = idloan;
        this.customerid = customerid;
        this.datecreated = datecreated;
        this.duedate = duedate;
        this.status = status;
        this.principal = principal;
        this.interest = interest;
        this.months = months;
        this.paymentamount = paymentamount;
    }

    public Integer getIdloan() {
        return idloan;
    }

    public void setIdloan(Integer idloan) {
        this.idloan = idloan;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getPaymentamount() {
        return paymentamount;
    }

    public void setPaymentamount(int paymentamount) {
        this.paymentamount = paymentamount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idloan != null ? idloan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loans)) {
            return false;
        }
        Loans other = (Loans) object;
        if ((this.idloan == null && other.idloan != null) || (this.idloan != null && !this.idloan.equals(other.idloan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.model.Loans[ idloan=" + idloan + " ]";
    }
    
}
