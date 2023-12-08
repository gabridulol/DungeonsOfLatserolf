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
    // private Graphics2D g2d;
    private ArrayList<String> listaBatalha;
    private ArrayList<String> infoBatalha; 
    private BufferedImage[][] map;
    private BufferedImage playerImage;
    private BufferedImage monsterImage;
    private int cont;

    public BattleFrame(ArrayList<String> listaBatalha, ArrayList<String> infoBatalha, AtomicBoolean batalhando, BufferedImage[][] map) {
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
                        cont ++;
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
        int dist = 5*16;

        for (int x = 0; x < 6 ; x++) {
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

    // @Override
    // protected void paintComponent(Graphics g) {
    //     super.paintComponent(g);

    //     Graphics2D g2d = (Graphics2D) g;

        // adicionar a primeira mensagem


        

        //mudar a cor da fonte
        

        // for (int x = 0; x < dx ; x++) {
        //     for (int y = 0; y < dy; y++) {
        //         int cellX = (int) (x * cellSize - xOffset / zoom);
        //         int cellY = (int) (y * cellSize - yOffset / zoom);

        //         BufferedImage image = mapEntity.getMap()[x][y].getAssetImage();

        //         if (image != null) {
        //             if(visitados[x][y])
        //                 // g2d.drawImage(image, x * cellSize, y * cellSize, this);
        //                 g2d.drawImage(image, cellX, cellY, this);
        //             else
        //                 // g2d.drawImage(mapEntity.getMapSystem().getImagemDoSistema().getImage("board(0)"), x * cellSize, y * cellSize, this);
        //                 g2d.drawImage(mapEntity.getMapSystem().getImagemDoSistema().getImage("board(0)"), cellX, cellY, this);
        //         }
        //     }
        // }

        // int characterXPosition = (int) ((characterX * cellSize) - xOffset / zoom);
        // int characterYPosition = (int) ((characterY * cellSize) - yOffset / zoom);
        
        // // g2d.drawImage(mapEntity.getMapSystem().getImagemDoSistema().getImage("down(0)"), characterX* cellSize, characterY* cellSize, this);
        // g2d.drawImage(playerImage, characterXPosition, characterYPosition, this);
        
    // }

        // private void updateMessage() {
        //     currentMessageIndex = (currentMessageIndex + 1) % messages.length;
        //     battleInfoTextArea.setText(messages[currentMessageIndex]);
        // }

    // public BattleFrame(String Text) {
    //     super("Batalha");

    //     setLayout(new BorderLayout());

    //     battleInfoTextArea = new JTextArea(Text);
    //     battleInfoTextArea.setEditable(false);

    //     JScrollPane scrollPane = new JScrollPane(battleInfoTextArea);  
        
    //     // JButton continueButton = new JButton("Continuar");
    //     // continueButton.addActionListener(e -> latch.countDown());
    //     add(scrollPane, BorderLayout.CENTER);
    //     // add(continueButton, BorderLayout.SOUTH);

    //     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    //     setSize(400,200);
    //     setLocationRelativeTo(null);
    //     setVisible(true);
    //     repaint();

    //     // waitForContinue();
        
    //     // JButton continueButton = new JButton("Continuar");
    //     // continueButton.addActionListener(new ActionListener() {
    //     //     @Override
    //     //     public void actionPerformed(ActionEvent e) {
    //     //         battleAccepted = true;
    //     //         setVisible(false); // Esconder a janela da batalha
    //     //     }
    //     // });

    //     // setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    //     // add(battleInfoTextArea);
    //     // // add(continueButton);

    //     // setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    //     // pack();  // Use pack to resize the frame based on its components
    //     // setLocationRelativeTo(null); // Centralizar na tela
    //     // setVisible(true);
    // }

    // protected void paintComponent(Graphics g) {
    //     super.paintComponents(g);
    //     g2d = (Graphics2D) g;
    //     g2d.drawString(text, 0, 0);
    // }

    // // public void setBattleInfoTextArea(String battleInfo) {
    // //     battleInfoTextArea.setText(battleInfo);
    // // }

    // public JButton createContinueButton(ActionListener actionListener) {
    //     JButton continueButton = new JButton("Continuar");
    //     continueButton.addActionListener(actionListener);
    //     return continueButton;
    // }

    // public void waitForContinue() {
    //     latch = new CountDownLatch(1);
    //     try {
    //         latch.await();
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

    // public void pause(int milissegundos) {
    //     try {
    //         Thread.sleep(milissegundos);
    //     } catch (InterruptedException e) {
    //         Thread.currentThread().interrupt();
    //         System.out.println("A pausa foi interrompida");
    //     }
    // }


    // @Override
    // public void keyPressed(KeyEvent e) {
    //     int keyCode = e.getKeyCode();
        
    //     if (keyCode == KeyEvent.VK_ENTER)
    //         System.out.println("ENTER");
    // }

    // @Override
    // public void keyTyped(KeyEvent e) {
    //     // Not needed for this example
    // }

    // @Override
    // public void keyReleased(KeyEvent e) {
    //     // Not needed for this example
    // }
}
