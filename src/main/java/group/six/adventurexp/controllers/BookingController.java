package group.six.adventurexp.controllers;


import group.six.adventurexp.models.Activity;
import group.six.adventurexp.models.Booking;
import group.six.adventurexp.repositories.JDBCActivityRepository;
import group.six.adventurexp.repositories.JDBCBookingRepository;
import group.six.adventurexp.repositories.interfaces.IActivityRepository;
import group.six.adventurexp.repositories.interfaces.IBookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Controller
public class BookingController {

    private IBookingRepository bookingRepository;
    private IActivityRepository activityRepository;

    public BookingController(){bookingRepository = new JDBCBookingRepository();
        activityRepository = new JDBCActivityRepository();

    }

    @GetMapping("bookings/book")
    public String booking(Model model)
    {
        model.addAttribute("activities", activityRepository.readAll());
        return "bookings/book";
    }

    @GetMapping("bookings/booking")
    public String bookingList(Model model)
    {
        model.addAttribute("bookings", bookingRepository.readAll());
        return "bookings/booking";
    }

    @PostMapping("bookings/create")
    public String createBooking(WebRequest request) throws ParseException {

        int activityid = Integer.parseInt(request.getParameter("activity")) - 1;
        String param2 = request.getParameter("booking-date");
        //Date date = new SimpleDateFormat("yyyy-MM-dd").parse(param2);
        LocalDate date = LocalDate.parse(param2);//("yyyy-MM-dd").parse(param2);
        int participants = Integer.parseInt(request.getParameter("participants"));
        int timeOfDay = Integer.parseInt(request.getParameter("time"));
        String telephoneNumber = request.getParameter("telephone");

        Booking booking = new Booking(activityRepository.read(activityid), date, participants, timeOfDay, telephoneNumber);

        bookingRepository.create(booking);

        return "redirect:/bookings/book";
    }
}