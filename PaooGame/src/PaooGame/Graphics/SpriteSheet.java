package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage spriteSheet;
    private static final int tileWidth = 64;
    private static final int tileHeight = 64;
    private static final int tileLifeW=192;
    private static final int tileLifeH=64;

    public SpriteSheet(BufferedImage buffImg)
    {
        spriteSheet=buffImg;
    }

    public BufferedImage crop(int x,int y)
    {
        return spriteSheet.getSubimage(x*tileWidth,y*tileHeight,tileWidth,tileHeight);

    }

    public BufferedImage cropLife(int x, int y)
    {
        return spriteSheet.getSubimage(x * tileLifeW, y * tileLifeH, tileLifeW, tileLifeH);
    }
}