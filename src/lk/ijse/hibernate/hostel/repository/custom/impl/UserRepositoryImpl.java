package lk.ijse.hibernate.hostel.repository.custom.impl;

import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.User;
import lk.ijse.hibernate.hostel.repository.custom.RoomRepository;
import lk.ijse.hibernate.hostel.repository.custom.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> getAll(Session session) throws Exception {
        Query from_user_ = session.createQuery("from User ");
        from_user_.setCacheable(true);
        return from_user_.getResultList();
    }

    @Override
    public String add(User obj, Session session) throws Exception {
        int save = (int) session.save(obj);
        return String.valueOf(save);
    }

    @Override
    public void delete(String id, Session session) throws Exception {
        User load = session.load(User.class, Integer.parseInt(id));
        session.delete(load);
    }

//    itin ain wenw att e room eke ee id ek ain weddi nee pana mge reservation ekk dmama ain krnn be room ekkwth student knkwth manika man  wenwd dnne pddk blmu eka
    @Override
    public void update(User obj, Session session) throws Exception {
        session.update(obj);
    }

    @Override
    public User search(String id, Session session) throws Exception {
        try {
            return session.get(User.class, Integer.parseInt(id));
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public boolean isExists(String id, Session session) throws Exception {
        session.get(Room.class, Integer.parseInt(id));
        return true;
    }

}
