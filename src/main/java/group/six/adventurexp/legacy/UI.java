/*
package group.six.adventurexp;


import group.six.adventurexp.models.Activity;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    public void Logo() {
        System.out.print("\n" +
                "Welcome To: \n" +

                "                  /$$                                 /$$                                         /$$                           /$$\n"+
                "                 | $$                                | $$                                        | $$                          | $$\n"+
                "    /$$$$$$  /$$$$$$$ /$$    /$$ /$$$$$$  /$$$$$$$  /$$$$$$   /$$   /$$  /$$$$$$   /$$$$$$       | $$  /$$$$$$  /$$$$$$$   /$$$$$$$\n"+
                "  |____  $$ /$$__  $$|  $$  /$$//$$__  $$| $$__  $$|_  $$_/  | $$  | $$ /$$__  $$ /$$__  $$      | $$ |____  $$| $$__  $$ /$$__  $$\n"+
                "   /$$$$$$$| $$  | $$ \\  $$/$$/| $$$$$$$$| $$  \\ $$  | $$    | $$  | $$| $$  \\__/| $$$$$$$$      | $$  /$$$$$$$| $$  \\ $$| $$  | $$\n"+
                "  /$$__  $$| $$  | $$  \\  $$$/ | $$_____/| $$  | $$  | $$ /$$| $$  | $$| $$      | $$_____/      | $$ /$$__  $$| $$  | $$| $$  | $$\n"+
                " |  $$$$$$$|  $$$$$$$   \\  $/  |  $$$$$$$| $$  | $$  |  $$$$/|  $$$$$$/| $$      |  $$$$$$$      | $$|  $$$$$$$| $$  | $$|  $$$$$$$\n"+
                " \\_______/ \\_______/    \\_/    \\_______/|__/  |__/   \\___/   \\______/ |__/       \\_______/      |__/ \\_______/|__/  |__/ \\_______/\n");
    }

    public void customerUI() {
    Scanner sc = new Scanner(System.in);
    CRUD crud = new CRUD();

        while(true) {
            System.out.println("You have the following options:");
            System.out.println("1. Show Activities | 0.Exit Application");

            String scannerInput = sc.next();

            switch (scannerInput) {
                case "1":
                    System.out.println("Vis");

                    ArrayList<Activity> aktiviteter = crud.read();
                    for(int i = 0; i < aktiviteter.size(); i++)
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
                    }
                    break;
                case "0":
                    System.exit(0);
                    break;
            }
        }
    }

    public void EmployeeUI() {
        Scanner sc = new Scanner(System.in);
        CRUD crud = new CRUD();

        while(true) {
            System.out.println("You have the following options:");
            System.out.println("1. Show Activities | 2. Create Activity | 3.Edit Activities | 4.Delete Activities | 0.Exit Application");

            String scannerInput = sc.next();

            switch (scannerInput) {
                case "1":
                    System.out.println("Vis");
                    ArrayList<Activity> aktiviteter = crud.read();
                    for(int i = 0; i < aktiviteter.size(); i++)
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
                    }
                    break;
                case "2":
                    System.out.println("create");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter name");
                    String name = scanner.nextLine();
                    System.out.println("Enter description");
                    String description = scanner.nextLine();
                    System.out.println("enter restriction(s)");
                    String restriction = scanner.nextLine();
                    System.out.println("Enter price");
                    double price = scanner.nextDouble();
                   // String description = scanner.nextLine();
                    System.out.println(name + price + description +restriction);
                    Activity activity = new Activity(name, price, description, restriction);
                    crud.create(activity);
                    break;
                case "3":
                    System.out.println("edit");

                    ArrayList<Activity> readAktiviteter = crud.read();
                    for(int i = 0; i < readAktiviteter.size(); i++)
                    {
                        System.out.println("Aktivitet " + i +": " + readAktiviteter.get(i).getName());
                    }
                    //for each print i+activity.name
                    //select by number
                    System.out.println("Please enter the number of the activity you wish to edit");

                    int selection = sc.nextInt();
                    boolean stillEditing = true;
                    Activity tempActivity = readAktiviteter.get(selection);
                    while (stillEditing){
                        System.out.println("1: " +tempActivity.getName());
                        System.out.println("2: "+tempActivity.getPrice());
                        System.out.println("3: "+tempActivity.getDescription());
                        System.out.println("4: "+tempActivity.getRestriction());
                        System.out.println("0: Done editing");
                        System.out.println("");
                        System.out.println("Please enter the number of the attribute you wish to edit");
                        int attSelect = sc.nextInt();
                        sc.nextLine(); //Må IKKE fjernes. nextInt() placerer scannerens cursor bag ved inten, så første gang man ber om nextLine
                        // efter nextInt får man bare \n, (med mindre linjen var noget i retning af "5 ord")


                        switch (attSelect) {
                            case 1:
                                System.out.println("Enter new name");
                                tempActivity.setName(sc.nextLine());
                                break;
                            case 2:
                                System.out.println("Enter new price (commas for decimal)");
                                tempActivity.setPrice(sc.nextDouble());
                                break;
                            case 3:
                                System.out.println("Enter new description");
                                tempActivity.setDescription(sc.nextLine());
                                break;
                            case 4:
                                System.out.println("Enter new restrictions");
                                tempActivity.setRestriction(sc.nextLine());
                                break;
                            case 0:
                                stillEditing = false;
                                break;
                        }
                    }

                    break;
                case "4":
                    System.out.println("delete");
                    crud.delete(sc.nextInt());
                    break;
                case "0":
                    System.exit(0);
                    break;
            }

        }
    }
}
*/
