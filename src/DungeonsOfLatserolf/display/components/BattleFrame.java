package DungeonsOfLatserolf.display.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleFrame extends JFrame {
    private boolean battleAccepted;
    private JTextArea battleInfoTextArea;

    public BattleFrame(String monsterInfo, String battleInfo, String battleIniciative) {
        super("Batalha");

        battleInfoTextArea = new JTextArea(monsterInfo + "\n" + battleInfo + "\n" + battleIniciative);
        battleInfoTextArea.setEditable(false);

        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battleAccepted = true;
                dispose(); // Fechar a janela da batalha
            }
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(battleInfoTextArea);
        add(continueButton);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centralizar na tela
        setVisible(true);

        // Bloquear o restante da interface enquanto a janela de batalha estiver aberta
        setEnabled(false);
    }

    public boolean isBattleAccepted() {
        return battleAccepted;
    }

    public void setBattleInfoTextArea(String battleInfo) {
        battleInfoTextArea.setText(battleInfo);
    }   
}
