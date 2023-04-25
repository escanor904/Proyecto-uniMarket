package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubCategoriaRepo extends JpaRepository<SubCategoria,Long>{

    // ---------------------------------Consultas propias-------------------------------------
    //se pueden contruir consultas propias mediante el lenguaje JPQL como la siguiente

    @Query("SELECT s FROM SubCategoria s INNER JOIN s.miCategoria c WHERE c.codigo = :codigo")
    List<SubCategoria> obtenerSubCategoriaPorCodigo(@Param("codigo") String codigoCategoria);

    @Query("SELECT s FROM SubCategoria s INNER JOIN s.miCategoria c WHERE c.nombre = :nombre")
    List<SubCategoria> obtenerSubCategoriaPornombre(@Param("nombre") String codigoCategoria);

    // Obtener subcategorías ordenadas por nombre ascendente
    @Query("SELECT s FROM SubCategoria s INNER JOIN s.miCategoria c ORDER BY s.nombre ASC")
    List<SubCategoria> obtenerSubCategoriasOrdenadasPorNombreAsc();

}
