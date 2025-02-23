
package l5b;

/**
 * @author ahmadabraham
 */
public class L5b {
 
    public static void main(String[] args) {
        System.out.println("String queue");
        Queue <String> myQ = new Queue<String>(); //string Q
        String[] names = {"harry", "mary", "mosi", "sadie","tom", "janice"};  
       for (int i=0; i<names.length;i++)
            myQ.enqueue(names[i]);
       System.out.println("Size is " + myQ.getSize());
         
       System.out.println("Head is " + myQ.peek());
        System.out.println("Items in queue are: " );
       for (int i=0; i<names.length; i++)
        System.out.println(myQ.dequeue());
       
       //test that it also works for integers
        System.out.println("Integer queue");
       Integer[]numbers={4,5,6,7,8,17,100};
       Queue<Integer> myI = new Queue<Integer>(); //Integer Q
       for (int i=0; i<numbers.length;i++)
            myI.enqueue(numbers[i]);
       System.out.println("Size is " + myI.getSize());
       //Verify it adds (and is an integer Q) and doesn't concatenate(String Q)
       int total=0;
       int tempSize=myI.getSize();
       System.out.println("Integers in Queue are:");
       for (int i=0; i<tempSize; i++) 
//cannot use size() here because it changes every time you dequeue
       {Integer val = myI.dequeue();
       
       System.out.print(val+ " ");
       total=total+val;
       }
       System.out.println("\nTotal is:" + total);
       //check you have made a circular queue
       //myI was empty. So fill it up again
       for (int i=0; i<numbers.length;i++)
            myI.enqueue(numbers[i]);
      //and print 20 items, going around and around
       System.out.println("Printing 20 values");
       System.out.println("Head is " + myI.peek());
       myI.printQ(20);
       //verify makeEmpty works
       myI.makeEmpty();
       //try to peek 
       System.out.println(myI.peek());
       //try to dequeue
       System.out.println(myI.dequeue());
       //what is its size?
       System.out.println("Size is " + myI.getSize());
       //add one item
       myI.enqueue(100);
       System.out.println("Size is " + myI.getSize());
       System.out.println(myI.dequeue());//dequeue only item in queue
        
       System.out.println("Size is " + myI.getSize()); //verify size is now 0
       System.out.println(myI.getHead());//verify no node left
    }
    
}
