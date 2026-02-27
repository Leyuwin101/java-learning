package Day39;

class Pair<K,V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void print() {
        System.out.println(key + " -> " + value);
    }

}
public class generic {
    public static void main(String[] args) {
        
        Pair<String, Integer> student = new Pair<>("Alice", 90);
        Pair<String, String> country = new Pair("PG", "Philippines");

        student.print();
        country.print();
    }
}
