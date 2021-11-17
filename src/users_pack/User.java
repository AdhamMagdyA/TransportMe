package users_pack;

import storage_pack.ListStorage;


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
        return ListStorage.getInstance().login(this.userName, this.password);
    }
    public void register(){
        Admin.addPendingRegistrations(this);
    }
    
    public String getUsername(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }
}
