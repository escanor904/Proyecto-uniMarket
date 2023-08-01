package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Categoria implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;


    @Column(length = 100,nullable = false)
    private String nombre;

    @ToString.Exclude
    @ManyToMany(mappedBy = "misCategorias")
    private List<Producto> misProductos=new ArrayList<>();
    //entidad propietaria necesito de una categoria para poder crear un producto




    public Categoria(Integer codigo, String nombre) {
        this.codigo=codigo;
        this.nombre = nombre;
    }
}
