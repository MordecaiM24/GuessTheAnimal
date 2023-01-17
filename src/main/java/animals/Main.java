package animals;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Communication.greeting();

        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter an animal:");
        boolean gotAnswer = false;
        String sent = Communication.getAnimal();

        boolean gotAnimal;
        System.out.println("Is it " + sent + "?");


        while(true){
            String response = input.nextLine();

            if(Communication.confirmation(response).equals("positive")){
                System.out.println("You answered: Yes");
                break;
            } else if (Communication.confirmation(response).equals("negative")) {
                System.out.println("You answered: No");
                break;
            } else {
                Communication.clarification();

            }
        }



        Communication.goodbye();

    }
}
