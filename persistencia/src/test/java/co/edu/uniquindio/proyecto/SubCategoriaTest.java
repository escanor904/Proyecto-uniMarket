package co.edu.uniquindio.proyecto;


import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.SubCategoria;
import co.edu.uniquindio.proyecto.repositorios.SubCategoriaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SubCategoriaTest {

    @Autowired
    private SubCategoriaRepo subCategoriaRepo;

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarSubCategorias(){

        List<SubCategoria> miCategorias= subCategoriaRepo.findAll();
        miCategorias.forEach(s -> System.out.println(s));
    }
}
