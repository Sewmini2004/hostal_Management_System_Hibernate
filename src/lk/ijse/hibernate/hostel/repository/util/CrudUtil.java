package lk.ijse.hibernate.hostel.repository.util;

import lk.ijse.hibernate.hostel.entity.SuperEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface CrudUtil<T extends SuperEntity> extends SuperRepo{
    public List<T> getAll(Session session) throws SQLException, ClassNotFoundException;
    public String add(T obj,Session session) throws SQLException, ClassNotFoundException;
    public boolean delete(String id,Session session) throws SQLException, ClassNotFoundException;
    public boolean update(T obj,Session session) throws SQLException, ClassNotFoundException;
    public T search(String id,Session session) throws SQLException, ClassNotFoundException;
    public boolean isExists(String id,Session session) throws SQLException, ClassNotFoundException;


}
