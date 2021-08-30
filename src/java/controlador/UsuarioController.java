package controlador;

import conexion.Conexion;
import dao.UsuariosDao;
import java.util.List;
import java.util.Scanner;
import modelo.usuarios;

public class UsuarioController {

    public static void main(String[] args) {
        Conexion c = new Conexion();
        UsuariosDao userd = new UsuariosDao(c);
        Scanner sc = new Scanner(System.in);
        usuarios user = new usuarios(0);

        System.out.println("Ingrese el nombre");
        user.setNombre(sc.nextLine());
        
        System.out.println("Ingresar Tipo de Usuario");
        user.setTipoUsuario(sc.nextLine());
        
        System.out.println("Ingresar conntrasenia");
        user.setContrasena(sc.nextLine());
        

        boolean resultado = userd.insertarUsuario(user);

        if (resultado)
            System.out.println("Se ingreso correctamente");
        else
            System.out.println("problemas al ingresar");
        
        //usuarios user = new usuarios(0);
        List<usuarios> all = userd.mostrarTodo();

        for (usuarios u : all) {
            System.out.println(" ID " + u.getId());
            System.out.println(" Nombre " + u.getNombre());
            System.out.println(" TipoUsuario" + u.getTipoUsuario());
            System.out.println(" Contrasena " + u.getContrasena());
        }

    }

}
