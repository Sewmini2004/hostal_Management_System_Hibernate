package lk.ijse.hibernate.hostel.repository.custom.impl;

import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.Student;
import lk.ijse.hibernate.hostel.repository.custom.RoomRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {
    @Override
    public List<Room> getAll(Session session) throws SQLException, ClassNotFoundException {
        return session.createQuery("from Room").getResultList();
    }

    @Override
    public String add(Room obj, Session session) throws SQLException, ClassNotFoundException {
        String save = (String) session.save(obj);
        return save;
    }

    @Override
    public void delete(String id, Session session) throws SQLException, ClassNotFoundException {
        session.delete(id);
    }

    @Override
    public void update(Room obj, Session session) throws SQLException, ClassNotFoundException {
        session.update(obj);
    }

    @Override
    public Room search(String id, Session session) throws SQLException, ClassNotFoundException {
        try {
            return session.get(Room.class, id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public boolean isExists(String id, Session session) throws Exception {
        session.get(Room.class, id);
        return true;
    }

}
