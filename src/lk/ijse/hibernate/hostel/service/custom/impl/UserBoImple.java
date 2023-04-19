package lk.ijse.hibernate.hostel.service.custom.impl;

import lk.ijse.hibernate.hostel.dto.RoomDTO;
import lk.ijse.hibernate.hostel.dto.UserDTO;
import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.User;
import lk.ijse.hibernate.hostel.repository.RepoFactory;
import lk.ijse.hibernate.hostel.repository.custom.UserRepository;
import lk.ijse.hibernate.hostel.service.custom.UserBo;
import lk.ijse.hibernate.hostel.service.util.Converter;
import lk.ijse.hibernate.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserBoImple implements UserBo {
    private final UserRepository userRepository = RepoFactory.getInstance().getRepo(RepoFactory.Repo.USER);

    //oy tk dgen ynn manika
    @Override
    public List<UserDTO> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        List<User> all = userRepository.getAll(session);
        ArrayList<UserDTO> list = new ArrayList<>();
        for (User user : all) {
            list.add(Converter.fromUser(user));
        }
        return list;
    }

    @Override
    public boolean add(UserDTO userDTO) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String add = userRepository.add(Converter.toUser(userDTO), session);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(int id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        userRepository.delete(String.valueOf(id), session);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(UserDTO userDTO) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        userRepository.update(Converter.toUser(userDTO), session);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public UserDTO search(int id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        UserDTO userDTO = Converter.fromUser(userRepository.search(String.valueOf(id), session));
        transaction.commit();
        session.close();
        return userDTO;

    }

    @Override
    public boolean isExists(int id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        userRepository.search(String.valueOf(id), session);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public int generateNextId() throws Exception {
        List<UserDTO> all = getAll();
        if (all.size() > 0) {
            return all.get(all.size() - 1).getUserId() + 1;
        } else {
            return 1;
        }
    }
}
