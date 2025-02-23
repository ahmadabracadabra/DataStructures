package h10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author ahmadabraham
 */
public class H10 {

    public static void main(String[] args) {
       
//        Names will be first name, last name (separated by a space). 
//        Birth dates will be in the form 04/01/2017. 
//        Phone numbers will be of the form 312-255-2000
         Scanner scnr = new Scanner(System.in);
         Person myPeople = new Person();
         BST<Person> myTree = new BST();
         
//input from file
  File inFile = new File("H10input.txt");
          Scanner  fileInput = null;
        try {
          fileInput = new Scanner(inFile);
        } catch (FileNotFoundException ex) {
        }
        
        
          while(fileInput.hasNext()) { 
              String fname=fileInput.next();
              String lname=fileInput.next();
              String bday=fileInput.next();
              String phone=fileInput.next();
              
              myPeople = new Person(fname, lname, bday, phone);
              
              myTree.insert(myPeople);
              }
           
             
             //menu loop
             boolean end = false;
              while (!end) {
            System.out.println("Menu:");
            System.out.println("1. Add a new person to tree");
            System.out.println("2. Search tree for a person by last name");
            System.out.println("3. List everyone in tree");
            System.out.println("4. Search for people born in a certain month");
            System.out.println("5. Quit");
            System.out.print("Enter option number: ");
            int num = scnr.nextInt();
           
           //menu options
            switch (num) {
                case 1:
                    //Add a new person to tree
                     scnr.nextLine();
                     System.out.print("Enter first name: ");
                    String fname = scnr.nextLine();
                    System.out.print("Enter last name: ");
                    String lname = scnr.nextLine();
                    System.out.print("Enter birth date in format MM/DD/YYYY: ");
                    String bday = scnr.nextLine();
                    System.out.print("Enter phone number in format 000-000-0000: ");
                    String phone = scnr.nextLine();

                    Person newPerson = new Person(fname, lname, bday, phone);
                    myTree.insert(newPerson);
                    System.out.println("Done.");
                    
                    break;
                case 2:
                    //Search tree for a person by last name
                    scnr.nextLine();
                    System.out.print("Enter last name: ");
                    String searchLastName = scnr.nextLine();
                    boolean found = false;
                    BinaryTreeNode<Person> currentNode = myTree.getRoot();

                    while (currentNode != null) {
                        int comparison = searchLastName.compareToIgnoreCase(currentNode.getElement().getLastname());
                        if (comparison == 0) {
                            System.out.println("Found: " + currentNode.getElement());
                            found = true;
                            break;
                        } else if (comparison < 0) {
                            currentNode = currentNode.getLeft();
                        } else {
                            currentNode = currentNode.getRight();
                        }
                    }

                    if (!found) {
                        System.out.println("Not found");
                    }
                    
                    break;
                case 3:
                    //List everyone in tree
                     myTree.inOrder();
                    break;
                case 4:
                    //Search for people born in a certain month
                     scnr.nextLine();
                     System.out.print("Enter birth month in format MM: ");
                    String month = scnr.nextLine();
                    System.out.println("People born in " + month + ":");
                    currentNode = myTree.getRoot();
                    listmonth(currentNode, month);
          
                    break;
                case 5:
                    //quit
                    end = true;
                    break;
                    
                default:
                    System.out.println("Not an option.");
                    
                break;
            }
        }
           
        
    } // end main
    
    
    //month transversal method
      public static void listmonth(BinaryTreeNode<Person> node, String month) {
        if (node != null) {
            listmonth(node.getLeft(), month);
            if (node.getElement().getBday().startsWith(month)) {
                System.out.println(node.getElement());
            }
            listmonth(node.getRight(), month);
        }
    }
    
} // end class
