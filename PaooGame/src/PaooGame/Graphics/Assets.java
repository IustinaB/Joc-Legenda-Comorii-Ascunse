package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class Assets {                                                                        /*!<Contine imaginile decupate utilizate*/


    public static BufferedImage soil1;
    public static BufferedImage soil2;
    public static BufferedImage soil3;
    public static BufferedImage soil4;
    public static BufferedImage soil5;
    public static BufferedImage soil6;
    public static BufferedImage soil7;
    public static BufferedImage soil8;
    public static BufferedImage sol;
    public static BufferedImage crate;
    public static BufferedImage diamond;
    public static BufferedImage goblet;
    public static BufferedImage coin1;
    public static BufferedImage coin2;
    public static BufferedImage coin3;
    public static BufferedImage coin4;
    public static BufferedImage coin5;
    public static BufferedImage coin6;
    public static BufferedImage coin7;
    public static BufferedImage crown;
    public static BufferedImage potion1;
    public static BufferedImage potion2;
    public static BufferedImage cufar;
    public static BufferedImage[] jackRight=new BufferedImage[5];
    public static BufferedImage[] jackLeft=new BufferedImage[5];
    public static BufferedImage[] jackUp=new BufferedImage[3];
    public static BufferedImage[] jackUpBack=new BufferedImage[3];
    public static BufferedImage[] jackDies=new BufferedImage[5];
    public static BufferedImage[] heart1=new BufferedImage[13];
    public static BufferedImage ciupercaRosie;
    public static BufferedImage ciupercaAlbastra;
    //Nivelul 2

    public static BufferedImage soil1L2;
    public static BufferedImage soil2L2;
    public static BufferedImage soil3L2;
    public static BufferedImage soil4L2;
    public static BufferedImage soil5L2;
    public static BufferedImage soil6L2;
    public static BufferedImage soil7L2;
    public static BufferedImage soil8L2;
    public static BufferedImage soil9L2;
    public static BufferedImage cer1;
    public static BufferedImage cer2;
    public static BufferedImage cer3;
    public static BufferedImage cerL2;

    public Assets(){

    }

    public static void Init() {
        SpriteSheet soil = new SpriteSheet(ImageLoader.LoadImage("/textures/sol.png"));
        soil1=soil.crop(0,0);
        soil2=soil.crop(1,0);
        soil3=soil.crop(2,0);
        soil4=soil.crop(3,0);
        soil5=soil.crop(4,0);
        soil6=soil.crop(5,0);
        soil7=soil.crop(6,0);
        soil8 = soil.crop(7, 0);
        crate=soil.crop(8,0);

        sol=soil.crop(10,0);

        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/avere.png"));
        diamond = sheet.crop(0, 0);
        crown=sheet.crop(1,0);
        goblet=sheet.crop(2,0);
        coin1=sheet.crop(3,0);
        coin2=sheet.crop(4,0);
        coin3=sheet.crop(5,0);
        coin4=sheet.crop(6,0);
        coin5=sheet.crop(7,0);
        coin6=sheet.crop(8,0);
        coin7=sheet.crop(9,0);
        potion1=sheet.crop(10,0);
        potion2=sheet.crop(11,0);
        cufar=sheet.crop(12,0);

        SpriteSheet jack=new SpriteSheet(ImageLoader.LoadImage("/textures/Jack.png"));
        jackRight[0]=jack.crop(1,0);
        jackRight[1]=jack.crop(1,0);
        jackRight[2]=jack.crop(2,0);
        jackRight[3]=jack.crop(3,0);
        jackRight[4]=jack.crop(4,0);

        jackLeft[0]=jack.crop(0,4);
        jackLeft[1]=jack.crop(1,4);
        jackLeft[2]=jack.crop(2,4);
        jackLeft[3]=jack.crop(3,4);
        jackLeft[4]=jack.crop(4,4);

        jackUp[0]=jack.crop(0,1);
        jackUp[1]=jack.crop(1,1);
        jackUp[2]=jack.crop(2,1);

        jackUpBack[0]=jack.crop(0,5);
        jackUpBack[0]=jack.crop(1,5);
        jackUpBack[0]=jack.crop(2,5);

        jackDies[0]=jack.crop(0,3);
        jackDies[1]=jack.crop(1,3);
        jackDies[2]=jack.crop(2,3);
        jackDies[3]=jack.crop(3,3);
        jackDies[4]=jack.crop(4,3);

        SpriteSheet ciuperca = new SpriteSheet(ImageLoader.LoadImage("/textures/ciuperci.png"));
        ciupercaRosie=ciuperca.crop(0,0);
        ciupercaAlbastra=ciuperca.crop(1,0);

        SpriteSheet heart=new SpriteSheet(ImageLoader.LoadImage("/textures/life.png"));
        heart1[0]=heart.cropLife(0,0);
        heart1[1]=heart.cropLife(0,1);
        heart1[2]=heart.cropLife(0,2);
        heart1[3]=heart.cropLife(0,3);
        heart1[4]=heart.cropLife(0,4);
        heart1[5]=heart.cropLife(0,5);
        heart1[6]=heart.cropLife(0,6);
        heart1[7]=heart.cropLife(0,7);
        heart1[8]=heart.cropLife(0,8);
        heart1[9]=heart.cropLife(0,9);
        heart1[10]=heart.cropLife(0,10);
        heart1[11]=heart.cropLife(0,11);
        heart1[12]=heart.cropLife(0,12);



        SpriteSheet cer=new SpriteSheet(ImageLoader.LoadImage("/textures/cer.png"));
        cer1=cer.crop(0,0);
        cer2=cer.crop(1,0);
        cer3=cer.crop(2,0);


        //Nivel 2 sol
        SpriteSheet soil2=new SpriteSheet(ImageLoader.LoadImage("/textures/solL2.png"));
        soil1L2=soil2.crop(0,0);
        soil2L2=soil2.crop(1,0);
        soil3L2=soil2.crop(2,0);
        soil4L2=soil2.crop(3,0);
        soil5L2=soil2.crop(4,0);
        soil6L2=soil2.crop(5,0);
        soil7L2=soil2.crop(6,0);
        soil8L2=soil2.crop(7,0);
        soil9L2=soil2.crop(8,0);
        cerL2=soil2.crop(9,0);


    }
}