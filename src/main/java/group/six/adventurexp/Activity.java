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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
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

    void setRestriction(String input){
        this.restriction = input;
    }
    String getRestriction(){
        return restriction;
    }



    void display(){
        //bruger sout til at printe information om aktiviteten i konsollen
        System.out.println("");
        System.out.println("Aktivitet: " + name);
        //print titlen og prisen
        System.out.println("Pris pr person " + price +"dkk");
        System.out.println(description);
        if (restriction != null && !restriction.equals("")) {
            System.out.println("BEMÆRK \n" + restriction);
        }
        System.out.println("");
        //print beskrivelsen
    }
}
