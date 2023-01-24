package br.impacta.security.br.impacta.security.repository;

import org.springframework.data.repository.CrudRepository;

import br.impacta.security.br.impacta.security.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByLogin(String login);
}
