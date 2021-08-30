package controlador;

import conexion.Conexion;
import dao.PersonaDao;
import java.util.List;
import modelo.Persona;

public class PersonaController {

    public static void main(String[] args) {
        Conexion c = new Conexion();
        PersonaDao userd = new PersonaDao(c);

       Persona user = new Persona(0);
        List<Persona> all = userd.mostrarTodo();

        for (Persona u : userd.mostrarTodo()) {
            System.out.println(" ID " + u.getId());
            System.out.println(" Nombre " + u.getNombre());
            System.out.println(" Apellido " + u.getApellido());
            System.out.println(" Edad " + u.getEdad());
        }

  }
    
}