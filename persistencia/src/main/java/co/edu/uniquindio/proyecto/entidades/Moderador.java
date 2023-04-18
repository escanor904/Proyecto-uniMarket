package co.edu.uniquindio.proyecto.entidades;

import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Moderador extends Persona implements Serializable {


    @OneToMany(mappedBy ="miModerador")
   private List<ProductoModerador> misProductosModerador;

    //se debe crear la relación entre moderador y producto
}
