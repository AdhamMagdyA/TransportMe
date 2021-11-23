package users_pack;
import rides.Offer;
import rides.Ride;

import java.util.ArrayList;
import java.util.List;
public class Driver extends User{
    String drivingLicense, nationalID;
    List<String> favArea;
    List<Ride> ridesInFavArea=null;
    ArrayList <Rating> list = new ArrayList<Rating>();

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
    public int showAverage()
    {
        int sum = 0;
        for (Rating rating : list) {
            sum = sum + rating.rating;
        }
        return (sum /list.size() );
    }

    public int showRatingList(int r1)
    {
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list);
        }

        return 0;
    }
}
