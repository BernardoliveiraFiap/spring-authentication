package br.com.fiap.springpfauthentication.resources;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.fiap.springpfauthentication.entity.Permissao;
import br.com.fiap.springpfauthentication.repository.PermissaoRepository;

import java.util.List;

@RestController
@RequestMapping("/permissao")
public class PermissaoResource {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @GetMapping
    public List<Permissao> getPermissoes() {
        return permissaoRepository.findAll();
    }

    @PostMapping
    public Permissao createPermissao(@RequestBody Permissao permissao) {
        return permissaoRepository.save(permissao);
    }

    @GetMapping("/{id}")
    public Permissao getPermissaoById(@PathVariable Long id) {
        return permissaoRepository.findById(id).orElse(null);
    }
}
