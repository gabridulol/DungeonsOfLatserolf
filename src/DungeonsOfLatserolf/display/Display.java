package DungeonsOfLatserolf.display;

import java.awt.Font;

import javax.swing.*;

public class Display extends JFrame {
    public Display() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Dungeons of Latserolf");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setResizable(false);

        JLabel label = new JLabel("Dungeons of Latserolf");
        label.setFont(new Font("JetBrainsMono", Font.BOLD, 64)); // Ajuste conforme necessário
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.NORTH);
        add(label);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}