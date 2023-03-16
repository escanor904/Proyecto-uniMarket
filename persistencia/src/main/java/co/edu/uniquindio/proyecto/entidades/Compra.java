package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
public class Compra implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private Date fechaCreacion;

    private Double valorTotal;

    @Enumerated(EnumType.STRING)
    private MedioDePago medioDePago;
    @ManyToOne
    private Usuario miUsuario;
    //entidad propietaria

    @OneToMany(mappedBy = "miCompra")
    private List<DetalleCompra> misDetalleCompras;


}




