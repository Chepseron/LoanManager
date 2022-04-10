/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.amon.model.Loanlimits;
import com.amon.model.Loans;
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
@Path("com.amon.model.loanlimits")
public class LoanlimitsFacadeREST extends AbstractFacade<Loanlimits> {

    @PersistenceContext(unitName = "loanSystemPU")
    private EntityManager em;

    public LoanlimitsFacadeREST() {
        super(Loanlimits.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Loanlimits entity) {
        super.create(entity);
    }

    @POST
    @Path("CreateLoanLimit")
    @Consumes({"application/xml", "application/json"})
    public void CreateLoanLimit(Loanlimits entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Loanlimits entity) {
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
    public Loanlimits find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("CheckLoanLimit/{id}")
    @Produces({"application/xml", "application/json"})
    public Loanlimits checkCustomerLimit(Loans entity) {
        return super.find(entity.getCustomerid());
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Loanlimits> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Loanlimits> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

}