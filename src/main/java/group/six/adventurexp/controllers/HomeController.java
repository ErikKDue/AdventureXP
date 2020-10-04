package group.six.adventurexp.controllers;

import group.six.adventurexp.models.Activity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
public class HomeController {

    public HomeController(){}

    public String home(){return "index";}

}
