package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Categoria;

public interface CategoriaServicio {

    Categoria registrarCategoria(Categoria categoria) throws Exception;
    void eliminarCategoria(Categoria categoria)throws Exception;
    Categoria actualizarcategoria(Categoria categoria)throws Exception;

    Categoria obtenerCategoria(String codigo) throws Exception;

}
