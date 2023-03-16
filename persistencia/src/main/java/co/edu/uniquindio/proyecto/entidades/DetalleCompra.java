package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
public class DetalleCompra implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private Integer unidades;

    private Double precioProducto;

    @ManyToOne
    private Compra miCompra;

    @OneToMany(mappedBy = "miDetalleCompra")
    private List<Producto> misProductos;


}
