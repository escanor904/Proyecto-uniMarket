package co.edu.uniquindio.proyecto.bean;



import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.CompraServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class CompraBean implements Serializable {


    @Getter @Setter
    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;

    @Autowired
    private CompraServicio compraServicio;

    @Getter @Setter
    private List<Compra> compras;


    //colocare la totalidad de las compras reales
    @Getter @Setter
    private List<DetalleCompra> detalleCompras;



    @PostConstruct
    public void inicializar(){
        this.compras = compraServicio.listarCompras();
        this.detalleCompras = new ArrayList<>();
        fusionarDetallesDeCompra();
    }

    /**
     * este método me permite fusionar todas las listas de detalles de cada compra en una única lista
     * para posteriormente mostrarla en la interfaz web
     */
    public void fusionarDetallesDeCompra(){

        for (int i = 0; i < compras.size() ; i++) {
            detalleCompras.addAll(compras.get(i).getMisDetalleCompras());
        }
    }




}
