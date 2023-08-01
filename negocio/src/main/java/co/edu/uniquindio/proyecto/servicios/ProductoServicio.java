package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.DTO.ProductoCarrito;
import co.edu.uniquindio.proyecto.entidades.*;

import java.util.ArrayList;
import java.util.List;

public interface ProductoServicio {


    Producto publicarProductoVender(Producto p,Usuario u) throws Exception;

    Producto registrarProducto(Producto p) throws Exception;
    void actualizarProducto(Producto p) throws Exception;

    void eliminarProducto(Integer codigo) throws Exception;

    Producto obtenerProducto(Integer codigo) throws Exception;
    List<Producto> listarProductosPorCategoria(Categoria categoria);

    void comentarProducto(Comentario comentario) throws Exception;

    void guardarProductoEnFavoritos(Producto producto,Usuario usuario) throws Exception;
    void eliminarProductofavorito(Producto producto,Usuario usuario)throws Exception;
    Compra comprarProductos(Usuario usuaario, ArrayList<ProductoCarrito> productos , MedioDePago medioDePago) throws Exception;

     List<Producto> buscarProductoPorNombre(String nombre, String [] producto);

     List<Producto> listarProductos(String codigoUsuario);

    List<Producto> listarProductos();





}
