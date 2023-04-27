package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,String> {

//se definen todas las consultas para acceder a los datos

//-----------------------------------Consultas propias-------------------------------------
    //se pueden contruir consultas propias mediante el lenguaje JPQL como la siguiente
    @Query("select u from Usuario u where u.nombre = :nombre")
    List<Usuario> obtenerUsuariosPorNombre(String nombre);

    @Query("select u.misProductos from Usuario u where u.codigo = :codigo")
    List<Producto> obtenerProductosUsuarioPorCodigo(String codigo);


    //seleccionar productos p de un usuario u combina las filas de para poder ver los productos
    @Query("select p from Usuario  u join u.misProductos p where u.codigo = :codigo")
    List<Producto> obtenerProductosUsuarioPorCodigoj(String codigo);

    @Query("select c from Usuario u join u.misComentarios c where u.codigo =:codigo")
    List<Comentario> obtenerComentarioDeUsuarioPorCodigo(String codigo);


    //usamos IN cuando queremos mezclar un objeto con una lista de cosas
    @Query("select p from Usuario  u, IN (u.productosFavoritos) p where u.email = :email")
    List<Producto> obtenerFavoritosPorCorreo(String email);

    @Query("select p from Usuario  u, IN (u.productosFavoritos) p where u.codigo = :codigo")
    List<Producto> obtenerFavoritosPorCodigo(String codigo);

    //se trae el email de el usuarios
    //la respuesta a esto va a ser una lista de objetos
    @Query("select u.email,p from Usuario u join u.misProductos p")
    List<Object[]> listarUsuariosYProductos();




    //---------------------------------Consultas inferidas por SpringBoot----------------------------------------


    //con inferencia de datos gracias a el framework de spring que es JPArepository
    List<Usuario>findAllByNombreContains(String nombre);
    List<Usuario>findAllByTelefono(String telefono);

    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmailAndCodigo(String email,String password);

    Optional<Usuario> findByUsernameAndPassword(String username,String password);


    Optional<Usuario> findByNombre(String nombre);

    Page<Usuario> findAllBy(Pageable paginador);


    @Query("select u from Usuario u where u.codigo = :codigo")
    Usuario obtenerUsuarioPorCodigo(String codigo);


}
