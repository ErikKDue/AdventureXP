package group.six.adventurexp.models;

import group.six.adventurexp.repositories.JDBCActivityRepository;

import java.time.LocalDate;
import java.util.Date;

public class Booking {
    int id;
    public Activity activity;
    LocalDate date;
    public int participants;
    int timeOfDay;
    String telephoneNumber;


    public Booking(String activity_name, LocalDate date, int participants, int timeOfDay, String telephoneNumber) {
        this.activity = new JDBCActivityRepository().readByName(activity_name);
        this.date = date;
        this.participants = participants;
        this.timeOfDay = timeOfDay;
        this.telephoneNumber = telephoneNumber;
    }

    public Booking(int activity_id, LocalDate date, int participants, int timeOfDay, String telephoneNumber, int booking_id) {
        this.activity = new JDBCActivityRepository().read(activity_id);
        this.date = date;
        this.participants = participants;
        this.timeOfDay = timeOfDay;
        this.telephoneNumber = telephoneNumber;
        this.id = booking_id;
    }

    public Booking(Activity activity, LocalDate date, int participants, int timeOfDay, String telephoneNumber) {
        this.activity = activity;
        this.date = date;
        this.participants = participants;
        this.timeOfDay = timeOfDay;
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(int timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getId() {
        return id;
    }

    public String toString()
    {
        return activity + " " + date + " " + " " + participants + " " + timeOfDay + " " + telephoneNumber;
    }
}
