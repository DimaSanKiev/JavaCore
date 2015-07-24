package _bionic_university._6_cash_management_system.dao;

import java.sql.SQLException;
import java.util.List;

public interface EntityDao<T> {

    List<T> selectAll() throws SQLException;

    void create(T object) throws SQLException;

    T readById(int id) throws SQLException;

    void updateById(T object, int id) throws SQLException;

    int deleteById(int id) throws SQLException;
}
