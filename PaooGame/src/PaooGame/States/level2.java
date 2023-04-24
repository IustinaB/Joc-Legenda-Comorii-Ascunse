package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Items.JackClass;
import PaooGame.Map.Map;
import PaooGame.Shortcut;

import java.awt.image.BufferedImage;

import static PaooGame.States.level1.Jack;

public class level2 extends State{
    private BufferedImage Level2;
    int Tip=2;

    public level2(Game game){
        super();
        Jack=JackClass.GetInstance(48*2,48*10,96,96, Assets.jackRight[0]);
        Jack.setX(48*2);
        Jack.setY(48*10);
        ImageLoader l2=new ImageLoader();
        Level2=l2.LoadImage("/textures/backgroundL2.png");
    }
    @Override
    public void Update() {
        Shortcut.game.gameCamera.Update(Jack);
        if (Shortcut.game.keyInput.escape == true) {
            State.SetState(Shortcut.game.pause);
        }
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

        //Jack.Update();
    }

    @Override
    public void Draw() {
        Shortcut.g.translate(Shortcut.game.gameCamera.getxOffset(),Shortcut.game.gameCamera.getyOffset());
        Shortcut.g.clearRect(0,0, Shortcut.game.getWnd().GetWndWidth(), Shortcut.game.getWnd().GetWndHeight());
        Jack.Draw();

        Shortcut.g.drawImage(Level2,-535,0,9600,720,null) ;
        Shortcut.g.drawImage(Level2,1020,0,9600,720,null) ;
        Shortcut.g.drawImage(Level2,0,0,9600,720,null) ;
        Shortcut.game.Tip=2;
        Map m2=new Map(Shortcut.game.Tip);
        m2.Draw(Shortcut.game);
        Jack.Draw();
    }
}
