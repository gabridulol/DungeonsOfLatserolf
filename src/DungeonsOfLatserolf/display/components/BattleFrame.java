package DungeonsOfLatserolf.display.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

public class BattleFrame extends JFrame {
    private JTextArea battleInfoTextArea;
    private CountDownLatch latch = new CountDownLatch(1);

    public BattleFrame(String Text) {
        super("Batalha");

        setLayout(new BorderLayout());

        battleInfoTextArea = new JTextArea(Text);
        battleInfoTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(battleInfoTextArea);  
        
        JButton continueButton = new JButton("Continuar");
        continueButton.addActionListener(e -> latch.countDown());

        add(scrollPane, BorderLayout.CENTER);
        add(continueButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400,200);
        setLocationRelativeTo(null);
        setVisible(true);

        // JButton continueButton = new JButton("Continuar");
        // continueButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         battleAccepted = true;
        //         setVisible(false); // Esconder a janela da batalha
        //     }
        // });

        // setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        // add(battleInfoTextArea);
        // // add(continueButton);

        // setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // pack();  // Use pack to resize the frame based on its components
        // setLocationRelativeTo(null); // Centralizar na tela
        // setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
    }

    public void setBattleInfoTextArea(String battleInfo) {
        battleInfoTextArea.setText(battleInfo);
    }

    public JButton createContinueButton(ActionListener actionListener) {
        JButton continueButton = new JButton("Continuar");
        continueButton.addActionListener(actionListener);
        return continueButton;
    }

    public void waitForContinue() {
        latch = new CountDownLatch(1);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


