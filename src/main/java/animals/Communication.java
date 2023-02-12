package animals;
import java.time.LocalTime;
import java.util.*;

public class Communication {
    static Scanner input = new Scanner(System.in);

    public static String question(String fact){
        if (fact.contains("can")){
            return "Can it " + fact.replace("can ", "") + "?";
        }
        if (fact.contains("has")){
            return "Does it have " + fact.replace("has ", "") + "?";
        }
        if (fact.contains("is")){
            return "Is it " + fact.replace("is ", "") + "?";
        }
        return "";
    }
    public static HashMap<String, String> animalInfo(String sent1, String sent2){
        HashMap<String, String> animalInfo = new HashMap<>();
        System.out.println("Specify a fact that distinguishes " + sent1 + " from " + sent2 + ".");
        System.out.println("The sentence should be of the format: 'It can/has/is ...'.");
        String fact = input.nextLine();
        while (!fact.matches("It (can|has|is) .*")){
            System.out.println("The sentence should be of the format: 'It can/has/is ...'.");
            System.out.println("The examples of a statement: ");
            System.out.println("- It can fly \n- It has a horn \n- It is a mammal");
            System.out.println("Specify a fact that distinguishes " + sent1 + " from " + sent2 + ".");
            fact = input.nextLine();
        }
        fact = fact.replaceFirst("It ", "");
        fact = fact.replaceAll("[?.!]", "");
        String question = question(fact);
        System.out.println("Is it correct for " + sent2 + "?");
        String factPos = dontStop() ? definite(sent2) : definite(sent1);
        String factNeg = factPos.equals(definite(sent1)) ? definite(sent2) : definite(sent1);

        animalInfo.put("fact", fact);
        animalInfo.put("true", factPos);
        animalInfo.put("false", factNeg);
        animalInfo.put("question", question);



        return animalInfo;

    }
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

    public static String definite(String indef){
        if (indef.startsWith("an")){
            return indef.substring(3);
        } else {
            return indef.substring(2);
        }
    }
    public static String getAnimal(){

        String sentence = input.nextLine().toLowerCase().replaceFirst("the ", "");
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

    public static boolean dontStop(){
        while(true){
            String response = input.nextLine();

            if(confirmation(response).equals("positive")){
                return true;
            } else if (confirmation(response).equals("negative")) {
                return false;
            } else {
                clarification();
            }
        }
    }

    public static String negate(String fact){
        if(fact.contains("is")){
            return fact.replaceFirst("is", "isn't");
        }
        if(fact.contains("has")){
            return fact.replaceFirst("has", "doesn't have");
        }
        if(fact.contains("can")){
            return fact.replaceFirst("can", "can't");
        }

        return fact;
    }


}

