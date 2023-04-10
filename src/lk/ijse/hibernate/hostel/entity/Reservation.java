package lk.ijse.hibernate.hostel.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Reservation implements SuperEntity {
    @Id
    private String resId;
    private Date date;
    private String status;
    private double keyMoney;
    private Double payingAmount;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "studentId")
    private Student student;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "roomTypeId")
    private Room room;


}
