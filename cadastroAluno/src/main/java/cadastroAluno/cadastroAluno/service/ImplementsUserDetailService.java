package cadastroAluno.cadastroAluno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import cadastroAluno.cadastroAluno.model.Usuario;
import cadastroAluno.cadastroAluno.repository.UsuarioRepository;

@Repository
public class ImplementsUserDetailService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByLogin(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não existe");
			
		}
		
		
		return usuario;
	}

}
