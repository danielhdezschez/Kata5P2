/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata5.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import kata5.model.Mail;

/**
 *
 * @author yadai
 */
public class MailListReaderBD {

    public MailListReaderBD(String BaseName) {
        this.BaseName = BaseName;
        // this.conn = null;
    }
    
    private final String BaseName;
    private Connection conn;

    public String getBaseName() {
        return BaseName;
    }
    
    public void connect() {
        conn = null;
        try {
            String url = "jdbc:sqlite:" + BaseName;
            conn = DriverManager.getConnection(url);
            System.out.println("Connexión a SQLite establecida"); 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public void close() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexion cerrada");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Mail> read() {
        String sql = "SELECT * FROM EMAIL";
        List<Mail> emails = new ArrayList<Mail>();
        try (
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                emails.add(new Mail(rs.getString("Mail")));
            }  
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return emails;
    }
    
    
}
