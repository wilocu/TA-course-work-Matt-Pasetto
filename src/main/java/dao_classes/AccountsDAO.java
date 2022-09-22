package dao_classes;

import Utilities.ConnectionPool;
import accounts.Accounts;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountsDAO implements IDAO<Accounts> {

    private static final Logger LOGGER = Logger.getLogger(AccountsDAO.class.getName());
    private static final String GET_BY_ID = "SELECT * FROM accounts WHERE id = ?;";
    private static final String GET_ID_BY_ACCOUNT = "SELECT * FROM accounts WHERE balance = ? AND personID = ? AND interestRateID = ? AND actionLogId = ?;";
    private static final String INSERT = "INSERT INTO accounts (balance, personID, interestRateID, actionLogId) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE accounts SET balance = ?, personID = ?, interestRateID = ?, actionLogId = ? WHERE id = ?;";

    @Override
    public Accounts getObjectByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Accounts acc = new Accounts(rs.getDouble(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                acc.setId(id);
                return acc;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert rs != null;
            rs.close();
            ps.close();
            ConnectionPool.getInstance().returnConnection(c);
        }
        throw new SQLException("No data matching the ID given");
    }

    @Override
    public int getIDbyObject(Accounts acc) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(GET_ID_BY_ACCOUNT);
            ps.setDouble(1, acc.getBalance());
            ps.setInt(2, acc.getPersonId());
            ps.setInt(3, acc.getInterestRateId());
            ps.setInt(4, acc.getActionLogId());
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert rs != null;
            rs.close();
            ps.close();
            ConnectionPool.getInstance().returnConnection(c);
        }
        throw new SQLException("No data matching the Object given");
    }

    @Override
    public void create(Accounts acc) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setDouble(1, acc.getBalance());
            ps.setInt(2, acc.getPersonId());
            ps.setInt(3, acc.getInterestRateId());
            ps.setInt(4, acc.getActionLogId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().returnConnection(c);
        }
    }

    @Override
    public void update(Accounts acc) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(UPDATE);
            ps.setDouble(1, acc.getBalance());
            ps.setInt(2, acc.getPersonId());
            ps.setInt(3, acc.getInterestRateId());
            ps.setInt(4, acc.getActionLogId());
            ps.setInt(5, acc.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().returnConnection(c);
        }
    }

}
