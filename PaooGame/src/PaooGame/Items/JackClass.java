package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.Input.KeyInput;
import PaooGame.Map.Map;
import PaooGame.Shortcut;
import java.awt.image.BufferedImage;
import java.awt.*;


public class JackClass extends Item {
    private static JackClass instance;
    public int life;
    private BufferedImage actual;
    boolean right = false, left = false, up = false;
    boolean move = false;
    int h = 96, w = 96;
    boolean rightP = false;
    boolean leftP = false;
    public static Rectangle cutie;
    public JackClass(int x, int y, int width, int height, BufferedImage image) {
        super(x, y, width, height, image);
        actual = Assets.jackRight[0];
        life=3;
        cutie = new Rectangle(x+20,y+10,96-43,96-10);
    }

    public static JackClass GetInstance(int x, int y, int width, int height, BufferedImage image){               /*!<Utilizare sablon Singleton*/
        if(instance==null)
        {
            instance=new JackClass(x,y,width,height,image);
        }
        return instance;
    }

    public static void Reset(){instance=null;}

    @Override
    public void Update() {

        if (MoveX() == true || MoveY() == true) {
            move = true;
        } else {
            move = false;
        }
    }
    public boolean MoveX() {                                                           /*!<Deplasare pe axa Ox*/
        if (KeyInput.right == true) {
            right = true;
            leftP = false;
            this.x = this.x + 15;
            this.cutie.x = x-20;
            rightP = true;
            KeyInput.right = false;
            return true;

        }
        if (KeyInput.left == true) {
            //System.out.println("LEFT");
            left = true;
            rightP = false;
            x = x - 15;
            this.cutie.x = x-20;
            leftP = true;
            KeyInput.left = false;
            return true;
        }
        return false;
    }


    @Override
    public boolean MoveY() {                                                                   /*!<Deplasare pe axa Oy-saritura*/

        if (KeyInput.up == true) {
            jump = 10;
        }
        y = y - jump;
        int ok = 0;
        int copiey = y;
        int i=0;
        //for (int i = 0; i < Map.Rectangle1.size(); i++)
        while(i<Map.Rectangle1.size() && ok==0){
            if (Map.Rectangle1.get(i).contains(x + 20, y + 97) == true || Map.Rectangle1.get(i).contains(x + 20 + 53, y + 97) == true) {
                copiey = Map.Rectangle1.get(i).y - 96;
                this.cutie.y = y;
                //System.out.println(y);
                ok = 1;
            }
            i++;
        }

        y = copiey;

            if(ok==0)
            {
                this.cutie.y = y;
                jump = jump - weight;
            }
        return false;
    }



   public boolean GetCollision() {

       for (int i = 0; i < Map.Rectangle1.size(); i++) {
           if (KeyInput.right == true && (Map.Rectangle1.get(i).contains(x+20+53+10,y+86)||Map.Rectangle1.get(i).contains(x+20+53+10,y))) {
               return true;
           }
           else if ((KeyInput.left == true) && (Map.Rectangle1.get(i).contains(x+25,y+86)||Map.Rectangle1.get(i).contains(x+25,y))) {


               return true;
           } else if ((KeyInput.up == true) && (Map.Rectangle1.get(i).contains(x+20,y+10)||Map.Rectangle1.get(i).contains(x+20+53,y+10))) {
               move=false;
               return true;
           }

       }
       return false;

   }

   public boolean GetCollisionM(Rectangle r)
   {

       /*if (r.intersects(Jack.cutie))
       {
           System.out.println();
           return true;
       }
*/
       if (KeyInput.right == true && (r.contains(x+20+53+15,y+86)||r.contains(x+20+53+15,y))) {
           return true;
       }
       else if ((KeyInput.left == true) && (r.contains(x+25,y+86)||r.contains(x+25,y))) {
           return true;
       }
       return false;
   }

    @Override
    public void Draw() {
        Graphics gr=Shortcut.g;

        if(move==true) {
            if (KeyInput.right == true) {
           //     System.out.println("right");
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackRight[1];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackRight[1];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackRight[2];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackRight[2];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackRight[3];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackRight[3];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackRight[4];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackRight[4];

                right = false;
                move = false;
            } else if (KeyInput.left == true) {
            //    System.out.println("left");
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackLeft[1];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackLeft[2];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackLeft[3];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackLeft[4];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackLeft[0];
                left = false;
                move = false;
            } else if ((KeyInput.up == true) && (rightP==true))
            {
              //  System.out.println("up");
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackUp[1];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackUp[2];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackUp[0];
                up = false;
                move = false;
            }
            else if((KeyInput.up==true) && (leftP==true)){
          //      System.out.println("up");
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackUpBack[1];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackUpBack[1];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackUpBack[2];
                Shortcut.g.drawImage(actual, (int) x, (int) y, w, h, null);
                actual = Assets.jackUpBack[0];
                up = false;
                move = false;
            }
        }
        else
        {
                Shortcut.g.drawImage(actual,(int)x,(int)y,w,h,null);
        }

    }



    public void Stop(){
        move=false;}
    public int GetX()
    {
        return x;
    }
    public int GetY()
    {
        return y;
    }

    public int getLife() {
        return life;
    }
    public void setX(int x)
    {
        this.x=x;
    }
    public void setY(int y)
    {
        this.y=y;
    }
}