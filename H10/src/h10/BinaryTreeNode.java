/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h10;


public class BinaryTreeNode<T>
{
    protected T element;
   protected BinaryTreeNode left, right;

   
   public BinaryTreeNode (T obj) 
   {
      element = obj;
      left = null;
      right = null;
   }

   public T getValue(){
       return  element;
   }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }


}


