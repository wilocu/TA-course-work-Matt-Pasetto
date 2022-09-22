package dao_classes;

import Utilities.ConnectionPool;
import people.Contact;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDAO implements IDAO<Contact>{
    private static final Logger LOGGER = Logger.getLogger(ContactDAO.class.getName());
    private static final String GET_BY_ID = "SELECT * FROM contacts WHERE id = ?;";
    private static final String GET_ID_BY_CONTACT = "SELECT * FROM contacts WHERE personID = ? AND email = ? AND phone_number = ?;";
    private static final String INSERT = "INSERT INTO contacts (personID, email, phone_number) VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE contacts SET personID = ?, email = ?, phone_number = ? WHERE id = ?;";

    @Override
    public Contact getObjectByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact(rs.getInt(1), rs.getString("email"),
                        rs.getString("phone_number"));
                contact.setId(id);
                return contact;
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
    public int getIDbyObject(Contact contact) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(GET_ID_BY_CONTACT);
            ps.setInt(1, contact.getPersonId());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getPhoneNumber());
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
    public void create(Contact contact) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setInt(1, contact.getPersonId());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getPhoneNumber());
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
    public void update(Contact contact) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(UPDATE);
            ps.setInt(1, contact.getPersonId());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getPhoneNumber());
            ps.setInt(4, contact.getId());
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
