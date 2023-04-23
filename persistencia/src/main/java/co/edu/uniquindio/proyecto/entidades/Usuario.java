package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Usuario extends Persona implements Serializable {

    @Column(nullable = false,length = 20,unique = true)
    private String username;
    @Column(nullable = false,length = 20)
    private String password;

     @ToString.Exclude
     @OneToMany(mappedBy = "miUsuario")
     private List<Producto> misProductos ;
     //entidad inversa


     //entidad propietaria entre usuario producto
    @ManyToMany
     private List<Producto> productosFavoritos;

     @ToString.Exclude
     @OneToMany(mappedBy = "miUsuario")
     private List<Comentario> misComentarios;


     @ToString.Exclude
     @OneToMany(mappedBy = "miUsuario")
     private List<Compra> misCompras;

    public Usuario(String codigo, String cedula,String direccion,@Email String email,@Length(max = 150) String nombre, String telefono,String password, String username) {
        super(codigo, nombre, cedula, email, direccion, telefono);
        this.username = username;
        this.password = password;

    }

    //entidad inversa



}
