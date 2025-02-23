
package l5;

/**
 * @author ahmadabraham
 */
public class L5 {
//this is the driver
    
    public static void main(String[] args) {
        Queue <String> myQ = new Queue<String>(); //string Q
        String[] names = {"harry", "mary", "mosi", "sadie","tom", "janice"};  
       for (int i=0; i<names.length;i++)
            myQ.enqueue(names[i]);
       System.out.println("Size is " + myQ.getSize());
       for (int i=0; i<6; i++)
        System.out.println(myQ.dequeue());
       //test that it also works for integers
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
      //cannot use getSize() here because it changes every time you dequeue
       {Integer val = myI.dequeue();
       
       System.out.print(val+ " ");
       total=total+val;
       }
       System.out.println("\nTotal is:" + total);
    }
    
}