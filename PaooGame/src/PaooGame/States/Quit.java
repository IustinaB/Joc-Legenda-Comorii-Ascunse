package PaooGame.States;

import java.util.concurrent.TimeUnit;

public class Quit extends State{

    public Quit(){
        super();
    }
    @Override
    public void Update() {                             /*!<State ce contine inchiderea ferestrei.*/
       try{
           TimeUnit.SECONDS.sleep(1);
       } catch(InterruptedException e)
       {
           System.out.println(e.getMessage());
       }
        System.exit(0);
    }

    @Override
    public void Draw() {

    }
}
