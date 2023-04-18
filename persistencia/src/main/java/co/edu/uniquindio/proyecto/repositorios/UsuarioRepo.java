package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,String> {

//se definen todas las consultas para acceder a los datos


    //se pueden contruir consultas propias mediante el lenguaje JPQL como la siguiente
    @Query("select u from Usuario u where u.nombre = :nombre")
    List<Usuario> obtenerUsuariosPorNombre(String nombre);

    @Query("select u.misProductos from Usuario u where u.codigo = :codigo")
    List<Producto> obtenerProductosUsuarioPorCodigo(String codigo);


    //con inferencia de datos gracias a el framework de spring que es JPArepository
    List<Usuario>findAllByNombreContains(String nombre);
    List<Usuario>findAllByTelefono(String telefono);
    Optional<Usuario> findByEmailAndCodigo(String email,String password);

    Page<Usuario> findAllBy(Pageable paginador);





}
