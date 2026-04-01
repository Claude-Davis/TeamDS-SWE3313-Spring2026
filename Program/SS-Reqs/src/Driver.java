import java.util.ArrayList;
import java.util.Scanner;

import classes.StaffAccount;

public class Driver {
        public static void main(String[] args) {

            ArrayList<StaffAccount> all_Staff = new ArrayList<>();  //this arraylist stores all staff profiles, aka StaffAccount objects
            ArrayList<StaffAccountKey> all_Keys = new ArrayList<>();  //this arraylist stores all staff passwords
            
            Scanner sc = new Scanner(System.in);
            ArrayList<loginValidation> loginValidations = new ArrayList();
            int option = -1;

            do {
                System.out.println("1-Staff account");
                System.out.println("2-Sign up");
                System.out.println("3-Login");
                System.out.println("Chose option: ");
                option = sc.nextInt();

                switch (option) {
                    case 3:
                        System.out.println("Enter Username: ");
                        String userName = sc.nextLine();
                        System.out.println("Enter password: ");
                        String password = sc.nextLine();
                        loginValidation login = new loginValidation(userName, password);
                        login.Validation();
                        loginValidations.add(login);
                        System.out.println(login.toString());
                }
            
            } while(option != 4);
       }
}
