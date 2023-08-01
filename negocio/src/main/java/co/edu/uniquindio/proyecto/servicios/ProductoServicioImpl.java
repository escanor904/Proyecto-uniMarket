package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.DTO.ProductoCarrito;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio{

    private final ProductoRepo productoRepo;

    private final UsuarioRepo usuarioRepo;

    private final CompraRepo compraRepo;
    private final DetalleCompraRepo detalleCompraRepo;

    private final ComentarioRepo comentarioRepo;

    public ProductoServicioImpl(ProductoRepo productoRepo,ComentarioRepo comentarioRepo,UsuarioRepo usuarioRepo,CompraRepo compraRepo,DetalleCompraRepo detalleCompraRepo) {
        this.productoRepo = productoRepo;
        this.comentarioRepo=comentarioRepo;
        this.usuarioRepo=usuarioRepo;
        this.compraRepo=compraRepo;
        this.detalleCompraRepo=detalleCompraRepo;
    }

    @Override
    public Producto registrarProducto(Producto p) throws Exception {
//        Optional<Producto> buscado= productoRepo.findById(p.getCodigo());
//
//        if (buscado.isPresent()){
//            throw new Exception("El codigo del producto ya existe");
//        }

        return productoRepo.save(p);
    }

    @Override
    public Producto publicarProductoVender(Producto p, Usuario u) throws Exception {

        Optional<Producto> buscado= productoRepo.findById(p.getCodigo());
        if (buscado.isPresent()){
            throw new Exception("El codigo del producto ya existe");
        }

        p.setMiUsuario(u);
        return productoRepo.save(p);



    }



    @Override
    public void actualizarProducto(Producto p) throws Exception {

    }

    @Override
    public void eliminarProducto(Integer codigo) throws Exception {
        Optional<Producto> producto = productoRepo.findById(codigo);

       if (producto.isEmpty()){
           throw new Exception("No existe ningun producto con ese codigo");
       }

       productoRepo.deleteById(codigo);
    }

    @Override
    public Producto obtenerProducto(Integer codigo) throws Exception {
        return productoRepo.findById(codigo).orElseThrow(()-> new Exception("el codigo del producto no es valido") );
    }

    @Override
    public List<Producto> listarProductosPorCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public void comentarProducto(Comentario comentario) throws Exception {
      comentario.setFechaCreacion(LocalDateTime.now());
     comentarioRepo.save(comentario);
    }

    @Override
    public void guardarProductoEnFavoritos(Producto producto, Usuario usuario) throws Exception {

        if (producto==null || usuario==null){
            throw new Exception("el producto o el usuario son nulos ");
        }

        producto.getUsuariosFavoritos().add(usuario);
        usuario.getProductosFavoritos().add(producto);

        productoRepo.save(producto);
        usuarioRepo.save(usuario);

    }

    @Override
    public void eliminarProductofavorito(Producto producto, Usuario usuario) throws Exception {
        if (producto==null || usuario==null){
            throw new Exception("el producto o el usuario son nulos ");
        }

        producto.getUsuariosFavoritos().remove(usuario);
        usuario.getProductosFavoritos().remove(producto);

        productoRepo.save(producto);
        usuarioRepo.save(usuario);

    }

    @Override
    public Compra comprarProductos(Usuario usuario, ArrayList<ProductoCarrito> productos, MedioDePago medioDePago) throws Exception{

        try {
            Compra compra = new Compra();
            compra.setFechaCreacion(LocalDate.now());
            compra.setMiUsuario(usuario);
            compra.setMedioDePago(medioDePago);
            Compra compraGuardada = compraRepo.save(compra);


            DetalleCompra dc;
            for (ProductoCarrito p : productos) {
                dc = new DetalleCompra();
                dc.setPrecioProducto(p.getPrecio());
                dc.setUnidades(p.getUnidades());
                dc.setMiProducto(productoRepo.findById(p.getId()).get());
                dc.setMiCompra(compra);

                detalleCompraRepo.save(dc);


            }
            return  compraGuardada;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }


    @Override
    public List<Producto> buscarProductoPorNombre(String nombre, String[] producto) {

        return productoRepo.buscarProductoNombre(nombre);
    }

    @Override
    public List<Producto> listarProductos(String codigoUsuario) {
        return null;
    }

    @Override
    public List<Producto> listarProductos(){
        try {
            return productoRepo.findAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
