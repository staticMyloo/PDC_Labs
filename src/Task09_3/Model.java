/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task09_3;

import java.sql.SQLException;
import java.util.Observable;
import java.util.Random;


/**
 *
 * @author myles
 */
public class Model extends Observable{
        

    public DataBase db;
    public Data data;
    public int answer = 0;
    public String username;
    
    public Model()
    {
        this.db = new DataBase();
        this.db.dbsetup();
    }
    
    public void checkName(String username, String password)
    {
        this.username = username;
        this.data = this.db.checkName(username, password);
        
        if(data.loginFlag)
        {
            this.newQuestion();
        }
        
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void newQuestion()
    {
        this.data.num1 = getNumber();
        this.data.num2 = getNumber();
        this.answer = this.data.num1 + this.data.num2;
    }
    
    public int getNumber()
    {
        Random generator = new Random();
        int num = generator.nextInt(100);
        return num;
    }
    
    public void checkAnswer(String answer)
    {
        if(answer.equals(this.answer + ""))
        {
            data.currentScore += 10;
        }
        else
        {
            data.currentScore -= 10;
        }
        
        this.newQuestion();
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void quitGame() throws SQLException
    {
        this.db.quitGame(this.data.currentScore, this.username);
        this.data.quitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    
    
}
