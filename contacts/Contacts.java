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
    List<String> contactName = Arrays.asList("Oggie Booggie | 800-243-1025", "Your Mom | 420-666-6969", "Sponge Bob | 915-243-6754");

    public void contacts(){

//        System.out.println(contactName);
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

        String addedCon = scan.nextLine();
        boolean hasIt = false;
        try{
            List<String> lines = Files.readAllLines(dataFile);
            for(String line: lines){
                if(line.equals(addedCon)){
                    hasIt = true;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        if(!hasIt) {

            try {
                List<String> currentList = Files.readAllLines(dataFile);
                currentList.add(addedCon);
                Files.write(dataFile, currentList);
                contacts();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
//        System.out.println(contactName);

}
public void searchContact(){
    System.out.println("enter name");

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
    System.out.println("enter name");

    String searchContact = scan.nextLine();
    try{
        List<String> removelines = Files.readAllLines(dataFile);
        for(String line: removelines){
            if(line.equalsIgnoreCase(searchContact)){

                removelines.remove(searchContact);
            }
        }
    }catch (IOException e){
        e.printStackTrace();
    }
}
}
