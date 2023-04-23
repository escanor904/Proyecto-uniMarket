package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;

import java.util.List;

public interface ProductoServicio {

    Producto publicarProducto(Producto p) throws Exception;
    List<Producto> listarProductosPorCategoria(Categoria categoria);

    void comentarProducto(String mensaje,Usuario usuario,Producto producto) throws Exception;
    void eliminarProductofavorito(Producto producto,Usuario usuario);
    void comprarProductos(DetalleCompra detalleCompra,Producto producto);


}
