package transportme;

import java.util.List;
import users_pack.User;

public class TransportMe {

    static User loggedIn = null;
    static List<User> registeredUsers = null;
    
    public static void storeUser(User u){
        registeredUsers.add(u);
        System.out.println("User is successfully registered");
    }
    
    public static void main(String[] args) {
        
    }
    
}
