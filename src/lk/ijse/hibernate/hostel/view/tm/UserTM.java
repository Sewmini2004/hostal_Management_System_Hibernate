package lk.ijse.hibernate.hostel.view.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserTM {
    private int userId;
    private String Name;
    private String address;
    private String contact;
    private String username;
    private String password;
}
