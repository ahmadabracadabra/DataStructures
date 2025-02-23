/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package h8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ahmadabraham
 */
public class H8 {

 public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        // Read the words from the file and enqueue them
        try {
            File file = new File("words.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNext()) {
                String word = fileScanner.next();
                queue.enqueue(word);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: words.txt file not found.");
            return;
        }

        // Print the initial queue
        System.out.println("Initial Queue:");
        queue.printQ();

        // Input integer n
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer n: ");
        int n = input.nextInt();

        // Solve Josephus problem
        String lastNode = queue.deleteEveryNthNode(n);

        // Print the last remaining node
        System.out.println("Last remaining node: " + lastNode);

        // Print the final queue to verify only one node remains
        System.out.println("Final Queue:");
        queue.printQ();

        input.close();
    }
}
