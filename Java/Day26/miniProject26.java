package Day26;

public class miniProject26 {
    public static void main(String[] args) {
        // Convert string "456" to integer and double
        String convert = "456";
        int i = Integer.parseInt(convert);
        System.out.println("Convert to integer: " + i);
        double d = Double.parseDouble(convert);
        System.out.println("Convert to double: " + d);

        // Autobox a char into Character
        char c = 'a';
        Character autobox = c;
        System.out.println("Character autobox: " + autobox);

        // Compare two Integer objects correctly
        Integer a = 10;
        Integer b = 10;
        System.out.println(a.equals(b));

    }
}
