package rides;

import users_pack.Driver;

public class Offer {
    private Ride ride;
    private static int id=0;
    private double price;
    private Driver driver;

    public Offer(Ride ride, double price, Driver driver) {
        this.ride = ride;
        this.price = price;
        this.driver = driver;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Offer.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void getOfferInfo(){
        System.out.println("Offer id is"+id);
        System.out.println("Driver's name is"+driver.getUsername());
        System.out.println("Suggested price is"+price);
    }
}
