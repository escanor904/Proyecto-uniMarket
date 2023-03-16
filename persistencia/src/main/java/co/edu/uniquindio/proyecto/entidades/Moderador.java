package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Moderador extends Persona implements Serializable {

    @OneToMany(mappedBy = "miModerador")
    private List<Autorizacion> misAutorizaciones;




}
