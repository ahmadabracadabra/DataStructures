
package h10;


public class BST <T extends Comparable> {
    
    private BinaryTreeNode root;
    public void BST()
    {   
       root = null;
        
    }
    public  boolean isEmpty()
    {
        return root==null;
    }
    
    //to work with person
     public void insert(T data) {
        root = insert(root, data);
    }
    
    public  BinaryTreeNode insert(BinaryTreeNode node, T data)
    {
        if (node==null)
            node = new BinaryTreeNode(data);
        else 
        { T data2 = (T) node.getElement();
        if(data.compareTo(data2)<0)
                node.left = insert(node.left, data);
        else node.right = insert(node.right, data);
        }
        return node;
        
    }
      
    //to work with person
    public void inOrder() {
        inOrder(root);
    }
    
    public void inOrder(BinaryTreeNode t) {
        if (t != null) 
        {
         inOrder(t.getLeft());
         System.out.println(t.getValue());
         inOrder(t.getRight());

    }
    }
     
          
          
    public BinaryTreeNode getRoot()
    {
        return root;
    }
    
}
