package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.DTO.ProductoValido;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.Date;
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

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarProductosYComentarios(){


        List<Object[]> respuesta= productoRepo.listarUsuariosYProductos();

        for (Object[] objeto:respuesta){
            System.out.println(objeto[0]+"-----"+objeto[1]);
        }

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuariosQueHanComentadoUnProducto(){
        List<Usuario> respuesta= productoRepo.listarUsuariosQueComentaronProducto("1");
        respuesta.forEach(u -> System.out.println(u));
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarProductosValidos(){
        System.out.println(new Date()+"----"+"Date");
        System.out.println(LocalDateTime.now()+"----"+"LocalDateTime");

        //List<ProductoValido> respuesta= productoRepo.listarProductosValidos(LocalDateTime.now());
       // respuesta.forEach(u -> System.out.println(u));
    }


    @Test
    @Sql("classpath:usuarios.sql")
    public void listarProductosConMasComentarios() {
        List<Object[]> resultado = productoRepo.listarProductosConMasComentarios();
        for (Object[] row : resultado) {
            String productoId = (String) row[0];
            String nombreProducto = (String) row[1];
            Long cantidadComentarios = (Long) row[2];
            System.out.println("Producto con el codigo: " + productoId + " - Nombre: " + nombreProducto + " - Cantidad de Comentarios: " + cantidadComentarios);
        }
    }

}