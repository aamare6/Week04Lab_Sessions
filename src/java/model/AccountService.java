
package model;


public class AccountService {
   
    String username;
    String password;

     public AccountService() {
        this.username = username;
        this.password = password;
    }
    
    public AccountService(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    
    
    public User login(String username, String password) {
      
        if (username.equalsIgnoreCase("adam") && password.equalsIgnoreCase("password") || username.equalsIgnoreCase("betty") && password.equalsIgnoreCase("password")) {
        
        return  new User(username, null);
        } 
        
        return null;
   
}
}