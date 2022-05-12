/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task01_2;

/**
 *
 * @author myles
 */
public class ShapeCalculator1 
{
    public static void main(String[] args) 
    {
       Circle cirObj = new Circle();
       cirObj.setRadius(2.5f);
        
       Rectangle recObj = new Rectangle();
       recObj.setWidth(12f);
       recObj.setLength(16.5f);
        
       Square squObj = new Square();
       squObj.setSide(3.3f);
       
       cirObj.calculateArea();
       recObj.calculateArea();
       squObj.calculateArea();
        
       cirObj.printInfo();
       recObj.printInfo();
       squObj.printInfo();
       
    }
}

