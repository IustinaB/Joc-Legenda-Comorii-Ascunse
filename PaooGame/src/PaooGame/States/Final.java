package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Input.MouseInput;
import PaooGame.Map.Map;
import PaooGame.Shortcut;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

import static PaooGame.Graphics.ImageLoader.LoadImage;

public class Final extends State{
    private BufferedImage Final;
    public Final(Game game)
    {
        ImageLoader fin=new ImageLoader();

        Final=fin.LoadImage("/textures/Final.jpg");
    }
    @Override
    public void Update() throws SQLException {
        if ((Shortcut.game.mouse.click == true && Shortcut.game.mouse.getX() <= 930 && MouseInput.getX() >= 845) && (Shortcut.game.mouse.getY() >= 645 && Shortcut.game.mouse.getY() <= 706)) {

            Shortcut.game.mouse.click = false;
            State.SetState(Shortcut.game.menu);
        } else if ((Shortcut.game.mouse.click == true && Shortcut.game.mouse.getX() <= 128 && MouseInput.getX() >= 42) && (Shortcut.game.mouse.getY() >= 645 && Shortcut.game.mouse.getY() <= 706)) {
            Shortcut.game.mouse.click = false;
            State.SetState(Shortcut.game.quit);
        }
    }


    @Override
    public void Draw() {
        System.out.println(MouseInput.getX()+ "  "+ MouseInput.getY());
        Shortcut.g.clearRect(0,0, Shortcut.game.getWnd().GetWndWidth(), Shortcut.game.getWnd().GetWndHeight());
        Shortcut.g.drawImage(Final,0,0,960,720,null) ;

        Shortcut.g.setColor(Color.PINK);
        Shortcut.g.setFont(new Font("Georgia", 2, 40));
        Shortcut.g.drawString("You've finished the game!" , 260, 400);
        Shortcut.g.drawString("Do you want to play it again?" , 220, 460);

    }
}
