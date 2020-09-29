package group.six.adventurexp;

public class Activity {
    String name;
    double price;
    String description;
    String restriction;



    Activity(String name, double price, String description, String restriction){
        this.name =name;
        this.price = price;
        this.description = description;
        this.restriction = restriction;
    }

    String getName(){
        return name;
    }

    double getPrice(){
        return price;
    }

    String getDescription(){
        return description;
    }
    String getRestriction(){
        return restriction;
    }



    void display(){
        //bruger sout til at printe information om aktiviteten i konsollen
        System.out.println("Aktivitet: " + name);
        //print titlen og prisen
        System.out.println("Pris pr person " + price +"dkk");
        System.out.println(description);
        System.out.println("NOTICE \n" + restriction);
        //print beskrivelsen
    }
}
