package Day26;
// Primitives: int, double, boolean → cannot call methods on them
// Wrappers: Integer, Double, Boolean → objects, have methods
// Autoboxing = primitive → wrapper automatically
// Unboxing = wrapper → primitive automatically
public class wrap {
    public static void main(String[] args) {
        // Autoboxing
        int num = 10;
        Integer numObj = num; // primitive -> object
        System.out.println("Integer object: " + numObj);

        // Unboxing
        Integer anothernum = 20;
        int primitve = anothernum; // object -> primitive
        System.out.println("Primitive int: " + primitve);

        // Using wrapper methods
        String s = "123";
        int parsed = Integer.parseInt(s);
        System.out.println("Parsed int: " + parsed);

        Double d = Double.valueOf("3.14");
        System.out.println("Double object: " + d);

        Boolean b = Boolean.valueOf("true");
        System.out.println("Boolean object: " + b);
    }
}
