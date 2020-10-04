package group.six.adventurexp.models;

import java.util.Date;

public class Booking {

    public Activity activity;
    Date date;
    public int participants;

    public Booking(Activity activity, Date date, int participants) {
        this.activity = activity;
        this.date = date;
        this.participants = participants;
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
        return activity + " " + date + " " + " " + participants;
    }
}
