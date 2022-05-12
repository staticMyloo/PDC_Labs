/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task02_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author myles
 */
public class TextOutPut 
{
    public static void main(String[] args) 
    {
        try
        {
            FileReader fr = new FileReader("./resources/T02_input.txt");
            BufferedReader inputStream = new BufferedReader(fr);
            String line = null;
            PrintWriter pw = new PrintWriter(new FileOutputStream("./resources/T02_output.txt"));

            while((line = inputStream.readLine()) != null)
            {
                char charCheck[] = line.toCharArray();
                
                for(int i = charCheck.length - 1; i >= 0; i--)
                {
                   char validC = charCheck[i];
                   
                   if(Character.isLetter(validC))
                   {
                       System.out.print(Character.toUpperCase(charCheck[i]));
                       pw.print(Character.toUpperCase(charCheck[i]));
                   }
                      if(i == 0)
                      {
                          System.out.print("\n");
                          pw.print("\n");
                      }
                }
            }    
            
            inputStream.close();
            pw.close();
            fr.close();
        }
        catch(FileNotFoundException e)
        {               
            System.out.println("File not found.");
        }
        catch(IOException ex)
        {
            System.out.println("Error reading from file ");
        }
    }
}
