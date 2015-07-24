package _bionic_university._6_cash_management_system.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface EntityDao<T> {

    List<T> selectAll() throws SQLException, IOException;

    void create(T object) throws SQLException, IOException;

    T selectById(int id) throws SQLException, IOException;

    void updateById(T object, int id) throws SQLException, IOException;

    void deleteById(int id) throws SQLException, IOException;
}
