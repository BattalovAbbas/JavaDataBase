package Tables;

/**
 * Created by Abbas on 16.11.2015.
 */
public class Booking {
    public int id;
    public int id_user;
    public Booking(){}
    public Booking(int id_user)
    {
        this.id_user = id_user;
    }
    public Booking(int id, int id_user)
    {
        this.id = id;
        this.id_user = id_user;
    }
}
