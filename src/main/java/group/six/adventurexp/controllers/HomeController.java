package group.six.adventurexp.controllers;

import group.six.adventurexp.models.Activity;
import group.six.adventurexp.repositories.InMemoryActivityRepository;
import group.six.adventurexp.repositories.interfaces.IActivityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private IActivityRepository activityRepository;

    public HomeController(){activityRepository = new InMemoryActivityRepository();}

    @GetMapping("/")
    public String home(){return "index";}

    @GetMapping("/booking")
    public String booking(){return "booking";}

    @GetMapping("/activities")
    public String activities(Model model){
         model.addAttribute("activities", activityRepository.readAll());
        return "activities";}
}
