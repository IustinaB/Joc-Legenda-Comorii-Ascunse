package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Input.MouseInput;
import PaooGame.Map.Map;
import PaooGame.Shortcut;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Win extends State{
    private BufferedImage Win;

    public Win(Game game)
    {
        ImageLoader win=new ImageLoader();

        Win=win.LoadImage("/textures/Win.jpg");
    }
    @Override
    public void Update() {
        if((Shortcut.game.mouse.click==true && Shortcut.game.mouse.getX()<=945 && MouseInput.getX()>=804) && (Shortcut.game.mouse.getY()>=682 && Shortcut.game.mouse.getY()<=706))
        {
            Shortcut.game.mouse.click=false;
            State.SetState(Shortcut.game.Level2);
        }

        if (Shortcut.game.keyInput.escape == true) {
            State.SetState(Shortcut.game.menu);
        }

    }

    @Override
    public void Draw() {
        Shortcut.g.clearRect(0,0, Shortcut.game.getWnd().GetWndWidth(), Shortcut.game.getWnd().GetWndHeight());
        Shortcut.g.drawImage(Win,0,0,960,720,null) ;

        Shortcut.g.setColor(Color.PINK);
        Shortcut.g.setFont(new Font("Georgia", 2, 50));
        int coins = Shortcut.game.Coins;
        Shortcut.g.drawString("" + coins, 495, 328);

        int goblets=Shortcut.game.Goblets;
        Shortcut.g.drawString(""+goblets,495,440);

        int diamonds=Shortcut.game.Diamonds;
        Shortcut.g.drawString(""+diamonds, 495,550);

        Shortcut.g.drawString("Your final score is: " + (Shortcut.game.Coins*2+ Shortcut.game.Goblets*10+Shortcut.game.Diamonds*4+Shortcut.game.Crown*100), 380, 660);


        Shortcut.game.getBs().show();
        Shortcut.g.dispose();

    }
}
