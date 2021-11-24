package users_pack;

public class Rating {
    private Client client;
    public int rating;


    public Rating(Client c ,int r)
    {
        client = c;
        rating = r;
    }

    public String tostring()
    {
        return "rate " + rating +"/n";

    }

}