package com.solvd.bankclasses.daoclasses.implemented;

import com.solvd.bankclasses.daoclasses.IPeopleDAO;
import com.solvd.bankclasses.utilities.ConnectionPool;
import org.apache.log4j.Logger;
import com.solvd.bankclasses.people.People;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDAO implements IPeopleDAO<People> {
    private static final Logger LOGGER = Logger.getLogger(ContactDAO.class.getName());
    private static final String GET_BY_ID = "SELECT * FROM com.solvd.bankclasses.people WHERE id = ?;";
    private static final String GET_ID_BY_PERSON = "SELECT * FROM com.solvd.bankclasses.people WHERE firstName = ? AND lastName = ? AND personType = ?;";
    private static final String INSERT = "INSERT INTO com.solvd.bankclasses.people (firstName, lastName, personType) VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE com.solvd.bankclasses.people SET firstName = ?, lastName = ?, personType = ? WHERE id = ?;";

    @Override
    public People getObjectByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                People person = new People(rs.getString("firstName"), rs.getString("lastName"),
                        rs.getInt("personType"));
                person.setId(id);
                return person;
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
    public int getIDbyObject(People person) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(GET_ID_BY_PERSON);
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setInt(3, person.getPersonType());
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
    public int create(People person) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setInt(3, person.getPersonType());
            ps.executeUpdate();
            return getIDbyObject(person);
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
    public void update(People person) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(UPDATE);
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setInt(3, person.getPersonType());
            ps.setInt(4, person.getId());
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
