package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Usuario extends Persona implements Serializable {


    @Column(nullable = false,length = 20,unique = true)
    private String username;

    @Column(nullable = false,length = 150)
    private String direccion;

    @Column(length = 20)
    private String telefono;


     @ToString.Exclude
     @OneToMany(mappedBy = "miUsuario")
     private List<Producto> misProductos ;
     //entidad inversa


     //entidad propietaria entre usuario producto
    @ManyToMany(cascade = CascadeType.ALL)
     private List<Producto> productosFavoritos=new ArrayList<>();

     @ToString.Exclude
     @OneToMany(mappedBy = "miUsuario")
     private List<Comentario> misComentarios;


     @ToString.Exclude
     @OneToMany(mappedBy = "miUsuario")
     private List<Compra> misCompras;

    public Usuario(String codigo, @Length(max = 150) String nombre, @Email String email, String telefono, String direccion , String username,String password) {
        super(codigo, nombre, email, password);
        this.username = username;
        this.direccion = direccion;
        this.telefono = telefono;
    }


    //entidad inversa



}
