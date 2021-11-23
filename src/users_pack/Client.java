package users_pack;
import rides.Offer;
import transportme.TransportMe;
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
        Ride rideRequest = new Ride(this,source,destination);
        for(Driver d :TransportMe.drivers){
            for(String favArea:d.favArea){
                if (favArea.equals(source)){
                    d.ridesInFavArea.add(rideRequest);
                }
            }
        }
        return true;
    }
    public void viewOffers(){
        for (Offer offer:rideRequest.offers){
            offer.getOfferInfo();
        }
    }
}
