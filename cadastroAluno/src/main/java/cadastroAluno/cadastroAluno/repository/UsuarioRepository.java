package cadastroAluno.cadastroAluno.repository;

import org.springframework.data.repository.CrudRepository;

import cadastroAluno.cadastroAluno.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByLogin(String login);
	
}
