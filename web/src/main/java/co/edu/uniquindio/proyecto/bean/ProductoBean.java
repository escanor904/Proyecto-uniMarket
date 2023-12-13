package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.CategoriaServicio;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;


@Component
@ViewScoped
public class ProductoBean implements Serializable {

    @Getter @Setter
    private Producto producto;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private CategoriaServicio categoriaServicio;

    private ArrayList<String> imagenes;

    @Getter @Setter
    private List<Categoria> categorias;

    @Value("${upload.url}")
    private String urlUpload;

    @Getter @Setter
    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;
    @PostConstruct
    public void inicializar(){
        this.producto = new Producto();
        this.imagenes=new ArrayList<>();
        this.categorias=categoriaServicio.listarCategorias();
    }

    public void crearProducto() {
        try {

            if (!imagenes.isEmpty() && (usuarioSesion!=null)) {

                producto.setMiUsuario(usuarioSesion);
                producto.setFechaCreacion(LocalDateTime.now());
                producto.setFechaLimite(LocalDateTime.now().plusMonths(1));
                producto.setMisImagens(imagenes);
                //esta linea me permite limpiar el texto de las etiquetas html
                producto.setDescripcion(Jsoup.parse(producto.getDescripcion()).text());

                productoServicio.registrarProducto(producto);
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "La creacion del producto fue exitosa");
                FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
                //return "producto_creado?faces-redirect=true";
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "es necesario subir al menos una imagen");
                FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        }

    } //return null;


    public void subirImagenes(FileUploadEvent event){
        UploadedFile imagen = event.getFile();
        String nombreImagen=subirImagen(imagen);

        if (nombreImagen!=null){
            imagenes.add(nombreImagen);
            System.out.println("se guardo la imagen");
        }
    }

    private String subirImagen(UploadedFile imagen) {
       try {
           File archivo = new File(urlUpload + "/" + imagen.getFileName());
           OutputStream outputStream = new FileOutputStream(archivo);
           IOUtils.copy(imagen.getInputStream(), outputStream);
           return imagen.getFileName();
       }catch (Exception e){
           e.printStackTrace();
       }
        return null;
    }


}
