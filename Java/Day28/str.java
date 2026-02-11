package Day28;

public class str {
    public static void main(String[] args) {
        // Important String Methods
        String text = "Java Programming";

        System.out.println(text.length());
        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());
        System.out.println(text.trim());
        System.out.println(text.substring(2, 6));
        System.out.println(text.contains("Java"));
        System.out.println(text.replace("Java", "Python"));
        System.out.println(text.charAt(1));


        String sentence = " Java is Powerful ";

        System.out.println("Length: " + sentence.length());
        System.out.println("Uppercase: " + sentence.toUpperCase());
        System.out.println("Trimmed: " + sentence.trim());
        System.out.println("Contains 'Java'?: " + sentence.contains("Java"));

          // StringBuilder example
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(5, " Java");
        sb.replace(0, 5, "Hi");

        System.out.println("StringBuilder result: " + sb);
    }
}
