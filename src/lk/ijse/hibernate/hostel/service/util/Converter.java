package lk.ijse.hibernate.hostel.service.util;

import lk.ijse.hibernate.hostel.dto.ReservationDTO;
import lk.ijse.hibernate.hostel.dto.RoomDTO;
import lk.ijse.hibernate.hostel.dto.StudentDTO;
import lk.ijse.hibernate.hostel.dto.UserDTO;
import lk.ijse.hibernate.hostel.entity.Reservation;
import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.Student;
import lk.ijse.hibernate.hostel.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Converter {

    /* From --- entity > DTO */
    /* To ---  DTO > entity */

    public static StudentDTO fromStudent(Student student) {
        return new StudentDTO(
                student.getStudentId(),
                student.getName(),
                student.getAddress(),
                student.getContactNo(),
                student.getDob(),
                student.getGender(),
                student.getReservations()
        );

    }

    public static Student toStudent(StudentDTO studentDTO) {
        return new Student(
                studentDTO.getStudentId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContactNo(),
                studentDTO.getDob(),
                studentDTO.getGender(),
                studentDTO.getReservations()
        );
    }

    public static RoomDTO fromRoom(Room room) {
        return new RoomDTO(
                room.getRoomTypeId(),
                room.getType(),
                room.getKeyMoney(),
                room.getQty(),
                room.getReservations()
        );
    }

    public static Room toRoom(RoomDTO roomDTO) {
        return new Room(
                roomDTO.getRoomTypeId(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty(),
                roomDTO.getReservations()
        );
    }

    public static ReservationDTO fromReservation(Reservation reservation) {
        return new ReservationDTO(
                reservation.getResId(),
                reservation.getStatus(),
                reservation.getKeyMoney(),
                reservation.getPayingAmount(),
                reservation.getAmountBalance(),
                fromStudent(reservation.getStudent()),
                fromRoom(reservation.getRoom()),
                reservation.getDateFrom(),
                reservation.getDateTo()
        );
    }

    //oya hdnn eka taya eka manika
    public static Reservation toReservation(ReservationDTO reservationDTO) {
        return new Reservation(
                reservationDTO.getResId(),
                reservationDTO.getStatus(),
                reservationDTO.getKeyMoney(),
                reservationDTO.getPayingAmount(),
                reservationDTO.getAmountBalance(),
                toStudent(reservationDTO.getStudent()),
                toRoom(reservationDTO.getRoom()),
                reservationDTO.getDateFrom(),
                reservationDTO.getDateTo()
        );

    }

    public static UserDTO fromUser(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getName(),
                user.getAddress(),
                user.getContact(),
                user.getUsername(),
                user.getPassword()
        );
    }

    public static User toUser(UserDTO user) {
        return new User(
                user.getUserId(),
                user.getName(),
                user.getAddress(),
                user.getContact(),
                user.getUsername(),
                user.getPassword()
        );
    }
}




