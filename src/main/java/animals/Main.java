package animals;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Communication.greeting();

        System.out.println("\nEnter the first animal:");
        String sent1 = Communication.getAnimal();

        System.out.println("Enter the second animal:");
        String sent2 = Communication.getAnimal();

        HashMap<String, String> facts = Communication.animalInfo(sent1, sent2);

        System.out.println("I learned the following facts about animals: ");
        System.out.println(" - The " + facts.get("true") + " " + facts.get("fact"));
        System.out.println(" - The " + facts.get("false") + " " + Communication.negate(facts.get("fact")));

        System.out.print("I can distinguish these animals by asking the question: \n - ");
        System.out.println(facts.get("question") + "\n");
        Communication.goodbye();

        System.out.println(facts);







    }
}
