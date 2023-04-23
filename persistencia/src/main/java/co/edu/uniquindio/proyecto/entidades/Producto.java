package co.edu.uniquindio.proyecto.entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    private float precio;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false)
    private LocalDate fechaLimite;

    @Column(nullable = false)
    private Integer unidades;

    @ToString.Exclude
    @ManyToOne
    private Usuario miUsuario;
    //entidad propietaria


    @ToString.Exclude
    @OneToMany(mappedBy = "miProducto")
    private List<Imagen> misImagens;

    @ToString.Exclude
    @ManyToOne
    private Categoria miCategoria;
    //entidad Propietaria es el producto porque para hacer un producto necesitamos una categoria

    @ToString.Exclude
    @OneToMany(mappedBy = "miProducto")
    private List<Comentario> miComentario;

    @ToString.Exclude
    @OneToMany(mappedBy = "miProducto")
    private List<DetalleCompra> misDetalleCompras;


    @ToString.Exclude
    @OneToMany(mappedBy = "miProducto")
    private List<DetalleDeProducto> misDetalleProductos;

    @ToString.Exclude
    @OneToMany(mappedBy = "miProducto")
    private List<ProductoModerador> misProductosModerador;


    //estos son los usuarios que tienen el producto en favoritos
    //entidad inversa entre usuario y producto
    @ToString.Exclude
    @ManyToMany(mappedBy = "productosFavoritos")
    private List<Usuario> usuariosFavoritos;

//se debe crear la relacion con el moderador

}
