package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoriaTest {

    @Autowired
    private CategoriaRepo categoriaRepo;



    //--------------------------------------Crud---------------------------------------------------------------
    @Test
    public void crearCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Tecnologia");

        categoriaRepo.save(categoria);

        Categoria categoriaGuardada = categoriaRepo.findById("306").orElse(null);
        Assertions.assertNotNull(categoriaGuardada);
        Assertions.assertEquals("Tecnologia", categoriaGuardada.getNombre());
    }

    @Test
    public void actualizarCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Tecnologia");

        categoriaRepo.save(categoria);

        Categoria categoriaActualizada = categoriaRepo.findById("306").orElse(null);
        Assertions.assertNotNull(categoriaActualizada);

        categoriaActualizada.setNombre("Tecnologia Actualizados");
        categoriaRepo.save(categoriaActualizada);

        Categoria categoriaObtenida = categoriaRepo.findById("306").orElse(null);
        Assertions.assertNotNull(categoriaObtenida);
        Assertions.assertEquals("Tecnologia Actualizados", categoriaObtenida.getNombre());
    }

    @Test
    public void eliminarCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Tecnologia");

        categoriaRepo.save(categoria);

        Categoria categoriaEliminada = categoriaRepo.findById("306").orElse(null);
        Assertions.assertNotNull(categoriaEliminada);

        categoriaRepo.deleteById("306");

        Categoria categoriaObtenida = categoriaRepo.findById("306").orElse(null);
        Assertions.assertNull(categoriaObtenida);
    }

    //------------------------------------ CONSULTAS-------------------------------------------------------------

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarCategorias(){
        List<Categoria> categorias = categoriaRepo.findAll();
        categorias.forEach(c -> System.out.println(c));

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void obtenerCategoriasOrdenadas(){

        String campoOrdenacion = "nombre"; // Campo por el cual ordenar las categorías
        List<Categoria> categorias = categoriaRepo.findAll(Sort.by(campoOrdenacion));
        // Verificar si las categorías están ordenadas por el campo especificado
        for (int i = 0; i < categorias.size() - 1; i++) {
            String valorActual = categorias.get(i).getNombre();
            String valorSiguiente = categorias.get(i + 1).getNombre();
            Assertions.assertTrue(valorActual.compareToIgnoreCase(valorSiguiente) <= 0);
            System.out.println(categorias);
        }

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void obtenerCategoriaPOrCodigoTest(){
         Optional<Categoria> buscada=categoriaRepo.findByCodigo(301);
         Assertions.assertNotNull(buscada);

    }



//    @Test
//    @Sql("classpath:usuarios.sql")
//    public void obtenerCategoriasYSubCategorias() {
//        List<Categoria> categorias = categoriaRepo.findAll(); // Obtener todas las categorías
//        assertNotNull(categorias); // Asegurarse de que la lista de categorías no sea nula
//
//        // Iterar por cada categoría
//        for (Categoria categoria : categorias) {
//            System.out.println("Categoría: " + categoria.getNombre());
//            System.out.println("Subcategorías:");
//
//            List<SubCategoria> subCategorias = subCategoriaRepo.obtenerSubCategoriaPorCodigo(categoria.getCodigo());
//            assertNotNull(subCategorias); // Asegurarse de que la lista de subcategorías no sea nula
//
//            // Imprimir las subcategorías de la categoría actual
//            for (SubCategoria subCategoria : subCategorias) {
//                System.out.println(subCategoria);
//            }
//
//            System.out.println("--------------------");
//        }
//    }

}
