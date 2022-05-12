/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task02_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author myles
 */
public class FileIO 
{
    public static void printList(ArrayList<String> list, PrintWriter pw)
    {
        for(int i = 0; i < list.size(); i++)
        {
            pw.print(list.get(i)+"\n");
        }
        
    }
    
    public static void main(String[] args) throws IOException 
    {
        
        try
        {
            ArrayList<String> stuData = new ArrayList<>();
            FileReader fr = new FileReader("./resources/T02_scores.txt");
            BufferedReader inputStream = new BufferedReader(fr);
            Scanner sc = new Scanner(System.in);
            String txtLine = null;
            int listCounter = 0;
            
            while ((txtLine = inputStream.readLine()) != null) 
            {
                stuData.add(txtLine);
            }
            
            char programLoop = 'Y';
            
            while(programLoop != 'x')
            {
           
                System.out.println("Enter student's name : ");
                String stuName = sc.nextLine();
                System.out.println("Enter student's score : ");
                int stuIntScore = sc.nextInt();
                String stuScore = String.valueOf(stuIntScore);
                boolean searched = false;
                
                for(int i = 0; i < stuData.size(); i++)
                {
                   stuName = stuName.substring(0,1).toUpperCase() + stuName.substring(1).toLowerCase();

                   if(stuData.get(i).contains(stuName))
                   {
                       System.out.println("Found "+stuName);
                       searched = true;

                       if(stuData.get(i).contains(stuScore))
                       {
                           System.out.println(stuName+" has a score of "+stuScore);
                           System.out.println("Override student's score? Y / N ?");
                           while(true)
                           {
                               char choice = sc.next().charAt(0);
                               if(choice == 'Y')
                               {
                                   System.out.println("Enter new score: ");
                                   int newScore = sc.nextInt();
                                   String newScoreStr = String.valueOf(newScore);
                                   stuData.set(i, stuName+" "+newScoreStr);
                                   break;
                               }
                               if(choice == 'N')
                               {
                                   break;
                               }

                           }
                       }
                       else if(!stuData.get(i).contains(stuScore))
                       {
                           System.out.println("Score does not match current data.");
                           String noNameScore = stuData.get(i).replace(stuName, "");
                           System.out.println("Student's current score :"+noNameScore);
                           System.out.println("Override student's score? Y / N ?");
                           while(true)
                           {
                               char choice = sc.next().charAt(0);
                               if(choice == 'Y')
                               {
                                   System.out.println("Enter new score: ");
                                   int newScore = sc.nextInt();
                                   String newScoreStr = String.valueOf(newScore);
                                   stuData.set(i, stuName+" "+newScoreStr);
                                   break;
                               }
                               if(choice == 'N')
                               {
                                   break;
                               }
                           }
                       }
                   }
                   else if(i == stuData.size() - 1 && !searched)
                   {
                       i = stuData.size();
                       System.out.println("Name not found");
                       while(true)
                       {
                        System.out.println("Add student? "+stuName+" Y / N");
                        char choice = sc.next().charAt(0);
                        if(choice == 'Y')
                        {
                            System.out.println("Enter score for "+stuName);
                            int tempScore = sc.nextInt();
                            stuData.add(stuName+" "+tempScore);
                            break;
                        }
                        if(choice == 'N')
                        {
                            break;
                        }
                       }
                   }     
                }

                System.out.println("Search for another student? Y / N");
                programLoop = sc.next().charAt(0);
                if(programLoop == 'N' || programLoop == 'n')
                {
                    programLoop = 'x';
                }
                else if(programLoop != 'Y' || programLoop != 'y' || programLoop != 'N' || programLoop != 'n' || programLoop != 'x')
                {
                    System.out.println("Invalid input.");
                }  
            }   
                System.out.println(stuData);
                listCounter++;

                PrintWriter pw = new PrintWriter(new FileOutputStream("./resources/T02_scores.txt"));
                printList(stuData, pw);

                inputStream.close();
                fr.close();
                pw.close();
                //System.out.print(stuData);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
    }
}
