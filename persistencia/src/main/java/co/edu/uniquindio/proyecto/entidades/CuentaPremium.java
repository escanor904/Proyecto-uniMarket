package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
@Entity
@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
public class CuentaPremium implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private String nombre;

    @OneToOne
    private Usuario miUsuario;
    //entidad propietaria


}
