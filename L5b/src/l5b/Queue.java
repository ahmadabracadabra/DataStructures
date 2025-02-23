
package l5b;

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
            getHead().setNext(getHead());
            getHead().setPrev(getHead()); 
        } else {
            tail.setNext(temp);
            temp.setPrev(tail);
            temp.setNext(getHead());
            getHead().setPrev(temp);
            tail = temp;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
           return (T)"Empty Queue";
        }

        T item = (T) getHead().getItem();

        if (getHead() == tail) {
            head = null;
            tail = null;
        } else {
            head = getHead().getNext();
            getHead().setPrev(tail);
            tail.setNext(getHead());
        }
        size--;
        return item;
    }

    
    public T peek() {
        if (isEmpty()) {
           return (T)"Empty Queue";
        }
        return (T) getHead().getItem();
    }

    public int getSize() {
        return size;
    }
    
     /**
     * @return the head
     */
    public Node getHead() {
        return head;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
      
    
  public void printQ(int n) {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }
        Node temp = getHead();
        System.out.print("Queue: ");
        for (int i = 0; i < n; i++) {
            System.out.print(temp.getItem() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

   

} //end class



 

   

   
  
  

  
    
      
    
  



