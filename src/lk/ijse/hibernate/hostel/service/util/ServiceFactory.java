package lk.ijse.hibernate.hostel.service.util;
import lk.ijse.hibernate.hostel.service.custom.impl.ReservationBoImple;
import lk.ijse.hibernate.hostel.service.custom.impl.RoomBoImple;
import lk.ijse.hibernate.hostel.service.custom.impl.StudentBoImple;


public class ServiceFactory {

       private static ServiceFactory serviceFactory;

        private ServiceFactory() {

        }
    public static ServiceFactory getInstance() {
        return serviceFactory == null ? serviceFactory = new ServiceFactory() : serviceFactory;
    }


        public enum ServiceType {
            STUDENT, ROOM, RESEVATION
        }

        public < T extends SuperBo> T getService(ServiceType serviceType) {
            switch (serviceType) {
                case STUDENT:
                    return (T) new StudentBoImple();
                case ROOM:
                    return (T) new RoomBoImple();
                case RESEVATION:
                    return (T) new ReservationBoImple();
                default:
                    return null;

            }


        }
    }

