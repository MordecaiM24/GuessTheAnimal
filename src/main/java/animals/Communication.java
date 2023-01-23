package animals;
import java.time.LocalTime;
import java.util.*;

public class Communication {
    static Scanner input = new Scanner(System.in);
    public static void greeting(){
        LocalTime current = LocalTime.now();
        int hour = current.getHour();
        String greeting;
        if(hour > 2 && hour < 5) {
            greeting = "Hi, Early Bird";
        } else if(hour >= 5 && hour < 12){
            greeting = "Good morning";
        } else if (hour >= 12 && hour < 18){
            greeting = "Good afternoon";
        } else if (hour >= 18){
            greeting = "Good evening";
        } else {
            greeting = "Hi, Night Owl";
        }

        System.out.println(greeting);
    }
    public static String getAnimal(){

        String sentence = input.nextLine().toLowerCase().replaceFirst("the", "");
        // Sanitize input; make it lower case and take out "the"

        String regex = "\\ban? .*";
        // Anything containing "a" or "an"
        if (sentence.matches(regex)){
            return sentence;
        }

        String article = startsWithVowel(sentence) ? "an" : "a";

        return article + " " + sentence;
    }
    public static boolean startsWithVowel(String noun){
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};


        return charArrayContains(vowels, noun.charAt(0));
    }

    public static boolean charArrayContains(char[] arr, char key){
        for (char c : arr) {
            if (c == key) {
                return true;
            }
        }
        return false;
    }
    public static boolean StringArrayContains(String[] arr, String key){
        for (String s : arr) {
            if (s.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static String confirmation(String response){
        String[] positiveResponses = {"y", "yes", "yeah", "yep", "sure", "right", "affirmative", "correct", "indeed", "you bet", "exactly", "you said it"};
        String[] negativeResponses = {"n", "no", "no way", "nah", "nope", "negative", "I don't think so", "yeah no"};
        //Cleaning response in case of punctuation and capitalization
        response = response.trim().toLowerCase().replaceFirst("[.!]", "");
        // regex expression means replace any period or exclamation with empty space


        if(StringArrayContains(positiveResponses, response)) {
            return "positive";
        } else if (StringArrayContains(negativeResponses, response)){
            return "negative";
        }
        return "Unknown response";
    }

    public static void goodbye(){
        String[] goodbyes = {"Goodbye", "Bye", "See you the next time", "See you later", "Talk to you later", "See ya", "Later", "Catch you later", "Have a good day"};
        int rnd = new Random().nextInt(goodbyes.length);
        System.out.println(goodbyes[rnd] + "!");
    }

    public static void clarification(){
        String[] clarifications = {"I'm not sure I caught you: was it yes or no?", "Funny, I still don't understand, is it yes or no?", "Oh, it's too complicated for me: just tell me yes or no.","Could you please simply say yes or no?", "Come on, yes or no?"};
        int rnd = new Random().nextInt(clarifications.length);
        System.out.println(clarifications[rnd]);


    }

    public static void dontStop(){
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
    }
}
