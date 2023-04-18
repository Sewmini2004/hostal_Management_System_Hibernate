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
    public List<Room> getAll(Session session) throws Exception {
        return session.createQuery("from Room").getResultList();
    }

    @Override
    public String add(Room obj, Session session) throws Exception {
        String save = (String) session.save(obj);
        return save;
    }

    @Override
    public void delete(String id, Session session) throws Exception {
        /*
        //mem nthuw krnonam manika api mthent delete krnn ona table ekta e objct ekk hdlne ywnn ona em krnonam
        Room room = new Room();//mem object ekk hdnne hibernate wlt mon table ekt kyla thorgnna
        room.setRoomTypeId(id);//ekt id ek dnne manikamon row ekkd dlt krnnona kyla blgnn hrida ek thrunda blnna pana ow
        session.delete(room);
*/
        Room load = session.load(Room.class, id);
        //mek thrunda?ow
        session.delete(load);
    }

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
