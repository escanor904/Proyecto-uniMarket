package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@EqualsAndHashCode
@Getter
@Setter
public class DetalleDeProducto implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    private String condigo;

    private String nombre;


}
