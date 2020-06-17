package pe.edu.upc.mTradePlus.model.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsuarioDetailsService usuarioDetailsService;
	
	@Autowired
	private LoggingAccessDeniedHandler loggingAccessDeniedHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		http
			.authorizeRequests()
				.antMatchers("/mTradePlus/index.html").permitAll()
				.antMatchers("/mTradePlus/landing").permitAll()
				.antMatchers("mTradePlus/producto").permitAll()
				//CLIENTE
				.antMatchers("/mTradePlus/compra").authenticated()
				.antMatchers("/mTradePlus/compra/nuevo").hasAuthority("ACCESS_ADDCOMPRA")
				.antMatchers("/mTradePlus/compra/eliminarCompra/**").hasAuthority("ACCESS_DELCOMPRA")
				//VENDEDOR
				.antMatchers("/mTradePlus/producto/nuevo").hasAuthority("ACCESS_ADDPRODUCTO")
				.antMatchers("/mTradePlus/producto/editarProducto/**").hasAuthority("ACCESS_EDITPRODUCTO")
				.antMatchers("/mTradePlus/producto/eliminarProducto/**").hasAuthority("ACCESS_DELTPRODUCTO")
				//ADMIN
				.antMatchers("/mTradePlus/cliente").hasRole("ADMINISTRADOR")
				.antMatchers("/mTradePlus/vendedor").hasRole("ADMINISTRADOR")
			.and()
			.formLogin()
				.loginProcessingUrl("/signin")
				.loginPage("/mTradePlus/login")
				.usernameParameter("inputUsername")
				.passwordParameter("inputPassword")
			.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/mTradePlus")
			.and()
			.rememberMe()
				.tokenValiditySeconds(2592000)
				.key("Cl4v3.")
				.rememberMeParameter("checkRememberMe")
				.userDetailsService(usuarioDetailsService)
			.and()
				.exceptionHandling()
				.accessDeniedHandler(loggingAccessDeniedHandler);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//AQUI SE CREA EL VINCULO ENTRE EL SPRING SECURITY Y: EL PASSWORDENCODER Y USUARIODETAILSSERVICE
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.usuarioDetailsService);
		return daoAuthenticationProvider;
	}
	
}
