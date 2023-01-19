package cadastroAluno.cadastroAluno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cadastroAluno.cadastroAluno.model.Livro;
import cadastroAluno.cadastroAluno.repository.AlunoRepository;
import cadastroAluno.cadastroAluno.repository.LivroRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin // para permitir que outras aplicações acesse essa controller
public class LivroController {

	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	LivroRepository livroRepository;
	
	
	@PostMapping("/cadastrarLivro/{codigo}")
	public void cadastrarLivro(@RequestBody Livro livro, @PathVariable long codigo) {
		livro.setAluno(alunoRepository.findById(codigo));
		
		livroRepository.save(livro);
		
		
	}
	
	@GetMapping("/listarLivros")
	public List<Livro> listarLivro() {
		List<Livro> livros =   (List<Livro>) livroRepository.findAll();
		
		
		return livros;
	}
	
	
}
