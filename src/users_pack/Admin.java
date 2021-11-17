package users_pack;

import java.util.List;
import storage_pack.ListStorage;

public class Admin extends User{
    static List<User> pendingRegistrations;
    
    public Admin(String userName, String mobileNumber,String password,String email){
        super(userName, mobileNumber,password,email);
    }
    
    public static void addPendingRegistrations(User user){
        pendingRegistrations.add(user);
    }
    
    public boolean acceptRegistration(String userName){
        for( User user : pendingRegistrations ){
            if( user.getUsername().equals("userName") ){
                ListStorage.getInstance().storeUser(user);
                return true;
            }
        }
        return false;
    }
}
