package cadastroAluno.cadastroAluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cadastroAluno.cadastroAluno.model.Aluno;
import cadastroAluno.cadastroAluno.model.Livro;
import cadastroAluno.cadastroAluno.repository.AlunoRepository;
import cadastroAluno.cadastroAluno.repository.LivroRepository;

@Controller
public class LivroControllerMono {

	@Autowired // Objeto sera instanciado e gerenciado pelo Spring Container
	AlunoRepository alunoRepository;
	
	@Autowired
	LivroRepository livroRepository;
	
	@RequestMapping(value ="cadastrarLivro/{codigo}", method = RequestMethod.GET)
	public ModelAndView cadastrarLivroMetodo(@PathVariable("codigo") long codigo) {
		Aluno aluno = alunoRepository.findById(codigo);
		
		ModelAndView modelAndViewAluno = new ModelAndView("cadastrarLivro");
		
		Iterable<Livro> livros  = livroRepository.findByAluno(aluno);
		
		
		
		
		modelAndViewAluno.addObject("livros", livros);
		modelAndViewAluno.addObject("aluno", aluno);
		return modelAndViewAluno;
		
	}
	
	@RequestMapping(value ="cadastrarLivro/{codigo}", method = RequestMethod.POST)
	public String cadastrarLivroMetodoPost(@PathVariable("codigo") long codigo, Livro livro) {
		
		livro.setAluno(alunoRepository.findById(codigo));
		
		livroRepository.save(livro);
		
		
		
		
		
		return "redirect:/cadastrarLivro/{codigo}";
		
	}
	
	//teste
	
	
}
