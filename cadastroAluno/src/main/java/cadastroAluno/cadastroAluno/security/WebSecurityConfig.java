package cadastroAluno.cadastroAluno.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebSecurityConfig {

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http // objeto do tipo HttpSecurity 
		.authorizeRequests() // Autorização para qualquer Requisição 
		.antMatchers("/css/**", "/images/**", "/favicon.ico").permitAll() // Permite acesso as pastas css e images para todos que estão logados
		.anyRequest().authenticated()// Indica que será necessario logar na aplicação 
		.and() // Conexão de instruções
		.formLogin()//Indica que terá uma pagina com formulario de Login
		.loginPage("/login")// Indica a pagina HTML que será usada para o Login
		.defaultSuccessUrl("/") // Indica a pagina que será apresentada apos a realização do Login
		.permitAll() // Todos os Usuarios logodos possuem permissão para acessar a Index
		.and() // Conexão de instruções
		.logout()//Indica que a aplicação terá logout
		.permitAll();//Permite que todos logados podem fazer logout
    return http.build();
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
}
