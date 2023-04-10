package lk.ijse.hibernate.hostel.dto;

import lk.ijse.hibernate.hostel.entity.Reservation;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String roomTypeId;
    private String type;
    private double keyMoney;
    private int qty;
    private List<Reservation> reservations;

}
