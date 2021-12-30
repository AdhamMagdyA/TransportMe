package users_pack;
import java.util.List;

import storage.UserListStorage;
import storage.UserStorage;
import transportme.TransportMe;

public class Admin extends User{

    UserStorage userStorage = new UserListStorage();

    public Admin(String userName, String mobileNumber,String password,String email){
        super(userName, mobileNumber,password,email);
    }
    //transformed to use UserStorage instead of TransportMe
    public void addPendingRegistrations(Driver driver){
        userStorage.addPendingRegistration(driver);
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
    // transformed to use UserStorage instead of TransportMe
    public void listPendingRegistrations(){
        for (Driver driver : userStorage.getPendingRegistrations()){
            System.out.println("driver name is :" +driver.getUsername());
            System.out.println("driver national id is :" +driver.getNationalID());
            System.out.println("driver driving licence is :" +driver.getDrivingLicense());
            System.out.println("=================================");
        }
    }
    // transformed to use UserStorage instead of TransportMe
    public boolean acceptRegistration(String userName){
        for( User user : userStorage.getPendingRegistrations() ){
            if( user.getUsername().equals(userName) ){
                // remove from pending registration
                userStorage.removePendingRegistration( (Driver) user );
                // add registration to database
                userStorage.addRegisteredUser(user);
                return true;
            }
        }
        System.out.println("User not found");
        return false;
    }

    // no need for this function for now
    /* public boolean rejectRegistration(String userName){
        for( User user : TransportMe.pendingRegistrations ){
            if( user.getUsername().equals(userName) ){
                TransportMe.pendingRegistrations.remove(user);
                System.out.println("Registration rejected successfully");
                return true;
            }
        }
        System.out.println("User not found");
        return false;
    }*/
}
