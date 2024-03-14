package br.com.fiap.springpfauthentication.resources;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.fiap.springpfauthentication.entity.Perfil;
import br.com.fiap.springpfauthentication.repository.PerfilRepository;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilResource {

    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping
    public List<Perfil> getPerfis() {
        return perfilRepository.findAll();
    }

    @PostMapping
    public Perfil createPerfil(@RequestBody Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @GetMapping("/{id}")
    public Perfil getPerfilById(@PathVariable Long id) {
        return perfilRepository.findById(id).orElse(null);
    }
}
