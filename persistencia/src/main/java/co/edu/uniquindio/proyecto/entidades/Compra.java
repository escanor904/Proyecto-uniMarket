package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;


    @Column(nullable = false,columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate fechaCreacion;


    @Column(nullable = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Float valorTotal=0F;

    @Enumerated(EnumType.STRING)
    private MedioDePago medioDePago;
    @ManyToOne
    private Usuario miUsuario;
    //entidad propietaria

    @OneToMany(mappedBy = "miCompra")
    private List<DetalleCompra> misDetalleCompras=new ArrayList<>();



    public Compra( LocalDate fechaCreacion, MedioDePago medioDePago, Usuario miUsuario) {

        this.fechaCreacion = fechaCreacion;
        this.medioDePago = medioDePago;
        this.miUsuario = miUsuario;
    }



}




