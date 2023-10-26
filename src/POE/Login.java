package POE;

//the login class

import javax.swing.JOptionPane;

public class Login {
    
    private String password, username, firstName, lastName;
    String underscore = "_";

    //A method to check if the username conditions are correct
    public boolean checkUserName(String username) {
        if (username.length() <= 5 && username.contains(underscore)) {
            JOptionPane.showMessageDialog(null,"Username successfully captured");
            return true; //when the condition is met it will return true
        } else {
            JOptionPane.showMessageDialog(null,"Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in lengt");
            return false; //when the condition is met it will return false
        }
    }

//A method to check if the password are correct
    public boolean checkPasswordComplexity(String password) {
        //boolean that will be match the password (seriers of characters)
        boolean alpfa = password.matches(".*[A-Z].*"),
                sp = password.matches(".*[!@#$%^&+-].*"),
                num = password.matches(".*[0-9].*");

        //a condition that will check password is correct
        if (password.length() >= 8 && alpfa && sp && num) {
            JOptionPane.showMessageDialog(null,"Password successfully captured \n");
            return true;
        } else {
             JOptionPane.showMessageDialog(null,"Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character");
            return false;
        }
    }
    
    
    //A method to check if the register username is still correct
        public boolean registerUserName(String username) {
        if (username.length() <= 5 && username.contains(underscore)) {
            return true; //when the condition is met it will return true
        } else {
            return false; //when the condition is met it will return false
        }
    }

//A method to check if the register password is still correct
    public boolean registerPasswordComplexity(String password) {
        //boolean that will be match the password (seriers of characters)
        boolean alpfa = password.matches(".*[A-Z].*"),
                sp = password.matches(".*[!@#$%^&+-].*"),
                num = password.matches(".*[0-9].*");

        //a condition that will check password is correct
        if (password.length() >= 8 && alpfa && sp && num) {
            return true;
        } else {
            return false;
        }
    }

    //This method returns the necessary registration messaging 
    public String registerUser(String username, String password) {

        if (!registerUserName(username) || !registerPasswordComplexity(password)) { //PASS IN THE REGISTRATION IS CORRECT
            String errorMessage = "The username or password incorrect";
            return errorMessage;
        } else {
            String approvedMessage = "You registered succesfully";
            return approvedMessage;
        }
    }

    //checks the user's username and password after being registered if it is true or false
    public boolean loginUser(String inputUser, String inputPass, String storePassword, String storeUsername, String storeFirst, String storeLast) {
        return inputUser.equals(storeUsername) && inputPass.equals(storePassword);
    }

    //This method returns the necessary messaging for succes login or faild
    public String returnLoginStatus(String inputUser, String inputPass, String storePassword, String storeUsername, String storeFirst, String storeLast, boolean loginUserStatus) {
        if (loginUserStatus) {
           String approvedMessage = "Sucessful login \n" + "Welcome " + storeFirst + ", " + storeLast + " it is great to see you again.";
            return approvedMessage;
        } else {
            String errorMessage = "Failed login \n" + "Username or password incorrect, please try again";
            return errorMessage;
        }
    }
    
     // Setter method for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter method for password
    public String getPassword() {
        return password;
    }
    
     // Setter method for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method for username
    public String getUsername() {
        return username;
    }
    
     // Setter method for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter method for firstName
    public String getFirstName() {
        return firstName;
    }
    
     // Setter method for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter method for last name
    public String getLastName() {
        return lastName;
    }

}
