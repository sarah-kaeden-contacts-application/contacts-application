package contacts;

import java.util.Scanner;

public class    ContactsApp {
    public static void main(String[] args) {
        Contacts makeIt = new Contacts();
        makeIt.makeFile();
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        String continuee = "n";
        do {
            menu.menu();
            String menuChoice = scan.nextLine();
            System.out.println("Done.");
            switch (menuChoice) {
                case "1" -> {
                    Contacts contacts = new Contacts();
                    contacts.contacts();
                }
                case "2" -> {
                    Contacts addContact = new Contacts();
                    addContact.addContacts();
                }
                case "3" -> {
                    Contacts searchCon = new Contacts();
                    searchCon.searchContact();
                }
                case "4" -> {
                    Contacts delete = new Contacts();
                    delete.deleteContact();
                }
                case "5" -> System.exit(0);
            }
            System.out.println("would you like to continue? [y/n]");
           continuee = scan.nextLine();
        }while(continuee.equalsIgnoreCase("y"));
    }

}

