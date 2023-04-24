package co.edu.uniquindio.proyecto;


import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {

    @Autowired
    private CompraRepo compraRepo;


    //-------------------------------CONSULTAS-----------------------------------------------------------
    @Test
    public void listarCompras() {
        List<Compra> compras = compraRepo.findAll(); // Obtener todas las compras

        // Iterar sobre las compras y mostrar información relevante
        for (Compra compra : compras) {
            System.out.println("ID de Compra: " + compra.getCodigo());
            System.out.println("Fecha de Compra: " + compra.getFechaCreacion());
            System.out.println("Total de Compra: " + compra.getValorTotal());
            // Puedes mostrar más información relacionada con la compra según tus necesidades
        }
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarComprasConDetalle() {
        List<Compra> compras = compraRepo.findAll(); // Obtener todas las compras

        // Iterar sobre las compras y mostrar su detalle
        for (Compra compra : compras) {
            System.out.println("Compra con ID: " + compra.getCodigo() + ", Fecha: " + compra.getFechaCreacion() + ", Total: " + compra.getValorTotal());

            // Obtener el detalle de la compra
            List<DetalleCompra> detalles = compra.getMisDetalleCompras();
            for (DetalleCompra detalle : detalles) {
                System.out.println("Detalle - Producto: " + detalle.getMiProducto().getNombre() + ", Cantidad: " + detalle.getUnidades()+ ", Precio: " + detalle.getPrecioProducto());
            }
        }
    }


    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuarioConMasCompras() {
        List<Object[]> resultado = compraRepo.listarUsuarioConMasCompras();
        for (Object[] row : resultado) {
            String usuarioId = row[0].toString(); // Convertir a String
            Long cantidadCompras = (Long) row[1]; // Obtener como Long
            System.out.println("Usuario con el ID: " + usuarioId + " - Cantidad de Compras: " + cantidadCompras);
        }
    }
}
