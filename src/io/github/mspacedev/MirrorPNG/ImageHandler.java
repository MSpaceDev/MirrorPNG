package io.github.mspacedev.MirrorPNG;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Copyright © MSpace-Dev 2018
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ImageHandler {
    public void mirrorImage(String imageName){
        BufferedImage mirrorIMG = null;
        BufferedImage img;

        // Read image
        try{
            File f = new File(imageName + ".png");
            mirrorIMG = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
            mirrorIMG = ImageIO.read(f);
        }catch(IOException e){
            System.out.println("Error: "+e);
        }
        
        // Write mirrored image
        try{
            new File("mirrored_images").mkdirs();
            File f = new File("mirrored_images/" + imageName + ".png");
            ImageIO.write(mirrorIMG, "png", f);
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }
}
