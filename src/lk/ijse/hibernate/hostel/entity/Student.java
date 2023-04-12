package lk.ijse.hibernate.hostel.entity;
import lombok.*;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
//ko methn ar object ek hdla thynne kohed manika mt pennanko
public class Student implements SuperEntity{
    @Id
    private String studentId;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String address;
    private String contactNo;
    private Date dob;
    private String gender;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reservation> reservations;


}
