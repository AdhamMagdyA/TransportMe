package storage_pack;

import java.util.List;
import users_pack.Admin;
import users_pack.Client;
import users_pack.Driver;
import users_pack.User;

public class ListStorage implements UserStorage{
    
    User loggedin;
    static List<User> registeredUsers;
    private static final ListStorage instance  = new ListStorage();
    
    private ListStorage(){
        //predefined registered users
        registeredUsers.add(new Admin("admin","011","admin","admin"));
        registeredUsers.add(new Client("client","011","client","client"));
        registeredUsers.add(new Driver("admin","011","admin","admin","213242153","24324"));
    }
    
    public static ListStorage getInstance(){
        return instance;
    }
    
    @Override
    public void storeUser(User user) {
       registeredUsers.add(user); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login(String username, String password) {
        boolean found = false;
        //iterate on registered users to find the user logging in
        for (User registeredUser : registeredUsers) {
            //if found a user that matches credintials
            if ( registeredUser.getUsername().equals(username) && registeredUser.getPassword().equals(password) ) 
            {
                found = true;
                loggedin = registeredUser;
                System.out.println("logged in successfully!");
                break;
            }
        }
        return found;
    }
    
}
