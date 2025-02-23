/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package l7;

public class BinaryTreeNode<T>
{
   private T element;
   private BinaryTreeNode<T> left, right;

   
   BinaryTreeNode (T obj) 
   {
      element = obj;
      left = null;
      right = null;
   }

   public T getValue(){
       return  element;
   }

    public void setValue(T element) {
        this.element = element;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }


}

