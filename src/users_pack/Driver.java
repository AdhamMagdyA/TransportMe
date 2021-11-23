package users_pack;
import rides.Offer;
import rides.Ride;
import java.util.List;
public class Driver extends User{
    String drivingLicense, nationalID;
    List<String> favArea;
    List<Ride> ridesInFavArea=null;
    public static int id=0;
    
    public Driver(String userName, String mobileNumber,String password,String email,String drivingLicense, String nationalID){
        super(userName, mobileNumber,password,email);
        this.drivingLicense=drivingLicense;
        this.nationalID=nationalID;
        id++;
    }
    public void listRides(String sourceArea){
        for (Ride ride:ridesInFavArea){
            if(ride.getSource().equals(sourceArea)){
                ride.getRideInfo();
            }
        }
    }
    public void suggestPrice(double price,int rideId){
        for(Ride ride: ridesInFavArea){
            if(ride.getId()==rideId){
                Offer offer = new Offer(ride,price,this);
                ride.addOffer(offer);
            }
        }
    }
}
