package mini;

import javax.swing.*;

public class mini13 extends JFrame {

    /** Array of lyrics lines to display */
    private String[] lyrics = {
        "Mamamatay akong nakangiti",
        "Kapag Ikaw ang nasa aking tabi",
        "Mabubuhay akong nagsisisi",
        "Kapag 'sang araw hindi Kita mapangiti",
        "Kalapastangan ang 'di Ka ibigin",
        "Kalokohan ang 'di Ka isipin",
        "Kung ang mundo ay biglang gugunawin",
        "Ikaw ang una kong hahanapin"
    };

    /** JLabel to show the current lyric line */
    private JLabel lyricLabel;

    /** Track the current character in a line */
    private int currentChar = 0;

    /** Track the current line */
    private int currentLine = 0;

    /** Delay in milliseconds between each character */
    private final int CHAR_DELAY = 100;

    /** Delay in milliseconds before showing the next line */
    private final int LINE_DELAY = 1500;

    /**
     * Constructor: sets up the JFrame and starts the lyrics display
     */
    public mini13() {
        setTitle("Kalapastangan");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lyricLabel = new JLabel("", SwingConstants.CENTER);
        lyricLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
        add(lyricLabel);

        setVisible(true);

        startLyrics(); // Begin showing lyrics
    }

    /**
     * Displays the lyrics with a typing effect, line by line
     */
    private void startLyrics() {
        new Thread(() -> {
            try {
                while (currentLine < lyrics.length) {
                    String line = lyrics[currentLine];
                    StringBuilder display = new StringBuilder();

                    /** Loop through each character in the line */
                    for (currentChar = 0; currentChar < line.length(); currentChar++) {
                        display.append(line.charAt(currentChar));
                        lyricLabel.setText(display.toString());
                        Thread.sleep(CHAR_DELAY); // Wait before showing next character
                    }

                    Thread.sleep(LINE_DELAY); // Wait before moving to next line
                    currentLine++;
                    currentChar = 0;
                }
            } catch(InterruptedException e) {
                e.printStackTrace(); // Handle thread interruption
            }
        }).start();
    }

    /**
     * Main method: launch the lyrics player
     */
    public static void main(String[] args) {
        new mini13();
    }
}