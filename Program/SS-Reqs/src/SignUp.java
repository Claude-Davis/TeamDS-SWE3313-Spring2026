package Program.SSReqs.src;

import java.util.Scanner;


public class SignUp {
    public static String account_sign_up(){
        Scanner sc = new Scanner(System.in);
    //after user clicks "Sign Up"

        //request user info                                                         //
        System.out.println("First Name");
        String firstName = sc.nextLine();

        System.out.println("Last Name ");
        String lastName = sc.nextLine();

        //display job position/role selection (GUI dropdown menu)                     //
        System.out.println("Select Your Role: ");
        String[] job_Positions = {"Chef", "Waiter", "Busboy", "Manager"};  //declare role options
        for (int i=0; i<4; i++){
            System.out.println(job_Positions[i]);
        }

        //user selects role [....from dropdown menu]
        String role = sc.nextLine();



        //request user info pt2                                                        //
        System.out.println("Username");
        String username = sc.nextLine();

        System.out.println("Password ");
        String password = sc.nextLine();
        
        //verify user info                                      //
            // search arraylist of staff, "all_Staff", for object with matching first name, last name, and username
        for (int i=0; i<all_Staff.size(); i++){
            StaffAccount x = all_Staff.get(i);
            //check first name
            if (x.get_firstName == firstName){
                System.out.println("good");
            } else {
                System.out.println("Invalid first name entry");}
            //check last name
            if (x.get_lastName == lastName){
                System.out.println("good");
            } else{
                System.out.println("Invalid last name entry");}
            //check username
            x.username_check(username);
        }

        //check password validity                              //
        for (int i=0; i<all_keys.size(); i++){
            StaffAccountKey x = all_keys.get(i);
            x.password_check(password);
        }

        return firstName + "\n" + lastName + "\n" + role + "\n" + username + "\n" + password;


    }

    public static void main(String[] args) {
        System.out.print(account_sign_up());
    }
}