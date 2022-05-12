/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task08_3;

import java.sql.SQLException;

/**
 *
 * @author myles
 */
public class SimpleBookStoreMain 
{
    public static void main(String[] args) throws SQLException {
        
    SimpleBookStore sbs = new SimpleBookStore();
    sbs.createPromotionTable();
    sbs.createWeekSpecialTable(sbs.getWeekSpecial());
    }
    
    
}
