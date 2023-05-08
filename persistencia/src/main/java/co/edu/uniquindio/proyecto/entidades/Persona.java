package co.edu.uniquindio.proyecto.entidades;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @Length(max = 150)
    private String nombre;

    @Column(nullable = false,length = 150,unique = true)
    @Email(message = "Escriba un email valido")
    private String email;

    @Column(nullable = false,length = 20)
    private String password;


}
