package co.edu.uniquindio.proyecto.entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@ToString
@AllArgsConstructor
public class Persona implements Serializable  {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

    @Column(nullable = false,length = 100)
    private String nombre;

    @Column(nullable = false,length = 150,unique = true)
    private String email;

    @Column(nullable = false,length = 20)
    private String password;


}
