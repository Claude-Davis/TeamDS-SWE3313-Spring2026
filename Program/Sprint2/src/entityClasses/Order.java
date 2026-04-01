package entityClasses;

import java.util.ArrayList;
import java.util.Scanner;
import sprint2.src.entityClasses.MenuItem;

public class Order {
    Scanner sc = new Scanner(System.in);

    private int id;
    private int nextId;
    private double TAX_RATE;
    private double SERVICE_FEE;
    private double basePrice;   //before tax is applied
    private double price;  //after tax is applied
    private ArrayList<MenuItem> items;

    public Order(ArrayList<String> orderItems) {
        //identifies each MenuItem object based on the provided item name and adds the object to the items list
        for (int i=0; i<=orderItems.size(); i++) {
            String item = orderItems(i);

            for (int j=0; j<=menu.size(); j++) {
                if (item.equals(menu(j).getItemName())) {
                    (this.items).add(item);
                }
            }
        }
        this.id = nextId;
        this.nextId++;
    }

    //price calculations
    public double calculatePrice() {
        boolean applyFee = false;

        System.out.println("Is it a holiday week?");
        String holiday = (sc.nextLine()).toLowerCase();
        System.out.println("Is this an organized event?");
        String event = (sc.nextLine()).toLowerCase();

        if (holiday.equals("y") ||
            holiday.equals( "yes") ||
            event.equals("y") ||
            event.equals("yes")) {
            this.basePrice += SERVICE_FEE;
        }

        this.price = basePrice + (basePrice*TAX_RATE);
        return this.price;
    }
}
