package DungeonsOfLatserolf.display.components;

import javax.swing.*;
import java.awt.event.*;

public class BattleDialog extends JDialog {
    private JTextArea battleInfoTextArea;
    private JButton continueButton;

    public BattleDialog(JFrame parent, String title, String monsterInfo, String battleInfo, String battleIniciative) {
        super(parent, title, true);

        battleInfoTextArea = new JTextArea(monsterInfo + "\n" + battleInfo + "\n" + battleIniciative);
        battleInfoTextArea.setEditable(false);

        continueButton = new JButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleDialog.this.dispose();
            }
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(battleInfoTextArea);
        add(continueButton);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        pack();
        setSize(1000, 1000); // Altera o tamanho do JDialog
        setVisible(true);
    }

    public boolean acceptBattle() {
        Object[] options = { "Sim", "Não" };
        int choice = JOptionPane.showOptionDialog(
                null,
                "Você encontrou um monstro, deseja batalhar?",
                "Batalha",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        return choice == JOptionPane.YES_OPTION;
    }

    public void setBattleInfo(String battleInfo) {
        battleInfoTextArea.setText(battleInfo);
    }

    public BattleDialog getBattleDialog() {
        return this;
    }
}
