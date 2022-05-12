/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task03_2;

import Task03_1.ResultString;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author myles
 */
public class MathQuizProgram 
{
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
       
        int operatorChoice = rand.nextInt(4) + 1;
        int userScore = 0;
        char loop = 'Y';
        ResultString operation = new ResultString();
        
        System.out.println("=====Welcome to the Math Quiz!=====");
        while(true)
        {
            double randOne = rand.nextInt(100) + 1;
            double randTwo = rand.nextInt(100) + 1;
            System.out.println("=====Generating a random question=====");
            generateOperator(operatorChoice, operation);
            double product = generateProduct(randOne, randTwo, operation);
            System.out.println("What is "+randOne+" "+operation.str+" "+randTwo+" ?");
            try
            {
                double answer = sc.nextDouble();
                if(answer == product)
                {
                    System.out.println("Correct!");
                    userScore += 10;
                }
                if(answer != product)
                {
                    System.out.println("Wrong! Answer is "+ product);
                    userScore -= 10;
                }
                    System.out.println("Your total score is "+ userScore+".");
                    System.out.println("Play again? (Y / N)");
                    loop = sc.next().charAt(0);

                    if(loop == 'N' || loop == 'n')
                    {
                        System.out.println("=====Thanks for playing!=====");
                        System.out.println("=====Your score is : "+userScore+"=====");
                        break;
                    }
                    if(loop == 'Y' || loop == 'y')
                    {
                        continue;
                    }
                    else if(loop != 'Y' || loop != 'y' || loop != 'N' || loop != 'n' || loop != 'x')
                    {
                        System.out.println("Invalid input. Try again");
                        sc.next();
                    }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input! Not a number.");
                sc.next();
            }
        }
    }
    
    public static double generateProduct(double randOne, double randTwo, ResultString s)
    {
        double product = 0;
        if(s.str.equals("*")) {product = randOne * randTwo; return product;}
        if(s.str.equals("/")) {product = randOne / randTwo; return product;}
        if(s.str.equals("-")) {product = randOne - randTwo; return product;}
        if(s.str.equals("+")) {product = randOne + randTwo; return product;}
        return product;
    }
    
    public static void generateOperator(int operatorChoice, ResultString operation)
    {
        if(operatorChoice == 1) {operation.str = "*";}
        if(operatorChoice == 2) {operation.str = "/";}
        if(operatorChoice == 3) {operation.str = "-";}
        if(operatorChoice == 4) {operation.str = "+";}
    }
}
