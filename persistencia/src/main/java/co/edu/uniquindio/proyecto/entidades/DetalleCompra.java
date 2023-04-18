package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
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
    @Column(length = 10)
    private String codigo;

    @Positive
    @Column(nullable = false)
    private Integer unidades;


    @Column(nullable = false)
    private Double precioProducto;

    @ManyToOne
    private Compra miCompra;

    @ManyToOne
    private Producto miProducto;


}
