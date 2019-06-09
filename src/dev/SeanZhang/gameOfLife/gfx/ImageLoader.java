package dev.SeanZhang.gameOfLife.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Sean Zhang
 */

//this class will load images in for you
public class ImageLoader {
    //takes in string parameter of the image path
    public static BufferedImage loadImage(String path) {
        try {
            //gets the resource from the path and returns it
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException ex) {
            ex.printStackTrace();
            //prevents program from running if there is an error
            System.exit(1);
        }
        //otherwise, return null if there is an exception
        return null;
    }
}
