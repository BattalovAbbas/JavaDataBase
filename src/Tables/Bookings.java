package Tables;

/**
 * Created by Abbas on 16.11.2015.
 */
public class Bookings {
    public int id_product;
    public int id_booking;
    public Bookings(){}
    public Bookings(int id_booking,int id_product)
    {
        this.id_booking = id_booking;
        this.id_product=id_product;
    }
}
