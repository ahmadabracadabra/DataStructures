/*
 Write a program that inputs feet and inches, 
creates a FeetAndInches object, puts it in a Node, 
and then adds them to the FRONT of the list, 
i.e., (prepends) these nodes to a list. Input is from the keyboard. 
Files Node.java and FeetAndInches.java have already been uploaded, 
you just have to write the main method.
 */

//PREPEND

package listwithnodesexample;

import java.util.Scanner;

//inserts nodes at front of list
public class ListWithNodesExample {

   
   public static void main(String[] args) {
    Scanner keyboard = new Scanner (System.in);
    int feet, inches;
   
   
    Node head=null;
    System.out.println("Please enter the number of feet and inches separated by space, enter 0 0 to quit");
    feet = keyboard.nextInt();
    inches = keyboard.nextInt();
    while(feet!=0 || inches !=0)
    {FeetAndInches measurement = new FeetAndInches(feet, inches);
       Node temp = new Node(measurement);
      if (head == null) 
       {head = temp;   //add the first node
         
       }
       else
       { temp.next = head;
       head=temp;
        
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
