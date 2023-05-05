package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    private final CategoriaRepo categoriaRepo;

    public CategoriaServicioImpl(CategoriaRepo categoriaRepo) {
        this.categoriaRepo = categoriaRepo;
    }

    @Override
    public Categoria registrarCategoria(Categoria categoria) throws Exception {
        Optional<Categoria> catBuscada = categoriaRepo.findByCodigo(categoria.getCodigo());

        if (catBuscada.isPresent()){
            throw  new Exception("el codigo de la categoria ya existe");
        }

        return  categoriaRepo.save(categoria);
    }

    @Override
    public void eliminarCategoria(Categoria categoria) throws Exception {

    }

    @Override
    public Categoria actualizarcategoria(Categoria categoria) throws Exception {
    return null;
    }
}
