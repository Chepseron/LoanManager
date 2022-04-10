/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.amon.model.Customer;
import com.amon.model.Loans;
import com.amon.model.Loanlimits;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import junit.framework.TestCase;
import service.*;

/**
 *
 * @author Anonymous
 */
public class LoansJUnitTest extends TestCase {

    public LoansJUnitTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    public void testCreateCustomer() {
        Customer cust = new Customer();
        cust.setFirstname("first name");
        cust.setSecondname("second name");
        cust.setLoanlimitsCollection(null);
        cust.setIdnumber("123456789");
        CustomerFacadeREST rest = new CustomerFacadeREST();
        rest.create(cust);
    }

    public void testCreateLoan() {

        //calculate the due date 
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DAY_OF_YEAR, 30);
        Date dueDate = c1.getTime();

        Loans loan = new Loans();
        loan.setPaymentamount(1000);
        loan.setCustomerid(1);
        loan.setDatecreated(new java.util.Date());
        loan.setDuedate(dueDate);
        loan.setStatus("Acquired");
        LoansFacadeREST rest = new LoansFacadeREST();
        rest.create(loan);
    }

    public void testCheckLoanLimit() {
        Customer cust = new Customer();
        Loans limits = new Loans();
        limits.setIdloan(1);
        LoanlimitsFacadeREST rest = new LoanlimitsFacadeREST();
        rest.checkCustomerLimit(limits);
    }

    public void testSetLoanLimit() {
        Customer cust = new Customer();
        Loanlimits limits = new Loanlimits();
        limits.setCustomerid(cust);
        limits.setLoanlimit(1000);
        LoanlimitsFacadeREST rest = new LoanlimitsFacadeREST();
        rest.create(limits);
    }

    public void checkLoanStatus() {
        Loans loan = new Loans();
        loan.setPaymentamount(1000);
        loan.setCustomerid(1);
        loan.setDatecreated(new java.util.Date());
        loan.setStatus("Acquired");
        LoansFacadeREST rest = new LoansFacadeREST();
        rest.find(loan.getIdloan());
    }
}
