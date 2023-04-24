package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Input.MouseInput;
import PaooGame.Shortcut;

import java.awt.image.BufferedImage;

public class GameOver extends State{
    private BufferedImage dead;
    public GameOver(Game game){
        super();
        ImageLoader d=new ImageLoader();
        dead=d.LoadImage("/textures/gameover.jpg");

    }
    @Override
    public void Update() {
        Game.Level1=new level1(Shortcut.game);
        level1.Jack.x=48*5;
        level1.Jack.y=48*10;
        if((Shortcut.game.mouse.click==true && Shortcut.game.mouse.getX()<=929 && MouseInput.getX()>=864) && (Shortcut.game.mouse.getY()>=669 && Shortcut.game.mouse.getY()<=693))
        {
            Shortcut.game.mouse.click=false;
            State.SetState(Shortcut.game.menu);
        }
    }

    @Override
    public void Draw() {
        Shortcut.g.clearRect(0,0, Shortcut.game.getWnd().GetWndWidth(), Shortcut.game.getWnd().GetWndHeight());

        Shortcut.g.drawImage(dead,0,0,960,720,null) ;
        Shortcut.game.getBs().show();

        Shortcut.g.dispose();
    }
}
