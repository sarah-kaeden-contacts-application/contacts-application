package contacts;

import java.util.Scanner;

public class    ContactsApp {
    public static void main(String[] args) {
        Contacts makeIt = new Contacts();
        makeIt.makeFile();
        Menu menu = new Menu();

        Scanner scan = new Scanner(System.in);

        String continuee = "n";
        do{
            menu.menu();
            String menuChoice = scan.nextLine();
            System.out.println("got it");
            switch (menuChoice){
                case "1":
                    Contacts contacts = new Contacts();
                    contacts.contacts();
                    break;
                case "2":
                    Contacts addContact = new Contacts();
                    addContact.addContacts();
                    break;
                case "3":
                    Contacts searchCon = new Contacts();
                    searchCon.searchContact();
                    break;
                case "4":
                    Contacts delete = new Contacts();
                    delete.deleteContact();
                    break;
                case "5":
                    System.exit(0);
                    break;
                case "6":
                    Bonus bonus = new Bonus();
                    bonus.bonus();
                    break;

            }
            System.out.println("would you like to continue? [y/n]");
           continuee = scan.nextLine();
        }while(continuee.equalsIgnoreCase("y"));




        //now the contacts.txt is made

    }

}

