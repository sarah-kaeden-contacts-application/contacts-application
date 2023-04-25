package contacts;

import java.util.Scanner;

public class Bonus {

    public void bonus() {
        System.out.println("Whats yo digits");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        switch (userInput.length()){
            case 7:
                String number = userInput.replaceFirst("(\\d{3})(\\d+)", "$1-$2-$3");
                System.out.println(number);
                break;
            case 10:
                String number1 = userInput.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
                System.out.println(number1);
                break;
        }
    }

}
