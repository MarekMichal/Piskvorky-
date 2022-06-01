/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marek
 */

    import java.sql.*;

public class Database {

    //pripojenie na databazu
    public static Connection connect(){
        Connection connection = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:DB.db");
            System.out.println("Connection success!");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }

    //funkcia na pridanie uzivate do DB resp registracia
    public static void register(Connection DB, String email, String password, String nick, int money, int vyhry, int prehry, int remizy){
        PreparedStatement ps = null;
        try{
            String sql = "INSERT INTO user(email, password, nick, money, vyhry, prehry, remizy) VALUES(?,?,?,?,?,?,?)";
            ps = DB.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, nick);
            ps.setInt(4, money);
            ps.setInt(5, vyhry);
            ps.setInt(6, prehry);
            ps.setInt(7, remizy);
            ps.executeUpdate();
            System.out.println("Data Inserted");
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
    }

    public static void updateUser(Connection DB, int money, int vyhry, int prehry, int remizy, String email){
        PreparedStatement ps = null;

        try{
            String sql = "UPDATE user SET money = ?, vyhry = ?, prehry = ?, remizy = ? WHERE email = ?";
            ps = DB.prepareStatement(sql);
            ps.setInt(1, money);
            ps.setInt(2, vyhry);
            ps.setInt(3, prehry);
            ps.setInt(4, remizy);
            ps.setString(5, email);
            ps.execute();
            System.out.println("User Updated");
        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    public static String getPassword(Connection DB, String email){
        PreparedStatement ps = null;
        ResultSet result = null;

        try{
            String sql = "SELECT password FROM user WHERE email = ?";
            ps = DB.prepareStatement(sql);
            ps.setString(1, email);
            result = ps.executeQuery();

            return result.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e.toString());
        }
    }

    //ziskat informacie o penazoch podla emailu
   

    public static int getVyhry(Connection DB, String email){
        PreparedStatement ps = null;
        ResultSet result = null;

        try{
            String sql = "SELECT vyhry FROM user WHERE email = ?";
            ps = DB.prepareStatement(sql);
            ps.setString(1, email);
            result = ps.executeQuery();
            return result.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e.toString());
        }
    }

    public static int getPrehry(Connection DB, String email){
        PreparedStatement ps = null;
        ResultSet result = null;

        try{
            String sql = "SELECT prehry FROM user WHERE email = ?";
            ps = DB.prepareStatement(sql);
            ps.setString(1, email);
            result = ps.executeQuery();

            return result.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e.toString());
        }
    }

    public static int getRemizy(Connection DB, String email){
        PreparedStatement ps = null;
        ResultSet result = null;

        try{
            String sql = "SELECT remizy FROM user WHERE email = ?";
            ps = DB.prepareStatement(sql);
            ps.setString(1, email);
            result = ps.executeQuery();

            return result.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e.toString());
        }
    }
    public static String getMeno(Connection DB, String email){
        PreparedStatement ps = null;
        ResultSet result = null;

        try{
            String sql = "SELECT nick FROM user WHERE email = ?";
            ps = DB.prepareStatement(sql);
            ps.setString(1, email);
            result = ps.executeQuery();

            return result.getString(1);

        } catch (SQLException e) {
            throw new RuntimeException(e.toString());
        }
    }
public static int getMoney(Connection DB, String email){
        PreparedStatement ps = null;
        ResultSet result = null;

        try{
            String sql = "SELECT money FROM user WHERE email = ?";
            ps = DB.prepareStatement(sql);
            ps.setString(1, email);
            result = ps.executeQuery();

            return result.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e.toString());
        }
    }

}

