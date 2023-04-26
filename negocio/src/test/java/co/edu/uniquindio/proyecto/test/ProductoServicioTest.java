package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;


@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ProductoServicioTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void obtenerProductoTest(){

        try {
            Usuario vendedor = usuarioServicio.obtenerUsuario("909");
            LocalDate ldn = LocalDate.now();
            LocalDate ld = LocalDate.of(2020,1,8);
            Producto producto = new Producto("2",null,"televisor smart tv",400000,ldn,ld,null);
            Producto publicado =productoServicio.publicarProducto(producto);

           Assertions.assertNotNull(publicado);
        } catch (Exception e) {
           // throw new RuntimeException(e);
            Assertions.assertTrue(false, e.getMessage());
        }


    }

    @Test
    public void publicarProducto(){


        try {
            LocalDate ldn = LocalDate.now();
            LocalDate ld = LocalDate.of(2020,1,8);
            Producto producto = new Producto("2",null,"televisor smart tv",400000,ldn,ld,20);
            System.out.println(producto);
            Producto salida =productoServicio.publicarProducto(producto);
            Assertions.assertNotNull(salida);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
