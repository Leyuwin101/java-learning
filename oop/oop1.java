package oop;

import java.util.*;

class Song {
    private final String title;
    private final String artist;
    private final String album;

    public Song(String title, String artist, String album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getAlbum() { return album; }

    public String displaySong() {
        return "\"" + getTitle() + "\" by " + getArtist() + " [" + getAlbum() + "]";
    }
}

class MusicLibrary {
    private final Random random = new Random();
    List<Song> songs;

    public MusicLibrary() { songs = new ArrayList<>(); }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Song added: " + song.displaySong());
    }

    public boolean removeSong(int index) {
        if (index >= 0 && index < songs.size()) {
            songs.remove(index);
            System.out.println("Removed a song ");
            return true;
        }
        return false;
    }

    public void randomSong() {
        if (songs.isEmpty()) {
            System.out.println("The music library is empty");
        } else {
            Song randomSong = songs.get(random.nextInt(songs.size()));
            System.out.println("Now playing: " + randomSong.displaySong());
        }
    }

    public void showSongs() {
    if (songs.isEmpty()) {
        System.out.println("No songs in library.");
        return;
    }
    for (int i = 0; i < songs.size(); i++) {
        System.out.println((i + 1) + ". " + songs.get(i).displaySong());
    }
}
    
}

public class oop1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MusicLibrary ml = new MusicLibrary();
        boolean exit = false;

        ml.addSong(new Song("Lowkey", "NIKI", "wanna take this downtown?"));
        ml.addSong(new Song("Every Summertime", "NIKI", "Shang‑Chi and the Legend of the Ten Rings OST"));
        ml.addSong(new Song("You'll Be in My Heart", "NIKI", "Single"));
        ml.addSong(new Song("Take A Chance With Me", "NIKI", "Nicole"));
        ml.addSong(new Song("Backburner", "NIKI", "Nicole"));
        ml.addSong(new Song("La La Lost You", "NIKI", "Single / Acoustic"));
        ml.addSong(new Song("Oceans & Engines", "NIKI", "Nicole"));
        ml.addSong(new Song("I Like U", "NIKI", "Single"));
        ml.addSong(new Song("High School in Jakarta", "NIKI", "Nicole"));
        ml.addSong(new Song("Lose", "NIKI", "Moonchild"));
        
        while(!exit) {
            System.out.println("\n====== WELCOME TO MUSIC LIBRARY ======");
            System.out.println(">>> 1. ADD SONG");
            System.out.println(">>> 2. REMOVE SONG");
            System.out.println(">>> 3. PLAY RANDOM SONG");
            System.out.println(">>> 4. SHOW ALL SONGS");
            System.out.println(">>> 5. EXIT");
            System.out.print("CHOOSE AN OPTION HERE: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter a title of the song: ");
                    String title = sc.nextLine();

                    System.out.print("Enter the artist of the song: ");
                    String artist = sc.nextLine();

                    System.out.print("Enter the album of the song: ");
                    String album = sc.nextLine();

                    Song newSong = new Song(title, artist, album);
                    ml.addSong(newSong);
                    break;
                case 2:
                    System.out.print("Enter an index of song to removed: ");
                    int index = sc.nextInt() - 1;

                    ml.removeSong(index);
                    break;
                case 3:
                    ml.randomSong();
                    break;
                case 4:
                    ml.showSongs();
                    break;
                case 5:
                    exit = true;
                    break;
                default: 
                    System.out.println("Invalid choice");
            }
        }
    sc.close();
    }
}
