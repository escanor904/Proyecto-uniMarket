package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//se define la clase que se va a probar
//este sirve para que las pruebas que ajecutemos aqui no afecten a la base de datos real
@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class UsuarioServicioTest {
    //inicializa el usuarioServicio
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void registrarusuario(){
     Usuario u = new Usuario("904","1023452133","cll28#14-09","mario@gmail.com","mario","3216758976","Heropro.12","unimario");
        try {
            Usuario registrado = usuarioServicio.registrarUsuario(u);
            Assertions.assertNotNull(registrado);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void actualizarUsuario(){
        Usuario u = new Usuario("904","1023452133","cll28#14-09","mario@gmail.com","mario","3216758976","Heropro.12","unimario");
        try {
            Usuario registrado = usuarioServicio.actualizarUsuario(u);
            Assertions.assertNotNull(registrado);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void eliminarUsuario(){
        Usuario u = new Usuario("904","1023452133","cll28#14-09","mario@gmail.com","mario","3216758976","Heropro.12","unimario");
        try {
            //usuarioServicio.registrarUsuario(u);
            usuarioServicio.eliminarUsuario("904");
        } catch (Exception e) {
            //throw new RuntimeException(e);
            //sirve para que no salga la excepcion y simplemente la prueba se muestre como no aprobada
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void listarUsuarios(){
        Usuario u = new Usuario("904","1023452133","cll28#14-09","mario@gmail.com","mario","3216758976","Heropro.12","unimario");
        try {
            usuarioServicio.registrarUsuario(u);
            List<Usuario> usuarios =usuarioServicio.listarUsuarios();
            usuarios.forEach(us -> System.out.println(us));
        } catch (Exception e) {
            //throw new RuntimeException(e);
            //sirve para que no salga la excepcion y simplemente la prueba se muestre como no aprobada
            Assertions.assertTrue(false);
        }
    }




}
