package br.com.fiap.springpfauthentication.resources;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.fiap.springpfauthentication.entity.Usuario;
import br.com.fiap.springpfauthentication.repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        return usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
    }

    // Implemente outros métodos conforme necessário
}
