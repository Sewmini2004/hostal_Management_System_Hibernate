package lk.ijse.hibernate.hostel.service.custom.impl;

import lk.ijse.hibernate.hostel.dto.ReservationDTO;
import lk.ijse.hibernate.hostel.entity.Reservation;
import lk.ijse.hibernate.hostel.repository.RepoFactory;
import lk.ijse.hibernate.hostel.repository.custom.ReservationRepository;
import lk.ijse.hibernate.hostel.service.custom.ReservationBo;
import lk.ijse.hibernate.hostel.service.util.Converter;
import lk.ijse.hibernate.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ReservationBoImple implements ReservationBo {
    private final ReservationRepository reservationRepository = RepoFactory.getInstance().getRepo(RepoFactory.Repo.RESEVATION);

    @Override
    public List<ReservationDTO> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        List<Reservation> all = reservationRepository.getAll(session);
        ArrayList<ReservationDTO> list = new ArrayList<>();
        for (Reservation reservation : all) {
            list.add(Converter.fromReservation(reservation));
        }
        session.close();
        return list;
    }

    @Override
    public boolean add(ReservationDTO reservationDTO) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();
        String add = reservationRepository.add(Converter.toReservation(reservationDTO), session);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();
        reservationRepository.delete(id, session);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(ReservationDTO reservationDTO) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();
        reservationRepository.update(Converter.toReservation(reservationDTO), session);
        transaction.commit();
        session.close();
        return true;
    }


    @Override
    public ReservationDTO search(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();
        ReservationDTO reservationDTO = Converter.fromReservation(reservationRepository.search(id, session));
        transaction.commit();
        session.close();
        return reservationDTO;
    }

    @Override
    public boolean isExists(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        reservationRepository.search(id, session);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String generateNextId() throws Exception {
        List<ReservationDTO> all = getAll();
        if (all.size() > 0) {
            String resId = all.get(all.size() - 1).getResId();
            String[] split = resId.split("[R]");
            int i = Integer.parseInt(split[1]);
            i++;
            return String.format("R%08d", i);
        } else {
            return "R00000001";
        }
    }
}
