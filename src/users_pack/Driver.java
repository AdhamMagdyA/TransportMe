package users_pack;

public class Driver extends User{
    String drivingLicense, nationalID;
    
    public Driver(String userName, String mobileNumber,String password,String email,String drivingLicense, String nationalID){
        super(userName, mobileNumber,password,email);
        
    }
}
