package lk.ijse.hibernate.hostel.dto;

import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.Student;

import java.util.Date;

public class ReservationDTO {
    private String resId;
    private Date date;
    private String status;
    private Student student;
    private Room room;

}
