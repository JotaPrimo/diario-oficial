package com.jotasantos.app.diariooficial.database.seeders;

import com.jotasantos.app.diariooficial.database.repositories.IUsuarioRepository;
import com.jotasantos.app.diariooficial.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioSeeder {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void populateUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setEmail("gestald118@gmail.com");
        usuario.setPassword(getPasswordEncoder().encode("12345678"));
        usuarios.add(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.setEmail("jessicaHelena@gmail.com");
        usuario2.setPassword(getPasswordEncoder().encode("12345678"));
        usuarios.add(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.setEmail("calebromeo@gmail.com");
        usuario3.setPassword(getPasswordEncoder().encode("12345678"));
        usuarios.add(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.setEmail("jugheadjones@gmail.com");
        usuario4.setPassword(getPasswordEncoder().encode("12345678"));
        usuarios.add(usuario4);

        usuarioRepository.saveAll(usuarios);
    }
}
