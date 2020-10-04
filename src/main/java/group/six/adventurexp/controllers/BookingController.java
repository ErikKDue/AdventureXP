package group.six.adventurexp.controllers;


import group.six.adventurexp.models.Activity;
import group.six.adventurexp.models.Booking;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Controller
public class BookingController {

    ArrayList<Activity> activities = new  ArrayList<>(Arrays.asList(
            new Activity(1, "GoKart",500, "Kør rundt på vores fede GoKart bane, i vores super hurtige og sjove GoKarts!", "Du skal være 16 år gammel, og mindst 1,50m høj"),
            new Activity(2, "Paint Ball", 750, "Skyd dine venner i fjæset med maling", "Du skal være 18 år gammel, der er ingen højde begrænsning"),
            new Activity(3,"Mini Golf", 900, "Bliv frustreret over dine dårlige evner til at spille mini golf, og lad dine aggresioner gå ud over din familie", "Der er ingen krav")));



    @GetMapping("bookings/book")
    public String booking(Model model)
    {
        model.addAttribute("activities", activities);
        return "bookings/book";
    }

    @PostMapping("bookings/create")
    public String createBooking(WebRequest request) throws ParseException {

        ArrayList<Booking> bookings = new ArrayList<>();

        int activityid = Integer.parseInt(request.getParameter("activity")) - 1;
        String param2 = request.getParameter("booking-date");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(param2);
        int participants = Integer.parseInt(request.getParameter("participants"));
        int timeOfDay = Integer.parseInt(request.getParameter("time"));
        String telephoneNumber = request.getParameter("telephone");

        Booking booking = new Booking(activities.get(activityid), date, participants, timeOfDay, telephoneNumber);
        bookings.add(booking);

        for (int i = 0; i < bookings.size(); i++)
        {
            System.out.println(bookings.get(i).toString());
        }

        return "redirect:/bookings/book";
    }
}
