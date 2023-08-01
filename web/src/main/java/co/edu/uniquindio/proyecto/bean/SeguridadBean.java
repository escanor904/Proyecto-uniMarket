package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.DTO.ProductoCarrito;
import co.edu.uniquindio.proyecto.entidades.MedioDePago;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;

@Scope("session")
@Component
public class SeguridadBean implements Serializable {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Getter @Setter
    private Boolean autenticado;

    @Getter @Setter
    private String email,password;

    @Getter @Setter
    private Usuario usuarioSesion;


    @Getter @Setter
    private ArrayList<ProductoCarrito> productosCarrito;

    @Getter @Setter
    private Float subTotal;

    @PostConstruct
    public void inicializar(){
        this.subTotal=0F;
        this.productosCarrito=new ArrayList<>();

    }

    @Autowired
    private ProductoServicio productoServicio;


  public String iniciarSesion(){
      if (!email.isEmpty() && !password.isEmpty()){
          try {


              usuarioSesion=usuarioServicio.iniciarSesion(email,password);
              autenticado=true;

              return "/index?faces-redirect=true";
          } catch (Exception e) {
              FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
              FacesContext.getCurrentInstance().addMessage("login-bean" , fm);
          }
      }
      return null;

  }
  public String cerrarSesion(){
      autenticado=false;
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
      return "/index?faces-redirect=true";
  }

  public void agregarProductocarrito(Integer id, Float precio,String nombre, String imagen){
        ProductoCarrito pc = new ProductoCarrito(id,nombre,imagen,precio,1);
        if (!productosCarrito.contains(pc)){
            productosCarrito.add(pc);
            subTotal += precio;

            FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","Producto agregado al carrito");
            FacesContext.getCurrentInstance().addMessage("add-cart" , fm);

        }

  }

  public void eliminarDelCarrito(int indice){

    subTotal-=productosCarrito.get(indice).getPrecio();
    productosCarrito.remove(indice);


  }

  public void actualizarSubTotal(){
        subTotal = 0F;

        for(ProductoCarrito p : productosCarrito){
            subTotal += p.getPrecio()*p.getUnidades();
        }

  }

  public void comprar(){
      if(usuarioSesion!=null && !productosCarrito.isEmpty()) {
          MedioDePago medioDePago= MedioDePago.TRANSFERENCIA_BANCARIA_PSE;
          try {
              productoServicio.comprarProductos(usuarioSesion, productosCarrito, medioDePago);
              productosCarrito.clear();
              subTotal= 0F;

              FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","Compra realizada satisfactoriamente");
              FacesContext.getCurrentInstance().addMessage("compra-msj" , fm);
          }catch (Exception e){

              FacesMessage fm= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
              FacesContext.getCurrentInstance().addMessage("compra-msj" , fm);

          }
      }

  }

}
