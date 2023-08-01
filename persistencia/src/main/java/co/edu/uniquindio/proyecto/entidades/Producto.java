package co.edu.uniquindio.proyecto.entidades;


import lombok.*;
import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;


    @NotBlank(message = "El nombre del producto es obligatorio")
    @Column(nullable = false,length = 100)
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String descripcion;

    @Positive
    @Column(nullable = false)
    private float precio;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Future
    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer unidades;

    @ToString.Exclude
    @ManyToOne
    private Usuario miUsuario;
    //entidad propietaria



    @ToString.Exclude
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> misImagens;


    @ToString.Exclude
    @ManyToMany
    private List<Categoria> misCategorias=new ArrayList<>();

    @ToString.Exclude
    @ManyToMany(mappedBy = "productosFavoritos")
    private List<Usuario> usuariosFavoritos=new ArrayList<>();



    //datos que se necesitan para crear un producto
    public Producto( String nombre, String descripcion, float precio, LocalDateTime fechaCreacion, LocalDateTime fechaLimite, Integer unidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimite = fechaLimite;
        this.unidades = unidades;

    }

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


    public String getImagenPrincipal(){
        if (misImagens!= null && !misImagens.isEmpty()){
         return misImagens.get(0);
        }
        return "default.jpg";
    }

//se debe crear la relacion con el moderador

}
