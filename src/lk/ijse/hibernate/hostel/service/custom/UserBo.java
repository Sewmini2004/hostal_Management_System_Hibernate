package lk.ijse.hibernate.hostel.service.custom;

import lk.ijse.hibernate.hostel.dto.RoomDTO;
import lk.ijse.hibernate.hostel.dto.UserDTO;
import lk.ijse.hibernate.hostel.service.util.SuperBo;

import java.util.List;

public interface UserBo extends SuperBo {
    public List<UserDTO> getAll() throws Exception;
    public boolean add(UserDTO userDTO) throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean update(UserDTO userDTO) throws Exception;
    public UserDTO search(int id) throws Exception;
    public boolean isExists(int id) throws Exception;
    public int generateNextId() throws Exception;

}
