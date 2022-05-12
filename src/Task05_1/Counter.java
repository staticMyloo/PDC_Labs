package Task05_1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Counter implements Runnable
{

    int num;

    public static void main(String[] args) {
        Counter oddcount = new Counter(1);
        Counter evencount = new Counter(2);
        
        Thread t1 = new Thread(oddcount);
        Thread t2 = new Thread(evencount);
        
        
        t1.start();
        t2.start();
    }

    public Counter(int i) {
        this.num = i;
    }

    public synchronized void printNum() throws InterruptedException
    {
        for (int j = this.num; j <= 10; j += 2)
        {
            System.out.print(j + " ");
            Thread.sleep(1000);
        }
    }

    @Override
    public void run()
    {
        try 
        {
            printNum();
        } catch (InterruptedException ex) {}
        
    }

}
