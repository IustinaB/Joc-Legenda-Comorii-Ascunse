package PaooGame.Items;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Input.KeyInput;
import PaooGame.Shortcut;

import java.awt.*;
import java.awt.image.BufferedImage;

import static PaooGame.Graphics.Assets.ciupercaRosie;


public class Ciuperci extends Item {                                                                         /*<Personaj cu care jucatorul intra in interactiune*/
    private BufferedImage actual;
    public boolean right=true, left=false;
    int h = 48, w = 48;
    public static Rectangle c;

    public Ciuperci(int x, int y, int width, int height, BufferedImage image) {
        super(x, y, width, height, image);
        actual = ciupercaRosie;
        c=new Rectangle(x,y,width,height);
    }

    public void Update() {

    }



    @Override
    public boolean MoveY() {

        return false;
    }
    public boolean MoveX(int ls, int ld) {
        if (right) {
            x=x+4;
            c.x=c.x+4;
            if(x==ld)
            {
                right=false;
                left=true;
            }
        }
        if(left)
        {
            x=x-4;
            c.x=c.x-4;
            if(x==ls) {
                right=true;
                left=false;
            }

        }
        return false;
    }



    @Override
    public void Draw() {

        Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
        //Shortcut.g.drawRect(c.x,c.y,width,height);
        c.x=x;
        c.y=y;
    }
}
