/*
 Write a program that inputs feet and inches, 
 creates a FeetAndInches object, puts it in a Node, 
and then adds (appends) these nodes to a list. 
Input is from the keyboard, the last values for feet and inches should be 0 0 . 
Files Node.java and FeetAndInches.java have already been uploaded, 
you just have to write the main method.
 */

//APPEND 

package listwithnodesexample;

import java.util.Scanner;


public class ListWithNodesExample {

    public static void main(String[] args) {
    Scanner keyboard = new Scanner (System.in);
    int feet, inches;
   
    Node tail= null;
    Node head=null;
    System.out.println("Please enter the number of feet and inches separated by space, enter 0 0 to quit");
    feet = keyboard.nextInt();
    inches = keyboard.nextInt();
    while(feet!=0 || inches !=0)
    {FeetAndInches measurement = new FeetAndInches(feet, inches);
       Node temp = new Node(measurement);
      if (head == null) 
       {head = temp;   //add the first node
         tail = temp;
       }
       else
       { tail.next = temp;
       tail=temp;
        
       }
     System.out.println("Please enter the number of feet and inches separated by space, enter 0 0 to quit");
    feet = keyboard.nextInt();
    inches = keyboard.nextInt();
    }
    PrintList(head);
   
    }
    
    
    public static void PrintList(Node head)
  { Node curr=head; FeetAndInches m;
    while(curr !=null)
    {m= (FeetAndInches) curr.item;
      System.out.println(m);
                         curr=curr.next;
                         }//end while
  }
}

