package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria implements Serializable {
    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private String codigo;


    @Column(length = 100,nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "miCategoria")
    private List<Producto> misProductos;
    //entidad  inversa

    @OneToMany(mappedBy = "miCategoria")
    private List<SubCategoria> miSubCategorias;
    //entidad inversa



}
