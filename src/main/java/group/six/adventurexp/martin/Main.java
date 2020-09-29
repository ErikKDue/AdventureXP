package group.six.adventurexp.martin;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        ArrayList<Aktivitet> aktiviteter = new  ArrayList<>(Arrays.asList(
                new Aktivitet(500, "GoKart", "Kør rundt på vores fede GoKart bane, i vores super hurtige og sjove GoKarts!", "Du skal være 16 år gammel, og mindst 1,50m høj"),
                new Aktivitet(750, "Paint Ball", "Skyd dine venner i fjæset med maling", "Du skal være 18 år gammel, der er ingen højde begrænsning"),
                new Aktivitet(300, "Mini Golf", "Bliv frustreret over dine dårlige evner til at spille mini golf, og lad dine aggresioner gå ud over din familie", "Der er ingen krav")
        ));


        for(int i = 0; i < aktiviteter.size(); i++)
        {
            System.out.println(aktiviteter.get(i).toString());
        }


    }


}
