package TestDungeonsOfLatserolf;

import javax.swing.*;

import DungeonsOfLatserolf.display.components.Dungeon;
import DungeonsOfLatserolf.graphics.AssetLibrary;
import DungeonsOfLatserolf.map.MapEntity;

public class TestImage extends JFrame {

    private BufferedImage image;

    public void ImageDisp(BufferedImage image) {
        this.image = image;

        // Configurar a JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Image Display");
        setResizable(false);

        // Criar um painel para exibir a imagem
        ImagePanel imagePanel = new ImagePanel(image);
        getContentPane().add(imagePanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        AssetLibrary assetLibrary = new AssetLibrary();

        TileTypeEntity tileTypeEntity = new Wall(assetLibrary.getImage("wall(0)"));

        SwingUtilities.invokeLater(() -> {
            TestImage TestImage = new TestImage();
            TestImage.ImageDisp(tileTypeEntity.getAssetImage());
        });
    }

    private static BufferedImage loadYourImage() {
        // Implementar o código para carregar a sua BufferedImage aqui
        // Exemplo: BufferedImage image = ImageIO.read(new
        // File("caminho/para/sua/imagem.png"));
        return null; // Retorne a BufferedImage carregada
    }

    private static class ImagePanel extends JPanel {
        private BufferedImage image;

        public ImagePanel(BufferedImage image) {
            this.image = image;
            setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, this);
            }
        }
    }
}
