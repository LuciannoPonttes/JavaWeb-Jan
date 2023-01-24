package br.impacta.security.br.impacta.security.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;




import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.impacta.security.br.impacta.security.service.ImplementsUserDetailService;

@Configuration
@EnableWebSecurity // Desativa a configuração padrão do Spring Security
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { 
										// Versão antiga, porém muito mais usada


	@Autowired
	private ImplementsUserDetailService implementsUserDetailService;
	
	// Configura os filtros de autenticão das requisições
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http // objeto do tipo HttpSecurity 
			.authorizeRequests() // Autorização para qualquer Requisição 
			.antMatchers("/css/**", "/images/**", "/favicon.ico").permitAll() // Permite acesso as pastas css e images para todos que estão logados
			.anyRequest().authenticated()// Indica que será necessario logar na aplicação 
			.and() // Conexão de instruções
			.formLogin()//Indica que terá uma pagina com formulario de Login
			.loginPage("/login")// Indica a pagina HTML que será usada para o Login
			.defaultSuccessUrl("/index") // Indica a pagina que será apresentada apos a realização do Login
			.permitAll() // Todos os Usuarios logodos possuem permissão para acessar a Index
			.and() // Conexão de instruções
			.logout()//Indica que a aplicação terá logout
			.permitAll();//Permite que todos logados podem fazer logout
			
		
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//auth
			//.inMemoryAuthentication() // Indica que será armezado em memoria(dados do usuario)
			//.withUser("Kate").password("{noop}2023").roles("USER");//Inidica usuario e senha
		
	
		auth
		.userDetailsService(implementsUserDetailService)
		.passwordEncoder(new BCryptPasswordEncoder());
	
	}


}
