package group.six.adventurexp;

import java.util.Scanner;

public class CRUD {

    public Activity Create()
    {
        double price;
        String name;
        String description;
        String restrictions;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv pris");
        price = scanner.nextDouble();
        System.out.println("Skriv navn");
        name = scanner.nextLine();
        System.out.println("Skriv beskrivelse");
        description = scanner.nextLine();
        System.out.println("Skriv krav");
        restrictions = scanner.nextLine();

        Activity act = new Activity(name, price, description, restrictions);

        return act;

    }


}
