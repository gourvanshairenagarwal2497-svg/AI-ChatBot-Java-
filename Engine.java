import java.util.HashMap;
import java.util.Random;

public class Engine {

    private database db;
    private Random random;

    public Engine() {
        db = new database();
        random = new Random();
    }

    // Main response method
    public String getResponse(String input) {

        input = nlpprocessing.process(input);

        if (input.isEmpty()) {
            return "Please type something.";
        }

        // Greetings
        if (isGreeting(input)) {
            return getGreeting();
        }

        // Farewell
        if (isFarewell(input)) {
            return getFarewell();
        }

        // Thank You
        if (input.contains("thank")) {
            return "You're welcome! Happy to help.";
        }

        // About Bot
        if (input.contains("your name")) {
            return "I am Java AI ChatBot.";
        }

        if (input.contains("who created you")) {
            return "I was created as a Java internship project.";
        }

        if (input.contains("help")) {
            return "You can ask me about Java, AI, NLP, Programming, College, Placements, Library, Fees and Admissions.";
        }

        // Search Knowledge Base
        String answer = searchDatabase(input);

        if (answer != null) {
            return answer;
        }

        // Programming Questions
        if (input.contains("programming")) {
            return "Programming is the process of writing instructions for a computer.";
        }

        if (input.contains("oop")) {
            return "OOP stands for Object-Oriented Programming. It is based on Classes and Objects.";
        }

        if (input.contains("class")) {
            return "A class is a blueprint for creating objects.";
        }

        if (input.contains("object")) {
            return "An object is an instance of a class.";
        }

        if (input.contains("loop")) {
            return "Loops are used to execute a block of code repeatedly.";
        }

        if (input.contains("array")) {
            return "An array stores multiple values of the same type.";
        }

        if (input.contains("string")) {
            return "A String represents a sequence of characters.";
        }

        return getUnknownResponse();
    }

    // Greeting Check
    private boolean isGreeting(String input) {
        return input.contains("hello") ||
                input.contains("hi") ||
                input.contains("hey") ||
                input.contains("namaste");
    }

    // Farewell Check
    private boolean isFarewell(String input) {
        return input.contains("bye") ||
                input.contains("goodbye") ||
                input.contains("see you");
    }

    // Greeting Responses
    private String getGreeting() {

        String greetings[] = {
                "Hello! How can I help you today?",
                "Hi! Nice to meet you.",
                "Welcome! Ask me anything.",
                "Hello! Hope you're having a great day."
        };

        return greetings[random.nextInt(greetings.length)];
    }

    // Farewell Responses
    private String getFarewell() {

        String bye[] = {
                "Good Bye! Have a nice day.",
                "See you again!",
                "Take care!",
                "Thanks for chatting with me."
        };

        return bye[random.nextInt(bye.length)];
    }

    // Search FAQ Database
    private String searchDatabase(String input) {

        HashMap<String, String> data = db.getData();

        for (String key : data.keySet()) {

            if (input.contains(key)) {
                return data.get(key);
            }

        }

        return null;
    }

    // Default Response
    private String getUnknownResponse() {

        String replies[] = {
                "Sorry, I don't understand that.",
                "Can you ask your question differently?",
                "I don't have information about that yet.",
                "Please ask another question related to Java or AI."
        };

        return replies[random.nextInt(replies.length)];
    }
}