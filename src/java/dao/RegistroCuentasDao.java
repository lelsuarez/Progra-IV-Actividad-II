package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.RegistrocCuentas;

public class RegistroCuentasDao {
    
    Conexion conn;
    
    public RegistroCuentasDao (Conexion r){
        this.conn = r;
    }
    
    public boolean insertarRegistroCuentas(RegistrocCuentas r){
        
        
        String sql = "insert into personas values (?,?,?,?)";
        
        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, r.getId());
            ps.setString(2, r.getNombre());
            ps.setString(3, r.getApellido());
            ps.setInt(4, r.getEdad());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        
    }
    
     public List<RegistrocCuentas> mostrarTodo (){
        
        List<RegistrocCuentas> personas = new LinkedList<>();
        RegistrocCuentas user;
        
        String sql = "select * from registoCuentas";
        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                user = new RegistrocCuentas(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setEdad(rs.getInt("edad"));
                user.setFechaDeCreacion(rs.getDate(sql));
                personas.add(user);
            }
            
            return  personas;
        }catch(Exception e ){
            System.err.println(" Excepcion " + e );
            return null;
        }
    }
    
    
    
    
    
}
