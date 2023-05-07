package lk.ijse.hibernate.hostel.service.util;
import lk.ijse.hibernate.hostel.service.custom.impl.*;


public class ServiceFactory {

       private static ServiceFactory serviceFactory;

        private ServiceFactory() {

        }
    public static ServiceFactory getInstance() {
        return serviceFactory == null ? serviceFactory = new ServiceFactory() : serviceFactory;
    }


        public enum ServiceType {
            STUDENT, ROOM, RESEVATION, USER, CUSTOM
        }

        public < T extends SuperBo> T getService(ServiceType serviceType) {
            switch (serviceType) {
                case CUSTOM:
                    return (T) new CustomBOImple();
                case USER:
                    return (T) new UserBoImple();
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

