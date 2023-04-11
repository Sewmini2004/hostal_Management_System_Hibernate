package lk.ijse.hibernate.hostel.entity;

import lk.ijse.hibernate.hostel.embaded.ReservationTimePeriod;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Reservation implements SuperEntity {
    @Id
    private String resId;
    private String status;
    private double keyMoney;
    private double payingAmount;
    private double amountBalance;
    @ElementCollection
    @CollectionTable(
            name = "reservation_period",
            joinColumns = @JoinColumn(name = "res_Id")
    )
    private List<ReservationTimePeriod> reservationTimePeriods;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "studentId")
    private Student student;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "roomTypeId")
    private Room room;


}
