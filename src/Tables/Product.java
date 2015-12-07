package Tables;

/**
 * Created by Abbas on 16.11.2015.
 */
public class Product {
    public int id;
    public String title;
    public Product(){}
    public Product(String title)
    {
        this.title=title;
    }
    public Product(int id,String title)
    {
        this.id = id;
        this.title=title;
    }
}
