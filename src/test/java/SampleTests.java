import com.solvd.bankclasses.daoclasses.implemented.BankDAO;
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

    @Test
    public void noBankExist() throws SQLException {
        Bank b = new Bank(1,1,1,1,1,1);
        b.setId(23);
        BankDAO bankDAO = new BankDAO();
        Assert.assertNull(bankDAO.getObjectByID(23));
    }

}
