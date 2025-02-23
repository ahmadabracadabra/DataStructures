package listclassexample;


import java.util.LinkedList;

/**
 * @author ahmadabraham
 */
public class ListClassExample {

    public static void main(String[] args) {
       
        LinkedList<Integer> myList = new LinkedList<Integer>();

        //can i add to this list
        myList.add(7);
        myList.add(-2);
        myList.add(-4);
        myList.add(0);
        myList.add(12);
        myList.add(19);
        myList.add(-1);
        myList.add(98);
        
        //can i print this list
        System.out.println("Initial list:");
        printList(myList);
        
        //can i remove from the front (test by print)
        System.out.println("Remove from front:");
        myList.removeFirst();
        printList(myList);
        
        //can i remove from the end (test by print)
        System.out.println("Remove from end:");
         myList.removeLast();
         printList(myList);
         
        //can i remove from the middle section (test by print)
        System.out.println("Remove from middle section:");
         myList.remove(3);
         printList(myList);
          
        //can i alter something in the list  (test by print)
        System.out.println("Alter list:");
         myList.set(3,45);
         printList(myList);
        
        //can i delete everything
         System.out.println("Delete entire list:");
         myList.clear();
         printList(myList);
         
         
         //REFRESH
          myList.add(11);
          myList.add(23);
          myList.add(-13);
          myList.add(45);
           myList.add(0);
         
        //can i make a new list with these values in reverse order
         System.out.println("New list in reverse:");
         
         LinkedList<Integer> newList = new LinkedList<Integer>();
         for(int i = myList.size() - 1; i >= 0; i--) {
         newList.add(myList.get(i));
         }
         
         printList(newList);
        
        
    }
    
    //print list method
    public static void printList(LinkedList <Integer> myList) {
        for(int i = 0; i < myList.size(); i++ ) {
        System.out.println(myList.get(i));
        }
    }
      
    
}
