package PaooGame;
import java.sql.*;
/*<! Clasa utilizata pentru a inregistra in baza de date scorul.*/
public class DataBase {
    Connection c=null;
    Statement stmt=null;

    public DataBase(){
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
            // c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS DATABASE" +
                    "( COINS    INT , " +
                    "DIAMONDS   INT ," +
                    "GOBLETS  INT  )";
            stmt.executeUpdate(sql);
            //  stmt.close();
            //  c.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    public void UpdateSave(int c, int d, int g) throws SQLException {

        String sql = "INSERT INTO DATABASE (COINS,DIAMONDS,GOBLETS) " +
                "VALUES ("+c+","+d+","+g+");";
        stmt.executeUpdate(sql);
    }


}