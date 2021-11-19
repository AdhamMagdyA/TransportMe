package users_pack;

import rides.Ride;

public class Client extends User {
    public static int id=0;
    
    public Client(String userName, String mobileNumber,String password,String email){
        super(userName, mobileNumber,password,email);
        id++;
    }
    // Email attribute is optional
    public Client(String userName, String mobileNumber,String password){
        super(userName, mobileNumber,password);
        id++;
        email="";
    }
    public boolean requestRide(String areaName){
        // if area exists
        Ride rideRequest = new Ride(this);
        //notify drivers with same area in favourite areas
        // should set area and user to rideRequest obj
        return true;
    }
}
