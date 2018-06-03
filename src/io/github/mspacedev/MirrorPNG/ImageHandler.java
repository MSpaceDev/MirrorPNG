package io.github.mspacedev.MirrorPNG;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © MSpace-Dev 2018
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ImageHandler {
    public void mirrorImage(String imageName){
        BufferedImage img = null;

        // Read image
        try {
            File f = new File(imageName + ".png");
            img = ImageIO.read(f);
        } catch(IOException e){
            System.out.println("Error: "+e);
        }

        // Make sure the file is found and create mirrored image
        if(img != null) {
            List<Integer> imgHex = new ArrayList<>();

            // Put all hex colours of img into array
            for (int y = 0; y < img.getHeight(); y++) {
                for (int x = 0; x < img.getWidth(); x++) {
                    imgHex.add(img.getRGB(x, y));
                }
            }

            // Create mirrored image
            int i = 0;
            for (int y = 0; y < img.getHeight(); y++) {
                for (int x = imgHex.size() / img.getWidth() - 1; x >= 0; x--) {
                    img.setRGB(x, y, imgHex.get(i));
                    i++;
                }
            }

            // Write mirrored image
            try {
                new File("mirrored_images").mkdirs();
                File f = new File("mirrored_images/" + imageName + ".png");
                ImageIO.write(img, "png", f);
            } catch(IOException e){
                System.out.println(e.toString());
            }
        }
    }
}
