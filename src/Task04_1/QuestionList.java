/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task04_1;

import java.util.ArrayList;

/**
 *
 * @author myles
 */
public class QuestionList 
{
    private ArrayList<Question> questionList;
    
    public QuestionList()
    {
        questionList = new ArrayList<>();
        
        while(questionList.size() < 10)
        {
            Question newQuestion = new Question();
            if(!questionList.contains(newQuestion))
            {
                questionList.add(newQuestion);
            }
        }
    }
    
    @Override
    public String toString()
    {
        String s = "";
        
        for(Question question : getQuestionList())
        {
            s += (question);
            s += "\n";
        }
        
        return s;
    }
  
    /**
     * @return the questionList
     */
    public ArrayList<Question> getQuestionList() 
    {
        return questionList;
    }
    
}
