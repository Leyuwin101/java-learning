package Day19;

// Create interface Playable with method play()
interface Playable {
    void play();
}

// Create classes Guitar and Piano implementing Playable
class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Guitar is playing a melody!");
    }
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Piano is playing a tune");
    }
}

public class miniProject19 {
    public static void main(String[] args) {
        Playable p1 = new Guitar();
        Playable p2 = new Piano();

        // Call play() for each instrument
        p1.play();
        p2.play();
    }
}
