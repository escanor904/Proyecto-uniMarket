package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Categoria;

import java.util.List;

public interface CategoriaServicio {

    Categoria registrarCategoria(Categoria categoria) throws Exception;
    void eliminarCategoria(Categoria categoria)throws Exception;
    Categoria actualizarcategoria(Categoria categoria)throws Exception;

    Categoria obtenerCategoria(Integer codigo) throws Exception;

    List<Categoria> listarCategorias() ;


}
