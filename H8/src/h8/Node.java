
package h8;

public class Node<T> {
//Node makes item, next, and prev all private
    //and therefore has to provide accessors
    //and mutators (gets and sets)
    private T item;
    private Node next;
    private Node prev;

    Node(T newItem) {
        item = newItem;
        next = null;
        prev = null;
    }

    Node(T newItem, Node nextNode, Node prevNode) {
        item = newItem;
        next = nextNode;
        prev = prevNode;
    }

    /**
     * @return the item
     */
    public T getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(T item) {
        this.item = item;
    }

    /**
     * @return the next
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * @return the prev
     */
    public Node getPrev() {
        return prev;
    }

    /**
     * @param prev the prev to set
     */
    public void setPrev(Node prev) {
        this.prev = prev;
    }

}
