/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task01_2;

/**
 *
 * @author myles
 */
public class Circle extends Shape
{
    private float radius;
   
    public Circle() 
    {
       super("Circle");
    }
    
    @Override
    public void calculateArea() 
    {
        this.area = Math.PI * (Math.pow(radius, 2));
    }

    @Override
     public void printInfo() 
    {
        System.out.println(this.shapeName);
        System.out.printf("%.3f\n", this.area);
    }
    /**
     * @return the radius
     */
    public float getRadius() 
    {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(float radius) 
    {
        this.radius = radius;
    }
}
