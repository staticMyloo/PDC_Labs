package Task09_1;

import static java.lang.Math.E;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class SumAll {

    public static void main(String[] args) {

        SumAll sa = new SumAll();
        Vector<Integer> vec = new Vector<>();
        Scanner scan = new Scanner(System.in);
        int num = 0;

        do {
            System.out.println("Input a non-zero integer, or input 0 to stop");
            num = scan.nextInt();
            vec.add(num);
        } while (num != 0);
        System.out.println("1: " + sa.sumNums1(vec));
        System.out.println("2: " + sa.sumNums2(vec));

        Object[] intArray = vec.toArray();
        System.out.println("3: " + sa.sumNums3(intArray));

    }

    public int sumNums1(Vector v) 
    {
        int sum = 0;
        Iterator iter = v.iterator();
        
        while(iter.hasNext())
        {
            sum += (int) iter.next();        
        }
        //add your code here

        return sum;
    }

    public int sumNums2(Vector<Integer> v) {
        int sum = 0;
        int i = v.size();
        
        for(;i > 0; i--)
        {
            Integer next = v.get(i-1);
            sum += next;
        }
        
        return sum;
    }

    public int sumNums3(Object... objs) {
        int sum = 0;
        for(Object ob : objs)
        {
            sum += (int) ob;
        }
        return sum;
    }

}
