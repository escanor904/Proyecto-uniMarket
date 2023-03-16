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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Autorizacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
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
