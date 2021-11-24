package rides;
import transportme.TransportMe;
import users_pack.Client;
import users_pack.Driver;
import java.util.List;

public class Ride {
    private static int count=0;
    private Client client;
    private int id;
    private String source;
    private String destination;
    public List<Offer> offers;

    public Ride(Client client,String source,String destination) {
        this.client =client;
        this.source=source;
        this.destination=destination;
        count++;
        this.id=count;
 }
    public int getId() {
        return id;
    }
    public String getSource() {
        return source;
    }
    public void getRideInfo(){
        System.out.println("Ride id is"+id);
        System.out.println("Ride source area's name is"+source);
        System.out.println("Ride destination area's name is"+destination);
        System.out.println("Client's name is"+client.getUsername());
        System.out.println("==============================");
    }
    public void addOffer(Offer offer){
        offers.add(offer);
        System.out.println("Offer added successfully");
    }
    public boolean notifyDrivers(String source){
        boolean found=false;
        for (Driver driver : TransportMe.drivers){
            for (String area : driver.favAreas){
                if (area.equals(source)){
                    driver.ridesInFavAreas.add(this);
                    found=true;
                }
            }
        }
        return found;
    }

}