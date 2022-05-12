/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task01_2;

import java.util.Scanner;

/**
 *
 * @author myles
 */
public class ShapeCalculator2 
{
    Scanner sc;
    public static void main(String[] args) 
    {
        try
        (Scanner sc = new Scanner(System.in)) 
        {
            System.out.println("Please Select: \n(1) Rectangle\n(2) Circle\n(3) Square");
           
            try
            {
                int userInput = sc.nextInt();
                
                if(userInput == 1)
                {
                    Rectangle newRec = new Rectangle();
                    System.out.println("Enter rectangle length :");
                    newRec.setLength(sc.nextFloat());                             
                    System.out.println("Enter rectangle width :");
                    newRec.setWidth(sc.nextFloat());
                    newRec.calculateArea();
                    newRec.printInfo();
                }
                if(userInput == 2)
                {
                    Circle newCirc = new Circle();
                    System.out.println("Enter circle radius :");
                    newCirc.setRadius(sc.nextFloat());
                    newCirc.calculateArea();
                    newCirc.printInfo();
                }
                if(userInput == 3)
                {
                    Square newSq = new Square();
                    System.out.println("Enter square's side length :");
                    newSq.setSide(sc.nextFloat());
                    newSq.calculateArea();
                    newSq.printInfo();
                }
                else
                {
                    System.out.println("Wrong input");
                }
                
            }
            catch(Exception e)
            {
                System.out.println("Invalid Input. Not an integer");
            }
                
        }
    }
}
