package lk.ijse.hibernate.hostel.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Transactional
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Reservation implements SuperEntity {
    @Id
    private String resId;
    private String status;
    private double keyMoney;
    private double payingAmount;
    private double amountBalance;
    @ManyToOne()
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//    @JoinColumn(referencedColumnName = "studentId")
    private Student student;

    @ManyToOne()
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//    @JoinColumn(referencedColumnName = "roomTypeId")
    private Room room;
    private Date dateTo;
    private Date dateFrom;

}
