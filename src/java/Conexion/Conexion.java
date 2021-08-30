package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    static String db = "registro";
    static String user = "root";
    static String pass = "admin";
    static String url = "jdbc:mysql://localhost:3306/"+db;
    
    Connection conn = null;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            
            if(conn != null){
                System.out.println("Conectado Correctamente");
            }
            
        }catch(Exception e){
            System.err.println(" ERROR conectandose " + e);
        }
    }
    
    
    public Connection Conectar (){
        return conn;
    }
    
    public void Desconectar () throws Exception{
        conn.close();
    }
    
    
    public static void main(String[] args) {
        Conexion c = new Conexion();
        
        c.Conectar();
        try{
            c.Desconectar();
        }catch(Exception e ){
            System.err.println("ERROR CONECTANDOSE " + e);
        }
        
    }
    
}