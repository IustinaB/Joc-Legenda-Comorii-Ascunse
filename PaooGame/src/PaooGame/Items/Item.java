package PaooGame.Items;



import PaooGame.Input.KeyInput;
import PaooGame.Map.Map;

import java.awt.*;
import java.awt.image.BufferedImage;



public abstract class Item {
    public  int x;
    public int y;    //pozitiile x si y pe tabla de joc
    protected int width;    //latimea imaginii entitatii
    protected int height;   //inaltimea imaginii entitatii
    protected BufferedImage image;
    protected int jump, weight;
    boolean move=false;
    public Item(int x, int y, int width, int height,BufferedImage image)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.image=image;
        jump=0;
        weight=3;


    }



    public void Update(){
    }
    public abstract boolean MoveY();
    public abstract void Draw();


}
