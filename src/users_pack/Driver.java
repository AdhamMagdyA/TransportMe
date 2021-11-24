package users_pack;
import rides.Offer;
import rides.Ride;

import java.util.ArrayList;
import java.util.List;
public class Driver extends User{
    private int id;
    private String drivingLicense, nationalID;
    public List<String> favAreas;
    public List<Ride> ridesInFavAreas=null;
    public ArrayList <Rating> list = new ArrayList<Rating>();

    
    public Driver(String userName, String mobileNumber,String password,String email,String drivingLicense, String nationalID){
        super(userName, mobileNumber,password,email);
        this.drivingLicense=drivingLicense;
        this.nationalID=nationalID;
        this.id=count;
    }
    public boolean listRides(String sourceArea){
        boolean found=false;
        for (Ride ride:ridesInFavAreas){
            if(ride.getSource().equals(sourceArea)){
                ride.getRideInfo();
                found=true;
            }
        }
        return found;
    }
    public void suggestPrice(double price,int rideId){
        for(Ride ride: ridesInFavAreas){
            if(ride.getId()==rideId){
                Offer offer = new Offer(ride,price,this);
            }
        }
    }
    public void showRatingList(int r1) {
        for (Rating rating : list){
            System.out.println("rating is :" +rating.rating);
            System.out.println("Client name is :" +rating.client.getUsername());
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
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public String getNationalID() {
        return nationalID;
    }
}
