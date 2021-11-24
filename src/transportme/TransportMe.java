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
    public static void login(String username, String password){
        if(searchRegisteredUser(username)){
            for(User u : registeredUsers){
                if(u.getUsername().equals(username) && u.getPassword().equals(password) ){
                    loggedIn = u;
                    System.out.println("logged in successfully");
                }
            }
            System.out.println("Wrong credentials");
        }else{
            System.out.println("user not found");
        }
    }
    public static boolean searchRegisteredUser(String username){
        for(User u : registeredUsers){
            if(u.getUsername().equals(username))
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Client c1 = new Client("esraa","15","146584");
        Client c2 = new Client("esraa","15","146584");
        Client c3 = new Client("fshe","15","146584");
        Client c4 = new Client("esrhgdaa","15","146584");
        System.out.println(c1.getId());
        System.out.println(c2.getId());
        System.out.println(c3.getId());
        System.out.println(c4.getId());
    }
    
}
