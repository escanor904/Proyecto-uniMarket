package co.edu.uniquindio.proyecto.entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false,length = 100)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Date fechaCreacion;

    @Column(nullable = false)
    private Date fechaLimite;

    @Column(nullable = false)
    private Integer unidades;

    @ManyToOne
    private Usuario miUsuario;
    //entidad propietaria

    @OneToMany(mappedBy ="miUsuario")
    private List<Favorito> misFavoritos;
    //entidad inversa

    @OneToMany(mappedBy = "miProducto")
    private List<Imagen> misImagens;

    @ManyToOne
    private Categoria miCategoria;
    //entidad Propietaria es el producto porque para hacer un producto necesitamos una categoria

    @OneToMany(mappedBy = "miProducto")
    private List<Comentario> miComentario;

    @OneToMany(mappedBy = "miProducto")
    private List<DetalleCompra> misDetalleCompras;


    @OneToMany(mappedBy = "miProducto")
    private List<DetalleDeProducto> misDetalleProductos;

    @OneToMany(mappedBy = "miProducto")
    private List<ProductoModerador> misProductosModerador;



//se debe crear la relacion con el moderador

}
