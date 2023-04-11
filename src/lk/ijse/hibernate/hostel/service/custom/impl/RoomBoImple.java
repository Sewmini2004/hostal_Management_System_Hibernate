package lk.ijse.hibernate.hostel.service.custom.impl;

import lk.ijse.hibernate.hostel.dto.RoomDTO;
import lk.ijse.hibernate.hostel.dto.StudentDTO;
import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.Student;
import lk.ijse.hibernate.hostel.repository.RepoFactory;
import lk.ijse.hibernate.hostel.repository.custom.RoomRepository;
import lk.ijse.hibernate.hostel.repository.custom.StudentRepository;
import lk.ijse.hibernate.hostel.service.custom.RoomBo;
import lk.ijse.hibernate.hostel.service.util.Converter;
import lk.ijse.hibernate.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RoomBoImple implements RoomBo {
    private final RoomRepository roomRepository = RepoFactory.getInstance().getRepo(RepoFactory.Repo.ROOM);
    Session session = FactoryConfiguration.getInstance().getSession();
    @Override
    public List<RoomDTO> getAll() throws Exception {
        List<Room> all =roomRepository.getAll(session);
        ArrayList<RoomDTO> list = new ArrayList<>();
        for (Room room: all) {
            list.add(Converter.fromRoom(room));
        }
        return list;
    }

    @Override
    public boolean add(RoomDTO roomDTO) throws Exception {
        Transaction transaction = session.beginTransaction();
        String add = roomRepository.add(Converter.toRoom(roomDTO), session);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Transaction transaction = session.beginTransaction();
       roomRepository.delete(id, session);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(RoomDTO roomDTO) throws Exception {
        Transaction transaction = session.beginTransaction();
        roomRepository.update(Converter.toRoom(roomDTO), session);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public RoomDTO search(String id) throws Exception {
        Transaction transaction = session.beginTransaction();
        RoomDTO roomDTO = Converter.fromRoom(roomRepository.search(id, session));
        transaction.commit();
        session.close();
        return roomDTO;

    }

    @Override
    public boolean isExists(String id) throws Exception {
        Transaction transaction = session.beginTransaction();
        roomRepository.search(id, session);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String generateNextId() throws Exception {
        List<RoomDTO> all = getAll();
        if (all.size() > 0) {
            String roomTypeId = all.get(all.size() - 1).getRoomTypeId();
            String[] split = roomTypeId.split("[R]");
            int i = Integer.parseInt(split[1]);
            i++;
            return String.format("R%08d", i);
        } else {
            return "R00000001";
        }
    }
}
