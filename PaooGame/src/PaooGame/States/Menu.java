package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Input.MouseInput;
import PaooGame.Shortcut;
import PaooGame.Tiles.*;

import java.awt.image.BufferedImage;
import java.sql.SQLException;

import PaooGame.DataBaseException;
public class Menu extends State{
    private BufferedImage menu,info;

    public Menu(Game game){                                                               /*!<State-ul ce contine meniul, butoanele aferente*/
        super();
        ImageLoader initial=new  ImageLoader();
        menu=initial.LoadImage("/textures/meniu.jpg");

    }

    @Override
    public void Update() throws SQLException {

        if((Shortcut.game.mouse.click==true && Shortcut.game.mouse.getX()<=542 && MouseInput.getX()>=418) && (Shortcut.game.mouse.getY()>=239 && Shortcut.game.mouse.getY()<=299)) //buton start
        {

            Shortcut.game.mouse.click=false;
            State.SetState(Shortcut.game.Level1);
        }
        else
        if((Shortcut.game.mouse.click==true && Shortcut.game.mouse.getX()<=542 && MouseInput.getX()>=418) && (Shortcut.game.mouse.getY()>=329 && Shortcut.game.mouse.getY()<=380)) //buton infos
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
        if ((Shortcut.game.mouse.click==true && Shortcut.game.mouse.getX()<=542 && MouseInput.getX()>=418) && (Shortcut.game.mouse.getY()>=512 && Shortcut.game.mouse.getY()<=574)) //buton load
        {
            Shortcut.game.mouse.click=false;
            try
            {
                if(Shortcut.game.Coins==0&&Shortcut.game.Goblets==0&&Shortcut.game.Diamonds==0)
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
        else
        if(Shortcut.game.mouse.click==true && (Shortcut.game.mouse.getX()<=542 || MouseInput.getX()>=418) && (Shortcut.game.mouse.getY()>=419 || Shortcut.game.mouse.getY()<=481))//buton scor
        {
            Shortcut.game.mouse.click=false;
            State.SetState(Shortcut.game.score);

        }


    }

    @Override
    public void Draw() {
        Shortcut.g.clearRect(0,0, Shortcut.game.getWnd().GetWndWidth(), Shortcut.game.getWnd().GetWndHeight());

        Shortcut.g.drawImage(menu,0,0,960,720,null) ;


        Shortcut.game.getBs().show();
        Shortcut.g.dispose();

    }

}