package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.usuarios;

public class UsuariosDao {

    Conexion conn;

    public UsuariosDao(Conexion c) {
        this.conn = c;
    }

    public boolean insertarUsuario(usuarios u) {

        String sql = "insert into usuarios values (?,?,?,?)";

        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, u.getId());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getTipoUsuario());
            ps.setString(4, u.getContrasena());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public List<usuarios> mostrarTodo() {

        List<usuarios> usuarios = new LinkedList<>();
        usuarios user;

        String sql = "select * from usuarios";
        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user = new usuarios(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setTipoUsuario(rs.getString("tipoUsuario"));
                user.setContrasena(rs.getString("contrasena"));
                usuarios.add(user);
            }
            System.out.println("Se realizo correctamente");

            return usuarios;
        } catch (Exception e) {
            System.err.println(" Excepcion " + e);
            return null;
        }
    }

}
