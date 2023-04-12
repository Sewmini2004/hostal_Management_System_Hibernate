package lk.ijse.hibernate.hostel.dto;

import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.Student;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private String resId;
    private String status;
    private double keyMoney;
    private Double payingAmount;
    private double amountBalance;
    private StudentDTO student;
    private RoomDTO room;
    private Date dateTo;
    private Date dateFrom;
}
