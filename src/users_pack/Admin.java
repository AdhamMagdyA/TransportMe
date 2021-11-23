package users_pack;
import java.util.List;
import transportme.TransportMe;

public class Admin extends User{
    static List<User> penddingRegistrations;
     static List<User> suspendedUsers; // if  the admin suspended any user , this user will add to the list and cannot be able to login
     static List<User> unsuspendedUsers; // if the admin canceled the user's suspending , this user will add to the list and able to login the system
                                         // because if any user will login to the system , we check this user in these two lists     
    public Admin(String userName, String mobileNumber,String password,String email){
        super(userName, mobileNumber,password,email);
    }
    
    public static void addPendingRegistrations(User user){
        penddingRegistrations.add(user);
    }
     public static void suspendUser (User user){
        suspendedUsers.add(user);
    }
       public static void unsuspendUser (User user){
        unsuspendedUsers.add(user);
    }
    
    public boolean acceptRegistration(String userName){
        for( User user : penddingRegistrations ){
            if( user.getUsername().equals("userName") ){
                TransportMe.storeUser(user);
                return true;
            }
        }
        System.out.println("User not found");
        return false;
    }
    
    public boolean rejectRegistration(String userName){
        for( User user : penddingRegistrations ){
            if( user.getUsername().equals("userName") ){
                penddingRegistrations.remove(user);
                System.out.println("Registration rejected successfully");
                return true;
            }
        }
        System.out.println("User not found");
        return false;
    }
}
