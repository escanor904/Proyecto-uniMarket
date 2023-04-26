package co.edu.uniquindio.proyecto.entidades;

import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Moderador extends Persona implements Serializable {

    @OneToMany(mappedBy ="miModerador")
   private List<ProductoModerador> misProductosModerador;

    //se debe crear la relación entre moderador y producto
}
