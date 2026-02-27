package Day39;
// Generics Only Work with Reference Types
// Generics were designed to work with objects, not primitives
// Create a generic class Container<T>
class Container<T extends Comparable<T>> {
    private T value;

    // Constructor
    public Container(T value) { this.value = value; }

    // Getter
    public T getValue() { return value; }

    // Setter
    public void setValue(T value) { this.value = value; }

    // Compare method
    public int compareTo(Container<T> other) {
        return this.value.compareTo(other.value);
    }

    // Why T extends Comparable<T>?

    // This ensures:
    // You can only pass types like Integer, String, Double, etc.
    // You can safely call .compareTo() on value
}

// Generic Method to Swap Two Elements in an Array
class ArrayUtils {
    
    // Store first value
    // Replace first with second
    // Replace second with stored value
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
public class miniProject39 {
    public static void main(String[] args) {
        
        // Using Container
        // Result	                Meaning
        // Negative number	        this < other
        // 0	                    this == other
        // Positive number	        this > other
        Container<Integer> c1 = new Container<>(10);
        Container<Integer> c2 = new Container<>(20);

        Container<String> c3 = new Container("Alice");
        Container<String> c4 = new Container("Alice");

        System.out.println("Before comparison: " + c1.getValue());
        System.out.println("Comparison result: " + c1.compareTo(c2));
        System.out.println("Comparison result: " + c3.compareTo(c4));

        // Using swap method
        Integer[] numbers = {1, 2, 3,4};

        System.out.println("Before swap: ");
        for(int n: numbers) {
            System.out.print(n + " ");
        }

        ArrayUtils.swap(numbers, 0, 3);

        System.out.println("\nAfter swap: ");
        for(int n: numbers) {
            System.out.print(n + " ");
        }
    }
}
