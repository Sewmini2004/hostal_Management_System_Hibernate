package lk.ijse.hibernate.hostel.dto;

import lk.ijse.hibernate.hostel.embaded.ReservationTimePeriod;
import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.Student;
import lombok.*;

import java.util.List;
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
    private Student student;
    private Room room;
    private List<ReservationTimePeriod> reservationTimePeriods;
}
