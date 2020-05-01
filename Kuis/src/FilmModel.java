
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class FilmModel {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/database_film";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public FilmModel()
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    
    public void insertFilm(String judul, String tipe, String episode, String genre, String status, String rating)
    {
        try
        {
            String query = "INSERT INTO `tabel_film` (`judul`,`tipe`,`episode`, `genre`, `status`, `rating`)"
                    + "VALUES ('"+judul+"', '"+tipe+"', '"+episode+"','"+genre+"','"+status+"','"+rating+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Added");
            JOptionPane.showMessageDialog(null, "Data Added");
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateFilm(String id, String judul, String tipe, String episode, String genre, String status, String rating)
    {
        try
        {
            String query ="UPDATE tabel_film SET judul='" + judul + "', tipe='" + tipe + 
                    "', episode='" + episode + "', genre='" + genre + "', status='" + status + "', rating='" + rating +
                    "' WHERE id = '"+ id + "'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data berhasil di update");
        }   catch(Exception sql){
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }           
    }
    
    public int getBanyakDataFilm()
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "Select * from `tabel_film`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
        
    public String[][] readFilm()
    {
        try
        {
            int jmlData = 0;
            String data[][] = new String[getBanyakDataFilm()][8];
            String query = "SELECT * FROM `tabel_film`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                int nomer = jmlData+1;
                int id = resultSet.getInt("id");
                data[jmlData][0] = Integer.toString(nomer);
                data[jmlData][1] = Integer.toString(id);
                data[jmlData][2] = resultSet.getString("judul");
                data[jmlData][3] = resultSet.getString("tipe");
                data[jmlData][4] = resultSet.getString("episode");
                data[jmlData][5] = resultSet.getString("genre");
                data[jmlData][6] = resultSet.getString("status");
                data[jmlData][7] = resultSet.getString("rating");
                jmlData++;
                
            }
            return data;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void deleteFilm(String id)
    {
        String idFilm = id;
        int idterpilih = Integer.parseInt(idFilm);
        try{
            String query = "DELETE FROM `tabel_film` WHERE `id` = '"+idterpilih+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public String[][] searchFilm(String cari) {
        try{
            int jmlData = 0;
            String query = "SELECT * FROM `tabel_film` where judul like '%"+cari+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            String data[][] = new String[getBanyakDataFilm()][8];
            while(resultSet.next()) 
            {
                int id = resultSet.getInt("id");
                data[jmlData][1] = Integer.toString(id);
                data[jmlData][2] = resultSet.getString("judul");
                data[jmlData][3] = resultSet.getString("tipe");
                data[jmlData][4] = resultSet.getString("episode");
                data[jmlData][5] = resultSet.getString("genre");
                data[jmlData][6] = resultSet.getString("status");
                data[jmlData][7] = resultSet.getString("rating");
                jmlData++;
            }
            return data;
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    
}

