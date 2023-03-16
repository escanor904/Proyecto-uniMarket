package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Autorizacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @ManyToOne
    private Moderador miModerador;
    //entidad propietaria

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoProducto estadoProducto;

    @OneToMany(mappedBy = "miAutorizacion")
    private List<Producto> misProductos;


}
