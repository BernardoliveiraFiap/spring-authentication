package br.com.fiap.springpfauthentication.resources;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.fiap.springpfauthentication.entity.Sistema;
import br.com.fiap.springpfauthentication.repository.SistemaRepository;

import java.util.List;

@RestController
@RequestMapping("/sistema")
public class SistemaResource {

    @Autowired
    private SistemaRepository sistemaRepository;

    @GetMapping
    public List<Sistema> getSistemas() {
        return sistemaRepository.findAll();
    }

    @PostMapping
    public Sistema createSistema(@RequestBody Sistema sistema) {
        return sistemaRepository.save(sistema);
    }

    @GetMapping("/{id}")
    public Sistema getSistemaById(@PathVariable Long id) {
        return sistemaRepository.findById(id).orElse(null);
    }
}

