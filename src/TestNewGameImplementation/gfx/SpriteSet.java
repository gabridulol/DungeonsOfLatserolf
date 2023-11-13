package TestNewGameImplementation.gfx;

import java.awt.Image;
import java.util.Map;
import java.util.HashMap;

public class SpriteSet {
    private Map<String, Image> animationSheets;

    public SpriteSet() {
        this.animationSheets = new HashMap<>();
    }

    public void addSheet(String name, Image animationSheet) {
        this.animationSheets.put(name, animationSheet);
    }

    public Image get(String name) {
        return this.animationSheets.get(name);
    }
}
