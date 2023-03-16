package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario extends Persona implements Serializable {


    @Column(nullable = false,length = 150)
    private String direccion;

    @Column(nullable = false,length = 20)
    private String telefono;

     @OneToMany(mappedBy = "miUsuario")
     private List<Producto> misProductos ;
     //entidad inversa


     @OneToMany(mappedBy = "miUsuario")
     private List<Favorito> misFavoritos;

}
