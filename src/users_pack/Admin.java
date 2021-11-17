package users_pack;

import java.util.List;

public class Admin extends User{
    static List<User> pendingRegistrations;
    
    public Admin(String userName, String mobileNumber,String password,String email){
        super(userName, mobileNumber,password,email);
    }
    
    public void addPendingRegistrations(User user){
        
    }
    
    public void acceptRegistration(String userName){
        
    }
}
