package Task08_2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BookStore {

    private final DBManager dbManager;
    private Connection conn;
    private Statement statement;

    public BookStore() throws SQLException {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
        this.statement = conn.createStatement();
        
    }

    public void connectBookStoreDB() 
    {
        //use the conn, initialize database by creating BOOK Table and insert records
        String url = "jdbc:derby://localhost:1527/BookStoreDB";
        String userName = "pdc";
        String password = "123";
        try
        {
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println(url+" connected...");
        }
        catch(SQLException ex)
        {
            System.err.println("SQLException: "+ ex.getMessage());
        }
    }

    public void createPromotionTable() throws SQLException {
        /* You may need the following SQL statements for this method:

         * Create the table:
           CREATE TABLE PROMOTION (CATEGORY VARCHAR(20), DISCOUNT INT);

         * Insert records into the table: 
           INSERT INTO PROMOTION VALUES ('Fiction', 0),
           ('Non-fiction', 10),
           ('Textbook', 20);

         */
        //statement = conn.createStatement();
        String newTable = "PROMOTION";
        if(tableExists(conn, newTable))
        {
           System.out.println("table exists, dropping table");
           String query = "DROP TABLE "+newTable;
           statement.executeUpdate(query);
        }
        
        {
            String sqlCreateTable = "CREATE TABLE "+newTable+" (CATEGORY VARCHAR(20), DISCOUNT INT)";
            statement.executeUpdate(sqlCreateTable);
            String insertValues = "INSERT INTO "+newTable+" VALUES ('Fiction', 0), ('Non-fiction', 10), ('Textbook', 20)";
            statement.executeUpdate(insertValues);
            System.out.println("table created");
        }
    }

    public boolean tableExists(Connection conn, String tableName) throws SQLException
    {
        DatabaseMetaData meta = conn.getMetaData();
        ResultSet rs = meta.getTables(null, null, tableName, new String[] {"TABLE"});
        
        return rs.next();
    }
    
    
    public ResultSet getWeekSpecial() throws SQLException {
        /* You may need the following SQL statements for this method:

        * Query multiple tables:
        
          SELECT TITLE, PRICE, DISCOUNT FROM BOOK, PROMOTION WHERE BOOK.CATEGORY=PROMOTION.CATEGORY;

         */
        //statement = conn.createStatement();
        ResultSet rs = null;
        Statement rsStatement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = rsStatement.executeQuery("SELECT TITLE, PRICE, DISCOUNT FROM BOOK, PROMOTION WHERE BOOK.CATEGORY=PROMOTION.CATEGORY");
        rs.beforeFirst();

        boolean flag = rs.next();
        System.out.println("does rs have a next ? "+flag);
        return (rs);

    }

    public void createWeekSpecialTable(ResultSet rs) throws SQLException 
    {
        //statement = conn.createStatement();
        try
        {
            //Statement statement = conn.createStatement();
            String newTable = "WEEKSPECIAL";
            if (tableExists(conn, newTable)) {
                String query = "DROP TABLE " + newTable;
                statement.executeUpdate(query);
                System.out.println("table exists");
            }
            String sqlCreateTable = "CREATE TABLE " + newTable + " (Title VARCHAR(30), SpecialPrice FLOAT)";
            statement.executeUpdate(sqlCreateTable);
            System.out.println("table created");

            String valueHolder = "VALUES ";
            rs.beforeFirst();
            while (rs.next() == true) 
            {
                String attribute1 = rs.getString("TITLE");
                float attribute2 = rs.getFloat(2) - (rs.getFloat(2) * (rs.getFloat(3) / 100));
                DecimalFormat df = new DecimalFormat("#.##");
                valueHolder += "('" + attribute1 + "', " + df.format(attribute2) + "),";
            }

            StringBuffer sb = new StringBuffer(valueHolder);
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
            String insert = "INSERT INTO " + newTable + " " + sb;
            statement.executeUpdate(insert);  
                
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(BookStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
