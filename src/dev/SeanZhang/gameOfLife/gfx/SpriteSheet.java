package dev.SeanZhang.gameOfLife.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Sean Zhang
 */

//the spritesheet class. it will be useful in the assets class
public class SpriteSheet {
    //creates an image varaible called sheet
    private BufferedImage sheet;
    
    //constructor takes in the image from the parameter and sets it 
    //to be the sheet variable in this class
    public SpriteSheet(BufferedImage sheet) {
        this.sheet=sheet;
    }
    
    //the crop method. This will be helpful in separating textures from
    //each other and getting the desired texture on the spritesheet.
    //this takes in the parameters x and y position,
    //and the width and height of the area you want to crop
    //In our case, it will be the size of the tiles in the image
    //(you will see in the assets class), which is 32.
    public BufferedImage crop(int x,int y,int width,int height) {
        return sheet.getSubimage(x, y, width, height);
    }
        
}
