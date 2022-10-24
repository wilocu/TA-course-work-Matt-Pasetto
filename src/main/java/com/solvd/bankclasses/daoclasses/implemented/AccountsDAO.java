package com.solvd.bankclasses.daoclasses.implemented;

import com.solvd.bankclasses.daoclasses.IAccountsDAO;
import com.solvd.bankclasses.utilities.ConnectionPool;
import com.solvd.bankclasses.accounts.Accounts;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountsDAO implements IAccountsDAO<Accounts> {

    private static final Logger LOGGER = Logger.getLogger(AccountsDAO.class.getName());
    private static final String GET_BY_ID = "SELECT * FROM com.solvd.bankclasses.accounts WHERE id = ?;";
    private static final String GET_ID_BY_ACCOUNT = "SELECT * FROM com.solvd.bankclasses.accounts WHERE balance = ? AND personID = ? AND interestRateID = ? AND actionLogId = ?;";
    private static final String INSERT = "INSERT INTO com.solvd.bankclasses.accounts (balance, personID, interestRateID, actionLogId) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE com.solvd.bankclasses.accounts SET balance = ?, personID = ?, interestRateID = ?, actionLogId = ? WHERE id = ?;";
    private static final String GET_ACCOUNTS_BY_USER = "SELECT * FROM accounts WHERE id IN (SELECT accountsID FROM user_status WHERE userID = ?);";


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

    public List<Accounts> getAccountsByUser(int userID) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Accounts> accounts = new ArrayList<>();
        try {
            ps = c.prepareStatement(GET_ACCOUNTS_BY_USER);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Accounts account = new Accounts(rs.getDouble("balance"), rs.getInt("personID"));
                account.setId(rs.getInt("id"));
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert rs != null;
            rs.close();
            ps.close();
            ConnectionPool.getInstance().returnConnection(c);
        }
        throw new SQLException("No Discounts matching the User given");
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
    public int create(Accounts acc) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setDouble(1, acc.getBalance());
            ps.setInt(2, acc.getPersonId());
            ps.setInt(3, acc.getInterestRateId());
            ps.setInt(4, acc.getActionLogId());
            ps.executeUpdate();
            return getIDbyObject(acc);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().returnConnection(c);
        }
        throw new SQLException("Could not get ID of newly created object");
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
