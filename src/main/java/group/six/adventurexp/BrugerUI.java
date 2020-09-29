package group.six.adventurexp;

import group.six.adventurexp.martin.Aktivitet;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BrugerUI {
    public static void main(String[] args) {
        // write your code here


        ArrayList<Aktivitet> aktiviteter = new  ArrayList<>(Arrays.asList(
                new Aktivitet(500, "GoKart", "Kør rundt på vores fede GoKart bane, i vores super hurtige og sjove GoKarts!", "Du skal være 16 år gammel, og mindst 1,50m høj"),
                new Aktivitet(750, "Paint Ball", "Skyd dine venner i fjæset med maling", "Du skal være 18 år gammel, der er ingen højde begrænsning"),
                new Aktivitet(300, "Mini Golf", "Bliv frustreret over dine dårlige evner til at spille mini golf, og lad dine aggresioner gå ud over din familie", "Der er ingen krav")
        ));




        Scanner scan = new Scanner(System.in);

        if (scan.hasNext("1")) {
            System.out.println("Ansat");
            //Arraylist ind her



            scan.nextLine();
        }
        if (scan.hasNext("0")){
            System.out.println("Aktiviteter");
            //Arraylist ind her
            for(int i = 0; i < aktiviteter.size(); i++)
            {
                System.out.println(aktiviteter.get(i).toString());
            }

            scan.nextLine();
        }




    }



}
