package cadastroAluno.cadastroAluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cadastroAluno.cadastroAluno.model.Aluno;
import cadastroAluno.cadastroAluno.repository.AlunoRepository;
import cadastroAluno.cadastroAluno.service.AlunoService;



@Controller
public class AlunoControllerMono {

	@Autowired // Objeto sera instanciado e gerenciado pelo Spring Container
	AlunoRepository alunoRepository;
	
	

	@RequestMapping("/")
	public ModelAndView listarAlunoMetodo() {
		
		ModelAndView modelAndViewAluno = new ModelAndView("listarAluno");
		Iterable<Aluno> alunos = alunoRepository.findAll();
		
		
		
		modelAndViewAluno.addObject("alunos", alunos);
		
		
		return modelAndViewAluno;
	}
	
	@RequestMapping("/cadastrarAluno")
	public String cadastrarAlunoMetodo() {
		
		return "cadastrarAluno";
	}
	
	
	@RequestMapping(value="/cadastrarAluno", method=RequestMethod.POST)
	public String cadastrarAlunoMetodoPost(Aluno aluno) {
		
		
		AlunoService alunoService = new AlunoService();
		
		aluno.setValorBolsa(alunoService.calcularBolsa(aluno.getQtdHora(), aluno.getValorHora()));
		
		alunoRepository.save(aluno);
		
		
		
		return "redirect:/";
	}
	
	@RequestMapping("/deletarAluno")
	public String deletarAluno(long codigo) {
		Aluno aluno = alunoRepository.findById(codigo);
		
		alunoRepository.delete(aluno);
		
		return "redirect:/";
	}
	
	@RequestMapping(value ="/{codigo}", method = RequestMethod.GET)
	public ModelAndView editarAlunoMetodo(@PathVariable("codigo") long codigo) {
		Aluno aluno = alunoRepository.findById(codigo);
		ModelAndView modelAndViewAluno = new ModelAndView("editarAluno");
		modelAndViewAluno.addObject("aluno", aluno);
		
		
		return modelAndViewAluno;
		
	}
	
	
	@RequestMapping(value ="/{codigo}", method = RequestMethod.POST)
	public String editarAlunoPost(Aluno aluno) {
		
		
		AlunoService alunoService = new AlunoService();
		
		aluno.setValorBolsa(alunoService.calcularBolsa(aluno.getQtdHora(), aluno.getValorHora()));
		
		alunoRepository.save(aluno);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
}
