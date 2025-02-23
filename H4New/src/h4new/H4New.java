
//ahmad abraham
//used canvas solution for hard parts
package h4new;

import java.io.*;
import java.util.*;

public class H4New {

    
    public static void main(String[] args) {
        
        LinkedList<String>[] AZarray = new LinkedList[26];
        createList(AZarray);
        int out = Output();
 
        printList(AZarray, out);
 
    }
    public static void createList(LinkedList<String>[] arr)
    {Scanner scnr = null;
        FileReader fileInput = null;   
        for (int i = 0; i < 26; i++) {
            arr[i] = new LinkedList<>(); //create all the linked lists
        }

        try {

            fileInput = new FileReader("words_no_duplicates-edited.txt");
            scnr = new Scanner(fileInput);
         
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
        

        }
         while (scnr.hasNext()) {  //add words to correct list
               String line = scnr.nextLine();
                int index = line.charAt(0) - 97;
                arr[index].add(line);
               
    }
    }
    public static void printList(LinkedList<String>[] arr, int index ) { 
        Iterator<String> iter;
         iter= arr[index].listIterator(); 
          while(iter.hasNext()) {
                System.out.println(iter.next());
          }
    }
    public static int Output()
    {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a character to see the list");
        String input = scnr.next();
        input = input.toLowerCase();
        char charInput = input.charAt(0); //get first character
        int output = (int) charInput - 97; //and its index
        
        while (output < 0 || output > 26) { //trap user if not in range
            System.out.println("Please input a valid character");
            input = scnr.next();
            input = input.toLowerCase();
            charInput = input.charAt(0);
            output = (int) charInput - 97;
           
        }
    return output;
    }
}
    

