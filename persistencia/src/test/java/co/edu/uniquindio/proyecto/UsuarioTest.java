package co.edu.uniquindio.proyecto;


import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {



    @Autowired// nos permite inicializar las variables que representen componentes de SpringBoot
    private UsuarioRepo usuarioRepo;
    @Autowired
    private CategoriaRepo categoriaRepo;





    @Test
    public void resgistraUsuario(){
        Usuario usuario=  new Usuario();
        usuario.setCodigo("904");
        usuario.setNombre("Pedro");
        usuario.setEmail("pedro@gmail.com");
        usuario.setPassword("Heropro.12");
        usuario.setDireccion("cll12#20-89");

         usuarioRepo.save(usuario);

         usuarioRepo.deleteById("904");

         Usuario usuarioBuscado = usuarioRepo.findById("904").orElse(null);

         Assertions.assertNull(usuarioBuscado);


    }

    @Test
    public void actualizarTest(){

        //si el usuario ya existe se actualza el registro
        //se guarda el ususario
        Usuario usuario=  new Usuario();
        usuario.setCodigo("904");
        usuario.setNombre("Pedro");
        usuario.setEmail("pedro@gmail.com");
        usuario.setPassword("Heropro.12");
        usuario.setDireccion("cll12#20-89");

        Usuario usuarioGuardado =usuarioRepo.save(usuario);

        // se modifica el correo
        usuarioGuardado.setEmail("pedrog@gmail.com");

        //se vuelve a guardar pero con un email diferente
        usuarioRepo.save(usuarioGuardado);
        Usuario usuarioBuscado = usuarioRepo.findById("904").orElse(null);
        System.out.println(usuarioGuardado);

       // Assertions.assertEquals("pedrog@gmail.com",usuarioBuscado.getEmail());


    }
    @Test
    public void eliminarTest(){
        Usuario usuario=  new Usuario();
        usuario.setCodigo("904");
        usuario.setNombre("Pedro");
        usuario.setEmail("pedro@gmail.com");
        usuario.setPassword("Heropro.12");
        usuario.setDireccion("cll12#20-89");

        usuarioRepo.save(usuario);
        Usuario usuarioBuscado= usuarioRepo.findById("904").orElse(null);
        usuarioRepo.delete(usuarioBuscado);

         usuarioBuscado= usuarioRepo.findById("904").orElse(null);
         Assertions.assertNull(usuarioBuscado);

    }
    //caundo se coloca la etiqueta sql hace que se indique que el data set de esa funcion sea el que este en el path asignado en la etuiqueta
    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuario() {
        List<Usuario> usuarios = usuarioRepo.findAll();//busca todos los usuarios, findall me permite traer los datos del data set
        usuarios.forEach(u -> System.out.println(u)); //funcion landa
     //listar actualizar eliminar y guardar
    }


    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuariosPorNombre(){
        List<Usuario> misUsuarios=usuarioRepo.findAllByNombreContains("pedro");
        misUsuarios.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuariosPorNumeroTelefono(){

        //Optional<Usuario> usuario = usuarioRepo.findAllByTelefono("23");
        //sirve para que los errore no inpidan el manejo del codigo
        //System.out.println(usuario);

    }


    @Test
    @Sql("classpath:usuarios.sql")
    public void paginarLista(){

        Pageable paginador = PageRequest.of(0,2);
    Page<Usuario> list = usuarioRepo.findAllBy(paginador);
        System.out.println(list.stream().collect(Collectors.toList()));

    }


    @Test
    @Sql("classpath:usuarios.sql")
    public void ordenarLista(){


        List<Usuario> list = usuarioRepo.findAll(Sort.by("nombre"));
        System.out.println(list.stream().collect(Collectors.toList()));

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarCategorias(){

    List<Categoria> categorias = categoriaRepo.findAll();
    categorias.forEach(c -> System.out.println(c));

    }


    @Test
    @Sql("classpath:usuarios.sql")
    public void listarProductosDeUnUsuario(){


        List<Producto>misProductos = usuarioRepo.obtenerProductosUsuarioPorCodigo("904");
        System.out.println(misProductos);

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void obtenerFavoritos(){


        List<Producto>misProductos = usuarioRepo.obtenerFavoritosPorCorreo("lian@gmail.com");
        misProductos.forEach(System.out::println);
        //Assertions.assertEquals(2,misProductos.size());

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void obtenerProductosPublicados(){


        List<Producto>misProductos = usuarioRepo.obtenerProductosUsuarioPorCodigoj("904");

        Assertions.assertEquals(2,misProductos.size());

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void obtenerComentariosDeUsuaroi(){


        List<Comentario> comentarios= usuarioRepo.obtenerComentarioDeUsuarioPorCodigo("908");
        Assertions.assertEquals(3,comentarios.size());

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuarioProductoTest(){


        List<Object[]> respuesta= usuarioRepo.listarUsuariosYProductos();

       for (Object[] objeto:respuesta){
           System.out.println(objeto[0]+"-----"+objeto[1]);
       }

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void buscarUsuarioPorCorreo(){
        Optional<Usuario> usuario = usuarioRepo.findByEmail("lian@gmail.com");
        Assertions.assertNotNull(usuario);

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void buscarUsuarioPorUsername(){
        Optional<Usuario> usuario = usuarioRepo.findByUsername("unimario");
        System.out.println(usuario);
        Assertions.assertNotNull(usuario);

    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void buscarUsuarioPorCedula(){
        Optional<Usuario> usuario = usuarioRepo.findByCedula("1023452133");
        Assertions.assertNotNull(usuario);

    }




















}
