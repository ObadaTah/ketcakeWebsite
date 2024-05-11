// package ps.ketcake.website;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

// // roles admin allow to access /admin/**
// // roles user allow to access /user/**
// // custom 403 access denied handler
// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
// throws Exception {

// httpSecurity.csrf(AbstractHttpConfigurer::disable)

// .authorizeHttpRequests(authorizeRequests -> authorizeRequests

// .requestMatchers("/login").permitAll()
// .requestMatchers("/actuator/**").permitAll()
// .requestMatchers("/assets/**").permitAll()

// .anyRequest().authenticated())

// .formLogin(loginConfig -> {
// loginConfig.loginPage("/login").permitAll();
// loginConfig.loginProcessingUrl("/loginProccessing").permitAll();
// loginConfig.successForwardUrl("/admin");
// loginConfig.usernameParameter("username");
// loginConfig.passwordParameter("password");
// });
// return httpSecurity.build();
// }

// // create two users, admin and user
// @Autowired
// public void configAuthentication(AuthenticationManagerBuilder auth) throws
// Exception {

// auth.inMemoryAuthentication()
// .withUser("user").password("password").roles("USER")
// .and()
// .withUser("admin").password("password").roles("ADMIN");
// }
// }