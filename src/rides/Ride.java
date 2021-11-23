package rides;
import users_pack.User;

import java.util.List;

public class Ride {
    private User user;
    private static int id=0;
    private String source;
    private String destination;
    public List<Offer> offers;

    public Ride(User user,String source,String destination) {
        this.user = user;
        this.source=source;
        this.destination=destination;
        id++;
 }
    public int getId() {
        return id;
    }
    public String getSource() {
        return source;
    }
    public String getDestination() {
        return destination;
    }
    public void getRideInfo(){
        System.out.println("Ride id is"+id);
        System.out.println("Ride source area's name is"+source);
        System.out.println("Ride destination area's name is"+destination);
        System.out.println("Client's name is"+user.getUsername());
    }
    public void addOffer(Offer offer){
        offers.add(offer);
    }

}