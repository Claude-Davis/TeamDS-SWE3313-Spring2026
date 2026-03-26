package Program.SSReqs.src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStaffManagement {

    public static StaffAccount createProfile(ArrayList<StaffAccount> allStaff) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Manager Staff Management ===");
        System.out.println("Create Profile");
        System.out.println();

        // Required fields
        System.out.print("First Name: ");
        String firstName = sc.nextLine().trim();

        System.out.print("Middle Name (optional): ");
        String middleName = sc.nextLine().trim();

        System.out.print("Last Name: ");
        String lastName = sc.nextLine().trim();

        System.out.print("Job Position (Chef, Waiter, Busboy, Manager): ");
        String role = sc.nextLine().trim();

        System.out.print("Hourly Rate: ");
        double hourlyRate = Double.parseDouble(sc.nextLine().trim());

        System.out.print("Assigned Work Email: ");
        String emailWork = sc.nextLine().trim();

        System.out.print("Assigned Username: ");
        String username = sc.nextLine().trim();

        // Optional fields
        System.out.print("Birthdate (YYYY-MM-DD) or leave blank: ");
        String birthDateInput = sc.nextLine().trim();
        LocalDate birthDate = birthDateInput.isEmpty() ? null : LocalDate.parse(birthDateInput);

        System.out.print("Hire Date (YYYY-MM-DD) or leave blank: ");
        String hireDateInput = sc.nextLine().trim();
        LocalDate hireDate = hireDateInput.isEmpty() ? null : LocalDate.parse(hireDateInput);

        System.out.print("Personal Email or leave blank: ");
        String emailPersonal = sc.nextLine().trim();

        System.out.print("Phone Number or leave blank: ");
        String phoneNumber = sc.nextLine().trim();

        System.out.print("Address Number or leave blank: ");
        String addressNumber = sc.nextLine().trim();

        System.out.print("Street Name or leave blank: ");
        String streetName = sc.nextLine().trim();

        System.out.print("City or leave blank: ");
        String city = sc.nextLine().trim();

        System.out.print("State or leave blank: ");
        String state = sc.nextLine().trim();

        System.out.print("Zipcode or leave blank: ");
        String zipcode = sc.nextLine().trim();

        // Waiter-only required field
        String assignedTable = "";
        if (role.equalsIgnoreCase("Waiter")) {
            do {
                System.out.print("Assigned Table (required for Waiter): ");
                assignedTable = sc.nextLine().trim();

                if (assignedTable.isEmpty()) {
                    System.out.println("Error: Waiters must be assigned a table.");
                }
            } while (assignedTable.isEmpty());
        }

        // Create the staff account
        StaffAccount newStaff = new StaffAccount(
                firstName,
                middleName,
                lastName,
                role,
                username,
                hourlyRate,
                birthDate,
                hireDate,
                addressNumber,
                streetName,
                city,
                state,
                zipcode,
                phoneNumber,
                emailPersonal,
                emailWork,
                assignedTable
        );

        allStaff.add(newStaff);

        System.out.println();
        System.out.println("Profile created successfully.");
        System.out.println(newStaff);

        return newStaff;
    }
}
