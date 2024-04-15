package psu.edu.Final.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = 
				new JdbcUserDetailsManager(dataSource);
		
		//define query to retrieve a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(				
				"SELECT user_id, pw, active FROM members WHERE user_id=?"				
				);
		
		//define query to retrieve authorities/roles by username
				jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(				
						"SELECT user_id, role FROM roles WHERE user_id=?"				
						);		
		
		return jdbcUserDetailsManager; 		
	}	
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	http.authorizeHttpRequests(configurer ->
    	configurer
    				.requestMatchers("/").hasRole("EMPLOYEE") // for viewing their own details, allow other roles to see other people
    				.requestMatchers("/employeeModify/**").hasRole("MANAGER") //managers can update information and create new people but CANNOT delete.
    				.requestMatchers("/employeeCreate/**").hasRole("ADMIN") //admins are the only one that can delete and create employees.
    				.anyRequest().authenticated()							//remember deletion is moving them to another table we DONT want to lose that data.
    			)
    			.formLogin(form ->
    					form
    						.loginPage("/login")
    						.loginProcessingUrl("/authenticateTheUser")
    						.permitAll()
    			)
    			.logout(logout -> logout.permitAll()    					
    			)
    			.exceptionHandling(configurer ->
    						configurer.accessDeniedPage("/access-denied")		
    					
    					);
    	
    	return http.build();
    }
    
	
}
