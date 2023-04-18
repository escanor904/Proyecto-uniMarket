package co.edu.uniquindio.proyecto.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
public class ProductoModerador implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private String motivo;

    @Column(nullable = false)
    private Date fecha;


    @ManyToOne
    private Moderador miModerador;


    @ManyToOne
    private Producto miProducto;

    @ManyToOne
    private Estado miEstado;

}
