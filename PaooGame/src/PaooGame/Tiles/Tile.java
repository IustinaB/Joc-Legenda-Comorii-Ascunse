package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    private static final int NO_TILES = 64;
    public static Tile[] tiles = new Tile[NO_TILES];

    public static Tile soil1= new Soil1(1);  //sol Nivel1
    public static Tile soil2= new Soil2(2);
    public static Tile soil3= new Soil3(3);
    public static Tile soil4= new Soil4(4);
    public static Tile soil5= new Soil5(5);
    public static Tile soil6= new Soil6(6);
    public static Tile soil7= new Soil7(7);
    public static Tile crate= new Crate(8);     //lada
    public static Tile sol=new Sol(9);

    public static Tile coin1=new Coin1(11);    //banuti
    public static Tile coin2=new Coin2(12);
    public static Tile coin3=new Coin3(13);
    public static Tile coin4=new Coin4(14);
    public static Tile coin5=new Coin5(15);
    public static Tile coin6=new Coin6(16);
    public static Tile coin7=new Coin7(17);

    public static Tile diamond= new Diamond(18); //diamant
    public static Tile goblet=new Goblet(19); //pocal
    public static Tile crown=new Crown(20);  //coroana
    public static Tile potion1=new Potion1(21); //potiune subtire
    public static Tile potion2=new Potion2(22); //potiune
    public static Tile cufar=new Cufar(35);



    //Nivelul 2
    public static Tile soil1L2=new Soil1L2(23);
    public static Tile soil2L2=new Soil2L2(24);
    public static Tile soil3L2=new Soil3L2(25);
    public static Tile soil4L2=new Soil4L2(26);
    public static Tile soil5L2=new Soil5L2(27);
    public static Tile soil6L2=new Soil6L2(28);
    public static Tile soil7L2=new Soil7L2(29);
    public static Tile soil8L2=new Soil8L2(30);
    public static Tile soil9L2=new Soil9L2(31);
    public static Tile cerl2=new CerL2(36);

    public static Tile cer1=new Cer1(32);
    public static Tile cer2=new Cer2(33);
    public static Tile cer3=new Cer3(34);



    public static final int TILE_WIDTH  = 48;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 48;

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;

    public Tile(BufferedImage image, int idd)
    {
        img=image;
        id=idd;

        tiles[id]=this;
    }

    public void Update()
    {

    }

    public void Draw(Graphics g, int x, int y)
    {
        // Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean IsSolid()
    {
        return false;
    }
    public static final Tile GetTile(int id){return tiles[id];}
    public int GetId()
    {
        return id;
    }



}