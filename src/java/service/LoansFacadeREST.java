/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.amon.model.Interest;
import com.amon.model.Loanlimits;
import com.amon.model.Loans;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Anonymous
 */
@Stateless
@Path("com.amon.model.loans")
public class LoansFacadeREST extends AbstractFacade<Loans> {

    private List<Loans> totalCustomerLoan = new ArrayList<>();
    private List<Loanlimits> totalCustomerLimit = new ArrayList<>();
    @PersistenceContext(unitName = "loanSystemPU")
    private EntityManager em;

    public LoansFacadeREST() {
        super(Loans.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Loans entity) {
        super.create(entity);
    }

    @POST
    @Path("CreateLoan")
    @Consumes({"application/xml", "application/json"})
    public void CreateLoan(Loans entity) {

        //calculate the total limit before assigning loan
        totalCustomerLoan = em.createQuery("SELECT l FROM Loans l WHERE l.customerid = " + entity.getCustomerid()).getResultList();
        int customerOwnedLoan = 0;
        for (Loans customerOwnedLoans : totalCustomerLoan) {
            customerOwnedLoan = customerOwnedLoan + customerOwnedLoans.getPrincipal();
        }

        //get customer limit;
        Loanlimits customerLimit = (Loanlimits) em.createQuery("SELECT l FROM Loanlimits l WHERE l.customerid = " + entity.getCustomerid()).getSingleResult();
        if (customerLimit.getLoanlimit() >= customerOwnedLoan) {
            //getting the due date
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
            Calendar c1 = Calendar.getInstance();
            c1.add(Calendar.DAY_OF_YEAR, 30);
            Date dueDate = c1.getTime();
            //get the interest configured
            InterestFacadeREST interest = new InterestFacadeREST();
            Interest interestrate = interest.find(1);
            //get the paid amount PRT
            int amountToPay = entity.getPrincipal() * entity.getInterest() * entity.getMonths();
            entity.setInterest(Integer.parseInt(String.valueOf(interestrate.getRate())));
            entity.setDatecreated(new java.util.Date());
            entity.setDuedate(dueDate);
            entity.setPaymentamount(amountToPay);
            super.create(entity);

        } else {
            //do not assign loan because the limits have exceeded
        }
    }

    @POST
    @Path("RepayLoan")
    @Consumes({"application/xml", "application/json"})
    public void RepayLoan(Loans entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Loans entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Loans find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Loans> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Loans> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * @return the totalCustomerLoan
     */
    public List<Loans> getTotalCustomerLoan() {
        return totalCustomerLoan;
    }

    /**
     * @param totalCustomerLoan the totalCustomerLoan to set
     */
    public void setTotalCustomerLoan(List<Loans> totalCustomerLoan) {
        this.totalCustomerLoan = totalCustomerLoan;
    }

    /**
     * @return the totalCustomerLimit
     */
    public List<Loanlimits> getTotalCustomerLimit() {
        return totalCustomerLimit;
    }

    /**
     * @param totalCustomerLimit the totalCustomerLimit to set
     */
    public void setTotalCustomerLimit(List<Loanlimits> totalCustomerLimit) {
        this.totalCustomerLimit = totalCustomerLimit;
    }

    /**
     * @return the totalCustomerLimit
     */
}
