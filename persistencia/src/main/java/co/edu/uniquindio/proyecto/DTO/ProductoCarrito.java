package co.edu.uniquindio.proyecto.DTO;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ProductoCarrito {

   @EqualsAndHashCode.Include
    private Integer id;
    private String nombre,imagen;
    private Float precio;
    private Integer unidades;




}
