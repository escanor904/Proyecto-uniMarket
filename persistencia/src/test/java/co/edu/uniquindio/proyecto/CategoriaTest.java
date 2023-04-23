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

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoriaTest {


    @Autowired
    private CategoriaRepo categoriaRepo;
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
}
