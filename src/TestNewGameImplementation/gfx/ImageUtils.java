package TestNewGameImplementation.gfx;

import java.awt.Image;
import javax.imageio.ImageIO;

public class ImageUtils {
    public static Image loadImage(String filePath) {
        try {
            return ImageIO .read(ImageUtils.class.getResource(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
