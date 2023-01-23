package animals;


public class Main {
    public static void main(String[] args) {
        Communication.greeting();

        System.out.println("\nEnter an animal:");
        String sent = Communication.getAnimal();

        System.out.println("Is it " + sent + "?");


        Communication.dontStop();

        Communication.goodbye();

    }
}
