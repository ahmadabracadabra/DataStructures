package testingtree;

import java.io.*;
import java.util.*;

class Node {
    String key;
    Node left, right;
    int height;

    Node(String key) {
        this.key = key;
        left = right = null;
        height = 0;  // Initially, height is 0
    }
}

class BinarySearchTree {
    Node root;
    int totalComparisons;
    int nodesInserted;

    BinarySearchTree() {
        root = null;
        totalComparisons = 0;
        nodesInserted = 0;
    }

    // Helper method for insertion that counts comparisons based on depth
    Node insert(Node node, String key) {
        if (node == null) {
            nodesInserted++;
            totalComparisons++;  // One comparison to insert this node
            return new Node(key);
        }

        totalComparisons++;  // One comparison for this node

        if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    void insert(String key) {
        root = insert(root, key);
    }

    int height(Node node) {
        if (node == null) return -1;  // Height of an empty tree is -1
        return node.height;
    }

    int getTotalComparisons() {
        return totalComparisons;
    }

    int getHeight() {
        return height(root);
    }

    double getAverageComparisons() {
        if (nodesInserted == 0) return 0;
        return (double) totalComparisons / nodesInserted;
    }
}

class AVLTree extends BinarySearchTree {

    int height(Node node) {
        if (node == null) return -1;  // Height of an empty tree is -1
        return node.height;
    }

    // Right Rotation
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left Rotation
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Get Balance Factor
    int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // Insert method with balancing
    @Override
    Node insert(Node node, String key) {
        if (node == null) {
            nodesInserted++;
            totalComparisons++;  // One comparison to insert this node
            return new Node(key);
        }

        totalComparisons++;  // One comparison for this node

        if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key);
        else
            node.right = insert(node.right, key);

        // Update the height of the current node
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Check balance and apply rotations if needed
        int balance = getBalance(node);

        // Left-Left Case
        if (balance > 1 && key.compareTo(node.left.key) < 0)
            return rightRotate(node);

        // Right-Right Case
        if (balance < -1 && key.compareTo(node.right.key) > 0)
            return leftRotate(node);

        // Left-Right Case
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right-Left Case
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    @Override
    void insert(String key) {
        root = insert(root, key);
    }
}

public class TestingTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        AVLTree avlTree = new AVLTree();

        List<String> strings = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("words2.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                strings.add(line);
                bst.insert(line);  // Insert into BST
                avlTree.insert(line);  // Insert into AVL Tree
            }
        } catch (IOException e) {
            System.out.println("File not found or error reading file.");
            return;
        }

        // Output BST results
        System.out.println("Binary Search Tree:");
        System.out.println("Number of strings: " + strings.size());
        System.out.println("Height: " + bst.getHeight());
        System.out.println("Total Comparisons: " + bst.getTotalComparisons());
        System.out.println("Average Comparisons: " + bst.getAverageComparisons());

        // Output AVL Tree results
        System.out.println("\nAVL Tree:");
        System.out.println("Number of strings: " + strings.size());
        System.out.println("Height: " + avlTree.getHeight());
        System.out.println("Total Comparisons: " + avlTree.getTotalComparisons());
        System.out.println("Average Comparisons: " + avlTree.getAverageComparisons());
    }
}





