import java.util.HashMap;

public class database {

    private HashMap<String, String> data;

    public database() {

        data = new HashMap<>();
        loadData();

    }

    // Load FAQ Data
    private void loadData() {

        // Java
        data.put("java", "Java is an Object-Oriented Programming language developed by Sun Microsystems.");
        data.put("jdk", "JDK stands for Java Development Kit.");
        data.put("jre", "JRE stands for Java Runtime Environment.");
        data.put("jvm", "JVM stands for Java Virtual Machine.");
        data.put("oop", "OOP is a programming paradigm based on classes and objects.");
        data.put("class", "A class is a blueprint used to create objects.");
        data.put("object", "An object is an instance of a class.");
        data.put("constructor", "A constructor initializes an object when it is created.");
        data.put("inheritance", "Inheritance allows one class to acquire the properties of another.");
        data.put("polymorphism", "Polymorphism allows one interface to have multiple implementations.");
        data.put("encapsulation", "Encapsulation binds data and methods into one unit.");
        data.put("abstraction", "Abstraction hides unnecessary implementation details.");

        // AI
        data.put("ai", "Artificial Intelligence enables machines to perform tasks that require human intelligence.");
        data.put("machine learning", "Machine Learning is a subset of Artificial Intelligence.");
        data.put("deep learning", "Deep Learning uses neural networks with multiple layers.");
        data.put("nlp", "Natural Language Processing helps computers understand human language.");

        // Programming
        data.put("programming", "Programming is the process of writing instructions for computers.");
        data.put("array", "An array stores multiple values of the same data type.");
        data.put("string", "A String is a sequence of characters.");
        data.put("loop", "Loops are used to execute a block of code repeatedly.");
        data.put("exception", "Exception handling prevents program crashes.");
        data.put("file", "Java provides File Handling using FileReader, FileWriter and BufferedReader.");

        // College
        data.put("college", "College timing is from 9:00 AM to 5:00 PM.");
        data.put("library", "Library is open from 9:00 AM to 6:00 PM.");
        data.put("admission", "Admissions begin every July.");
        data.put("fees", "Please contact the Accounts Office for fee details.");
        data.put("hostel", "Hostel facilities are available for boys and girls.");
        data.put("placement", "Many reputed companies visit our campus every year.");
        data.put("canteen", "The college canteen serves food from 8:00 AM to 4:00 PM.");

        // Database
        data.put("database", "A database is an organized collection of data.");
        data.put("dbms", "DBMS stands for Database Management System.");
        data.put("sql", "SQL is used to manage relational databases.");

        // General
        data.put("internet", "The Internet is a global network connecting millions of computers.");
        data.put("computer", "A computer is an electronic device used for processing data.");
        data.put("software", "Software is a collection of programs that perform specific tasks.");
        data.put("hardware", "Hardware refers to the physical parts of a computer.");
        data.put("operating system", "An Operating System manages computer hardware and software resources.");

    }

    // Return Knowledge Base
    public HashMap<String, String> getData() {
        return data;
    }

    // Check if a keyword exists
    public boolean containsKey(String key) {
        return data.containsKey(key);
    }

    // Get a response directly
    public String getAnswer(String key) {
        return data.get(key);
    }

    // Display total FAQs
    public int totalQuestions() {
        return data.size();
    }
}