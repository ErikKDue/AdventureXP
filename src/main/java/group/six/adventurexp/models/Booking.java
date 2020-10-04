package group.six.adventurexp.models;

import java.util.Date;

public class Booking {

    public Activity activity;
    Date date;
    public int participants;
    int timeOfDay;
    String telefoneNumber;

    public Booking(Activity activity, Date date, int participants, int timeOfDay, String telephoneNumber) {
        this.activity = activity;
        this.date = date;
        this.participants = participants;
        this.timeOfDay = timeOfDay;
        this.telefoneNumber = telephoneNumber;
    }

    public String getTelefoneNumber() {
        return telefoneNumber;
    }

    public void setTelefoneNumber(String telefoneNumber) {
        this.telefoneNumber = telefoneNumber;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public String toString()
    {
        return activity + " " + date + " " + " " + participants + " " + timeOfDay + " " + telefoneNumber;
    }
}
