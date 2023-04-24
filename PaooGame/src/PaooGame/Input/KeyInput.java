package PaooGame.Input;

import PaooGame.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{
    public boolean space;
    public static boolean right,left,up,escape;
    public boolean[] key;

    public KeyInput()
    {
        key=new boolean[256];
    }

    public void Update()
    {
        space=key[KeyEvent.VK_SPACE];
        right=key[KeyEvent.VK_D];
        left=key[KeyEvent.VK_A];
        up=key[KeyEvent.VK_W];
        escape=key[KeyEvent.VK_ESCAPE];
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key[e.getKeyCode()]=true;
        Update();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key[e.getKeyCode()]=false;
        Update();
    }
}
