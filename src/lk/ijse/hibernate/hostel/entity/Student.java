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

    public Student(String studentId, String name, String address, String contactNo, Date dob, String gender) {
        this.studentId=studentId;
        this.name=name;
        this.address=address;
        this.contactNo=contactNo;
        this.dob=dob;
        this.gender=gender;
    }


}
