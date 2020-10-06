package group.six.adventurexp.repositories;

import group.six.adventurexp.models.Activity;
import group.six.adventurexp.models.Booking;
import group.six.adventurexp.models.DBManager;
import group.six.adventurexp.repositories.interfaces.IBookingRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCBookingRepository implements IBookingRepository {

    @Override
    public boolean create(Booking newItem) { int rowsAffected =0;
        try {
            Connection connection = DBManager.getConnection();

            //public Booking(Activity activity, Date date, int participants, int timeOfDay, String telephoneNumber)
            //String sql = "INSERT INTO activity values( ?, ?, ?, ?)";
            String sql = "INSERT INTO booking (FK_Activity, dato, bookingtime, tlf, participants) values( ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, new JDBCActivityRepository().readByName(newItem.getActivity().getName()).getId());
            statement.setDate(2, java.sql.Date.valueOf(newItem.getDate()));
            statement.setInt(3, newItem.getTimeOfDay());
            statement.setString(4, newItem.getTelephoneNumber());
            statement.setInt(5, newItem.getParticipants());
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            if(e instanceof SQLIntegrityConstraintViolationException){
                //throw new DepartmentException("Department not added");
            }
        }
        return (rowsAffected==1);
    }

    @Override
    public Booking read(int id) {
        try {
            Connection connection = DBManager.getConnection();
            String sql = "SELECT * FROM booking WHERE booking_id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()){ //skal være i rigtig rækkefølge?
                int b_id = rs.getInt("booking_id");
                int actId = rs.getInt("FK_Activity");
                LocalDate date = rs.getDate("Dato").toLocalDate();
                int participants = rs.getInt("participants");
                int timeOfDay = rs.getInt("bookingtime");
                String telephoneNumber = rs.getString("tlf");


                return new Booking(actId, date, participants, timeOfDay, telephoneNumber, b_id);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Booking readByClient(String phone) {
        try {
            Connection connection = DBManager.getConnection();
            String sql = "SELECT * FROM booking WHERE tlf =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, phone);

            ResultSet rs = statement.executeQuery();

            if (rs.next()){ //skal være i rigtig rækkefølge?
                int b_id = rs.getInt("booking_id");
                int actId = rs.getInt("FK_Activity");
                LocalDate date = rs.getDate("Dato").toLocalDate();
                int participants = rs.getInt("participants");
                int timeOfDay = rs.getInt("bookingtime");
                String telephoneNumber = rs.getString("tlf");


                return new Booking(actId, date, participants, timeOfDay, telephoneNumber, b_id);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Booking> readAll(){
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        try {
            Connection connection = DBManager.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM booking"; // NATURAL JOIN dept";
            ResultSet rs = statement.executeQuery(sql); //rammer jeg stålet på databasen
            int b_id;
            LocalDate date;
            int actId;
            int participants;
            String telephoneNumber;
            int timeOfDay;

            while (rs.next()) {

                b_id = rs.getInt("booking_id");
                actId = rs.getInt("FK_Activity");
                date = rs.getDate("Dato").toLocalDate();
                participants = rs.getInt("participants");
                timeOfDay = rs.getInt("bookingtime");
                telephoneNumber = rs.getString("tlf");

                Booking booking = new Booking(actId, date, participants, timeOfDay, telephoneNumber, b_id);
                bookings.add(booking);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
    @Override
    public boolean update(Booking item) {
        int rowsAffected =0;
        try {
            Connection connection = DBManager.getConnection();
            String sql = "UPDATE booking SET FK_Activity=?, Dato=?, bookingtime=?, tlf=?, participants =? WHERE booking_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, new JDBCActivityRepository().readByName(item.getActivity().getName()).getId());
            statement.setDate(2, java.sql.Date.valueOf(item.getDate()));
            statement.setInt(3, item.getTimeOfDay());
            statement.setString(4, item.getTelephoneNumber());
            statement.setInt(5, item.getParticipants());
            statement.setInt(6, item.getId());
            rowsAffected = statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //read by item.id
        //replace the activity found there with item
        return (rowsAffected==1);
    }

    @Override
    public boolean delete(int id) {
        //delete where ID matches ID lol
        int rowsAffected =0;
        try {
            Connection connection = DBManager.getConnection();
            String sql = "DELETE FROM booking WHERE booking_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            rowsAffected = statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (rowsAffected==1);
    }
}
