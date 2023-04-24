package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Input.MouseInput;
import PaooGame.Shortcut;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Score extends State{
    private BufferedImage scor;
    public Score(Game game)                                                                 /*!<State ce contine referinte despre obictele colectate de jucator,fiecare dintre acestea avand o anumita valoare*/
    {
        ImageLoader score=new ImageLoader();

        scor=score.LoadImage("/textures/Score.jpg");
    }
    @Override
    public void Update() {
        if((Shortcut.game.mouse.click==true && Shortcut.game.mouse.getX()<=929 && MouseInput.getX()>=864) && (Shortcut.game.mouse.getY()>=669 && Shortcut.game.mouse.getY()<=693))
        {
            Shortcut.game.mouse.click=false;
            State.SetState(Shortcut.game.menu);
        }
    }

    @Override
    public void Draw() {
        Shortcut.g.clearRect(0,0, Shortcut.game.getWnd().GetWndWidth(), Shortcut.game.getWnd().GetWndHeight());
        Shortcut.g.drawImage(scor,0,0,960,720,null) ;
        Shortcut.g.setColor(Color.PINK);
        Shortcut.g.setFont(new Font("Georgia", 2, 50));
        Shortcut.g.drawString("Your last score is " + (Shortcut.game.Coins*2+ Shortcut.game.Goblets*10+Shortcut.game.Diamonds*4+Shortcut.game.Crown*100), 260, 450);

        Shortcut.game.getBs().show();
        Shortcut.g.dispose();
    }
}
