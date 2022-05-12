package Task08_3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class SimpleBookStore {

    SimpleDBManager dbManager;
    Connection conn;
    Statement statement;

    public SimpleBookStore() throws SQLException {
        dbManager = new SimpleDBManager();
        //
        this.conn = dbManager.getConnection();
        this.statement = conn.createStatement();
        try {
            
             String newTable = "TABLE";
             
        if(tableExists(conn, newTable))
        {
           System.out.println("table exists, dropping table");
           String query = "DROP TABLE "+newTable;
           statement.executeUpdate(query);
        }
        
        statement.addBatch("CREATE  TABLE BOOK  (BOOKID  INT,   TITLE   VARCHAR(50),   CATEGORY   VARCHAR(20),   PRICE   FLOAT)");
        statement.addBatch("INSERT INTO BOOK VALUES (1, 'Slum Dog Millionaire', 'Fiction', 19.90),\n"
                + "(2, 'Run Mummy Run', 'Fiction', 28.00),\n"
                + "(3, 'The Land of Painted Caves', 'Fiction', 15.40),\n"
                + "(4, 'Cook with Jamie', 'Non-fiction', 55.20),\n"
                + "(5, 'Far Eastern Odyssey', 'Non-fiction', 24.90),\n"
                + "(6, 'Open', 'Non-fiction', 33.60),\n"
                + "(7, 'Big Java', 'Textbook', 55.00),\n"
                + "(8, 'Financial Accounting', 'Textbook', 24.80)");
        statement.executeBatch();
        dbManager.closeConnections();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        //System.out.println("BOOKSTORE");
    }

    public static void main(String[] args) throws SQLException {
        SimpleBookStore sbs = new SimpleBookStore();
         
        
       
    }

    public void closeConnection() {
        this.dbManager.closeConnections();
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

    public static boolean tableExists(Connection conn, String tableName) throws SQLException
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
        {}
    }
}
