package com.solvd.bankclasses.daoclasses.implemented;

import com.solvd.bankclasses.daoclasses.IBankDAO;
import com.solvd.bankclasses.utilities.ConnectionPool;
import org.apache.log4j.Logger;
import com.solvd.bankclasses.places.Bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDAO implements IBankDAO<Bank> {
    private static final Logger LOGGER = Logger.getLogger(BankDAO.class.getName());
    private static final String GET_BY_ID = "SELECT * FROM bank WHERE idBank = ?;";
    private static final String GET_ID_BY_BANK = "SELECT * FROM bank WHERE People_idPerson = ?, Address_idAddress = ?, Location_idLocation = ?, BankBalance_idFunds = ?, Security_idSecurity = ?, ArmoredTransport_idArmoredTransport = ?;";
    private static final String INSERT = "INSERT INTO bank (People_idPerson, Address_idAddress, Location_idLocation, BankBalance_idFunds, Security_idSecurity, ArmoredTransport_idArmoredTransport) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE bank SET People_idPerson = ?, Address_idAddress = ?, Location_idLocation = ?, BankBalance_idFunds = ?, Security_idSecurity = ?, ArmoredTransport_idArmoredTransport = ? WHERE id = ?;";

    @Override
    public Bank getObjectByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bank p = new Bank(rs.getInt("personId"), rs.getInt("addressId"), rs.getInt("locationId"), rs.getInt("fundsId"),
                        rs.getInt("securityId"), rs.getInt("armoredTransportId"));
                p.setId(id);
                return p;
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
    public int getIDbyObject(Bank b) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(GET_ID_BY_BANK);
            ps.setInt(1, b.getPersonId());
            ps.setInt(2, b.getAddressId());
            ps.setInt(3, b.getLocationId());
            ps.setInt(4, b.getFundsId());
            ps.setInt(5, b.getSecurityId());
            ps.setInt(6, b.getArmoredTransportId());
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
    public void create(Bank b) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setInt(1, b.getPersonId());
            ps.setInt(2, b.getAddressId());
            ps.setInt(3, b.getLocationId());
            ps.setInt(4, b.getFundsId());
            ps.setInt(5, b.getSecurityId());
            ps.setInt(6, b.getArmoredTransportId());
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
    public void update(Bank b) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(UPDATE);
            ps.setInt(1, b.getPersonId());
            ps.setInt(2, b.getAddressId());
            ps.setInt(3, b.getLocationId());
            ps.setInt(4, b.getFundsId());
            ps.setInt(5, b.getSecurityId());
            ps.setInt(6, b.getArmoredTransportId());
            ps.setInt(7, b.getId());
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
