package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
public class DetalleDeProducto implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;


    @Column(length = 100,nullable = false)
    private String nombre;

    @ManyToOne
    private Producto miProducto;

    @OneToMany(mappedBy = "miDetalleDeProducto")
    private List<OpcionDetalleProducto>misOpcionesDetalleProductos;

}
