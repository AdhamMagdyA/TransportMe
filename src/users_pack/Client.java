package users_pack;
import rides.Offer;
import rides.Ride;

public class Client extends User {
    public static int id=0;
    Ride rideRequest;

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
    public boolean requestRide(String source,String destination){
        // if area exists
        Ride rideRequest = new Ride(this,source,destination);
        //notify drivers with same area in favourite areas
        // should set area and user to rideRequest obj
        return true;
    }
    public void viewOffers(){
        for (Offer offer:rideRequest.offers){
            offer.getOfferInfo();
        }
    }
    public void add_rating(Driver dr , int r)
    {

        Rating rate = new Rating(this,r);
        dr.list.add(rate);

    }

}
