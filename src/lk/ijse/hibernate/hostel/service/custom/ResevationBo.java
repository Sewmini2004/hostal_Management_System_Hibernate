package lk.ijse.hibernate.hostel.service.custom;

import lk.ijse.hibernate.hostel.dto.ReservationDTO;
import lk.ijse.hibernate.hostel.dto.StudentDTO;
import lk.ijse.hibernate.hostel.service.util.SuperBo;

import java.sql.SQLException;
import java.util.List;

public interface ResevationBo extends SuperBo {
    public List<ReservationDTO> getAll() throws Exception;
    public boolean add(ReservationDTO reservationDTO) throws Exception;
    public boolean delete(String id) throws Exception;
    public boolean update(ReservationDTO reservationDTO) throws Exception;
    public ReservationDTO search(String id) throws Exception;
    public boolean isExists(String id) throws Exception;
    public String generateNextId() throws Exception;

}
