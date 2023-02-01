package cadastroAluno.cadastroAluno.repository;

import org.springframework.data.repository.CrudRepository;

import cadastroAluno.cadastroAluno.model.Aluno;
import cadastroAluno.cadastroAluno.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long> {
	Iterable<Livro> findByAluno(Aluno aluno);
}
