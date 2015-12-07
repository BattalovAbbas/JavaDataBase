
import BusinessLogic.BusinessLogic;
import Tables.*;

import java.util.Scanner;
import java.util.*;


public class Main
{
    static BusinessLogic businessLogic= new BusinessLogic();;
    public static void main(String[] args)
    {
        //Create();
        Input();
    }
    static List<User> userList = new ArrayList<User>();
    static Scanner in = new Scanner(System.in);
    public static void Input()
    {
        System.out.println("1-Insert, 2-Update, 3-Select, 4-Delete 5-ADD USER-PRODUCT");
        System.out.println("Enter the number of teams:  ");
        int index = in.nextInt();
        switch (index) {
            case 1:  Insert();
                break;
            case 2:  Update();
                break;
            case 3:  Select();
                break;
            case 4:  Delete();
                break;
            case 5: AddBooking();
            default:
                break;
        }
        Input();
    }
    public static void AddBooking()
    {
        System.out.println("User ID:");
        System.out.println("Product ID:");
        int user_id = in.nextInt();
        int product_id = in.nextInt();
        Booking Booking = new Booking(user_id);
        Booking= (Booking)businessLogic.Insert(Booking);
        Bookings Bookings = new Bookings(Booking.id,product_id);
        Bookings = (Bookings)businessLogic.Insert(Bookings);
        System.out.println("Insert ADD USER-PRODUCT completed");
        User user = (User) businessLogic.Select("User", "ID",Integer.toString(user_id));
        System.out.println("USER ID = " + user.id);
        System.out.println("NAME = " + user.name);
        System.out.println("SURNAME = " + user.surname);
        Product product = (Product)businessLogic.Select("Product", "ID", Integer.toString(product_id));
        System.out.println( "PRODUCT ID = " + product.id );
        System.out.println( "TITLE = " + product.title );
    }
    public static void Create()
    {
        businessLogic.Create();
    }
    public static void Insert()
    {
        System.out.println("Insert: 1-User, 2-Product, 3-Booking, 4-Bookings ");
        int index = in.nextInt();
        switch (index) {
            case 1:
                System.out.println("User:");
                System.out.println("Insert: NAME");
                System.out.println("Insert: SURNAME");
                String name =in.next();
                String surname = in.next();
                User user = new User(name, surname);
                user = (User)businessLogic.Insert(user);
                System.out.println("Insert User completed");
                System.out.println("ID = " + user.id);
                System.out.println("NAME = " + user.name);
                System.out.println("SURNAME = " + user.surname);
                break;
            case 2:
                System.out.println("Product:");
                System.out.println("Insert: TITLE");
                String title = in.next();
                Product product = new Product(title);
                product= (Product)businessLogic.Insert(product);
                System.out.println("Insert Product completed");
                System.out.println("ID = " + product.id);
                System.out.println("TITLE = " + product.title);
                break;
            case 3:
                System.out.println("Booking:");
                System.out.println("Insert: ID_USER");
                int ID_USER = in.nextInt();
                Booking Booking = new Booking(ID_USER);
                Booking= (Booking)businessLogic.Insert(Booking);
                System.out.println("Insert Booking completed");
                System.out.println("ID = " + Booking.id);
                System.out.println("ID_USER = " + Booking.id_user);
                break;
            case 4:
                System.out.println("Bookings:");
                System.out.println("Insert: ID_BOOKING");
                System.out.println("Insert: ID_PRODUCT");
                int ID_BOOKING = in.nextInt();
                int ID_PRODUCT = in.nextInt();
                Bookings Bookings = new Bookings(ID_BOOKING,ID_PRODUCT);
                Bookings = (Bookings)businessLogic.Insert(Bookings);
                System.out.println("Insert Bookings completed");
                System.out.println("id_booking = " + Bookings.id_booking);
                System.out.println("id_product = " + Bookings.id_product);
                break;
            default:
                break;
        }
        System.out.println("--------------------------------------------");
    }
    public static void Update()
    {
        System.out.println("Update: 1-User, 2-Product, 3-Booking");
        int index = in.nextInt();
        String str="";
        switch (index) {
            case 1:
                User user = new User();
                System.out.println("User ID:");
                str = new Scanner(System.in).nextLine();
                user = (User) businessLogic.Select("User", "ID", str);
                System.out.println("ID = " + user.id);
                System.out.println("NAME = " + user.name);
                System.out.println("SURNAME = " + user.surname);
                if(user.id != 0) {
                    System.out.println("Update: NAME");
                    System.out.println("Update: SURNAME");
                    user.name = in.next();
                    user.surname = in.next();
                    businessLogic.Update(user);
                }
                break;
            case 2:
                Product product = new Product();
                System.out.println("Product ID:");
                str= new Scanner(System.in).nextLine();
                product = (Product)businessLogic.Select("Product", "ID", str);
                System.out.println( "ID = " + product.id );
                System.out.println( "TITLE = " + product.title );
                if(product.id != 0) {
                    System.out.println("Update: TITLE");
                    product.title = in.next();
                    businessLogic.Update(product);
                }
                break;
            case 3:
                List<Booking> booking = new ArrayList<Booking>();
                System.out.println("Booking ID:");
                str= new Scanner(System.in).nextLine();
                booking = (ArrayList<Booking>)businessLogic.Select("Booking", "ID", str);
                for (Booking b:booking)
                {
                    System.out.println("ID = " + b.id);
                    System.out.println("ID_USER = " + b.id_user);
                }
                if(booking.get(0).id != 0) {
                    System.out.println("Update: ID_USER");
                    booking.get(0).id_user = in.nextInt();
                    businessLogic.Update(booking.get(0));
                }
                break;
            default:
                break;
        }
        System.out.println("Update completed");
        System.out.println("--------------------------------------------");
    }
    public static void Select()
    {
        System.out.println("Select: 1-User, 2-Product, 3-Booking 4-Bookings");
        int index = in.nextInt();
        String str="";
        switch (index) {
            case 1:
                User user = new User();
                System.out.println("User:");
                System.out.println("Select:1-ID, 2-NAME, 3-SURNAME 4-ALL");
                index = in.nextInt();
                if(index>0 && index<5)
                {
                    switch (index) {
                        case 1:
                            System.out.println("User ID:");
                            str = new Scanner(System.in).nextLine();
                            user = (User) businessLogic.Select("User", "ID", str);
                            System.out.println("ID = " + user.id);
                            System.out.println("NAME = " + user.name);
                            System.out.println("SURNAME = " + user.surname);
                            break;
                        case 2:
                            System.out.println("User NAME:");
                            str = new Scanner(System.in).nextLine();
                            user = (User) businessLogic.Select("User", "NAME", str);
                            System.out.println("ID = " + user.id);
                            System.out.println("NAME = " + user.name);
                            System.out.println("SURNAME = " + user.surname);
                            break;
                        case 3:
                            System.out.println("User SURNAME:");
                            str = new Scanner(System.in).nextLine();
                            user = (User) businessLogic.Select("User", "SURNAME", str);
                            System.out.println("ID = " + user.id);
                            System.out.println("NAME = " + user.name);
                            System.out.println("SURNAME = " + user.surname);
                            break;
                        case 4:
                            List<User> users = (List<User>) businessLogic.Select("User", "ALL", str);
                            for (User u:users) {
                                System.out.println("ID = " + u.id);
                                System.out.println("NAME = " + u.name);
                                System.out.println("SURNAME = " + u.surname);
                            }
                            return;
                        default:
                            break;
                    }
                    System.out.println("User Select:1-Booking, 2-Product");
                    index = in.nextInt();
                    List<Booking> booking;
                    switch (index) {
                        case 1:
                            System.out.println( "Booking: ");
                            booking = (List<Booking>)businessLogic.Select("Booking", "ID_USER", Integer.toString(user.id));
                            for (Booking b:booking) {
                                System.out.println("ID = " + b.id);
                                System.out.println("ID_USER = " + b.id_user);
                            }
                            break;
                        case 2:
                            System.out.println( "Product: ");
                            booking = (List<Booking>)businessLogic.Select("Booking", "ID_USER", Integer.toString(user.id));
                            for (Booking b:booking)
                            {
                                List<Bookings> bookings = (ArrayList<Bookings>)businessLogic.Select("Bookings", "ID_BOOKING", Integer.toString(b.id));
                                for (Bookings bk:bookings)
                                {
                                    Product product = (Product)businessLogic.Select("Product", "ID", Integer.toString(bk.id_product));
                                    System.out.println( "NAME = " + product.title );
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
                break;
            case 2:
                Product product = new Product();
                System.out.println("Product:");
                System.out.println("Select: 1-ID, 2-TITLE 3-ALL");
                index = in.nextInt();
                switch (index) {
                    case 1:
                        System.out.println("Product ID:");
                        str= new Scanner(System.in).nextLine();
                        product = (Product)businessLogic.Select("Product", "ID", str);
                        System.out.println( "ID = " + product.id );
                        System.out.println( "TITLE = " + product.title );
                        break;
                    case 2:
                        System.out.println("Product TITLE:");
                        str= new Scanner(System.in).nextLine();
                        product = (Product)businessLogic.Select("Product", "TITLE", str);
                        System.out.println( "ID = " + product.id );
                        System.out.println( "TITLE = " + product.title);
                        break;
                    case 3:
                        List<Product> products = (List<Product>) businessLogic.Select("Product", "ALL", str);
                        for (Product p:products)
                        {
                            System.out.println("ID = " + p.id);
                            System.out.println("TITLE = " + p.title);
                        }
                    default:
                        break;
                }
                break;
            case 3:
                List<Booking> booking = new ArrayList<Booking>();
                System.out.println("Booking:");
                System.out.println("Select: 1-ID, 2-ID_USER 3-ALL");
                index = in.nextInt();
                switch (index) {
                    case 1:
                        System.out.println("Booking ID:");
                        str= new Scanner(System.in).nextLine();
                        booking = (ArrayList<Booking>)businessLogic.Select("Booking", "ID", str);
                        for (Booking b:booking) {
                            System.out.println("ID = " + b.id);
                            System.out.println("ID_USER = " + b.id_user);
                        }
                        break;
                    case 2:
                        System.out.println("Booking ID_USER:");
                        str= new Scanner(System.in).nextLine();
                        booking = (List<Booking>)businessLogic.Select("Booking", "ID_USER", str);
                        for (Booking b:booking) {
                            System.out.println("ID = " + b.id);
                            System.out.println("ID_USER = " + b.id_user);
                        }
                        break;
                    case 3:
                        List<Booking> Booking = (List<Booking>) businessLogic.Select("Booking", "ALL", str);
                        for (Booking b:Booking) {
                            System.out.println("ID = " + b.id);
                            System.out.println("ID_USER = " + b.id_user);
                        }
                        return;
                    default:
                        break;
                }
                break;
            case 4:
                List<Bookings> bookings = new ArrayList<Bookings>();
                System.out.println("Bookings:");
                System.out.println("Select: 1-ID_BOOKING, 2-ID_PRODUCT 3-ALL");
                index = in.nextInt();
                switch (index) {
                    case 1:
                        System.out.println("Booking ID_BOOKING:");
                        str= new Scanner(System.in).nextLine();
                        bookings = (ArrayList<Bookings>)businessLogic.Select("Bookings", "ID_BOOKING", str);
                        for (Bookings b:bookings) {
                            System.out.println("ID_BOOKING = " + b.id_booking);
                            System.out.println("ID_PRODUCT = " + b.id_product);
                        }
                        break;
                    case 2:
                        System.out.println("Booking ID_PRODUCT:");
                        str= new Scanner(System.in).nextLine();
                        bookings = (List<Bookings>)businessLogic.Select("Bookings", "ID_PRODUCT", str);
                        for (Bookings b:bookings) {
                            System.out.println("ID_BOOKING = " + b.id_booking);
                            System.out.println("ID_PRODUCT = " + b.id_product);
                        }
                        break;
                    case 3:
                        List<Bookings> Bookings = (List<Bookings>) businessLogic.Select("Bookings", "ALL", str);
                        for (Bookings bs:Bookings) {
                            System.out.println("id_booking = " + bs.id_booking);
                            System.out.println("id_product = " + bs.id_product);
                        }
                        return;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        System.out.println("--------------------------------------------");
    }
    public static void Delete()
    {
        System.out.println("Delete: 1-User, 2-Product, 3-Booking");
        int index = in.nextInt();
        int id;
        switch (index) {
            case 1:
                System.out.println("Delete User: ID");
                id = in.nextInt();
                List<Booking> booking = (List<Booking>)businessLogic.Select("Booking", "ID_USER", Integer.toString(id));
                for (Booking b:booking)
                {
                    List<Bookings> bookings = (ArrayList<Bookings>)businessLogic.Select("Bookings", "ID_BOOKING", Integer.toString(b.id));
                    for (Bookings bk:bookings)
                    {
                        businessLogic.Delete("Bookings","ID_BOOKING", bk.id_booking);
                    }
                    businessLogic.Delete("Booking","ID", b.id_user);
                }
                businessLogic.Delete("User","ID", id);
                break;
            case 2:
                System.out.println("Delete Product: ID");
                id = in.nextInt();
                List<Bookings> bookings = (ArrayList<Bookings>)businessLogic.Select("Bookings", "ID_PRODUCT", Integer.toString(id));
                for (Bookings bk:bookings)
                {
                    businessLogic.Delete("Bookings","ID_PRODUCT", bk.id_product);
                }
                businessLogic.Delete("Product","ID", id);
                break;
            case 3:
                System.out.println("Delete Booking: ID");
                id = in.nextInt();
                List<Bookings> bookingse = (ArrayList<Bookings>)businessLogic.Select("Bookings", "ID_BOOKING", Integer.toString(id));
                for (Bookings bk:bookingse)
                {
                    businessLogic.Delete("Bookings","ID_BOOKING", bk.id_booking);
                }
                businessLogic.Delete("Booking","ID", id);
                break;
            default:
                break;
        }
        System.out.println("Delete completed");
        System.out.println("--------------------------------------------");

    }

}
