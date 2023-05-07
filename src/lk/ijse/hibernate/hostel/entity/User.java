package lk.ijse.hibernate.hostel.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements SuperEntity{
    @Id
    private int userId;
    private String Name;
    private String address;
    private String contact;
    private String username;
    private String password;

}
