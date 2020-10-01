package group.six.adventurexp.repositories;

import group.six.adventurexp.models.Activity;
import group.six.adventurexp.repositories.interfaces.IActivityRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryActivityRepository implements IActivityRepository {

    int idCount;

    private List<Activity> inMemoryDatabase;

    public InMemoryActivityRepository(){

        idCount = 1;

        this.inMemoryDatabase = new ArrayList<Activity>(
                Arrays.asList(
                        new Activity(idCount++,"GoKart",500, "Kør rundt på vores fede GoKart bane, i vores super hurtige og sjove GoKarts!", "Du skal være 16 år gammel, og mindst 1,50m høj"),
                        new Activity(idCount++,"Paint Ball", 750, "Skyd dine venner i fjæset med maling", "Du skal være 18 år gammel, der er ingen højde begrænsning"),
                        new Activity(idCount++,"Mini Golf", 900, "Bliv frustreret over dine dårlige evner til at spille mini golf, og lad dine aggresioner gå ud over din familie", "Der er ingen krav")
                )
        );
    }
    @Override
    public boolean create(Activity activity) {

        activity.id = idCount++;

        inMemoryDatabase.add(activity);
        return true;
    }

    @Override
    public Activity read(int id) {
        for(Activity act : inMemoryDatabase){
            if(act.getId() == id){
                return act;
            }
        }
        return null;
    }

    @Override
    public List<Activity> readAll() {
        return inMemoryDatabase;
    }

    @Override
    public boolean update(Activity activity) {

        System.out.println("Attempting to update activity:\n"+activity);

        for(int i = 0; i < inMemoryDatabase.size(); i++)
        {
            if(inMemoryDatabase.get(i).id == activity.id)
            {
                inMemoryDatabase.set(i, activity);
                System.out.println("Activity imprinted:\n"+activity);
            }
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        inMemoryDatabase.remove(id-1);
        return false;
    }

}
