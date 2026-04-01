package entityClasses;
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
    private String assignedTable;

    public StaffAccount(String firstName, String middleName, String lastName, String role, String username,
                        Double hourlyRate, LocalDate birthDate, LocalDate hireDate, String addressNumber,
                        String streetName, String city, String state, String zipcode, String phoneNumber,
                        String emailPersonal, String emailWork, String assignedTable)
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
        this.assignedTable = assignedTable;
    }

    //getters
    public String getFullName() //returns full name of Staffer
    {
        return firstName + " " + middleName + " " + lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmailPersonal()
    {
        return emailPersonal;
    }

    public String getEmailWork()
    {
        return emailWork;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getAddress() //returns full address of Staffer
    {
        return addressNumber + " " + streetName + " " + city + " " + state + " " + zipcode;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public String getUsername()
    {
        return username;
    }

    public String assignedTable()
    {
        return assignedTable;
    }

    //setters
    public void setFirstName(String firstName)
    {
         this.firstName = firstName;
    }

    public void setMiddleName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setHourlyRate(Double hourlyRate)
    {
        this.hourlyRate = hourlyRate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public void setHireDate(LocalDate hireDate)
    {
        this.hireDate = hireDate;
    }

    public void setAddressNumber(String addressNumber)
    {
        this.addressNumber = addressNumber;
    }

    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailPersonal(String emailPersonal)
    {
        this.emailPersonal = emailPersonal;
    }

    public void setEmailWork(String emailWork)
    {
        this.emailWork = emailWork;
    }
}
