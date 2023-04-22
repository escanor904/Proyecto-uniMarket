package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


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
            throw new RuntimeException(e);
        }
    }


}
