/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task04_1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author myles
 */
public class FilePrinter 
{
    private PrintWriter pw;
    
    public FilePrinter() throws FileNotFoundException
    {
        pw = new PrintWriter(new FileOutputStream("./resources/T04_users.txt"));
    }
    
    public void printScores(ArrayList<String> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            pw.print(list.get(i)+"\n");
        }
        pw.close();
    }
   
 }
