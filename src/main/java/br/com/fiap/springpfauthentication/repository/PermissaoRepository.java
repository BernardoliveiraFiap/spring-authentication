package br.com.fiap.springpfauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.springpfauthentication.entity.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {}
