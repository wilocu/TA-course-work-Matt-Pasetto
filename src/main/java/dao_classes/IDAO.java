package dao_classes;

import java.sql.SQLException;

interface IDAO<T> {
    public T getObjectByID(int id) throws SQLException;

    public int getIDbyObject(T t) throws SQLException;

    public void create(T t) throws SQLException;

    public void update(T t) throws SQLException;
}
