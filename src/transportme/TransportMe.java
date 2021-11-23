package transportme;

import java.util.List;

import rides.Ride;
import users_pack.*;

public class TransportMe {

    public static User loggedIn = null;
    public static List<User> registeredUsers = null;
    public static List<Driver> drivers = null;
    public static List<Client> clients = null;
    public static List<Ride> rides = null;
    
    public static void storeUser(User u){
        registeredUsers.add(u);
        if(u instanceof Driver) drivers.add((Driver) u);
        if(u instanceof Client) clients.add((Client) u);

        System.out.println("User is successfully registered");
    }
    
    public static void main(String[] args) {
        
    }
    
}
