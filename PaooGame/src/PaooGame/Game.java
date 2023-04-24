package PaooGame;

import PaooGame.GameWindow.CameraWindow;
import PaooGame.GameWindow.GameWindow;
import PaooGame.Graphics.Assets;
import PaooGame.Input.MouseInput;
import PaooGame.Items.JackClass;
import PaooGame.Map.Map;
import PaooGame.States.*;

import PaooGame.States.Menu;
import PaooGame.Input.KeyInput;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.sql.SQLException;

public class Game implements Runnable {


    private GameWindow wnd;
    private boolean runState;
    private Thread gameThread;
    private BufferStrategy bs;
    public static DataBase database;
    public static int w,h;
    public static int Coins=0;
    public static int Diamonds=0;
    public static int Goblets=0;
    public static int Crown=0;
    public int Tip=1;


    public static JackClass jack;
    //Input
    public KeyInput keyInput;
    public MouseInput mouse;
    //Camera
    public CameraWindow gameCamera;
    Graphics g;

    public State start;
    public State menu;
    public State info;
    public static State Level1;
    public State Level2;
    public State score;
    public State win;
    public State gameOver;
    public State pause;
    public State quit;
    public State Final;

    public Map map;
    public Game(String title, int width, int height)
    {
        wnd=new GameWindow(title, width, height);
        runState=false;
        this.w=width;
        this.h=height;
        Shortcut.game=this;
        database=new DataBase();

    }

    private void InitGame()
    {
        wnd=new GameWindow("Legenda Comorii Ascunse",960, 720);
        wnd.BuildGameWindow();
        keyInput = new KeyInput();
        mouse=new MouseInput();
        Assets.Init();
        wnd.GetWndFrame().addKeyListener(keyInput);
        wnd.GetCanvas().addKeyListener(keyInput);
        wnd.GetWndFrame().addMouseListener(mouse);
        wnd.GetWndFrame().addMouseMotionListener(mouse);
        wnd.GetCanvas().addMouseListener(mouse);
        wnd.GetCanvas().addMouseMotionListener(mouse);

        gameCamera=new CameraWindow(0,0);

        start=new StartState(this);
        menu=new Menu(this);
        info=new Info(this);
        map=new Map(1);
        Level1=new level1(this);
        Level2=new level2(this);
        win=new Win(this);
        score=new Score(this);
        gameOver=new GameOver(this);
        pause=new Pause(this);
        quit=new Quit();
        Final=new Final(this);
        State.SetState(start);
    }

    public void run()
    {
        InitGame();
        long oldTime=System.nanoTime();
        long curentTime;
        final int framesPerSecond=60;
        final double timeFrame= 1000000000 / framesPerSecond;
        while (runState == true)
        {
            curentTime=System.nanoTime();
            if((curentTime-oldTime)>timeFrame)
            {
                try {
                    Update();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Draw();
                oldTime=curentTime;
            }
        }
    }

    public synchronized void StartGame()
    {
        if(runState==false) {
            runState = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
        else
        {
            return;
        }
    }
    
    public synchronized void StopGame()
    {
        if(runState == true)
        {
            runState = false;
            try {
                gameThread.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        else
        {
            return;
        }
    }

    private void Update() throws SQLException {
        State.GetState().Update();
    }

    private void Draw() {



        bs = wnd.GetCanvas().getBufferStrategy();
        if (bs == null) {
            try {
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        g = bs.getDrawGraphics();
        g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());
        Shortcut.g=g;

        //g.drawRect(1*Tile.TILE_WIDTH,1*Tile.TILE_HEIGHT,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
        State.GetState().Draw();


       bs.show();
       g.dispose();
    }

    public GameWindow getWnd() {
        return wnd;
    }
    public Graphics getG(){
        return g;
    }
    public BufferStrategy getBs() {
        return bs;
    }
    public void setBs(BufferStrategy x) {
        bs = x;
    }
    public CameraWindow getGameCamera(){return gameCamera;}

}
