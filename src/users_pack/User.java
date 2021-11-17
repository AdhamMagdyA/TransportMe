package users_pack;


public class User {
    String userName,mobileNumber,password,email;
    
    public User(String userName, String mobileNumber,String password,String email){
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.email = email;
    }
    
    public User(String userName, String mobileNumber,String password){
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.email = null;
    }
    
    public boolean login(){
        return false;
    }
    public boolean register(){
        return false;
    }
}
