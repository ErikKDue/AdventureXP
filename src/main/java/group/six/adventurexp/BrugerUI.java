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
        UI ui = new UI();

        Scanner scan = new Scanner(System.in);
        System.out.println("Velkommen til Adventure XP! (slogan her)");
        System.out.println("Tast 1 for intern bruger eller 0 for ekstern bruger");

        while (true) {

            if (scan.hasNext("1")) {
                //System.out.println("Ansat");

                ui.EmployeeUI();

                scan.nextLine();
            } else if (scan.hasNext("0")) {
                ui.EmployeeUI();


                scan.nextLine();
            } else {
                System.out.println("Ugyldigt input; prøv igen.");
                scan.nextLine();
            }
        }

    }

}