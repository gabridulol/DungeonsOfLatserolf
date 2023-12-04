package TestDungeonsOfLatserolf;

import javax.swing.JOptionPane;

public class ExemploPopup {

    public static void main(String[] args) {
        // Exemplo de uso de JOptionPane para exibir uma mensagem simples
        exibirPopup("Bem-vindo ao jogo!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        // Exemplo de uso de JOptionPane para exibir uma mensagem com um botão de confirmação
        int resultado = exibirPopupComBotao("Você deseja abrir a porta?", "Pergunta", JOptionPane.YES_NO_OPTION);

        // Verifica a resposta do usuário
        if (resultado == JOptionPane.YES_OPTION) {
            // Lógica para lidar com a abertura da porta
            exibirPopup("Você abriu a porta!", "Ação realizada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Lógica para lidar com a recusa de abrir a porta
            exibirPopup("Você optou por não abrir a porta.", "Ação realizada", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método para exibir uma popup simples
    private static void exibirPopup(String mensagem, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
    }

    // Método para exibir uma popup com um botão de confirmação
    private static int exibirPopupComBotao(String pergunta, String titulo, int opcoes) {
        return JOptionPane.showConfirmDialog(null, pergunta, titulo, opcoes);
    }
}