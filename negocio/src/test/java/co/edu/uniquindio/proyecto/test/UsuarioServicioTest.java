package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class UsuarioServicioTest {


    //inicializa el usuarioServicio
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void registrarusuario(){
        Usuario u = new Usuario("904","mario","mario@gmail.com","7535432","cll28#14-09","Heropro.12","unimario");
        try {
            Usuario registrado = usuarioServicio.registrarUsuario(u);
            Assertions.assertNotNull(registrado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void actualizarUsuario() throws Exception {
        // Crear un usuario existente en la base de datos
        Usuario u = new Usuario("904","mario","mario@gmail.com","7535432","cll28#14-09","Heropro.12","unimario");
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
        Usuario u = new Usuario("904","mario","mario@gmail.com","7535432","cll28#14-09","unimario","Heropro.12");
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
        //registrarusuario();
        try {
            Usuario u = usuarioServicio.obtenerUsuario("904");
            Assertions.assertNotNull(u);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            Assertions.assertTrue(false);
        }
    }

}
