package co.edu.uniquindio.proyecto;


import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.SubCategoria;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import co.edu.uniquindio.proyecto.repositorios.SubCategoriaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SubCategoriaTest {

    @Autowired
    private SubCategoriaRepo subCategoriaRepo;

    @Autowired
    private CategoriaRepo categoriaRepo;


//---------------------------------------CRUD--------------------------------------------------------
    @Test
    @Sql("classpath:usuarios.sql") // Archivo SQL con datos de categorías en la base de datos
    public void crearSubcategoria() {
        // Crear una nueva subcategoría
        SubCategoria subcategoria = new SubCategoria();
        subcategoria.setCodigo("12");
        subcategoria.setNombre("iphone");

        // Obtener la categoría con código "305" de la base de datos
        Categoria categoria = categoriaRepo.obtenerCategoriaPorCodigo("303");
        assertNotNull(categoria); // Asegurarse de que la categoría no sea nula

        // Asociar la subcategoría con la categoría obtenida anteriormente
        subcategoria.setMiCategoria(categoria);

        // Guardar la subcategoría en la base de datos
        SubCategoria subcategoriaGuardada = subCategoriaRepo.save(subcategoria);

        // Obtener la lista de subcategorías por código de categoría
        List<SubCategoria> subcategoriasObtenidas = subCategoriaRepo.obtenerSubCategoriaPorCodigo("303");
        assertNotNull(subcategoriasObtenidas); // Asegurarse de que la lista de subcategorías no sea nula
        assertEquals(1, subcategoriasObtenidas.size()); // Asegurarse de que se obtenga una subcategoría en la lista
        assertEquals("12", subcategoriasObtenidas.get(0).getCodigo()); // Asegurarse de que el código de la subcategoría obtenida sea "12"
    }

    //---------------------------------------CONSULTAS---------------------------------------------------
    @Test
    @Sql("classpath:usuarios.sql")
    public void listarSubCategorias(){
        List<SubCategoria> miCategorias= subCategoriaRepo.findAll();
        miCategorias.forEach(s -> System.out.println(s));
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void obtenersubCategoriasOrdenadasAsc() {
        // Obtener subcategorías ordenadas por nombre ascendente
        List<SubCategoria> subCategoriasAsc = subCategoriaRepo.obtenerSubCategoriasOrdenadasPorNombreAsc();
        System.out.println("Subcategorías ordenadas por nombre ascendente:");
        subCategoriasAsc.forEach(s -> System.out.println(s));
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void obtenerSubCategoriasPorCategoria() {
        String codigoCategoria = "302"; // Código de la categoría buscada

        List<SubCategoria> subCategorias = subCategoriaRepo.obtenerSubCategoriaPorCodigo(codigoCategoria);
        subCategorias.forEach(s -> System.out.println(s));
    }


    /**
     * esta la imprime con el nombre de la categoria
     */
    @Test
    @Sql("classpath:usuarios.sql")
    public void obtenerSubCategoriasPorCategoria2() {
        String codigoCategoria = "302"; // Código de la categoría buscada

        Categoria categoria = categoriaRepo.obtenerCategoriaPorCodigo(codigoCategoria);
        assertNotNull(categoria); // Asegurarse de que la categoría no sea nula

        List<SubCategoria> subCategorias = subCategoriaRepo.obtenerSubCategoriaPorCodigo(codigoCategoria);
        assertNotNull(subCategorias); // Asegurarse de que la lista de subcategorías no sea nula

        // Imprimir el nombre de la categoría
        System.out.println("Categoría: " + categoria.getNombre());
        System.out.println("Contiene las siguientes subCategorias " + codigoCategoria + ":");

        for (SubCategoria subCategoria : subCategorias) {
            System.out.println(subCategoria);
        }
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void obtenerSubCategoriasConCategorias() {

        List<SubCategoria> subCategorias = subCategoriaRepo.findAll(); // Obtener todas las subcategorías
        assertNotNull(subCategorias); // Asegurarse de que la lista de subcategorías no sea nula

        // Iterar por cada subcategoría
        for (SubCategoria subCategoria : subCategorias) {
            System.out.println("Subcategoría: " + subCategoria.getNombre());
            System.out.println("Categoría: " + subCategoria.getMiCategoria().getNombre());
            System.out.println("--------------------");
        }
    }


}