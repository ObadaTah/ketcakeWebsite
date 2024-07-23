// config/AuthConfig.java
package ps.ketcake.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(authorize -> authorize
                        // .requestMatchers("/login").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                        .requestMatchers("/styles.css").permitAll()
                        .requestMatchers("/items/**").permitAll()
                        .requestMatchers("/edit-page.js").permitAll()
                        .anyRequest().authenticated()
                // .requestMatchers(HttpMethod.POST, "/admin/**").hasRole("ADMIN")
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    // @Bean
    // AuthenticationManager authenticationManager(AuthenticationConfiguration
    // authenticationConfiguration)
    // throws Exception {
    // return authenticationConfiguration.getAuthenticationManager();
    // }

    // @Bean
    // PasswordEncoder passwordEncoder() {
    // return new BCryptPasswordEncoder();
    // }
}
