/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task01_2;

/**
 *
 * @author myles
 */
public class Square extends Rectangle
{
    private float sqLength;
    
    public Square()
    {
       super("Square");
    }

      @Override
    public void calculateArea() 
    {
      this.area = sqLength * sqLength;
    }
    
    public void setSide(float side)
    {
        this.sqLength = side;
    }
    
}
