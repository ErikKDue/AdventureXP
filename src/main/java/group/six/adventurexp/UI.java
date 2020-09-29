package group.six.adventurexp;


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

    public void EmployeeUI() {
        Logo();
        Scanner sc = new Scanner(System.in);
        CRUD crud = new CRUD();

        while(true) {
            System.out.println("You have the following options:");
            System.out.println("1. Show Activities | 2. Create Activity | 3.Edit Activities | 4.Delete Activities | 0.Exit Application");

            String scannerInput = sc.next();

            switch (scannerInput) {
                case "1":
                    System.out.println("Vis");
                    crud.read();
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

                    //for each print i+activity.name
                    //select by number
                    //while boolean stillEditing
                    //print all attributes
                    //print list of attributes

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

