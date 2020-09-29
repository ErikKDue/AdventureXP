package group.six.adventurexp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CRUD {

    ArrayList<Activity> aktiviteter = new  ArrayList<>(Arrays.asList(
            new Activity("GoKart",500, "Kør rundt på vores fede GoKart bane, i vores super hurtige og sjove GoKarts!", "Du skal være 16 år gammel, og mindst 1,50m høj"),
            new Activity("Paint Ball", 750, "Skyd dine venner i fjæset med maling", "Du skal være 18 år gammel, der er ingen højde begrænsning"),
            new Activity("Mini Golf", 900, "Bliv frustreret over dine dårlige evner til at spille mini golf, og lad dine aggresioner gå ud over din familie", "Der er ingen krav")
    ));

    public void create(Activity activity)
    {
        aktiviteter.add(activity);
    }

    public ArrayList read()
    {
        return aktiviteter;
        //Erik: Det virker  fjollet at have vores basale read-metode til at fremvise resultatet til brugeren. Det er et UI-ansvar.
       /* for(int i = 0; i < aktiviteter.size(); i++)
        {
            //bruger sout til at printe information om aktiviteten i konsollen
            System.out.println("");
            System.out.println("Aktivitet: " + aktiviteter.get(i).getName());
            //print titlen og prisen
            System.out.println("Pris pr person " + aktiviteter.get(i).getPrice() +"dkk");
            System.out.println(aktiviteter.get(i).getDescription());
            if (aktiviteter.get(i).getRestriction() != null && !aktiviteter.get(i).getRestriction().equals("")) {
                System.out.println("BEMÆRK \n" + aktiviteter.get(i).getRestriction());
            }
            System.out.println("");
            //print beskrivelsen
        }*/
    }

    public void delete(int i)
    {
        aktiviteter.remove(i - 1);
    }




}
