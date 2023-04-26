package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio{

    private final ProductoRepo productoRepo;

    public ProductoServicioImpl(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Override
    public Producto publicarProducto(Producto p) throws Exception {

        try {
            return productoRepo.save(p);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void actualizarProducto(Producto p) throws Exception {

    }

    @Override
    public void eliminarProducto(String codigo) throws Exception {
        Optional<Producto> producto = productoRepo.findById(codigo);

       if (producto.isEmpty()){
           throw new Exception("No existe ningun producto con ese codigo");
       }

       productoRepo.deleteById(codigo);
    }

    @Override
    public Producto obtenerProducto(String codigo) throws Exception {
        return productoRepo.findById(codigo).orElseThrow(()-> new Exception("el codigo del producto no es valido") );
    }

    @Override
    public List<Producto> listarProductosPorCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public void comentarProducto(String mensaje, Usuario usuario, Producto producto) throws Exception {

    }

    @Override
    public void guardarProductoEnFavoritos(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void eliminarProductofavorito(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void comprarProductos(DetalleCompra detalleCompra, Producto producto) {

    }

    @Override
    public List<Producto> buscarProducto(String nombre, String[] producto) {
        return null;
    }

    @Override
    public List<Producto> listarProductos(String codigoUsuario) throws Exception {
        return null;
    }
}
