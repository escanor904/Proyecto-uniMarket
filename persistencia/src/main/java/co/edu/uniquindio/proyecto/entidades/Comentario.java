package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
@EqualsAndHashCode
public class Comentario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private String mensaje;

    private Date fechaCreacion;

    @ManyToOne
    private Producto miProducto;
    //entidad propietaria

    @ManyToOne
    private Usuario miUsuario;

}
