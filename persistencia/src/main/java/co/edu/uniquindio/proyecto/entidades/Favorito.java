package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Favorito implements Serializable {

    @Id
    @ManyToOne
    private Usuario miUsuario;
    //entidad propietaria

    @Id
    @ManyToOne
    private Producto miProducto;
    //entidad propietaria


}
