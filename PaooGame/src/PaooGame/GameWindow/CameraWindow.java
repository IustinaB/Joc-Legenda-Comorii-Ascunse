package PaooGame.GameWindow;

import PaooGame.Game;
import PaooGame.Items.*;

public class CameraWindow {                                                                     /*!<Clasa utilizata pentru a se deplasa odata cu miscarea jucatorului*/
    private int xOffset;
    private int yOffset;

    public CameraWindow(int xOffset, int yOffset){
        this.xOffset=xOffset;
        this.yOffset=yOffset;
    }

    public void Update(JackClass jack) {xOffset=(int)(-jack.GetX()+(int)(Game.w/2));}

    public void setxOffset(int xOffset){this.xOffset=xOffset;}
    public void setyOffsetTime(int yOffset){this.yOffset=yOffset;}

    public int getxOffset(){return xOffset;}
    public int getyOffset(){return yOffset;}



}
