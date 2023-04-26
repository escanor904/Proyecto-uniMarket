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
    public void registrarusuarioTest(){
     Usuario u = new Usuario("905","mario contreras","1023452133","mario@gmail.com","28#14-09","3216758976","unimario","Heropro.12");
        try {
            Usuario registrado = usuarioServicio.registrarUsuario(u);
            Assertions.assertNotNull(registrado);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void aactualizarUsuarioTest(){
        Usuario u =  new Usuario("909","mario contreras","1023452133","mario@gmail.com","28#14-09","3216758976","unimario","Heropro.12");
        try {
            Usuario registrado = usuarioServicio.actualizarUsuario(u);
            Assertions.assertNotNull(registrado);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void eliminarUsuarioTest(){
        Usuario u =  new Usuario("904","mario contreras","1023452133","mario@gmail.com","28#14-09","3216758976","unimario","Heropro.12");
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
    public void listarUsuariosTest(){
        Usuario u = new Usuario("904","mario contreras","1023452133","mario@gmail.com","28#14-09","3216758976",null,"Heropro.12");
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

    @Test
    public void actualizarUsuarioTest() throws Exception {
        // Crear un usuario existente en la base de datos
        Usuario u =  new Usuario("904","mario contreras","1023452133","mario@gmail.com","28#14-09","3216758976","unimario","Heropro.12");
        Usuario registrado = usuarioServicio.registrarUsuario(u);

        // Modificar los datos del usuario
        registrado.setNombre("Mario Modificado");
        registrado.setTelefono("9876543210");

        try {
            Usuario actualizado = usuarioServicio.actualizarUsuario(registrado); // Llamada al método de actualización de usuario
            Assertions.assertNotNull(actualizado);
            Assertions.assertEquals("Mario Modificado", actualizado.getNombre()); // Verificar que los datos se hayan actualizado correctamente
            Assertions.assertEquals("9876543210", actualizado.getTelefono());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Este metodo nos permite probar que el inicio de sesion este funcionando bien
     * @autor Escanor
     */
    @Test
    public void inicioSesionTest(){
        Usuario u = new Usuario("904","mario contreras","1023452133","mario@gmail.com","28#14-09","3216758976","unimario","Heropro.12");
        try {
            usuarioServicio.registrarUsuario(u);
            usuarioServicio.iniciarSesion("unimario","Heropro.12");


        } catch (Exception e) {
            //throw new RuntimeException(e);
            //sirve para que no salga la excepcion y simplemente la prueba se muestre como no aprobada
            Assertions.assertTrue(false, e.getMessage());
        }
    }

    @Test
    public void obtenerUsuarioTest(){
        try {
            Usuario u = usuarioServicio.obtenerUsuario("909");
            Assertions.assertNotNull(u);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            Assertions.assertTrue(false);
        }
    }








}
