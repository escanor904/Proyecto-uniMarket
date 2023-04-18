package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Usuario extends Persona implements Serializable {


    @Column(nullable = false,length = 150)
    private String direccion;

    @Column(length = 20)
    private String telefono;

     @OneToMany(mappedBy = "miUsuario")
     private List<Producto> misProductos ;
     //entidad inversa

     @ToString.Exclude
     @OneToMany(mappedBy = "miUsuario")
     private List<Favorito> misFavoritos;

     @ToString.Exclude
     @OneToMany(mappedBy = "miUsuario")
     private List<Comentario> misComentarios;


     @ToString.Exclude
     @OneToMany(mappedBy = "miUsuario")
     private List<Compra> misCompras;
     //entidad inversa



}
