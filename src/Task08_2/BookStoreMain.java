package Task08_2;

import java.sql.SQLException;

public class BookStoreMain {

    public static void main(String[] args) throws SQLException 
    {
       BookStore bookstore = new BookStore();
       bookstore.createPromotionTable();
       bookstore.createWeekSpecialTable(bookstore.getWeekSpecial());
    }
}
