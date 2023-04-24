package PaooGame.States;
import PaooGame.Game;

import java.sql.SQLException;

public abstract class State {
    private static State currentState = null;                                     /*!< retin starea curenta*/
    public static void SetState(State s) {
        currentState = s;
    }

    public static State GetState() {
        return currentState;
    }

    protected Game game;
    public State()
    {
        this.game=game;
    }

    //voi actuaiza pentru fisecare stare in parte
    public abstract void Update() throws SQLException;

    //voi desena pentru fisecare stare in parte
    public abstract void Draw();
}
