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

    @ManyToOne
    private Autorizacion miAutorizacion;

    @OneToMany(mappedBy = "miProducto")
    private List<Comentario> miComentario;

    @ManyToOne
    private DetalleCompra miDetalleCompra;

    public Producto(String codigo, String nombre, String descripcion, Double precio, Date fechaCreacion, Date fechaLimite, Integer unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimite = fechaLimite;
        this.unidades = unidades;
    }
}
