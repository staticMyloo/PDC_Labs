/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task01_2;

/**
 *
 * @author myles
 */
public class Rectangle extends Shape
{
    private float width;
    private float length;
    
    public Rectangle(String name)
    {
        setName(name);
    }
    
    public Rectangle() 
    {
      super("Rectangle");
    }
    
     @Override
     public void printInfo() 
    {
        System.out.println(this.shapeName);
        System.out.printf("%.3f\n", this.area);
    }
    
    @Override
    public void calculateArea() 
    {
        this.area = width * length;
    }

    /**
     * @return the width
     */
    public float getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public float getLength() {
        return length;
    }

    /**
     * @param length the height to set
     */
    public void setLength(float length) {
        this.length = length;
    }
}
