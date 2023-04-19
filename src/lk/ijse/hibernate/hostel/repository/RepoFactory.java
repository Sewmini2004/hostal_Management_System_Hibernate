package lk.ijse.hibernate.hostel.repository;

import lk.ijse.hibernate.hostel.repository.custom.impl.ReservationRepositoryImpl;
import lk.ijse.hibernate.hostel.repository.custom.impl.RoomRepositoryImpl;
import lk.ijse.hibernate.hostel.repository.custom.impl.StudentRepositoryImpl;
import lk.ijse.hibernate.hostel.repository.custom.impl.UserRepositoryImpl;
import lk.ijse.hibernate.hostel.util.FactoryConfiguration;
import org.hibernate.Session;

public class RepoFactory {
    private static RepoFactory repoFactory;
    private Session session = FactoryConfiguration.getInstance().getSession();

    private RepoFactory() {

    }

    public static RepoFactory getInstance() {
        return repoFactory == null ? repoFactory = new RepoFactory() : repoFactory;
    }

    public enum Repo {
        STUDENT, ROOM, RESEVATION, USER
    }

    public <T extends SuperRepo> T getRepo(Repo repo) {
        switch (repo) {
            case USER:
                return (T) new UserRepositoryImpl();
            case STUDENT:
                return (T) new StudentRepositoryImpl();
            case ROOM:
                return (T) new RoomRepositoryImpl();
            case RESEVATION:
                return (T) new ReservationRepositoryImpl();
            default:
                return null;

        }


    }
}
