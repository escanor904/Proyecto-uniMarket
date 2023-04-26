package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Usuario extends Persona implements Serializable {

    @NotBlank(message = "el campo de usuario no puede ser nulo")
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

    public Usuario(String codigo, @Length(max = 150) String nombre, @Email String email, String password, String direccion, String telefono, String username, String password1) {
        super(codigo, nombre, email, password, direccion, telefono);
        this.username = username;
        this.password = password1;
    }


    //entidad inversa



}
