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
                    String name = scanner.nextLine();
                    double price = scanner.nextDouble();
                    String description = scanner.nextLine();
                    String restriction = scanner.nextLine();
                    Activity activity = new Activity(name, price, description, restriction);
                    crud.create(activity);
                    break;
                case "3":
                    System.out.println("edit");
                    break;
                case "4":
                    System.out.println("delete");
                    break;
                case "0":
                    System.exit(0);
                    break;
            }

        }
    }
}

