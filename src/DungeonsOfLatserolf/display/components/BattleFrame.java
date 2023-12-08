package DungeonsOfLatserolf.display.components;

import javax.swing.*;

import DungeonsOfLatserolf.map.tile.TileTypeEntity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class BattleFrame extends JFrame {
    private ArrayList<String> listaBatalha;
    private ArrayList<String> infoBatalha;
    private BufferedImage[][] map;
    private BufferedImage playerImage;
    private BufferedImage monsterImage;
    private int cont;

    public BattleFrame(ArrayList<String> listaBatalha, ArrayList<String> infoBatalha, AtomicBoolean batalhando,
            BufferedImage[][] map) {
        this.listaBatalha = listaBatalha;
        this.infoBatalha = infoBatalha;
        this.map = map;

        cont = 0;

        setLayout(new FlowLayout());
        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setText(infoBatalha.get(cont));
        label.setForeground(Color.WHITE);
        label.setText(listaBatalha.get(cont));
        add(label);
        add(label2);
        repaint();
        cont++;

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        if (cont < listaBatalha.size()) {
                            label.setText(listaBatalha.get(cont));
                            label2.setText(infoBatalha.get(cont));
                            repaint();
                        }

                        else {
                            batalhando.set(false);
                            setVisible(false);
                        }
                        cont++;
                    } catch (IndexOutOfBoundsException exception) {
                        label.setText("Fim da batalha");
                        batalhando.set(false);
                        setVisible(false);
                    }

                }
            }
        });

        setPreferredSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("batalha");
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
        g2d.scale(2, 2);

        int cellX;
        int cellY;
        int dist = 5 * 16;

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
