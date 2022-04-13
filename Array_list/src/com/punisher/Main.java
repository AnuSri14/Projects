package com.punisher;
import java.util.Scanner;

public class Main {

    private static final Scanner Input = new Scanner(System.in);
    private static final GroceryList ShoppingList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice;

        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = Input.nextInt();
            Input.nextLine();

            switch (choice) {
                case 0 -> printInstructions();
                case 1 -> ShoppingList.printGroceryList();
                case 2 -> addItem();
                case 3 -> modifyItem();
                case 4 -> removeItem();
                case 5 -> searchForItem();
                case 6 -> quit = true;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
//        System.out.println("\t 6 - To process Array");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem() {
        System.out.print("Please enter the grocery item: ");
        ShoppingList.addGroceryItem(Input.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Current item name: ");
        String itemNo = Input.nextLine();
        System.out.print("Enter new item: ");
        String newItem = Input.nextLine();
        ShoppingList.modifyGroceryItem(itemNo, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter item name: ");
        String itemNo = Input.nextLine();
        ShoppingList.removeGroceryItem(itemNo);
    }

    public static void searchForItem() {
        System.out.print("Item to search for: ");
        String searchItem = Input.nextLine();
        if(ShoppingList.onFile(searchItem)) {
            System.out.println("Found " + searchItem);
        } else {
            System.out.println(searchItem + ", not on file.");
        }
    }

}
