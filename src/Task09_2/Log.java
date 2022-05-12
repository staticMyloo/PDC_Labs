package Task09_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {

    private static Log log;
    public static BufferedWriter bufWriter;
    public static int instanceNumber = 0;

    public Log(String str) {
        try {
            this.bufWriter = new BufferedWriter(new FileWriter("./resources/T09_log.txt", true));

            System.out.println("Writing Log.");
            bufWriter.write(str);
            bufWriter.flush();

        } catch (IOException e) {
        }
        
        instanceNumber++;
        System.out.println("A log instance has been created");
    }
    
    public static synchronized Log getSingletonInstance(String str) throws IOException
    {
        if(log == null)
        {
            log = new Log(str);
        }
        else
        {
            System.out.println("Writing Log.");
            try
            {
                bufWriter.write(str);
                bufWriter.flush();
            }
            catch(IOException ex)
            {}
                
        }
        return log;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }
    
}
