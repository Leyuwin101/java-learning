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
        
        // ===================== HashSet =====================
        Set<Color> hashSetColors = new HashSet<>();
        hashSetColors.add(new Color("Red"));
        hashSetColors.add(new Color("Blue"));
        hashSetColors.add(new Color("Yellow"));
        hashSetColors.add(new Color("Green"));
        hashSetColors.add(new Color("Red"));   // duplicate

        System.out.println("HashSet (no duplicates, unordered): " + hashSetColors);

        // ===================== LinkedHashSet =====================
        Set<Color> linkedHashSetColors = new LinkedHashSet<>();
        linkedHashSetColors.add(new Color("Red"));
        linkedHashSetColors.add(new Color("Blue"));
        linkedHashSetColors.add(new Color("Yellow"));
        linkedHashSetColors.add(new Color("Green"));
        linkedHashSetColors.add(new Color("Red")); // duplicate ignored

        System.out.println("LinkedHashSet (insertion order): " + linkedHashSetColors);

        // ===================== TreeSet =====================
        TreeSet<Color> treeSetColors = new TreeSet<>();
        treeSetColors.add(new Color("Purple"));
        treeSetColors.add(new Color("Black"));
        treeSetColors.add(new Color("Green"));
        treeSetColors.add(new Color("Blue"));
        treeSetColors.add(new Color("Purple")); // duplicate ignored

        System.out.println("TreeSet (sorted order): " + treeSetColors);

        // ===================== contains() checks =====================
        System.out.println("\n--- Contains Checks ---");
        System.out.println("HashSet contains Red? " + hashSetColors.contains(new Color("Red")));
        System.out.println("LinkedHashSet contains Black? " + linkedHashSetColors.contains(new Color("Black")));
        System.out.println("TreeSet contains Red? " + treeSetColors.contains(new Color("Red")));

    }
    
}
