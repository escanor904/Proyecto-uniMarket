package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.MedioDePago;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.ModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class CompraServicioTest {
    @Autowired
    private CompraServicio compraServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;


    @Test
    public void registrarCompraTest() throws Exception {
        // Crear un objeto Usuario con algunos datos de ejemplo
        Usuario usuario = new Usuario("909", "Mario", "mario@gmail.com", "3216758976", "28#14-09", "unimario", "Heropro.12");
        // Registrar el usuario antes de crear la compra (si aún no está registrado)
        usuarioServicio.registrarUsuario(usuario);
        // Crear un objeto Compra con algunos datos de ejemplo
        Compra compra = new Compra( LocalDate.now(), 100.0F, MedioDePago.MASTERCARD,usuario);
        try {
            // Registrar la compra
            Compra resultado = compraServicio.registrarCompra(compra);

            // Verificar que la compra devuelta no sea nula
            Assertions.assertNotNull(resultado);

            // Verificar que la compra devuelta tenga un ID asignado
            Assertions.assertNotNull(resultado.getCodigo());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


    @Test
    public void actualizarCompraTest() throws Exception {
        // Crear un objeto Usuario con algunos datos de ejemplo
        Usuario usuario = new Usuario("908", "Mario", "mario2@gmail.com", "3216758976", "28#14-09", "unimario", "Heropro.12");

        // Registrar el usuario antes de crear la compra (si aún no está registrado)
        usuarioServicio.registrarUsuario(usuario);

        // Crear una Compra con algunos datos de ejemplo
        Compra compra = new Compra( LocalDate.now(), 100.0F, MedioDePago.MASTERCARD, usuario);

        // Registrar la compra
        Compra resultado = compraServicio.registrarCompra(compra);

        // Actualizar algunos datos de la Compra
        resultado.setValorTotal(150.0F);
        resultado.setMedioDePago(MedioDePago.TRANSFERENCIA_BANCARIA_PSE);

        // Actualizar la Compra
        Compra resultadoActualizado = null;
        try {
            resultadoActualizado = compraServicio.actualizarCompra(resultado);
        } catch (Exception e) {
            // Manejar cualquier excepción lanzada por el método actualizarCompra
        }

        // Verificar que la Compra devuelta no sea nula
        Assertions.assertNotNull(resultadoActualizado);

        // Verificar que la Compra devuelta tenga los datos actualizados
        Assertions.assertEquals(resultado.getValorTotal(), resultadoActualizado.getValorTotal());
        Assertions.assertEquals(resultado.getMedioDePago(), resultadoActualizado.getMedioDePago());
    }


    @Test
    public void eliminarCompraTest() throws Exception {
        // Crear un objeto Usuario con algunos datos de ejemplo
        Usuario usuario = new Usuario("908", "Mario", "mario2@gmail.com", "3216758976", "28#14-09", "unimario", "Heropro.12");

        // Registrar el usuario antes de crear la compra (si aún no está registrado)
        usuarioServicio.registrarUsuario(usuario);

        // Crear una Compra con algunos datos de ejemplo
        Compra compra = new Compra(LocalDate.now(), 100.0F, MedioDePago.MASTERCARD, usuario);

        // Registrar la compra
        Compra resultado = compraServicio.registrarCompra(compra);

        // Eliminar la Compra
        compraServicio.eliminarCompra(resultado.getCodigo());

        // Intentar obtener la Compra eliminada
        Compra compraEliminada = null;
        try {
            compraEliminada = compraServicio.obtenerCompra(resultado.getCodigo());
        } catch (Exception e) {
            // Capturar la excepción si se lanza al intentar obtener la compra eliminada
        }

        // Verificar que la Compra eliminada no se pueda encontrar
        Assertions.assertNull(compraEliminada);
    }


    @Test
    public void listarComprasTest() {
        // Crear algunos objetos de ejemplo
        Usuario usuario1 = new Usuario("910", "Mario", "mario2@gmail.com", "3216758976", "28#14-09", "unimario", "Heropro.12");
        Usuario usuario2 = new Usuario("911", "Luigi", "luigi@gmail.com", "3216758977", "28#14-10", "uniluigi", "Heropro.12");

        Compra compra1 = new Compra( LocalDate.now(), 100.0F, MedioDePago.MASTERCARD, usuario1);
        Compra compra2 = new Compra( LocalDate.now(), 50.0F, MedioDePago.TRANSFERENCIA_BANCARIA_PSE, usuario2);

        try {
            // Registrar las compras
            usuarioServicio.registrarUsuario(usuario1);
            usuarioServicio.registrarUsuario(usuario2);
            compraServicio.registrarCompra(compra1);
            compraServicio.registrarCompra(compra2);

            // Listar las compras
            List<Compra> compras = compraServicio.listarCompras();

            // Imprimir las compras
            compras.forEach(c -> System.out.println(c));
        } catch (Exception e) {
            // Manejar cualquier excepción lanzada durante la prueba
            Assertions.fail("La prueba ha fallado: " + e.getMessage());
        }
    }

    @Test
    public void registrarCompra() throws Exception {

        // Crear un objeto Compra con algunos datos de ejemplo
        Compra compra = new Compra( LocalDate.now(), 100.0F, MedioDePago.MASTERCARD,null);
        compra.setCodigo(12);
        try {
            // Registrar la compra
            Compra resultado = compraServicio.registrarCompra(compra);

            // Verificar que la compra devuelta no sea nula
            Assertions.assertNotNull(resultado);

            // Verificar que la compra devuelta tenga un ID asignado
            //Assertions.assertNotNull(resultado.getCodigo());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


}
