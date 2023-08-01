package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Comentario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;


    @Column(nullable = false,columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreacion;
    @Column(length = 150,nullable = false)
    @NotBlank(message ="El camapo del mensaje no puede estra vacio" )
    private String mensaje;


    @ToString.Exclude
    @ManyToOne
    private Producto miProducto;
    //entidad propietaria

    @ToString.Exclude
    @ManyToOne
    private Usuario miUsuario;


    public Comentario( String mensaje, LocalDateTime fechaCreacion) {
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaEstilo(){

        return fechaCreacion.format(DateTimeFormatter.ISO_DATE);
    }


}
