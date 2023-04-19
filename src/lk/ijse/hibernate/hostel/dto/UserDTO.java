package lk.ijse.hibernate.hostel.dto;

import lk.ijse.hibernate.hostel.entity.SuperEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private int userId;
    private String Name;
    private String address;
    private String contact;
    private String username;
    private String password;
}
