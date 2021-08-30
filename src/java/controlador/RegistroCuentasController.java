package controlador;

import conexion.Conexion;
import dao.RegistroCuentasDao;
import java.util.List;
import modelo.RegistrocCuentas;

public class RegistroCuentasController {

    public static void main(String[] args) {
        Conexion c = new Conexion();
        RegistroCuentasDao userd = new RegistroCuentasDao(c);
        RegistrocCuentas user = new RegistrocCuentas(0);

        List<RegistrocCuentas> all = userd.mostrarTodo();

        for (RegistrocCuentas u : userd.mostrarTodo()) {
            System.out.println(" ID " + u.getId());
            System.out.println(" Nombre " + u.getNombre());
            System.out.println(" Apellido " + u.getApellido());
            System.out.println(" FechaDeCreacion" + u.getFechaDeCreacion());

        }

    }
}