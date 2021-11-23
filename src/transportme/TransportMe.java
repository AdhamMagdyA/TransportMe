package transportme;

import java.util.List;
import users_pack.*;

public class TransportMe {

    static User loggedIn = null;
    static List<User> registeredUsers = null;
    static List<Driver> drivers = null;
    static List<Client> clients = null;
    
    public static void storeUser(User u){
        registeredUsers.add(u);
        if(u instanceof Driver) drivers.add((Driver) u);
        if(u instanceof Client) clients.add((Client) u);

        System.out.println("User is successfully registered");
    }
    
    public static void main(String[] args) {
        
    }
    
}
