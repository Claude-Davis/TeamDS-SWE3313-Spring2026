package sweproject;

public class loginValidation {
   private String userName;
   private String passWord;
    public String loginValidation(String userName, String password) {
        this.userName = userName;
        this.passWord = password;
    }

    public String getUsername(){
    return userName;
    }
    public String getPassword() {
        return passWord;
    }
    public String Validation() {

        if (userName.equals("Manager") && passWord.equals("Manager ")) {
            return "Manager successfully login .";
        }
        else if (userName.equals("Chef") && passWord.equals("ChefPassword")) {
            return "Chef successfully login ";
        } else if (userName.equals("busboy")&& passWord.equals("BusboyPassword")) {
            return "successfully login ";

        } else if (userName.equals("Waiter ")&& passWord.equals("waiterPassword")) {
            return "Waiter successfully login ";
        }
        else {
            return "User name " + userName + " Password " + passWord + " does not exist";
        }


    }

    public String toString(){
        return "user name : " + userName + "\n" + " Pass word : " + passWord+ " Login Successfully";
    }
}
