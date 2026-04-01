package entityClasses;

import java.util.Scanner;
import java.text.DecimalFormat;
import javafx.scene.image.Image;

public class MenuItem {
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.00");

    private String itemName;
    private String allergens;
    private static String category;
    private double price;
    private Image image;
    private int id;
    private static int nextId = 0;

    public MenuItem(String itemName, int id, double price) {
        this.itemName = itemName;
        this.id = nextId;
        this.nextId++;
        this.price = price;
    }

    //getters
    public String getItemName() {
        return itemName;
    }

    //setters
    public void setCategory() {
        System.out.print("To which category does this item belong?\n\tEntree\tSide\tBurger\tSandwhich\tAppetizer\tSalad\tBeverage");
        String c = sc.nextLine();
        this.category = c;
    }
    public void setPrice(double p) {
        this.price = p;
    }
    public void setAllergens(String a) {
        this.allergens = a;
    }
    public void setImage(Image i){
        this.image = i;
    }

    public String toString(){
        return itemName + " : $" + df.format(price);
    }

}
