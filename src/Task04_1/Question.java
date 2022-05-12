/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task04_1;

import java.util.Random;

/**
 *
 * @author myles
 */
public final class Question
{
    private int operandOne;
    private int operandTwo;
    private String operator;
    private double result;
    
    public Question()
    {
        this.operandOne = generateNumber((100)+1);
        this.operandTwo = generateNumber((100)+1);
        switch (this.generateNumber(4)) 
        {
            case 0:
                operator = "+";
                this.result = operandOne + operandTwo;
                break;
            case 1:
                operator = "-";
                this.result = operandOne - operandTwo;
                break;
            case 2:
                operator = "*";
                this.result = operandOne * operandTwo;
                break;
            case 3:
                operator = "/";
                //Keep assigning a new random number to num2 if num2 is 0.
                while (operandTwo == 0) {
                    operandTwo = this.generateNumber(100);
                }
                // In java, the result of an integer divided by an integer is still an integer.
                this.result = 1d * operandOne / operandTwo;
                // Hence, we first let num1 times 1.0 to make num1 become a double type number.
                break;
            default:
                break;
        }
        
    }
    
    @Override
    public String toString()
    {
        return operandOne+operator+operandTwo+"=?";
    }
    
    public int generateNumber(int range) 
    {
        return (new Random()).nextInt(range);
    }
    /**
     * @return the result
     */
    public double getResult()
    {
        return result;
    }
}
