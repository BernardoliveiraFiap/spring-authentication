package br.com.fiap.springpfauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.springpfauthentication.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmailAndSenha(String email, String senha);
}
