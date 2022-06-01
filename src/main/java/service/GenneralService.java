package service;

import model.HocSinh;

import java.sql.SQLException;
import java.util.List;

public interface GenneralService <T> {
    public List<T> findAll();

    public void add(HocSinh t) throws Exception;

    public T findById(int id);

    public boolean update (HocSinh t) throws SQLException;

    public boolean delete (int id) throws SQLException;

}
