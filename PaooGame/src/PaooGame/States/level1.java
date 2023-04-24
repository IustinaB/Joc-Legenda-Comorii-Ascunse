package PaooGame.States;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Items.Ciuperci;
import PaooGame.Items.JackClass;
import PaooGame.Map.*;
import PaooGame.Shortcut;
import PaooGame.Game;

import java.awt.image.BufferedImage;
import static PaooGame.Shortcut.g;


public class level1 extends State {

    private BufferedImage life;
    public static JackClass Jack;
    private BufferedImage background2,background3;
    public static Ciuperci ciupercaR,ciupercaR1;


    public level1(Game game)
    {
        super();
        Jack.Reset();

        Jack=JackClass.GetInstance(48*2,48*10,96,96, Assets.jackRight[0]);        /*!<Utilizarea sablonului Singleton pentru instantierea personajului*/

        ciupercaR1= new Ciuperci(48 * 30, 537, 50, 50,Assets.ciupercaRosie);

    }
    @Override
    public void Update() {

        ciupercaR1.MoveX(48*27,48*32);

        if (Shortcut.game.keyInput.escape == true) {
            State.SetState(Shortcut.game.pause);
        }
        Shortcut.game.gameCamera.Update(Jack);

       if (Jack.GetCollision() == true) {
           {
               Jack.Stop();
           }
        } else {
        //   System.out.println("Jack.Update()");

            Jack.Update();
        }
        if(Jack.y>700) {
            Jack.life--;
            if (Jack.life == 0) {
                State.SetState(Shortcut.game.gameOver);
            }
        }


    }

    @Override
    public void Draw() {
        BufferedImage background;
        ImageLoader img= new ImageLoader();
        background=img.LoadImage("/textures/Background.png");

        g.translate(Shortcut.game.gameCamera.getxOffset(),Shortcut.game.gameCamera.getyOffset());
        Jack.Draw();
        g.drawImage(background,0,0,9600,720,null) ;
      //  System.out.println(Jack.GetX()+" "+Jack.GetY()+ " \n "+Jack.cutie.x+" " +Jack.cutie.y);
       ImageLoader im=new ImageLoader();
       background2=ImageLoader.LoadImage("/textures/1.png");
       g.drawImage(background2,0,0,-480,720,null) ;


       ciupercaR1.Draw();

        ImageLoader im2=new ImageLoader();
        background3=im2.LoadImage("/textures/backgroundultim.png");
        g.drawImage(background3,9600,0,960,720,null);

        Map m=new Map(Shortcut.game.Tip);
        m.Draw(Shortcut.game);
        Jack.Draw();
        Shortcut.g.drawImage(Assets.heart1[0], Jack.GetX() - 450, 20, null);

    }
}
