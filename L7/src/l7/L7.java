package l7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @author ahmadabraham
 */
public class L7 {

    public static void main(String[] args) {
        Integer[] arr = {6, 8, 3, 4, 9, 2};  // Data to put in BST
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[0]); // The root

        // Build the tree
        for (int i = 1; i < arr.length; i++) {
            TreeInsert(root, arr[i]);
        }

        // Print out the data - should be sorted
        inOrder(root);

        // Test comparisons
        int totalComparisons = 0;
        for (Integer value : arr) {
            totalComparisons += Comparisons(root, value);
        }

        System.out.println("Number of comparisons to find all data in tree is " + totalComparisons);
        System.out.println("Average number of comparisons is " + (totalComparisons * 1.0 / arr.length));

        // Second part with file input
        File f = new File("words_no_duplicates.txt");
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
        for (String word : starr) {
            totalComparisonsString += Comparisons(root2, word);
        }

        System.out.println("Number of comparisons to find all data in tree is " + totalComparisonsString);
        System.out.println("Average number of comparisons is " + (totalComparisonsString * 1.0 / starr.size()));

        // Calculate and print depth for a given integer and string
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter an integer in the tree to calculate its depth: ");
            int intInput = input.nextInt();
            System.out.println("Depth of integer " + intInput + " is: " + TreeDepth(root, intInput, 0));

            System.out.print("Enter a string in the tree to calculate its depth: ");
            String strInput = input.next();
            System.out.println("Depth of string \"" + strInput + "\" is: " + TreeDepth(root2, strInput, 0));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type.");
        }

        // Calculate and print height of both trees
        System.out.println("Height of integer tree: " + height(root));
        System.out.println("Height of string tree: " + height(root2));
    }

    // Template method for counting comparisons in BST
    public static <T extends Comparable<T>> int Comparisons(BinaryTreeNode<T> root, T num) {
        BinaryTreeNode<T> curr = root;
        int comparisons = 1;

        while (curr != null) {
            if (num.equals(curr.getValue())) {
                break;
            } else if (num.compareTo(curr.getValue()) < 0) {
                curr = curr.getLeft();
                comparisons++;
            } else {
                curr = curr.getRight();
                comparisons++;
            }
        }
        return comparisons;
    }

    // Template method to perform an in-order traversal of a BST
    public static <T> void inOrder(BinaryTreeNode<T> t) {
        if (t != null) {
            inOrder(t.getLeft());
            System.out.println(t.getValue());
            inOrder(t.getRight());
        }
    }

    // Template method to insert a value into a non-null BST tree
    public static <T extends Comparable<T>> void TreeInsert(BinaryTreeNode<T> root, T num) {
        BinaryTreeNode<T> b = new BinaryTreeNode<>(num);
        BinaryTreeNode<T> curr = root;
        while (curr != null) {
            T currValue = curr.getValue();
            if (num.compareTo(currValue) < 0) {
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

    // Template method to calculate the depth of a node in the tree
    public static <T extends Comparable<T>> int TreeDepth(BinaryTreeNode<T> t, T num, int depth) {
        if (t == null) {
            return -1; // Node not found
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

    // Template method to calculate the height of the tree
    public static <T> int height(BinaryTreeNode<T> node) {
        if (node == null) {
            return -1; // If the tree is empty, return -1
        }

        // Recursively find the height of left and right subtrees
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        // Return the maximum of left and right heights plus 1
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
