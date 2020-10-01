/*
package group.six.adventurexp;
import group.six.adventurexp.legacy.CRUD;

import java.util.Scanner;

 public class BrugerUI {
    public static void main(String[] args) {
        // write your code here
        CRUD crud = new CRUD();
        UI ui = new UI();

        Scanner scan = new Scanner(System.in);
        ui.Logo();
        System.out.println("Tast 1 for Employee eller 0 for Customer");

        while (true) {

            if (scan.hasNext("1")) {
                //System.out.println("Ansat");

                ui.EmployeeUI();

                scan.nextLine();
            } else if (scan.hasNext("0")) {
                ui.customerUI();


                scan.nextLine();
            } else {
                System.out.println("Ugyldigt input; prøv igen.");
                scan.nextLine();
            }
        }

    }
} */