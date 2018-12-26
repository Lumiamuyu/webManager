package Lumiamuyu.utilTest;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMap<T> {
    public T RowMapping(ResultSet resultSet) throws SQLException;
}
