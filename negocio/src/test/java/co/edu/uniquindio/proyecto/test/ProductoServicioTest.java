package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.CategoriaServicio;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ProductoServicioTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private CategoriaServicio categoriaServicio;

    @Test
    public void obtenerProductoTest(){

        try {
            Usuario vendedor = usuarioServicio.obtenerUsuario("909");
            LocalDate ldn = LocalDate.now();
            LocalDate ld = LocalDate.of(2020,1,8);
            //Producto producto = new Producto("2",null,"televisor smart tv",400000,ldn,ld,null);
           // Producto publicado =productoServicio.publicarProducto(producto);

          // Assertions.assertNotNull(publicado);
        } catch (Exception e) {
           // throw new RuntimeException(e);
            Assertions.assertTrue(false, e.getMessage());
        }


    }

    @Test
    public void publicarProductoVentaTest(){
        Usuario  u = new Usuario("905","mario contreras","mario@gmail.com","3216758976","28#14-09","unimario","Heropro.12");


        LocalDate ldn = LocalDate.now();
        LocalDate ld = LocalDate.of(2020,1,8);
       // Producto producto = new Producto("2","televisor","televisor smart tv",400000,ldn,ld,20);

        try {
            usuarioServicio.registrarUsuario(u);
            //Producto salida =productoServicio.publicarProductoVender(producto,u);

           // Assertions.assertNotNull(salida);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void registrarProducto(){

        LocalDateTime ld= LocalDateTime.of(2024,1,8,7, 7);
        Producto p = new Producto("televisor","televisor smart tv",400000, LocalDateTime.now(),ld,20);



        try {
           productoServicio.registrarProducto(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void registrarProductoConCate(){

        Categoria cat1= new Categoria(301,"VEHICULOS");
        Categoria cat2= new Categoria(302,"CELULARES");
        Categoria cat3= new Categoria(303,"JOYAS");
        Categoria cat4= new Categoria(304,"COMPUTADORES");
        LocalDateTime ld= LocalDateTime.of(2024,1,8,7, 7);
        Producto p = new Producto("televisor","televisor smart tv",400000, LocalDateTime.now(),ld,20);

        try {

           categoriaServicio.registrarCategoria(cat1);
           categoriaServicio.registrarCategoria(cat2);
           categoriaServicio.registrarCategoria(cat3);
           categoriaServicio.registrarCategoria(cat4);

            //Categoria categoria1=categoriaServicio.obtenerCategoria("301");
            //Categoria categoria2=categoriaServicio.obtenerCategoria("302");
            //List<Categoria> categorias = new ArrayList<>();
           // categorias.add(categoria1);
            //categorias.add(categoria2);
            p.getMisCategorias().add(cat1);
            p.getMisCategorias().add(cat2);
            cat1.getMisProductos().add(p);
            cat2.getMisProductos().add(p);
            productoServicio.registrarProducto(p);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    @Test
    public void comentarProductoTest(){

        Usuario  u = new Usuario("905","juan alonso","jalonso@gmail.com","3216758976","28#14-09","unialonso","Heropro.12");

        LocalDate ldn = LocalDate.now();
        LocalDate ld = LocalDate.of(2024,1,8);
        //Producto producto = new Producto("2","televisor","televisor smart tv",400000,ldn,ld,20);



        try {
            usuarioServicio.registrarUsuario(u);
           // productoServicio.registrarProducto(producto);
           // productoServicio.comentarProducto("precio minimo",u , producto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }



    @Test
    public void guardarProductoEnFavoritosTest(){

        Usuario  u = new Usuario("904","mario contreras","mario@gmail.com","3216758976","28#14-09","unimario","Heropro.12");



        LocalDateTime ld= LocalDateTime.of(2024,1,8,7, 7);
        Producto p = new Producto("televisor","televisor smart tv",400000, LocalDateTime.now(),ld,20);



        try {
            usuarioServicio.registrarUsuario(u);
            productoServicio.registrarProducto(p);

            productoServicio.guardarProductoEnFavoritos(p,u);
            //productoServicio.eliminarProductofavorito(p,u);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void buscarProductosPorNombreTest(){

        List<Producto> productos = productoServicio.buscarProductoPorNombre("lenovo",null);
        productos.forEach(p -> System.out.println(p));
    }



}
