package com.tienda.repository;

import com.tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {
    //aqui se usa para el proceso del login
    Usuario findByUsername(String username);
    //se usa para buscar un registro de usuario en el proceso de activacion de un nuevo usuario
    Usuario findByUsernameAndPassword(String username, String Password);
    
    //se utiliza para validar si dentro de la tabla usuario, ya existe un registro con el username o con el correo indicado
    Usuario findByUsernameOrCorreo(String username, String correo);
    
    //se utiliza para validar si dentro de la tabla usuario, ya existe un registro con el username o con el correo indicado
    boolean existsByUsernameOrCorreo(String username, String correo);

}
