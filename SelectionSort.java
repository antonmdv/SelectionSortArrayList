/*
 * Author: Anton Medvedev, amedvedev2013@my.fit.edu
 * Course: CSE 1002, Section 03, Fall 2014
 * Project: interface
 */
import java.util.*;

public class SelectionSort{
    /**
     * Random number generator for positions
     */
    private static final Random RNG = new Random(Long.getLong("seed",System.nanoTime()));
    /**
     * sorts theList in order;
     * @param theList
     */
    public static void sort(List <Integer> theList){
        int hold1;
        int hold2;
        int LowIndex = 0;
        for(int i = 0; i < theList.size(); i++){
            hold1 = theList.get(i);
            hold2 = hold1;
            for(int n = i; n < theList.size(); n++){
                if(theList.get(n) < hold2){
                    hold2 = theList.get(n);
                    LowIndex = n;
                }
            }
            if(hold2 < hold1){
                Integer holdINT = theList.get(LowIndex);
                theList.set(LowIndex, theList.get(i));
                theList.set(i, holdINT);
            }
            
        }
    }
    /**
     * Main method 
     * @param args
     */
    public static void main(String[] args){
        List <Integer> theList = new ArrayList <Integer>();
        int input = Integer.parseInt(args[0]);
        int hold;
        for(int i = 1; i <= input; i++){
            hold = i;
            theList.add(hold);
        }
        Collections.shuffle(theList,RNG);
        System.out.println("Shuffled:");
        System.out.println(theList);
        sort(theList);
        System.out.println("Sorted:");
        System.out.println(theList);
    }
}