package com.app;
import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.in;

public class UserInterface {
    private AddressBook addressBook;
    private Scanner scanner;
    // Constructor
    // Constructor
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

            switch (choice){
                case "1":
                    addContact();
                    break;
                case "5":
                    System.out.println("See you next time!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again!");

            }

        }
        }
    private void addContact(){
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phone = scanner.nextLine();
        addressBook.addContactToAddressBook(name, email, phone);

}
    }


