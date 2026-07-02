import java.util.ArrayList;

public class nlpprocessing {

    // Main NLP Processing Method
    public static String process(String input) {

        if (input == null) {
            return "";
        }

        input = convertToLower(input);
        input = removeSpecialCharacters(input);
        input = removeExtraSpaces(input);

        return input;
    }

    // Convert text to lowercase
    private static String convertToLower(String text) {
        return text.toLowerCase();
    }

    // Remove punctuation and special symbols
    private static String removeSpecialCharacters(String text) {
        return text.replaceAll("[^a-zA-Z0-9 ]", "");
    }

    // Remove extra spaces
    private static String removeExtraSpaces(String text) {
        return text.trim().replaceAll("\\s+", " ");
    }

    // Split sentence into words
    public static String[] tokenize(String text) {

        text = process(text);

        if (text.isEmpty())
            return new String[0];

        return text.split(" ");
    }

    // Check if a keyword exists
    public static boolean containsKeyword(String input, String keyword) {

        input = process(input);

        return input.contains(keyword.toLowerCase());
    }

    // Extract keywords (simple version)
    public static ArrayList<String> extractKeywords(String input) {

        String[] words = tokenize(input);

        ArrayList<String> keywords = new ArrayList<>();

        for (String word : words) {

            if (word.length() > 2) {
                keywords.add(word);
            }

        }

        return keywords;
    }

    // Display processed sentence
    public static void printProcessedText(String input) {

        System.out.println("Processed Text : " + process(input));

    }

}