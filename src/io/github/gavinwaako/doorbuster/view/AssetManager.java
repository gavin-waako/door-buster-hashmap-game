package io.github.gavinwaako.doorbuster.view;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class AssetManager {

    //
    private final Map<String, BufferedImage> cache = new HashMap<>();

    //
    public BufferedImage getImage(String name) {
        if (!cache.containsKey(name)) {
            cache.put(name, load(name));
        }
        return cache.get(name);
    }

    //
    private BufferedImage load(String name) {
        String fileName = name + ".png";
        try (InputStream in = AssetManager.class.getResourceAsStream("/images/" + fileName)) {
            if (in != null) return ImageIO.read(in);
        } catch (IOException e) {
            System.err.println("Error reading " + fileName + ": " + e.getMessage());
        }
        System.err.println("Image not found: " + fileName + " (using placeholder)");
        return null;
    }
}