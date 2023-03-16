package co.edu.uniquindio.proyecto.entidades;

import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Categoria implements Serializable {
    @Id
    private String codigo;

    private String nombre;

    @OneToMany(mappedBy = "miCategoria")
    private List<Producto> misProductos;
    //entidad  inversa

    @OneToMany(mappedBy = "miCategoria")
    private List<SubCategoria> miSubCategorias;
    //entidad inversa



}
