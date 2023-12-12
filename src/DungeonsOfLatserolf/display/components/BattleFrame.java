package DungeonsOfLatserolf.display.components;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class BattleFrame extends JFrame {
    private BufferedImage[][] map;
    private int cont;

    public BattleFrame(ArrayList<String> listaBatalha,
            ArrayList<String> infoBatalha,
            ArrayList<String> listaDado,
            AtomicBoolean batalhando,
            BufferedImage[][] map, JLabel labelScore, int score) {

        this.map = map;

        cont = 0;

        setLayout(new BorderLayout());
        Color black = new Color(23, 17, 26);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(black);

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();

        label1.setForeground(Color.WHITE);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setText(listaDado.get(cont));

        label2.setForeground(Color.WHITE);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setText(infoBatalha.get(cont));

        label3.setForeground(Color.WHITE);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setText(listaBatalha.get(cont));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        panel.add(label1, gbc);
        panel.add(label2, gbc);
        panel.add(label3, gbc);

        add(panel, BorderLayout.NORTH);
        repaint();
        cont++;

        AtomicBoolean lose = new AtomicBoolean(
                "perdeu".equals(listaBatalha.get(listaBatalha.size() - 1).split(" ")[1]));

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        if (cont < listaBatalha.size()) {
                            label1.setText(listaDado.get(cont));
                            label2.setText(listaBatalha.get(cont));
                            label3.setText(infoBatalha.get(cont));
                            repaint();

                        }

                        else {
                            batalhando.set(false);
                            setVisible(false);
                            if (lose.get())
                                System.exit(0);
                            labelScore.setText("Score: " + score);
                        }

                        cont++;
                    } catch (IndexOutOfBoundsException exception) {
                        batalhando.set(false);
                        setVisible(false);

                        if (lose.get())
                            System.exit(0);
                        labelScore.setText("Score: " + score);
                    }

                }
            }
        });

        getContentPane().setBackground(black);
        setPreferredSize(new Dimension(600, 520));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Batalha");
        setResizable(false);
        pack();
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int cellSize = 16;

        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(4, 4);

        int cellX;
        int cellY;
        int dist = 2 * 14;

        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                cellX = (int) (x * cellSize) + dist;
                cellY = (int) (y * cellSize) + dist;

                if (map[x][y] != null)
                    g2d.drawImage(map[x][y], cellY, cellX, this);
            }
        }

        cellX = (int) (1 * cellSize) + dist;
        cellY = (int) (4 * cellSize) + dist;

        g2d.drawImage(map[6][0], cellX, cellY, this);

        cellX = (int) (3 * cellSize) + dist;
        cellY = (int) (2 * cellSize) + dist;

        g2d.drawImage(map[6][1], cellX, cellY, this);
    }
}
