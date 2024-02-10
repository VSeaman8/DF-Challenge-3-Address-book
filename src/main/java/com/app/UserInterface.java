package com.app;
import java.io.InputStream;
import java.util.Scanner;

public class UserInterface {
    private AddressBook addressBook;
    private Scanner scanner;

    public UserInterface(InputStream in) {
        this.addressBook = new AddressBook();
        this.scanner = new Scanner(in);
    }

    public void start(){
        while (true){
            System.out.println("1. Add contact");
            System.out.println("2. Search for contact");
            System.out.println("3. Remove contact");
            System.out.println("4. View all contacts");
            System.out.println("5. exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    searchForContact();
                    break;
                case "3":
                    removeContact();
                    break;
                case "4":
                    viewAllContacts();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        }
    }

    private void addContact(){
        System.out.println("Enter Name: ");
        String name = scanner.nextLine().toLowerCase();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine().toLowerCase();
        System.out.println("Enter Phone Number: ");
        String phone = scanner.nextLine().toLowerCase();
        addressBook.addContactToAddressBook(name, email, phone);
    }

    private void searchForContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().toLowerCase();
        addressBook.searchName(name);
    }

    private void viewAllContacts() {
        addressBook.getAllContacts();
    }

    private void removeContact() {
        System.out.print("Enter name of contact to remove: ");
        String name = scanner.nextLine().toLowerCase();
        boolean isRemoved = addressBook.removeContactByName(name);
        if (isRemoved) {
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface(System.in);
        ui.start();
    }
}





