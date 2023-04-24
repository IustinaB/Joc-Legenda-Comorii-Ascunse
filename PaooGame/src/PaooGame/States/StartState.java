package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Input.MouseInput;
import PaooGame.Shortcut;

import java.awt.image.BufferedImage;

public class StartState extends State{                                     /*<State-ul de inceput ce contine numele jocului si un buton pentru continuare*/
    private final BufferedImage start;
    public StartState(Game game) {
        super();
        ImageLoader image = new ImageLoader();
        start=image.LoadImage("/textures/Start.jpg");
    }
    @Override
    public void Update() {
    }

    @Override
    public void Draw() {
        Shortcut.g.clearRect(0,0,Shortcut.game.getWnd().GetWndWidth(),Shortcut.game.getWnd().GetWndHeight());
        Shortcut.g.drawImage(start,0,0,960,720,null) ;

        if(Shortcut.game.mouse.click==true && (Shortcut.game.mouse.getX()<=536 && MouseInput.getX()>=419) && (Shortcut.game.mouse.getY()>=594 && Shortcut.game.mouse.getY()<=615))
        {
            Shortcut.game.mouse.click=false;
            State.SetState(Shortcut.game.menu);
        }
    }
}
