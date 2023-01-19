package cadastroAluno.cadastroAluno.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cadastroAluno.cadastroAluno.model.Aluno;
import cadastroAluno.cadastroAluno.repository.AlunoRepository;
import cadastroAluno.cadastroAluno.service.AlunoService;


@RestController//é um controller
@RequestMapping("/api")
@CrossOrigin
public class AlunoController {
	
	@Autowired // Objeto sera instanciado e gerenciado pelo Spring Container
	AlunoRepository alunoRepository;
	
	// Metodo Get ou seja realizar consulta
	
	@GetMapping("/alunos")
	public List<Aluno> listarAlunos(){
		List<Aluno> listaAlunos = (List<Aluno>) alunoRepository.findAll(); 
		return listaAlunos;
	}
	
	@PostMapping("/cadastraAluno")
	public void cadastrarAluno(@RequestBody Aluno aluno) {
		
		AlunoService alunoService = new AlunoService();
		
		aluno.setValorBolsa(alunoService.calcularBolsa(aluno.getQtdHora(), aluno.getValorHora()));
		alunoRepository.save(aluno);
	}
	 
	@GetMapping("/aluno/{codigo}")
	public Aluno procurarAluno(@PathVariable long codigo) {
		
		Aluno aluno = alunoRepository.findById(codigo);
		
		return aluno;
	}
	
	@DeleteMapping("/alunoDeletar/{codigo}")
	public void deletarAluno(@PathVariable long codigo) {
		Aluno aluno = alunoRepository.findById(codigo);
		
		alunoRepository.delete(aluno);
		
		
	}
	
	@PutMapping("/editarAluno")
	public void editarAluno(@RequestBody Aluno aluno) {
		
		alunoRepository.save(aluno);
		
	}
	
	
}
