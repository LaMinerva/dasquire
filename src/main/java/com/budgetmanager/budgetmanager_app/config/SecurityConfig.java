package com.budgetmanager.budgetmanager_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
            .csrf(csrf -> csrf.ignoringRequestMatchers("/accedi"))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/","/registrati", "/error","/accedi","/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/accedi")
                .loginProcessingUrl("/accedi")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/dashboard", true)
                .failureUrl("/accedi?error")
                .permitAll()
            )
            .logout(l -> l.logoutUrl("/logout").logoutSuccessUrl("/accedi?logout"));

        return http.build();    
    }

   @Bean
   public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
   } 

   @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
    return web -> web.debug(true);
}

}