package users_pack;
import java.util.List;
import transportme.TransportMe;

public class Admin extends User{

    public Admin(String userName, String mobileNumber,String password,String email){
        super(userName, mobileNumber,password,email);
    }
    
    public static void addPendingRegistrations(Driver driver){
        TransportMe.pendingRegistrations.add(driver);
    }
     public static void suspendUser (String username){
         for( User user : TransportMe.registeredUsers ) {
             if(user.getUsername().equals(username) ){
                 TransportMe.registeredUsers.remove(user);
                 TransportMe.suspendedUsers.add(user);
         }
         }



    }
       public static void unSuspendUser(String username) {
           for (User user : TransportMe.registeredUsers) {
               if (user.getUsername().equals(username)) {
                   TransportMe.registeredUsers.add(user);
                   TransportMe.suspendedUsers.remove(user);
               }

           }
       }
    public void listPendingRegistrations(){
        for (Driver driver : TransportMe.pendingRegistrations){
            System.out.println("driver name is :" +driver.getUsername());
            System.out.println("driver national id is :" +driver.getNationalID());
            System.out.println("driver driving licence is :" +driver.getDrivingLicense());
            System.out.println("=================================");
        }
    }
    public boolean acceptRegistration(String userName){
        for( User user :TransportMe.pendingRegistrations ){
            if( user.getUsername().equals(userName) ){
                TransportMe.storeUser(user);
                TransportMe.pendingRegistrations.remove(user);
                return true;
            }
        }
        System.out.println("User not found");
        return false;
    }
    
    public boolean rejectRegistration(String userName){
        for( User user : TransportMe.pendingRegistrations ){
            if( user.getUsername().equals(userName) ){
                TransportMe.pendingRegistrations.remove(user);
                System.out.println("Registration rejected successfully");
                return true;
            }
        }
        System.out.println("User not found");
        return false;
    }
}
