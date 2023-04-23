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

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SubCategoriaTest {

    @Autowired
    private SubCategoriaRepo subCategoriaRepo;

    @Autowired
    private CategoriaRepo categoriaRepo;

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


}