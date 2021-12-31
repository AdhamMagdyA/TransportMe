package users_pack;
import rides.Offer;
import rides.Ride;

import java.util.ArrayList;

public class Driver extends User{
    private int id;
    private String drivingLicense, nationalID;
    public ArrayList<String> favAreas = new ArrayList<String>();
    public ArrayList<Ride> availableRides = new ArrayList<Ride>();
    public ArrayList<Rating> list = new ArrayList<Rating>();
    private boolean availableForHandlingRequests;

    
    public Driver(String userName, String mobileNumber,String password,String email,String drivingLicense, String nationalID){
        super(userName, mobileNumber,password,email);
        this.drivingLicense=drivingLicense;
        this.nationalID=nationalID;
        this.id=count;
        this.availableForHandlingRequests = true;
    }

    public boolean listRides(String sourceArea){
        boolean found=false;
        for (Ride ride: availableRides){
            if(ride.getSource().equals(sourceArea)){
                ride.getRideInfo();
                found=true;
            }
        }
        return found;
    }
    public void suggestPrice(double price,int rideId){
        for(Ride ride: availableRides){
            if(ride.getId()==rideId){
                Offer offer = new Offer(ride,price,this);
            }
        }
    }
    public void showRatingList() {
        for (Rating rating : list){
            System.out.println("rating is :" +rating.rating);
            System.out.println("Client name is :" +rating.client.getUsername());
            System.out.println("=================================");
        }
    }
    public double calculateAverageRating() {
        int sum = 0;
        for (Rating rating : list) {
            sum = sum + rating.rating;
        }
        return ((double) sum /list.size() );
    }
    public void getDriverInfo(){
        System.out.println("Driver Name is"+userName);
        System.out.println("Driver id is"+id);
        System.out.println("Driver total rating is"+calculateAverageRating());
        System.out.println("=================================");
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public String getNationalID() {
        return nationalID;
    }
    public void setFavAreas(String area){
        favAreas.add(area);
    }
    public boolean getAvailableForHandlingRequests(){return getAvailableForHandlingRequests();}
    public void setAvailableForHandlingRequests(boolean availableForHandlingRequests) {
        this.availableForHandlingRequests = availableForHandlingRequests;
    }
}
