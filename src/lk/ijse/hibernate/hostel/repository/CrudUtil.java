package lk.ijse.hibernate.hostel.repository;

import lk.ijse.hibernate.hostel.entity.SuperEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public interface CrudUtil<T extends SuperEntity> extends SuperRepo{
    public List<T> getAll(Session session) throws Exception;
    public String add(T obj,Session session) throws Exception;
    public void delete(String id,Session session) throws Exception;
    public void update(T obj,Session session) throws Exception;
    public T search(String id,Session session) throws Exception;
    public boolean isExists(String id,Session session) throws Exception;


}
