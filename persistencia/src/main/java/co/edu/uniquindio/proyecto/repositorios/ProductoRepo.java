package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.SubCategoria;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,String>{

    @Query("select p.miUsuario.nombre from Producto p where p.codigo = :codigo")
    String obtenerNombreDelVendedor(String codigo);




}
