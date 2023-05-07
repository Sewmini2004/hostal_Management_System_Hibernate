package lk.ijse.hibernate.hostel.repository.custom.impl;

import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.Student;
import lk.ijse.hibernate.hostel.repository.custom.RoomRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {
    @Override
    public List<Room> getAll(Session session) throws Exception {
        Query from_room = session.createQuery("from Room");
        from_room.setCacheable(true);
        return from_room.getResultList();
    }

    @Override
    public String add(Room obj, Session session) throws Exception {
        String save = (String) session.save(obj);
        return save;
    }

    @Override
    public void delete(String id, Session session) throws Exception {
        Room load = session.load(Room.class, id);
        session.delete(load);
    }

//    itin ain wenw att e room eke ee id ek ain weddi nee pana mge reservation ekk dmama ain krnn be room ekkwth student knkwth manika man  wenwd dnne pddk blmu eka
    @Override
    public void update(Room obj, Session session) throws Exception {
        session.update(obj);
    }

    @Override
    public Room search(String id, Session session) throws Exception {
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
