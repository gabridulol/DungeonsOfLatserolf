package DungeonsOfLatserolf;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

public class Main {
    public static void main(String[] args) {
        // GameWindow
        JFrame windowFrame = new JFrame("Dungeons of Latserolf");
        JLabel textLabel = new JLabel("Welcome to Dungeons of Latserolf!");
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        Font font = new Font("JetBrains Mono", Font.PLAIN, 48);
        textLabel.setFont(font);
        windowFrame.add(textLabel);
        windowFrame.setSize(1280, 720);
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setLocationRelativeTo(null);
        windowFrame.setVisible(true);
    }
}
