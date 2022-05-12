package Task05_2;



public class Star {
    
    
    private final Object monObj = new Object();
    private int count;

    public Star(int count)
    {
        this.count = count;
    }

    public void printFigure()
    {
        SpacePrinter spaceP = new SpacePrinter();
        StarPrinter starP = new StarPrinter();
        Thread t1 = new Thread(spaceP);
        Thread t2 = new Thread(starP);
        
        t2.start();
        t1.start();
    }
    
    public static void main(String[] args) {
        Star star = new Star(9);
        star.printFigure();
    }
    
    private class SpacePrinter implements Runnable
    {

        @Override
        public void run()
        {
            for (int i = 1; i <= count; i++) 
            {
                //Print spaces
                for (int j = 0; j < (9 - i); j++) 
                {
                    System.out.print("-");
                }
                
                
                synchronized (monObj)
                {
                    monObj.notify();
                    try
                    {
                        monObj.wait();
                    }
                    catch(InterruptedException e){}
                }
            }
            
            synchronized (monObj) 
            {
                monObj.notify();
            }    
        }
    }
    
    private class StarPrinter implements Runnable
    {
        @Override
        public void run()
        {  
            synchronized (monObj) 
            {
                try
                {
                    monObj.wait();
                }
                catch(InterruptedException e){}
            }
            
            for (int i = 1; i <= count; i++) 
            {
                
                 //Print stars
                for (int j = 0; j < (2 * i - 1); j++) 
                {
                    System.out.print("*");
                }
                    System.out.println();
                    
                    
                synchronized (monObj) 
                {
                    monObj.notify();
                    try
                    {
                        monObj.wait();
                    }
                    catch(InterruptedException e){}
                }
                
            }
                
        }
    }
        
        
  

}
