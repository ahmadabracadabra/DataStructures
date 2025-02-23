
package l5;

/**
 * @author ahmadabraham
 */
public class Queue<T> {
 

    private Node head;
    private Node tail;
    private int size;

    Queue() {
        head = null;
        tail = null;
        size = 0;
    }
    
     public void enqueue(T newItem) {
        Node temp = new Node(newItem);
        if (this.isEmpty()) {
            head = temp;
            tail = temp;
        } else {
            tail.setNext(temp);
            temp.setPrev(tail);
            tail = temp;
        }
        size++;
    }
   

    public T dequeue() {
        if (isEmpty()) {
            return (T)"Empty Queue";
        }
        T temp = (T) head.getItem();
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        }
        else {
            tail = null; 
        }
        size--;
        return temp;
    }
    
    
    public T peek() {
        if(isEmpty()){
            return (T)"Empty Queue";
        }
        return (T) head.getItem();
    }
        

    public int getSize() {
        return size;
    }

   public void makeEmpty() {
    head = null;
    tail = null;
    size = 0;
}

   public boolean isEmpty() {
        return size == 0;
    }
   
} // end class



 

   

   
  
  

  
    