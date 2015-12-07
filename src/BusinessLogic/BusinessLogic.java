package BusinessLogic;
import Tables.*;
import DataBase.DataBase;

import java.util.List;

/**
 * Created by Abbas on 06.11.2015.
 */
public class BusinessLogic {
    public DataBase dataBase = new DataBase();
    public void Create()
    {
        dataBase.Create();
    }
    public Object Insert(Object object)
    {
        return dataBase.Insert(object);
    }
    public void Update(Object object)
    {
        dataBase.Update(object);
    }
    public Object Select(String table, String column, String item)
    {
        return dataBase.Select(table, column, item);
    }
    public void Delete(String table, String column, int id)
    {
        dataBase.Delete(table, column, id);
    }
}
