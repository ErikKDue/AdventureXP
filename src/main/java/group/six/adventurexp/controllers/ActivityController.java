package group.six.adventurexp.controllers;

import group.six.adventurexp.models.Activity;
import group.six.adventurexp.repositories.InMemoryActivityRepository;
import group.six.adventurexp.repositories.JDBCActivityRepository;
import group.six.adventurexp.repositories.interfaces.IActivityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivityController {

    private IActivityRepository activityRepository;

   public ActivityController(){activityRepository = new JDBCActivityRepository(); }

    @GetMapping("/activities")
    public String activities(Model model)
    {
        model.addAttribute("activities", activityRepository.readAll());
        return "activities/activities";
   }

    @GetMapping("activities/createActivity")
    public String newActivity(){return "activities/createActivity";}

    @PostMapping("/createActivity")
    public String createActivity(@ModelAttribute Activity activity)
    {
        activityRepository.create(activity);
        return "redirect:/activities";
    }


    @GetMapping("/editActivity")
    public String editActivity(@RequestParam String id, Model model)
    {   // info fra anmodende side uddrages
        int _id = Integer.parseInt(id);

        Activity activity = activityRepository.read(_id);
        model.addAttribute("activity", activity);

        return "activities/editActivity";
    }

    @PostMapping("/updateActivity")
    public String update(@ModelAttribute Activity activity){
        activityRepository.update(activity);
        return "redirect:/activities";
    }


    @GetMapping("/deleteActivity")
    public String delete(@RequestParam String id, Model deleteModel)
    {
        deleteModel.addAttribute("activity", activityRepository.read(Integer.parseInt(id)));

        return "activities/deleteActivity";
    }

    @PostMapping("/deleteActivity")
    public String deleteActivity(@RequestParam int id, Model model)
    {
        model.addAttribute("activities", activityRepository.delete(id));
        return "redirect:/activities";
    }
}
