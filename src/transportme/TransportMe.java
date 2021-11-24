package transportme;
import java.util.List;
import java.util.Scanner;

import rides.*;
import users_pack.*;

public class TransportMe {

    public static User loggedIn = null;
    public static List<User> registeredUsers = null;
    public static List<Driver> drivers = null;
    public static List<Client> clients = null;
    public static List<Ride> rides = null;
    private static Admin systemAdmin = new Admin("admin","123456789","password","email");
    
    public static void storeUser(User u){
        registeredUsers.add(u);
        if(u instanceof Driver) drivers.add((Driver) u);
        if(u instanceof Client) clients.add((Client) u);

        System.out.println("User is successfully registered");
    }
    public static boolean searchDriver(String username){
        for(Driver driver : drivers){
            if(driver.getUsername().equals(username)) return true;
        }
        return false;
    }

    public static void displayClientMenu(){
        System.out.println("1-Request Ride.");
        System.out.println("2-View Offers.");
        System.out.println("3-Add Rating.");
        System.out.println("4-Back.");
        choice = input.nextInt();
        while (choice!=4){
            if (choice==1){
                System.out.println("Enter source and destination area names.");
                String source;
                String destination;
                source = input.nextLine();
                destination = input.nextLine();
                ((Client) loggedIn).requestRide(source,destination);
                break;
            }
            if (choice==2){
                ((Client) loggedIn).viewOffers();
                break;
            }
            if (choice==3){
                System.out.println("Enter driver's name .");
                String name;
                int rating;
                name = input.nextLine();
                if (searchRegisteredUser(name)){
                    for (Driver driver: TransportMe.drivers){
                        if (driver.getUsername().equals(name)){
                            System.out.println("Enter your rating from 1 to 5 .");
                            rating = input.nextInt();
                            if (rating >0 && rating <5){
                                ((Client) loggedIn).addRating(driver,rating);
                                System.out.println("Rating added successfully .");
                            }
                            else {
                                System.out.println("wrong number, please try again.");
                            }
                            break;
                        }
                    }
                }
                else {
                    System.out.println("There is no such driver in the system");
                    break;
                }
            }
        }
    }

    public static void displayDriverMenu(){
        System.out.println("1-List Rides in Favourite Area.");
        System.out.println("2-Display Rating List.");
        System.out.println("3-Back.");
        choice = input.nextInt();
        while (choice!=3){
            if (choice==1) {
                System.out.println("Enter source area name.");
                String source;
                source = input.nextLine();
                ((Driver) loggedIn).listRides(source);
                System.out.println("=================================");
                System.out.println("1-Suggest Price for ride");
                System.out.println("2- Back");
                choice = input.nextInt();
                if (choice==1){
                    double price;
                    int rideID;
                    rideID = input.nextInt();
                    price = input.nextDouble();
                    System.out.println("Enter price.");
                    ((Driver) loggedIn).suggestPrice(price,rideID);
                }

            }
            if (choice==2) {

            }

        }

    }
    public static void displayAdminMenu(){


    }


    public static boolean login(String username, String password){
        boolean status=false;
        if(systemAdmin.getUsername().equals(username)&&systemAdmin.getPassword().equals(password)){
            displayAdminMenu();
            System.out.println("ADMIN LOGGED IN SUCCESSFULLY");
            status=true;
        }
        else if (searchRegisteredUser(username)){
            for(User u : registeredUsers){
                if(u.getUsername().equals(username) && u.getPassword().equals(password) ){
                    loggedIn = u;
                    System.out.println("logged in successfully");
                    status=true;
                }
            }
        }
        else{
            System.out.println("user not found");
            status=false;
        }
        return status;
    }
    public static boolean searchRegisteredUser(String username){
        for(User u : registeredUsers){
            if(u.getUsername().equals(username))
                return true;
        }
        return false;
    }
    static void displayMenu() {
        System.out.println("1-REGISTER .");
        System.out.println("2-SIGN IN.");
        System.out.println("3-EXIT .");
    }
    static void register(int ch){
        if (ch==1){
            System.out.println("ENTER YOUR INFORMATION AS FOLLOW: USERNAME, MOBILE NUMBER, PASSWORD, EMAIL");
            String userName = input.next();
            String mobileNumber = input.next();
            String password = input.next();
            String email = input.next();
            Client client = new Client(userName,mobileNumber,password,email);
            storeUser(client);
        }
        if (ch==2){
            System.out.println("ENTER YOUR INFORMATION AS FOLLOW: USERNAME, MOBILE NUMBER, PASSWORD, EMAIL, NATIONAL ID, DRIVING LICENCE");
            String userName = input.next();
            String mobileNumber = input.next();
            String password = input.next();
            String email = input.next();
            String nationalID = input.next();
            String drivingLicence = input.next();
            Driver driver = new Driver(userName,mobileNumber,password,email,nationalID,drivingLicence);
            Admin.addPendingRegistrations(driver);
        }
    }
    static Scanner input = new Scanner(System.in);
    static int choice;
    static int ip;
    public static void main(String[] args) {
        System.out.println("=======WELCOME TO TRANSPORT ME , PLEASE ENTER CHOICE NUMBER=======");
        displayMenu();
        do {
            choice = input.nextInt();
            //REGISTRATION
            if (choice == 1) {
                System.out.println("1-CLIENT");
                System.out.println("2-DRIVER.");
                System.out.println("3-BACK.");
                ip = input.nextInt();
                while (ip != 3) {
                    register(ip);
                    break;
                }
                displayMenu();
            }
            // signIn
            if (choice == 2) {
                System.out.println("ENTER YOUR USER NAME AND PASSWORD");
                String userName = input.next();
                String password = input.next();
                boolean status =login(userName,password);
                if (status){
                    if (loggedIn instanceof Client){
                        displayClientMenu();
                        break;
                    }
                    if (loggedIn instanceof Driver){
                        displayDriverMenu();
                        break;
                    }
                    if (loggedIn instanceof Admin){
                        displayAdminMenu();
                        break;
                    }

                }
                else {

                }

                displayMenu();
            }
        }
        while (choice != 3);




    }
    
}
