package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
public class DetalleDeProducto implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @Column(length = 10)
    private String condigo;


    @Column(length = 100,nullable = false)
    private String nombre;


}
