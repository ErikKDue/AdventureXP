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

        while(true) {
            System.out.println("You have the following options:");
            System.out.println("1. Show Activities | 2. Create Activity | 3.Edit Activities | 4.Delete Activities | 0.Exit Application");

            String scannerInput = sc.next();

            switch (scannerInput) {
                case "1":
                    System.out.println("Vis");
                    break;
                case "2":
                    System.out.println("create");
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

