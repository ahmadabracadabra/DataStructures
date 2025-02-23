
package l6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ahmadabraham
 */
public class L6 {

    
    public static void main(String[] args) {
      
        Integer[] arr = {6, 8, 3, 4, 9, 2 };  //data to put in BST
              
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(arr[0]);//the root
         
        //build the tree
        for (int i = 1; i < arr.length; i++) {
            
           TreeInsert(root, arr[i]);    
           
        }
        //print out the data - should be sorted
        inOrder(root);
       
        //test comparisons
        int totalComparisons=0;

       for (int i = 0; i < arr.length; i++) {
         totalComparisons=totalComparisons + Comparisons(root, arr[i]);
       }
        
       System.out.println("Number of comparisons to find all data in tree is " + totalComparisons);
       System.out.println("Average number of comparisons is " + totalComparisons*1.0/arr.length);
       
       
       //Second part 
        File f = new File("words2.txt");
        Scanner fileInput = null;
        try {
            fileInput = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
            System.exit(-1);
        }

        
        ArrayList<String> starr = new ArrayList<>();
          while (fileInput.hasNextLine()) {
            String word = fileInput.nextLine();  
            starr.add(word); 
          }

         
          BinaryTreeNode<String> root2 = new BinaryTreeNode<>(starr.get(0)); 

          for (int i = 1; i < starr.size(); i++) {
              
                TreeInsert(root2, starr.get(i));  
                
          }

            inOrder(root2);

            int totalComparisonsString = 0;

            for (int i = 0; i < starr.size(); i++) {
                totalComparisonsString = totalComparisonsString + Comparisons(root2, starr.get(i));
            }
        
       System.out.println("Number of comparisons to find all data in tree is " + totalComparisonsString);
       System.out.println("Average number of comparisons is " + totalComparisonsString*1.0/starr.size());
       
        
        
    } // end main 
    
    
    //template method for counting comparisons in BST
   public static <T extends Comparable> int Comparisons(BinaryTreeNode<T> root, T num) {
    BinaryTreeNode<T> curr = root;
    int Comparisons = 1; 

    while (curr != null) {
        if (num.equals(curr.getValue())) { 
            break;
        } else if (num.compareTo(curr.getValue()) < 0) {
            curr = curr.getLeft();
            Comparisons++;
        } else {
            curr = curr.getRight();
            Comparisons++;
        }
    }
    return Comparisons;
}
     
    
     //method to perform- an inorder traversal of a BST
        public static void inOrder(BinaryTreeNode t) {
        if (t != null) 
        {
         inOrder(t.getLeft());
         System.out.println(t.getValue());
         inOrder(t.getRight());

    }
        }
               
      
       //template method to insert an integer (num) into a non-null BST tree 
        public static <T extends Comparable> void TreeInsert(BinaryTreeNode<T> root, T num)
        {     BinaryTreeNode<T> b=new BinaryTreeNode(num);
              BinaryTreeNode<T> curr=root;
                while (curr != null) {
               T currValue= curr.getValue();
                if(num.compareTo(currValue) < 0){
                    if (curr.getLeft() == null) {
                        curr.setLeft(b);
                        
                        break;
                    } else {
                        curr = curr.getLeft();
                        
                    }

                } else {
                    if (curr.getRight() == null) {
                        curr.setRight(b);
                       
                        break;
                    } else {
                        curr = curr.getRight();
                       
                    }
                }
            }
        }
                
         public int height(BinaryTreeNode node) {
        // If the tree is empty, return -1
        if (node == null) {
            return -1;
        }

        // Height of left subtree
        int leftHeight = height(node.getLeft());
        // Height of right subtree
        int rightHeight = height(node.getRight());

        // Return the maximum of left and right heights plus 1
        return Math.max(leftHeight, rightHeight) + 1;
    }
        
                
                
    public static <T extends Comparable> int TreeDepth(BinaryTreeNode<T> t, T num, int depth) {
        if (t == null) {
            return -1; // Node not found (this won't be used since we're assuming the node exists)
        }

        if (num.equals(t.getValue())) {
            return depth; // Found the node, return its depth
        }

        // Search in left and right subtrees
        int leftDepth = TreeDepth(t.getLeft(), num, depth + 1);
        if (leftDepth != -1) {
            return leftDepth; // Node found in the left subtree
        }

        return TreeDepth(t.getRight(), num, depth + 1); // Search in the right subtree
    }
    
    
    
  
               
        
        
}// end class