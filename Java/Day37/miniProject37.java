package Day37;

import java.util.*;

class Color implements Comparable<Color> {
    private String colors;

    public Color(String colors) {
        this.colors = colors;
    }

    public String getColor() { return colors; }

    @Override
    public String toString() { return colors; }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) return true;
        if (!(obj instanceof Color)) return false;
        Color color = (Color) obj;
        return colors.equals(color.colors);
    }

    @Override
    public int hashCode() { return colors.hashCode(); }

    @Override
    public int compareTo(Color other) { return this.colors.compareTo(other.colors); }
}
public class miniProject37 {
    public static void main(String[] args) {
        // HashSet uses hashCode()/equals() to detect duplicates, no order guaranteed.
        // TreeSet uses compareTo() to sort and detect duplicates, so your objects need to implement
        // Create a Set<Color> of colors
        Set<Color> setColors = new HashSet<>();

        setColors.add(new Color("Red"));
        setColors.add(new Color("Blue"));
        setColors.add(new Color("Yellow"));
        // Try adding duplicates and see what happens
        setColors.add(new Color("Red"));

        System.out.println("Set: " + setColors);


        Set<Color> linkedColors = new LinkedHashSet<>();
        linkedColors.add(new Color("Red"));
        linkedColors.add(new Color("Blue"));
        linkedColors.add(new Color("Yellow"));
        linkedColors.add(new Color("Red")); // ignored

        System.out.println("LinkedHashSet: " + linkedColors);

        // Use a TreeSet to sort the elements
        TreeSet<Color> treesetColors = new TreeSet<>();

        treesetColors.add(new Color("Purple"));
        treesetColors.add(new Color("Black"));

        System.out.println("TreeSet: " + treesetColors);

        // Check if a specific element exists
        if (setColors.contains(new Color("Red"))) {
            System.out.println("Set Colors contains Red ");
        } else {
            System.out.println("Set Colors doesn't contain that color");
        }

        if (linkedColors.contains(new Color("Black"))) {
            System.out.println("Linked colors contains Black");
        } else {
            System.out.println("Linked Colors doesn't contain that color");
        }
        if (treesetColors.contains(new Color("Red"))) {
            System.out.println("Kulay contains Red");
        } else {
            System.out.println("Treeset Colors doesn't contain that color");
        }
        

    }
    
}
