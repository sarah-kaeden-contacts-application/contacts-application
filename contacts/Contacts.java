package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Contacts {
    String directory = "contacts";
    String fileName = " contacts.txt";

    Path dataDirectory = Paths.get(directory);
    Path dataFile = Paths.get(directory, fileName);

    public  void makeIt(){


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

        List<String> contactName = Arrays.asList("Oggie Booggie | 800-243-1025", "Your Mom | 420-666-6969", "Kim K | 915-243-6754");
        System.out.println(contactName);
        try {
            List<String > contactNameFiles = Files.readAllLines(dataFile);

            for(int i =  1; i<= contactNameFiles.size(); i +=1){
                System.out.println(i+": "+ contactNameFiles.get(i-1));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
