package org.example.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests((auth)-> auth
                .requestMatchers("/hello/**").permitAll().anyRequest()
                .authenticated()).httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
  public   UserDetailsService users()
    {
        UserDetails user = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("Pass"))
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(user);


    }


@Bean
    public PasswordEncoder passwordEncoder()
{
    return new BCryptPasswordEncoder();
}


}
