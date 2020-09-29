package group.six.adventurexp;


import java.util.Scanner;

public class UI {

    public void Logo() {
        System.out.print("\n" +
                "Welcome To: \n" +
         "  $$$$$$\\         $$\\                                    $$\\                                       $$\\                                  $$\\  \n" +
         "$$   __$$\\        $$ |                                    $$ |                                       $$ |                                  $$ | \n" +
         "$$ /   $$ |   $$$$$$$ |$$\\   $$\\ $$$$$$\\    $$$$$$$\\ $$$$$$\\   $$\\  $$\\ $$$$$$\\   $$$$$$\\    $$ |         $$$$$$\\    $$$$$$$\\    $$$$$$$ | \n" +
         "$$$$$$$$$ |  $$  __$$ |\\$$\\$$   |$$  __$$\\  $$  __$$\\\\$$  _|   $$ |  $$ | $$ __$$\\  $$  __$$\\  $$ |         \\___$$\\   $$  __$$\\   $$  __$$ | \n" +
         "$$   __$$ |  $$ /  $$ | \\$$\\$$ / $$$$$$$$ |  $$ |  $$ |  $$ |     $$ |  $$ | $$  \\__|  $$$$$$$$|   $$ |         $$$$$$$   | $$ |  $$  |  $$ /  $$ | \n" +
         "$$  |  $$ |  $$ |  $$ |  \\$$$  /  $$   ____|  $$ |  $$ |  $$ |$$ \\$$ |  $$ | $$  |      $$   ___|   $$ |        $$  __$$   | $$ |  $$  |  $$ |  $$ | \n" +
         "$$  |  $$ | \\$$$$$$$ |   \\$  /  \\$$$$$$$\\  $$ |  $$ | \\$$$$ | \\$$$$$$  | $$  |    \\$$$$$$$\\   $$$$$$$$\\ \\$$$$$$$   | $$ |  $$  | \\$$$$$$$ | \n" +
         "\\__|  \\__| \\_______|    \\_/    \\_______| \\__| \\__| \\____/   \\______/  \\__|     \\_______|  \\________| \\_______|   \\__|  \\__|  \\_______|");
        System.out.println();
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

