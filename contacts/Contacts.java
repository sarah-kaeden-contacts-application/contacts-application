package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Contacts {
    Scanner scan = new Scanner(System.in);
    String directory = "contacts";
    String fileName = " contacts.txt";

    Path dataDirectory = Paths.get(directory);
    Path dataFile = Paths.get(directory, fileName);

    public  void makeFile(){
        if(Files.notExists(dataFile)){
            try{
                Files.createFile(dataFile);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(Files.notExists(dataDirectory)){
            try{
                Files.createDirectories(dataDirectory);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }



    public void contacts(){

        System.out.println("name | phone number");
        System.out.println("-----------------------");

        try {
            List<String > contactNameFiles = Files.readAllLines(dataFile);

            for (String contact : contactNameFiles){
                System.out.println(contact);
                System.out.println("-----------------------");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void addContacts(){

        String name = scan.nextLine();
        String phoneNumber = scan.nextLine();
        switch (phoneNumber.length()) {
            case 7 -> {
                phoneNumber = phoneNumber.replaceFirst("(\\d{3})(\\d+)", "$1-$2-$3");
            }
            case 10 -> {
                phoneNumber = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
            }
        }
        boolean hasIt = false;
        List<String> addedContact = Arrays.asList(name + " | " + phoneNumber);
        if(!hasIt) {
            try {

                Files.write(dataFile, addedContact, StandardOpenOption.APPEND);
                contacts();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void searchContact(){
        System.out.println("Enter Name:");

        String searchContact = scan.nextLine();

        try{
            List<String> lines = Files.readAllLines(dataFile);
            for(String line: lines){
                if(line.contains(searchContact)){
                    System.out.println(line);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void deleteContact(){
        System.out.println("Enter Name:");

        String searchContact = scan.nextLine();
        List<String> newList = new ArrayList<>();
        try{
            List<String> removelines = Files.readAllLines(dataFile);
            for(String line: removelines){
                if(line.contains(searchContact)){
                    continue;
                } else {
                    newList.add(line);
                }
            }
            Files.write(dataFile, newList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
