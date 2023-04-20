package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class productoTest {
    @Autowired
    private ProductoRepo productoRepo;

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarProductos(){


        List<Producto> misProductos = productoRepo.findAll();
        System.out.println(misProductos);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void buscarNombreDeVendedorPorCodigo(){
        String nombre = productoRepo.obtenerNombreDelVendedor("1");
        System.out.println(nombre);
    }

}