package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.servicios.CategoriaServicio;
import co.edu.uniquindio.proyecto.servicios.CategoriaServicioImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest(classes = NegocioApplication.class)
//@Transactional
public class CategoriaServicioTest {

    @Autowired
    CategoriaServicio categoriaServicio;


    @Test
    public void registrarcategoria () {
        Categoria cat1= new Categoria("301","VEHICULOS");
        Categoria cat2= new Categoria("302","CELULARES");
        Categoria cat3= new Categoria("303","JOYAS");
        Categoria cat4= new Categoria("304","COMPUTADORES");


        try {
            categoriaServicio.registrarCategoria(cat1);
            categoriaServicio.registrarCategoria(cat2);
            categoriaServicio.registrarCategoria(cat3);
            categoriaServicio.registrarCategoria(cat4);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
