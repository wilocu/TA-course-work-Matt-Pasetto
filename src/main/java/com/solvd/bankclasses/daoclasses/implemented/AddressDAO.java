package com.solvd.bankclasses.daoclasses.implemented;

import com.solvd.bankclasses.daoclasses.IAddressDAO;
import com.solvd.bankclasses.utilities.ConnectionPool;
import com.solvd.bankclasses.places.Address;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO implements IAddressDAO {
    private static final Logger LOGGER = Logger.getLogger(AddressDAO.class.getName());
    private static final String GET_BY_ID = "SELECT * FROM addresses WHERE id = ?;";
    private static final String GET_ID_BY_ADDRESS = "SELECT * FROM addresses WHERE street = ? AND city = ? AND state = ? AND zipcode = ?;";
    private static final String INSERT = "INSERT INTO addresses (street, city, state, zipcode) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE addresses SET street = ?, city = ?, state = ?, zipcode = ? WHERE id = ?;";

    public Address getObjectByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Address p = new Address(rs.getString("street"), rs.getString("city"), rs.getString("state"), rs.getInt("zipcode"));
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
        throw new SQLException("No data with given ID");
    }

    public int getIDbyObject(Address p) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(GET_ID_BY_ADDRESS);
            ps.setString(1, p.getStreetAddress());
            ps.setString(2, p.getCity());
            ps.setString(3, p.getState());
            ps.setInt(4, p.getZipcode());
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
        throw new SQLException("No ID with given object was found");
    }

    public void create(Address p) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setString(1, p.getStreetAddress());
            ps.setString(2, p.getCity());
            ps.setString(3, p.getState());
            ps.setInt(4, p.getZipcode());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().returnConnection(c);
        }
        throw new SQLException("Could not get ID of newly created object");
    }

    public void update(Address p) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(UPDATE);
            ps.setString(1, p.getStreetAddress());
            ps.setString(2, p.getCity());
            ps.setString(3, p.getState());
            ps.setInt(4, p.getZipcode());
            ps.setInt(5, p.getId());
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
