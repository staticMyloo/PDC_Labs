/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task04_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author myles
 */
public class MathQuizNew 
{  
    public static void main(String[] args) throws IOException 
    {
        
        try
        {
            
        QuestionList qList = new QuestionList();
        ArrayList<String> names = new ArrayList<>();
        FileReader fr = new FileReader("./resources/T04_users.txt");
        BufferedReader inputStream = new BufferedReader(fr);
        Scanner sc = new Scanner(System.in);
        String txtLine;
        boolean exists = false;
        int userScore = 0;
        int rounds = 3;
        
         while ((txtLine = inputStream.readLine()) != null) 
         {
                names.add(txtLine);
         }
        
        System.out.println("Enter a user name:");
        String userQuery = sc.nextLine();
        
        for(int i = 0; i < names.size(); i++)
        {
            if(names.get(i).contains(userQuery))
            {
                String splitName[] = names.get(i).split(" ");
                userScore = Integer.parseInt(splitName[1]);
                exists = true;
            }
        }
        if(!exists)
        {
            names.add(userQuery+" "+userScore);
        }
        
        while(rounds > 0)
        {
            System.out.println(qList.getQuestionList().get(rounds));
            Double answer = sc.nextDouble();
            if(answer == qList.getQuestionList().get(rounds).getResult())
            {
                System.out.println("Correct!");
                userScore +=10;
            }
            else
            {
                System.out.println("Wrong!");
                userScore -=10;
            }
            
            rounds--;
        }
        
        for(int i = 0; i < names.size(); i++)
        {
            if(names.get(i).contains(userQuery))
            {
                names.set(i, userQuery.toLowerCase()+" "+userScore);
            }
        }
        
        FilePrinter fp = new FilePrinter();
        fp.printScores(names);
        //.close called in Class method.
        System.out.println("Your final score is "+userScore+"!");
        fr.close();
        }
         catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
    }
}  

