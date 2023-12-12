package DungeonsOfLatserolf.display.components;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleDialog extends JDialog {
    private JTextPane battleInfoTextPane;
    private JButton continueButton;

    public BattleDialog(JFrame parent, String title, String monsterInfo, String battleInfo, String battleIniciative) {
        super(parent, title, true);

        battleInfoTextPane = new JTextPane();
        battleInfoTextPane.setEditable(false);
        setStyledText(battleInfoTextPane, monsterInfo + "\n" + battleInfo + "\n" + battleIniciative);

        continueButton = new JButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BattleDialog.this.dispose();
            }
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(battleInfoTextPane);
        add(continueButton);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        pack();
        setSize(1000, 1000);
        setVisible(true);
    }

    private void setStyledText(JTextPane textPane, String text) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet style = new SimpleAttributeSet();

        StyleConstants.setForeground(style, Color.WHITE);
        StyleConstants.setBackground(style, new Color(23, 17, 26));
        StyleConstants.setFontFamily(style, "CooperBits");
        StyleConstants.setFontSize(style, 48);

        try {
            doc.insertString(0, text, style);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean acceptBattle() {
        Object[] options = { "Sim", "Não" };
        int choice = JOptionPane.showOptionDialog(
                BattleDialog.this,
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
        setStyledText(battleInfoTextPane, battleInfo);
    }
}