import com.solvd.bankclasses.accounts.Account;
import com.solvd.bankclasses.accounts.Accounts;
import com.solvd.bankclasses.daoclasses.implemented.BankDAO;
import com.solvd.bankclasses.people.Contact;
import com.solvd.bankclasses.people.People;
import com.solvd.bankclasses.places.Address;
import com.solvd.bankclasses.places.Bank;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;

@Test()
public class SampleTests {

    @Test
    public void bankTest() {
        Bank b = new Bank(1,1,1,1,1,1);
        b.setId(1);
        Assert.assertEquals(b.getId(), 1);
        Assert.assertEquals(b.getAddressId(), 1);
        Assert.assertEquals(b.getArmoredTransportId(), 1);
        Assert.assertEquals(b.getLocationId(), 1);
        Assert.assertEquals(b.getFundsId(), 1);
        Assert.assertEquals(b.getPersonId(), 1);
        Assert.assertEquals(b.getSecurityId(), 1);
        Assert.assertNotEquals(b.getId(), 0);
    }

    @Test
    public void bankSetID() {
        Bank b = new Bank(1,1,1,1,1,1);
        b.setId(23);
        Assert.assertEquals(b.getId(), 23);
        Assert.assertNotEquals(b.getId(), 1);
    }

//    @Test
//    public void noBankExist() throws SQLException {
//        Bank b = new Bank(1,1,1,1,1,1);
//        b.setId(23);
//        BankDAO bankDAO = new BankDAO();
//        Assert.assertNull(bankDAO.getObjectByID(23));
//    }

    @Test
    public void accountComesWith20() {
        Accounts a = new Accounts(0, 1);
        Assert.assertEquals(a.getBalance(), 20);
        Assert.assertEquals(a.getPersonId(), 1);
    }

    @Test
    public void accountDeposit() {
        Accounts a = new Accounts(0, 1);
        Assert.assertEquals(a.getBalance(), 20);
        Assert.assertEquals(a.getPersonId(), 1);

        a.addBalance(20);
        Assert.assertEquals(a.getBalance(), 40);
    }

    @Test
    public void accountWithdraw() {
        Accounts a = new Accounts(0, 1);
        Assert.assertEquals(a.getBalance(), 20);
        Assert.assertEquals(a.getPersonId(), 1);

        a.subtractBalance(20);
        Assert.assertEquals(a.getBalance(), 0);
    }

    @Test
    public void createCustomer() {
        People p = new People("Test", "test"); //default should be customer
        Assert.assertEquals(p.getPersonType(), 3);
    }

    @Test
    public void createOwner() {
        People p = new People("Test", "test",1); //default should be customer
        Assert.assertEquals(p.getPersonType(), 1);
    }

    @Test
    public void createEmployee() {
        People p = new People("Test", "test",2); //default should be customer
        Assert.assertEquals(p.getPersonType(), 2);
    }

    @Test
    public void compareAddress() {
        Address a = new Address("23 markus", "new york", "ny", 20354);
        Address a2 = new Address("21 markus", "new york", "ny", 20354);
        Assert.assertFalse(a.equals(a2));
    }

    @Test
    public void connectContact() {
        People p = new People("Test", "test"); //default should be customer
        p.setId(1);
        Contact c = new Contact(1, "hdhdgdgf@gmail", "7635485769");
        Assert.assertEquals(c.getPersonId(), p.getId());
    }

}
