public class LoginValidation {
    public class LoginValidation {
        private String username;
        private String password;
    }

    public LoginValidation(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String Validation() {
        if (this.username.equals("Admin") && this.password.equals("Adminpassword")) {
            return "Admin";
        } else if (this.username.equals("user") && this.password.equals("userpassword")) {
            return "user";
        } else {
            return !this.username.equals("username") && !this.password.equals("password") ? "user name and password do not match" : null;
        }
    }

    public String toString() {
        return "user name : " + this.username + "\n Pass word : " + this.password + " Login Successfully";
    }
}
