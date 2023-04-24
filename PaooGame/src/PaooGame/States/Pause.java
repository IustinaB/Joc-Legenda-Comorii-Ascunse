package PaooGame.States;

import PaooGame.DataBaseException;
import PaooGame.Game;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Input.MouseInput;
import PaooGame.Shortcut;

import java.awt.image.BufferedImage;
import java.sql.SQLException;

public class Pause extends State{
    private BufferedImage pause;

    public Pause(Game game){                                                                    /*!<State ce contine butonul de Rsume in loc de Start si restul butoanelor din meniu.*/
        ImageLoader Pause=new ImageLoader();
        pause=Pause.LoadImage("/textures/meniu2.jpg");
    }
    @Override
    public void Update() {
        if((Shortcut.game.mouse.click==true && Shortcut.game.mouse.getX()<=542 && MouseInput.getX()>=418) && (Shortcut.game.mouse.getY()>=239 && Shortcut.game.mouse.getY()<=299))
        {
            Shortcut.game.mouse.click=false;
            level1.Jack.Reset();
            State.SetState(Shortcut.game.Level1);
        }
        if((Shortcut.game.mouse.click==true && Shortcut.game.mouse.getX()<=542 && MouseInput.getX()>=418) && (Shortcut.game.mouse.getY()>=329 && Shortcut.game.mouse.getY()<=390)) //buton infos
        {
            Shortcut.game.mouse.click=false;
            State.SetState(Shortcut.game.info);
        }
        else
        if ((Shortcut.game.mouse.click==true && Shortcut.game.mouse.getX()<=542 && MouseInput.getX()>=418) && (Shortcut.game.mouse.getY()>=602 && Shortcut.game.mouse.getY()<=662)) //buton quit
        {
            Shortcut.game.mouse.click=false;
            State.SetState(Shortcut.game.quit);
        }

        else
        if ((Shortcut.game.mouse.click==true && Shortcut.game.mouse.getX()<=542 && MouseInput.getX()>=418) && (Shortcut.game.mouse.getY()>=512 && Shortcut.game.mouse.getY()<=574)) //buton quit
        {
            Shortcut.game.mouse.click=false;
            try
            {
                if(level1.Jack==null)
                {
                    throw new DataBaseException();
                }
                else
                {
                    Game.database.UpdateSave(Shortcut.game.Coins,Shortcut.game.Goblets,Shortcut.game.Diamonds);
                }
            }
            catch (DataBaseException e)
            {
                System.out.println("DataBaseException.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(Shortcut.game.mouse.click==true && (Shortcut.game.mouse.getX()<=542 || MouseInput.getX()>=418) && (Shortcut.game.mouse.getY()>=419 || Shortcut.game.mouse.getY()<=481))
        {
            Shortcut.game.mouse.click=false;
            State.SetState(Shortcut.game.score);
        }
    }

    @Override
    public void Draw() {
        Shortcut.g.clearRect(0,0, Shortcut.game.getWnd().GetWndWidth(), Shortcut.game.getWnd().GetWndHeight());
        Shortcut.g.drawImage(pause,0,0,960,720,null);

        Shortcut.game.getBs().show();
        Shortcut.g.dispose();

    }
}
