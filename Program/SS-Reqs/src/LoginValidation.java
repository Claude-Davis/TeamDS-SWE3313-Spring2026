public class Account {
    public class Account {
        private String username;
        private String password;
        private String role;
    }

    public Account(String username, String password,String role) {
        this.username = username;
        this.password = password;
        this.role=role
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    public String getRole(){
        return role;
    }   

    public String Validation() {
        iif (userName.equals("Manager") && passWord.equals("Manager ")) {
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
