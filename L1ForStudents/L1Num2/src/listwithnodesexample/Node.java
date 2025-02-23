/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listwithnodesexample;

/**
 *
 * @author Jean Mehta
 */
public class Node {
  
 Object item;
  Node next;
  
  Node(Object newItem)
  { item = newItem;
    next=null;
  }
  
  Node(Object newItem, Node nextNode)
  { item = newItem;
    next=nextNode;
  }
}
  
    

