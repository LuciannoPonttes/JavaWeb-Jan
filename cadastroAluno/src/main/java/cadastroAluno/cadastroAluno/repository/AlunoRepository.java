package cadastroAluno.cadastroAluno.repository;

import org.springframework.data.repository.CrudRepository;

import cadastroAluno.cadastroAluno.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
	Aluno findById(long codigo);
}
