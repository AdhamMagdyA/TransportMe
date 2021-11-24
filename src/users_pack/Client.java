package users_pack;
import rides.Offer;
import rides.Ride;
import transportme.TransportMe;

public class Client extends User {
    private int id=0;
    Ride rideRequest;

    public Client(String userName, String mobileNumber,String password,String email){
        super(userName, mobileNumber,password,email);
        this.id=count;
    }
    // Email attribute is optional
    public Client(String userName, String mobileNumber,String password){
        super(userName, mobileNumber,password);
        id++;
        email="";
    }

    public int getId() {
        return id;
    }

    public void requestRide(String source,String destination){
        Ride rideRequest = new Ride(this,source,destination);
        boolean status;
        status=rideRequest.notifyDrivers(source);
        if (status){
            TransportMe.rides.add(rideRequest);
            System.out.println("Requested successfully");
        }
        else {
            System.out.println("No drivers in Your area");
        }
    }
    public void viewOffers(){
        for (Offer offer:rideRequest.offers){
            offer.getOfferInfo();
        }
    }
    public void addRating(Driver dr , int r)
    {
        Rating rate = new Rating(this,r);
        dr.list.add(rate);
    }

}
