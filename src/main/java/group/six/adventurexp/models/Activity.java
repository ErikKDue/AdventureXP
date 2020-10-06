package group.six.adventurexp.models;

public class Activity {
    public int id;
    String name;
    double price;
    String description;
    String restriction;



    public Activity(int id, String name, double price, String description, String restriction){
        this.id =id;
        this.name =name;
        this.price = price;
        this.description = description;
        this.restriction = restriction;
    }

    public Activity(String name, double price, String description, String restriction) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.restriction = restriction;
    }

    public void setId(int id){ this.id = id;}

    public int getId(){return id;}

    public void setName(String name) { this.name = name; }

    public void setPrice(double price) { this.price = price; }

    public void setDescription(String description) { this.description = description; }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public String getDescription(){
        return description;
    }

    public void setRestriction(String input){
        this.restriction = input;
    }

    public String getRestriction(){
        return restriction;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                "name=" + name +
                ", price='" + price +
                ", description='" + description +
                ", restriction=" + restriction +
                '}';
    }

    public void display(){
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
