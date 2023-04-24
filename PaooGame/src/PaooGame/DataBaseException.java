package PaooGame;

public class DataBaseException extends Exception{
    /*!
    Exceptie pentru momentul in care scorul este 0
     */
    public DataBaseException(){
        super("Inca nu s-au colectat obiecte pentru a fi adaugate in baza de date");
    }
}
