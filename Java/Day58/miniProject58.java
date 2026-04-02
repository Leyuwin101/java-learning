package Day58;

public class miniProject58 {
    public static void main(String[] args) {

        int FLAG_READ = 1;
        int FLAG_WRITE = 2;
        int FLAG_EXECUTE = 4;

        int permissions = FLAG_READ | FLAG_WRITE;

        System.out.println("Has read? " + ((permissions & FLAG_READ) != 0)); // true
        System.out.println("Has write? " + ((permissions & FLAG_WRITE) != 0));  // true
        System.out.println("Has execute? " + ((permissions & FLAG_EXECUTE) != 0)); // false

        permissions |= FLAG_EXECUTE;
        System.out.println("Has execute now? " + ((permissions & FLAG_EXECUTE) != 0)); // true

    }
}
