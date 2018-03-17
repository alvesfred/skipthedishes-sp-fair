package br.sp.fair.fredericoalves.skipthedishes.auth;

/**
 * Web Security
 *
 * @author frederico.alves
 *
 */
// TODO
//@Configuration
public class SecurityConfig { //extends WebSecurityConfigurerAdapter {
/*
	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("fred").password("fred")
				.roles("USER").and().withUser("admin").password("admin")
				.roles("USER", "ADMIN");
	}

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/api/**")
				.hasRole("USER").antMatchers("/api/**").hasRole("USER")
				.antMatchers("/**").hasRole("ADMIN").and().csrf().disable()
				.headers().frameOptions().disable();
	}
*/
}
