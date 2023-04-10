package lk.ijse.hibernate.hostel.service.util;

import lk.ijse.hibernate.hostel.dto.ReservationDTO;
import lk.ijse.hibernate.hostel.dto.RoomDTO;
import lk.ijse.hibernate.hostel.dto.StudentDTO;
import lk.ijse.hibernate.hostel.entity.Reservation;
import lk.ijse.hibernate.hostel.entity.Room;
import lk.ijse.hibernate.hostel.entity.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Converter {
/* From --- entity > DTO */
/* To ---  DTO > entity */

 public  StudentDTO fromStudent(Student student){
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
 public  Student toStudent(StudentDTO studentDTO){
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
 public  RoomDTO fromRoom(Room room){
  return new RoomDTO(
          room.getRoomTypeId(),
          room.getType(),
          room.getKeyMoney(),
          room.getQty(),
          room.getReservations()
  );
 }

 public  Room toRoom(RoomDTO roomDTO){
  return new Room(
          roomDTO.getRoomTypeId(),
          roomDTO.getType(),
          roomDTO.getKeyMoney(),
          roomDTO.getQty(),
          roomDTO.getReservations()
  );
 }


 public  ReservationDTO fromReservation(Reservation reservation){
  return new ReservationDTO(
          reservation.getResId(),
          reservation.getDate(),
          reservation.getStatus(),
          reservation.getKeyMoney(),
          reservation.getPayingAmount(),
          reservation.getStudent(),
          reservation.getRoom()
    );
 }

 public  Reservation toReservation(ReservationDTO reservationDTO){
  return new Reservation(
          reservationDTO.getResId(),
          reservationDTO.getDate(),
          reservationDTO.getStatus(),
          reservationDTO.getKeyMoney(),
          reservationDTO.getPayingAmount(),
          reservationDTO.getStudent(),
          reservationDTO.getRoom()
  );

 }
}
