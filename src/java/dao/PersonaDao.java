package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Persona;

public class PersonaDao {
    
    Conexion conn;
    
    public PersonaDao (Conexion c){
        this.conn = c;
    }
    
    public boolean insertarPersona(Persona p){
        
        
        String sql = "insert into personas values (?,?,?,?)";
        
        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            ps.setInt(4, p.getEdad());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        
    }
    
        public List<Persona> mostrarTodo (){
        
        List<Persona> personas = new LinkedList<>();
        Persona user;
        
        String sql = "select * from personas";
        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                user = new Persona(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setEdad(rs.getInt("edad"));
                personas.add(user);
            }
            
            return  personas;
        }catch(Exception e ){
            System.err.println(" Excepcion " + e );
            return null;
        }
    }
    
    
    
}
