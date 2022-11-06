package kr.masirou.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DatabaseConnector<T> {
    public T execute(PreparedStatement s) throws SQLException;

}
