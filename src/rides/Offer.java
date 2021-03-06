package rides;

import users_pack.Driver;

public class Offer {
    private Ride ride;
    private static int count=0;
    private  int id=0;
    private double price;
    private Driver driver;

    public void addOffer(){
        this.ride.addOffer(this);
    }

    public Offer(Ride ride, double price, Driver driver) {
        this.ride = ride;
        this.price = price;
        this.driver = driver;
        this.id=count;
        addOffer();
    }
    public void getOfferInfo(){
        System.out.println("Offer id is"+id);
        driver.getDriverInfo();
        System.out.println("Suggested price is"+price);
        System.out.println("=================================");
    }

    public Driver getDriver() {
        return driver;
    }

    public int getId() {
        return id;
    }
}
