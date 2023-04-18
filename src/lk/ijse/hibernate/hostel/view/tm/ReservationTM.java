package lk.ijse.hibernate.hostel.view.tm;

import lombok.*;

import javax.persistence.Id;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ReservationTM {
    @Id
    private String resId;
    private double keyMoney;
    private double payingAmount;
    private String studentId;
    private String name;
    private String roomTypeId;
    private String type;


}
