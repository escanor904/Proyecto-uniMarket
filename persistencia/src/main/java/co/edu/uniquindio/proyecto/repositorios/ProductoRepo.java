package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.DTO.ProductoValido;
import co.edu.uniquindio.proyecto.entidades.Imagen;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.SubCategoria;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,String>{

    @Query("select p.miUsuario.nombre from Producto p where p.codigo = :codigo")
    String obtenerNombreDelVendedor(String codigo);


    //left join nos muestra la relacion de el usuario y los comentario para saber que usuario tiene comentario o que ususario tiene los comentarios en null
    @Query("select p.nombre,c.mensaje from Producto p left join p.miComentario c")
    List<Object[]> listarUsuariosYProductos();


    //usuarios que han comentado un producto especifico
    //de un producto se trae la informacion del usuario pero del usuario necesita

    @Query("select p.miUsuario from Producto p  join p.miComentario c where p.codigo = :codigo ")
    List<Usuario> listarUsuariosQueComentaronProducto(String codigo);



    @Query("SELECT p.codigo, p.nombre, COUNT(c.mensaje) FROM Producto p LEFT JOIN p.miComentario c GROUP BY p.codigo, p.nombre ORDER BY COUNT(c.mensaje) DESC")
    List<Object[]> listarProductosConMasComentarios();

    //listarProductosValisdos
    //@Query("select new co.edu.uniquindio.proyecto.DTO.ProductoValido(p.nombre,p.descripcion,p.precio) from Producto p where p.fechaLimite < :fechaActual")
   // List<ProductoValido> listarProductosValidos(LocalDateTime fechaActual);





}
