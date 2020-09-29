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
    }

    public void EmployeeUI() {
        Logo();
        Scanner sc = new Scanner(System.in);
        String scannerInput = sc.next();
        System.out.println("You have the following options:");
        System.out.println("1. Show Activities | 2. Create Activity | 3.Edit Activities | 4.Delete Activities");
        switch (scannerInput){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
        }
    }
}

