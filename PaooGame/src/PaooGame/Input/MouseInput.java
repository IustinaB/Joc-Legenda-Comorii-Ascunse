package PaooGame.Input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MouseInput extends MouseAdapter{
    private static int x,y;
    public boolean click;

    @Override
    public void mousePressed(MouseEvent e){
        if(e.getButton()== MouseEvent.BUTTON1)
            click=true;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            click = false;
    }
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
    public static int getX() {
        return  x;
    }
    public static int getY() {
        return  y;
    }
}
