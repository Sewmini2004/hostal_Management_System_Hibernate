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
public class User implements SuperEntity{
    @Id
    private int userId;
    private String Name;
    private String address;
    private String contact;
    private String username;
    private String password;

}
