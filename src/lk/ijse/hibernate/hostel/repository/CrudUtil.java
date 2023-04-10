package lk.ijse.hibernate.hostel.repository;

import lk.ijse.hibernate.hostel.entity.SuperEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
//mken exception throw wenn hdnn Exception kyn ekt manika okkom exception ahu weno ekai ek danne hdee

public interface CrudUtil<T extends SuperEntity> extends SuperRepo{
    public List<T> getAll(Session session) throws SQLException, ClassNotFoundException;
    public String add(T obj,Session session) throws SQLException, ClassNotFoundException;
    public void delete(String id,Session session) throws Exception;
    public void update(T obj,Session session) throws SQLException, ClassNotFoundException;
    public T search(String id,Session session) throws SQLException, ClassNotFoundException;
    public boolean isExists(String id,Session session) throws Exception;


}
