// package ps.ketcake.website;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Description;
// import org.thymeleaf.spring6.SpringTemplateEngine;

// @org.springframework.context.annotation.Configuration
// public class Configuration {
// @Bean
// @Description("Thymeleaf Template Resolver")
// public ServletContextTemplateResolver templateResolver() {
// ServletContextTemplateResolver templateResolver = new
// ServletContextTemplateResolver();
// templateResolver.setPrefix("/WEB-INF/views/");
// templateResolver.setSuffix(".html");
// templateResolver.setTemplateMode("HTML5");

// return templateResolver;
// }

// @Bean
// @Description("Thymeleaf Template Engine")
// public SpringTemplateEngine templateEngine() {
// SpringTemplateEngine templateEngine = new SpringTemplateEngine();
// templateEngine.setTemplateResolver(templateResolver());
// templateEngine.setTemplateEngineMessageSource(messageSource());
// return templateEngine;
// }
// }
