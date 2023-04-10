package lk.ijse.hibernate.hostel.dto;
import lk.ijse.hibernate.hostel.entity.Reservation;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class StudentDTO {
    private String studentId;
    private String name;
    private String address;
    private String contactNo;
    private Date dob;
    private String gender;
    private List<Reservation> reservations;
}
