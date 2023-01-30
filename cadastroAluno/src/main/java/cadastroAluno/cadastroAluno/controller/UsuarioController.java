package cadastroAluno.cadastroAluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cadastroAluno.cadastroAluno.model.Aluno;
import cadastroAluno.cadastroAluno.model.Usuario;
import cadastroAluno.cadastroAluno.repository.UsuarioRepository;
import cadastroAluno.cadastroAluno.service.AlunoService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@RequestMapping("/cadastroUsuario")
	public String cadastrarUsuarioMetodo() {
		
		return "cadastrarUsuario";
	}
	
	@RequestMapping(value="/cadastroUsuario", method=RequestMethod.POST)
	public String cadastrarUsuarioMetedo(Usuario usuario) {
		
		
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		
		
		usuarioRepository.save(usuario);
		
		
		return "redirect:/gerenciarUsuario";
	}
	
	
	@RequestMapping("/gerenciarUsuario")
	public ModelAndView cadastrarUsuarioGet() {
		
		ModelAndView modelAndViewUsuario = new ModelAndView("gerenciarUsuario");
		Iterable<Usuario> usuarios = usuarioRepository.findAll();
		
		
		
		modelAndViewUsuario.addObject("usuarios", usuarios);
		
		
		return modelAndViewUsuario;
		
		
	}
	
	
	@RequestMapping("/deletarUsuario")
	public String deletarUsuario(String login) {
		Usuario usuario = usuarioRepository.findByLogin(login);
		
		usuarioRepository.delete(usuario);
		
		return "redirect:/gerenciarUsuario";
	}
	
	
	@RequestMapping(value ="usuarioEditar/{login}", method = RequestMethod.GET)
	public ModelAndView editarUsuarioGet(@PathVariable("login") String login) {
		
		Usuario usuario = usuarioRepository.findByLogin(login);
		ModelAndView modelAndViewUAndView = new ModelAndView("editarUsuario");
		modelAndViewUAndView.addObject("usuario", usuario);
		
		
		return modelAndViewUAndView;
	}
	
	
	@RequestMapping(value ="usuarioEditar/{login}", method = RequestMethod.POST)
	public String editarUsuarioPost(Usuario usuario) {
		
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		
		
		usuarioRepository.save(usuario);
		
		
		return "redirect:/gerenciarUsuario";
	}
	
	
	
	
	
	
	
	
}
