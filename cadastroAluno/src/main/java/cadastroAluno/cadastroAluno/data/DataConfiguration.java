package cadastroAluno.cadastroAluno.data;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration// Indico para o Spring Container que essa é uma classe de configuração
public class DataConfiguration {

	@Bean// Esse metodo vai ser gerenciado(instanciado, "chamado") pelo Spring Container
	public DataSource dataSource() {
		DriverManagerDataSource driveBanco = new DriverManagerDataSource(); // Cria o drive que recebe os paremetros de conexão com o banco
		driveBanco.setDriverClassName("com.mysql.cj.jdbc.Driver");// Indica qual drive sera usado para a conexão com o banco
		driveBanco.setUrl("jdbc:mysql://localhost:3306/db_aluno");// Inidia a url para acessar o banco
		driveBanco.setUsername("root");// usuario do banco
		driveBanco.setPassword("root");// senha do banco
		
		return driveBanco;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();// Objeto que recebe os parametros de configuração do Hibernate
		
		adapter.setDatabase(Database.MYSQL);//Indica qual banco o hiberta irá usar
		adapter.setShowSql(true);// Informa que o os scripts SQLs serão apresentados no console
		adapter.setGenerateDdl(true);// Gera a tabela das entidades no banco de dados automaticamente
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");// Inidico o dialeto do banco de dados
		
		adapter.setPrepareConnection(true);
		
		
		
		return adapter;
	}
	
	
	
	
}
