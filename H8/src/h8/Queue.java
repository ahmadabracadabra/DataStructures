
package h8;

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
            return (T) "Empty Queue";
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
            return (T) "Empty Queue";
        }
        return (T) getHead().getItem();
    }

    public int getSize() {
        return size;
    }

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

    public void printQ() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }
        Node temp = getHead();
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.println(temp.getItem() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    // Method to delete every nth node
    public T deleteEveryNthNode(int n) {
        if (isEmpty() || n <= 0) {
            return null; // Invalid case
        }

        Node current = head;
        Node prev = tail; // Start with tail since it's a circular queue
        int count;

        // Continue until only one node remains
        while (size > 1) {
            count = 1;
            // Move (n-1) steps ahead to find the nth node to delete
            while (count != n) {
                prev = current;
                current = current.getNext();
                count++;
            }

            // Remove the nth node
           // System.out.println("Removing: " + current.getItem());
            prev.setNext(current.getNext());
            current.getNext().setPrev(prev);

            if (current == head) {
                head = head.getNext(); // Update head if necessary
            }
            if (current == tail) {
                tail = prev; // Update tail if necessary
            }

            current = prev.getNext(); // Move to the next node
            size--;
        }

        // Only one node remains, return the last remaining item
        return (T) head.getItem();
    }

} //end class




 

   

   
  
  

  
    
      
    
  



