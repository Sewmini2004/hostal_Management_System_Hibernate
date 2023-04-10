package lk.ijse.hibernate.hostel.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Room implements SuperEntity{
    @Id
    private String roomTypeId;
    private String type;
    private double keyMoney;
    private int qty;
    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reservation> reservations;


}
