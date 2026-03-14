import java.time.LocalDate; //utilizing java's time library to create date datatypes

public class StaffAccount
{
    private String firstName;
    private String middleName;
    private String lastName;
    private String role;
    private String username;
    private Double hourlyRate;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String addressNumber;
    private String streetName;
    private String city;
    private String state;
    private String zipcode;
    private String phoneNumber;
    private String emailPersonal;
    private String emailWork;

    public StaffAccount(String firstName, String middleName, String lastName, String role, String username,
                        Double hourlyRate, LocalDate birthDate, LocalDate hireDate, String addressNumber,
                        String streetName, String city, String state, String zipcode, String phoneNumber,
                        String emailPersonal, String emailWork)
    {
        this.firstName = firstName; //uses "this" keyword to differentiate between the instance variables and local variables
        this.middleName = middleName;
        this.lastName = lastName;
        this.role = role;
        this.username = username;
        this.hourlyRate = hourlyRate;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.addressNumber = addressNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.emailPersonal = emailPersonal;
        this.emailWork = emailWork;
    }

    public String getFullName() //returns full name of Staffer
    {
        return firstName + " " + middleName + " " + lastName;
    }
}