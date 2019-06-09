package dev.SeanZhang.gameOfLife.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Sean Zhang
 */

//assets class. We will be accessing this classes variables in multiple classes
public class Assets {
    //public static varaibles so that they can be accessed by other classes
    private static int imgWidth;
    public static BufferedImage[][] gradientTiles;
    public static BufferedImage black,white;
    
    
    //this initialises that assets method. This is called in the game classe's 
    //constructor.
    public static void init(int w,int imgW) {
        Assets.imgWidth=imgW;
        gradientTiles = new BufferedImage[w][w];
        //creates new spritesheet object from the image path specified below.
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/gradient.png"));
        SpriteSheet bg = new SpriteSheet(ImageLoader.loadImage("/res/textures/black.png"));
        
        for(int i=0;i<gradientTiles.length;i++) {
            for(int j=0;j<gradientTiles[0].length;j++) {
                gradientTiles[i][j] = sheet.crop(j*imgWidth,i*imgWidth,imgWidth,imgWidth);
            }
        }
        
        black = sheet.crop(0, 0, imgWidth, imgWidth);
    }
}
