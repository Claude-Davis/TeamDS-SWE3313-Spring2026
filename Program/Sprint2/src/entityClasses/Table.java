package entityClasses;


import java.util.ArrayList;
import java.util.Scanner;

public class Table {
    Scanner sc = new Scanner(System.in);

    String tableId;
    StaffAccount waiter;
    ArrayList<Seat> seats = new ArrayList<>();
    boolean jointStatus = false;

    public Table (String id) {
        this.tableId = id;
    }


    //nested class
    //each table is assigned seats
    public class Seat {
        String seatId;
        ArrayList<Order> orders;

        public Seat(String seatId){
            this.seatId = seatId;
        }

        //getter for Seat
        public String getId() {
            return seatId;
        }

        /* write a method to create an object of class Order
            this object is saved to the seats ArrayList
        */
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    //getter Table
    public String getTableId() {
        return tableId;
    }

    //setters
    public void setWaiter() {
        System.out.print("Who do you want to assign to Table " + tableId + "?\n\t");
        String waiterName = sc.nextLine();

        //locate StaffAccount object with matching name attributes of waiterName value
        for (int i; i<=staff.size(); i++) {
            if (waiterName.equals(staff(i).getFullName())) {
                StaffAccount s = staff(i);
            }
        }
        this.waiter = s;
    }
    public void addOneSeat() {
        System.out.println("Provide the location (in relation to the table) of the seat to be added. ");
        String seatId = sc.nextLine();

        //creates an object of nested Seat class
        Seat s = new Seat(seatId);

        (this.seats).add(s);
    }
    public void removeOneSeat() {
        System.out.println("Provide the location (in relation to the table) of the seat to be removed. ");
        String seatId = sc.nextLine();

        //locates the specific seat
        for (int i=0; i<=seats.size(); i++) {
            if (seatId.equals(seats(i).getId())) {
                seats.remove(i);
            }
        }
    }
    public void addSeatSet(ArrayList<Seat> seatSet) {
        (this.seats).addAll(seatSet);
    }
    public void updateJointStatusTrue() {
        this.jointStatus = true;
    }
    public void updateJointStatusFalse() {
        this.jointStatus = false;
    }
}
