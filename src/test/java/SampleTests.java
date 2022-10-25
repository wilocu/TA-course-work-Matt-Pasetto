import com.solvd.bankclasses.accounts.Account;
import com.solvd.bankclasses.accounts.Accounts;
import com.solvd.bankclasses.daoclasses.implemented.AccountsDAO;
import com.solvd.bankclasses.daoclasses.implemented.BankDAO;
import com.solvd.bankclasses.people.Contact;
import com.solvd.bankclasses.people.People;
import com.solvd.bankclasses.places.Address;
import com.solvd.bankclasses.places.Bank;
import com.solvd.bankclasses.service.impl.AccountServiceImpl;
import com.solvd.bankclasses.service.impl.BankServiceImpl;
import com.solvd.bankclasses.service.impl.PeopleServiceImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;

@Test()
public class SampleTests {

    @Test
    public void bankDAOgetIDbyObject() throws SQLException {
        Bank b = new Bank(1,1,1,1,1,1);
        b.setId(23);
        BankDAO bankDAO = new BankDAO();
        bankDAO.create(b);
        Assert.assertEquals(bankDAO.getIDbyObject(b), b.getId());
    }

    @Test
    public void bankDAOgetObjectByID() throws SQLException {
        Bank b = new Bank(1,1,1,1,1,1);
        b.setId(23);
        BankDAO bankDAO = new BankDAO();
        bankDAO.create(b);
        Assert.assertEquals(bankDAO.getObjectByID(b.getId()), b);
    }

    @Test
    public void bankDAOupdateBank() throws SQLException {
        Bank b = new Bank(1,1,1,1,1,1);
        b.setId(23);
        BankDAO bankDAO = new BankDAO();
        bankDAO.create(b);
        Bank b2 = new Bank(2,2,2,2,2,2);
        b.setId(33);
        bankDAO.update(b2);
        Assert.assertEquals(bankDAO.getObjectByID(b.getId()), b2);
    }

    @Test
    public void AccountsDAOgetObjectByID() throws SQLException {
        Accounts a = new Accounts(1,1,1,1);
        a.setId(23);
        AccountsDAO accountsDAO = new AccountsDAO();
        accountsDAO.create(a);
        Assert.assertEquals(accountsDAO.getIDbyObject(a), a.getId());
    }

    @Test
    public void AccountsDAOgetIDbyObject() throws SQLException {
        Accounts a = new Accounts(1,1,1,1);
        a.setId(23);
        AccountsDAO accountsDAO = new AccountsDAO();
        accountsDAO.create(a);
        Assert.assertEquals(accountsDAO.getObjectByID(a.getId()), a);
    }

    @Test
    public void AccountsDAOUpdate() throws SQLException {
        Accounts a = new Accounts(1,1,1,1);
        a.setId(23);
        AccountsDAO accountsDAO = new AccountsDAO();
        accountsDAO.create(a);
        Accounts a2 = new Accounts(2,2,2,2);
        a.setId(33);
        accountsDAO.update(a2);
        Assert.assertEquals(accountsDAO.getObjectByID(a.getId()), a2);
    }

    @Test
    public void accountServiceLoadData() {
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.parseFromXmlDOM("src/main/resources/xsd_dir/accounts.xsd", "src/main/resources/xml_dir/accounts.xml");
        Assert.assertNotNull(accountService.getAccountByUser(1));
    }

    @Test
    public void bankServiceLoadData() {
        BankServiceImpl bankService = new BankServiceImpl();
        bankService.parseFromXmlDOM("src/main/resources/xsd_dir/bank.xsd", "src/main/resources/xml_dir/bank.xml");
        Assert.assertNotNull(bankService.getBankByID(1));
    }

    @Test
    public void peopleServiceLoadData() {
        PeopleServiceImpl peopleService = new PeopleServiceImpl();
        peopleService.parseFromXmlDOM("src/main/resources/xsd_dir/people.xsd", "src/main/resources/xml_dir/people.xml");
        Assert.assertNotNull(peopleService.getPeopleByID(1));
    }

    @Test
    public void peopleServiceAddCustomer() {
        PeopleServiceImpl peopleService = new PeopleServiceImpl();
        Assert.assertNotNull(peopleService.addCustomerForTest());
    }

}
