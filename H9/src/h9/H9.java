/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package h9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H9 {

    
    public static void main(String[] args) {
        Queue<Integer> inputQueue = new LinkedList<>();

        // Read integers from radix.txt and enqueue them into the input queue
        try {
            File file = new File("Radix.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextInt()) {
                int number = fileScanner.nextInt();
                inputQueue.add(number);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: radix.txt file not found.");
            return;
        }

        // Perform radix sort
        Queue<Integer> sortedQueue = radixSort(inputQueue);

        // Print the sorted queue using printQ method
        printQ(sortedQueue);
    }

    // Method to print the contents of the queue
    public static void printQ(Queue<Integer> queue) {
        System.out.println("Sorted Queue:");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }

    // Method to perform radix sort
    public static Queue<Integer> radixSort(Queue<Integer> queue) {
        // Maximum number of digits (4 since numbers are <= 9999)
        int maxDigits = 4;

        // Array of queues for each radix (0-9)
        Queue<Integer>[] buckets = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<>();
        }

        // Iterate over each digit place (ones, tens, hundreds, thousands)
        for (int exp = 1; exp <= 1000; exp *= 10) {
            // Distribute numbers into buckets based on current digit
            while (!queue.isEmpty()) {
                int num = queue.poll();
                int digit = (num / exp) % 10;
                buckets[digit].add(num);
            }

            // Collect numbers from buckets back into the queue
            for (int i = 0; i < 10; i++) {
                while (!buckets[i].isEmpty()) {
                    queue.add(buckets[i].poll());
                }
            }
        }

        // Return the sorted queue
        return queue;
    }
}
