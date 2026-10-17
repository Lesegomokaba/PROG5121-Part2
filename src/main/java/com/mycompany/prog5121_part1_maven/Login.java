/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



/**
 *
 * @author Leseg
 *//*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_part1_maven;

/**
 *
 * @author Leseg
 */
public class Login {
    // Login class handles user registration, validation, and authentication.
    private String UserName;
    private String Password;
    private String cellphone;
    private String firstName;
    private String lastname;
    private String loginUsername;
    private String loginPassword;
    private String loginStatus;
    
    
    public boolean checkUserName(){
        return UserName.contains("_") && UserName.length() <= 5;
        
    }
    
    public void setusername(String username) {
        this.UserName = username;
     }
    
 public boolean checkPasswordComplexity() {
    return Password.length() >= 8
            && Password.matches(".*[A-Z].*")
            && Password.matches(".*[0-9].*")
            && Password.matches(".*[^a-zA-Z0-9].*");
}
 public void setPassword(String password) {
    this.Password = password;
}
     public void setcellphone (String cellphone) {
    this.cellphone = cellphone;
}
     public boolean checkCellPhoneNumber() {
         // Regex pattern adapted from Oracle Java documentation on regular expressions.
// https://docs.oracle.com/javase/tutorial/essential/regex/
    return cellphone.matches("^\\+27[0-9]{9}$");
}
   public void setfirstName(String firstName) {
    this.firstName = firstName;
} 
   public void setlastname(String lastname) {
    this.lastname = lastname;
   }
   
  public String registerUser() {
    if (!checkUserName()) {
        return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
    }

    if (!checkPasswordComplexity()) {
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }

    if (!checkCellPhoneNumber()) {
        return "Cell phone number incorrectly formatted or does not contain international code.";
    }

    return "Registration successful.";
}

public String registerUser(String field) {
    if (field.equals("username")) {
        if (checkUserName()) {
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    }

    if (field.equals("password")) {
        if (checkPasswordComplexity()) {
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
    }

    if (field.equals("cellphone")) {
        if (checkCellPhoneNumber()) {
            return "Cell phone number successfully added.";
        } else {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
    }

    return "Invalid registration field.";
}
  
  
  
  
  public void setLoginUserName(String loginUsername) {
    this.loginUsername = loginUsername;
}
  
  public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
}
  
   public String returnLoginStatus() {
       return loginStatus;

     }
   
     public boolean loginUser() {
    if (UserName.equals(loginUsername) && Password.equals(loginPassword)) {
        loginStatus = "Welcome " + firstName + ", " + lastname + " it is great to see you again.";
        return true;
    } else {
        loginStatus = "Username or password incorrect, please try again.";
        return false;
    }
}
  
  public static void main(String[] args) {
       Login login = new Login();
        login.setusername("kyl_1");
         login.setfirstName("Lesego");
    login.setlastname("Mokaba");
    
         System.out.println(login.checkUserName());
          login.setPassword("Password1!");
          
           System.out.println(login.checkPasswordComplexity());
            login.setcellphone("+27821234567");
             System.out.println(login.checkCellPhoneNumber());
             
             System.out.println(login.registerUser("username"));
             
              login.setLoginUserName("kyl_1");
    login.setLoginPassword("Password1!");
    
    
    System.out.println(login.loginUser());
System.out.println(login.returnLoginStatus());

}
  
  
 }




    