
import entityClasses.Table;
import java.util.ArrayList;
import java.util.Scanner;
;

public class TableManagement {
    static ArrayList<Table> tables = new ArrayList<>(); //stores all table objects
    static ArrayList<Table> joinedTables = new ArrayList<>(); /* stores the Table objects that represent
                                                             individual tables that have ben combined/joined */
    public static void main(String[] args) {
        
        //all tables
        Table a1 = new Table("A1");
        Table a2 = new Table("A2");
        Table a3 = new Table("A3");
        Table a4 = new Table("A4");
        Table a5 = new Table("A5");
        Table a6 = new Table("A6");

        Table b1 = new Table("B1");
        Table b2 = new Table("B2");
        Table b3 = new Table("B3");
        Table b4 = new Table("B4");
        Table b5 = new Table("B5");
        Table b6 = new Table("B6");

        Table c1 = new Table("C1");
        Table c2 = new Table("C2");
        Table c3 = new Table("C3");
        Table c4 = new Table("C4");
        Table c5 = new Table("C5");
        Table c6 = new Table("C6");

        Table d1 = new Table("D1");
        Table d2 = new Table("D2");
        Table d3 = new Table("D3");
        Table d4 = new Table("D4");
        Table d5 = new Table("D5");
        Table d6 = new Table("D6");

        Table e1 = new Table("E1");
        Table e2 = new Table("E2");
        Table e3 = new Table("E3");
        Table e4 = new Table("E4");
        Table e5 = new Table("E5");
        Table e6 = new Table("E6");

        Table f1 = new Table("F1");
        Table f2 = new Table("F2");
        Table f3 = new Table("F3");
        Table f4 = new Table("F4");
        Table f5 = new Table("F5");
        Table f6 = new Table("F6");

        //add Table objects to tables ArrayList
        tables.add(a1);
        tables.add(a2);
        tables.add(a3);
        tables.add(a4);
        tables.add(a5);
        tables.add(a6);

        tables.add(b1);
        tables.add(b2);
        tables.add(b3);
        tables.add(b4);
        tables.add(b5);
        tables.add(b6);
        
        tables.add(c1);
        tables.add(c2);
        tables.add(c3);
        tables.add(c4);
        tables.add(c5);
        tables.add(c6);

        tables.add(d1);
        tables.add(d2);
        tables.add(d3);
        tables.add(d4);
        tables.add(d5);
        tables.add(d6);

        tables.add(e1);
        tables.add(e2);
        tables.add(e3);
        tables.add(e4);
        tables.add(e5);
        tables.add(e6);

        tables.add(f1);
        tables.add(f2);
        tables.add(f3);
        tables.add(f4);
        tables.add(f5);
        tables.add(f6);


        /* Provide a button to initiate the joinTables method */
        /* Provide a button to initiate the separateTables method */
    }

    public void joinTables(int numberOfTables) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tableNames = new ArrayList<>();
        ArrayList<Table> chosenTables = new ArrayList<>();

        System.out.println("Enter which tables you wish to join together:");
        for (int i=0; i<=numberOfTables; i++) {
            String table = sc.nextLine();
            tableNames.add(table);
        }

        //identifies the table objects based on the provided input/table IDs and stores the tables to be joined to chosenTables list
        for (int i=0; i<=numberOfTables; i++) {
            String tableId = tableNames.get(i);
            for (int j=0; j<=tables.size(); j++) {
                Table object = tables.get(j);
                if (tableId.equals(object.getTableId())) {
                    chosenTables.add(object);
                }
            }
        }

        /* join the identified tables by removing the individual Table objects from the tables list,
        adding those objects to the joinedTables list (for future use to separate the tables),
        creating a new Table object that is given a combined tableId, combines the seats list for each object involved,
        and calls the updatedJointStatusTrue() method
        */
        String jointTableId = "J";
        ArrayList<Table.Seat> jointSeats = new ArrayList<>();
            //
        for (int i=0; i<=chosenTables.size(); i++) {
            Table object = chosenTables.get(i);
            tables.remove(object); //removes the table(s) being combined from the tables ArrayList
            jointTableId += "-" + object.getTableId();
            jointSeats.addAll(object.getSeats());
        }
            //
        Table joinedTable = new Table(jointTableId);
        joinedTable.addSeatSet(jointSeats);
        joinedTable.updateJointStatusTrue();
        tables.add(joinedTable);  //adds the newly combined Table object to the tables list
    }

    public Table separateTables() {
        /* This method should allow the manager to select a joined table,
        allow the system to confirm that the table is a joined table,
        and allow the manager to separate the table into its original tables by
        removing the joined table from the tables ArrayList and
        returning the appropriate individual Table objects to the tables ArrayList */
    }
}
