package group.six.adventurexp;

import group.six.adventurexp.martin.Aktivitet;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BrugerUI {
    public static void main(String[] args) {
        // write your code here
        CRUD crud = new CRUD();

        ArrayList<Activity> aktiviteter = new  ArrayList<>(Arrays.asList(
                new Activity("GoKart",500, "Kør rundt på vores fede GoKart bane, i vores super hurtige og sjove GoKarts!", "Du skal være 16 år gammel, og mindst 1,50m høj"),
                new Activity("Paint Ball", 750, "Skyd dine venner i fjæset med maling", "Du skal være 18 år gammel, der er ingen højde begrænsning"),
                new Activity("Mini Golf", 900, "Bliv frustreret over dine dårlige evner til at spille mini golf, og lad dine aggresioner gå ud over din familie", "Der er ingen krav")
        ));


        Scanner scan = new Scanner(System.in);
        System.out.println("Velkommen til Adventure XP! (slogan her)");
        System.out.println("Tast 1 for intern bruger eller 0 for ekstern bruger");

        while (true) {

            if (scan.hasNext("1")) {
                //System.out.println("Ansat");
                UI ui = new UI();
                ui.EmployeeUI();

                scan.nextLine();
            } else if (scan.hasNext("0")) {

                for (int i = 0; i < aktiviteter.size(); i++) {
                    aktiviteter.get(i).display();
                }


                scan.nextLine();
            } else {
                System.out.println("Ugyldigt input; prøv igen.");
                scan.nextLine();
            }
        }

    }

}