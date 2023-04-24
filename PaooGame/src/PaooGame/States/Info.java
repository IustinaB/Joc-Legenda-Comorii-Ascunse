package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Input.MouseInput;
import PaooGame.Shortcut;

import java.awt.image.BufferedImage;

public class Info extends State{
    private BufferedImage info;
    public Info (Game game){

        ImageLoader infos=new ImageLoader();                                 /*!<State ce contine informatii despre deplasarea jucatorului*/

        info=infos.LoadImage("/textures/Infos.jpg");
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
        Shortcut.g.drawImage(info,0,0,960,720,null) ;
        Shortcut.game.getBs().show();
        Shortcut.g.dispose();
    }
}
