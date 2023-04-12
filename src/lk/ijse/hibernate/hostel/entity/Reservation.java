package lk.ijse.hibernate.hostel.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private String status;
    private double keyMoney;
    private double payingAmount;
    private double amountBalance;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "studentId")
    private Student student;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "roomTypeId")
    private Room room;
    private Date dateTo;
    private Date dateFrom;

}
