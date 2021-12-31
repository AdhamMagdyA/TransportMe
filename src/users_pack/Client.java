package users_pack;
import rides.Offer;
import rides.Ride;
import transportme.TransportMe;

public class Client extends User {
    private int id=0;
    Ride rideRequest=null;

    public Client(String userName, String mobileNumber,String password,String email){
        super(userName, mobileNumber,password,email);
        this.id=count;
    }
    // Email attribute is optional
    public Client(String userName, String mobileNumber,String password){
        super(userName, mobileNumber,password);
        this.id=count;

    }

    public void requestRide(String source,String destination){
        Ride rideRequest = new Ride(this,source,destination);
        boolean status;
        status=rideRequest.notifyDrivers(source);
        if (status){
            TransportMe.rides.add(rideRequest);
            this.rideRequest=rideRequest;
            System.out.println("Requested successfully");
        }
        else {
            System.out.println("No drivers in Your area");
        }
    }
    public void viewOffers(){
        if(this.rideRequest==null)
        {
            System.out.println("no Rides yet.");
        }
        else if(rideRequest.offers==null||rideRequest.offers.size()==0)
        {
            System.out.println("no offers yet.");
        }

        else {
            for (Offer offer:rideRequest.offers){
                offer.getOfferInfo();
            }
        }
    }
    public void addRating(Driver dr , int r) {
        Rating rate = new Rating(this,r);
        dr.list.add(rate);
    }

    public boolean acceptOffer(int id){
        for (Offer offer:rideRequest.offers){
            if (offer.getId() == id)
            {
                // means that the driver is now handling a request
                offer.getDriver().setAvailableForHandlingRequests(false);
                // request resolved
                rideRequest = null;

                return true;
            }
        }
        return false;
    }

}
