package users_pack;

import java.util.ArrayList;

public class Driver extends User{
    String drivingLicense, nationalID;
    public static int id=0;
    ArrayList <Rating> list = new ArrayList<Rating>();
    
    public Driver(String userName, String mobileNumber,String password,String email,String drivingLicense, String nationalID){
        super(userName, mobileNumber,password,email);
        this.drivingLicense=drivingLicense;
        this.nationalID=nationalID;
        id++;
    }
    
    public int show_average()
   {

       int sum = 0;
       for(int i = 0; i < list.size(); i++)
       {
          sum= sum + list.get(i).rating;
       }
       return (sum /list.size() );
   }
    
   public int show_ratinglist(int r1)
   { 
       for(int i = 0; i < list.size(); i++)
       {
          System.out.println(list);
       }

        return 0;
   }
}
