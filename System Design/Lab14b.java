import java.util.*;

public class Lab14b{
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i<5000000; i++) 
            list.add(i);
        long endTime = System.currentTimeMillis();
        System.out.println("Travese time using index is " + (endTime - startTime)+"\n");

        int x;
        startTime = System.currentTimeMillis();
        for (int i : list) {
            x = i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Travese time using iterator is " + (endTime - startTime)+"\n");

    }
}