package bg.softuni.pochivkarest.config;

import bg.softuni.pochivkarest.model.enums.UserRoles;
import bg.softuni.pochivkarest.repository.UserRepository;
import bg.softuni.pochivkarest.service.PochivkaUserDetailsService;
import jakarta.servlet.Filter;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.web.servlet.server.CookieSameSiteSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfiguration {

    //Here we have to expose 3 things:
    // 1. PasswordEncoder
    // 2. SecurityFilterChain
    // 3. UserDetailsService

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.cors().
//                and().
//                csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).
//                and().
//                authorizeHttpRequests((requests) -> requests
//                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations(),
//                                new AntPathRequestMatcher("/"),
//                                new AntPathRequestMatcher("/home"),
//                                new AntPathRequestMatcher("/search"),
//                                new AntPathRequestMatcher("/search-sea"),
//                                new AntPathRequestMatcher("/search-mountain"),
//                                new AntPathRequestMatcher("/search-ai"),
//                                new AntPathRequestMatcher("/hotel-detail/*"),
//                                new AntPathRequestMatcher("/search-rest"),
//                                new AntPathRequestMatcher("/accommodation"),
//                                new AntPathRequestMatcher("/comfort"),
//                                new AntPathRequestMatcher("/category"),
//                                new AntPathRequestMatcher("/town"),
//                                new AntPathRequestMatcher("/csrf")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/login"),
//                                new AntPathRequestMatcher("/register"),
//                                new AntPathRequestMatcher("/login-rest")).anonymous()
//                        .anyRequest().authenticated());

        // define which requests are allowed and which not
//                        authorizeHttpRequests().
//                // everyone can download static resources (css, js, images)
//                        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
//                // everyone can login and register
//                        requestMatchers("/login", "/register").anonymous().
//                        requestMatchers("/", "/home", "/search", "/search-sea", "/search-mountain",
//                                "/search-ai", "/hotel-detail/*").permitAll().
//                // pages available only for moderators
//                        requestMatchers("/pages/moderators").hasRole(UserRoles.MODERATOR.name()).
//                // pages available only for admins
//                        requestMatchers("/pages/admins/**").hasRole(UserRoles.ADMINISTRATOR.name()).
//                // all other pages are available for logger in users
//                        anyRequest().
//                authenticated().

        // configuration of form login
//        formLogin().
//                // the custom login form
//                        loginPage("/login-rest").
//                // the name of the username form field
//                        usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
//                // the name of the password form field
//                        passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
//                // where to go in case that the login is successful
//                        defaultSuccessUrl("/").
//                // where to go in case that the login failed
//                        failureForwardUrl("/users/login-error").
//                and().
//                // configure logout
//                        logout().
//                // which is the logout url
//                        logoutUrl("/logout").
//                logoutSuccessUrl("/").
//                // invalidate the session and delete the cookies
//                        invalidateHttpSession(true).
//                deleteCookies("JSESSIONID");


//        return http.build();
//    }

//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepository) {
//        return new PochivkaUserDetailsService(userRepository);
//    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOriginPatterns(List.of("http://localhost:3000/"));
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
//        configuration.setAllowedHeaders(List.of("*"));
//        configuration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//
//    @Bean
//    public CookieSameSiteSupplier applicationCookieSameSiteSupplier() {
//        return CookieSameSiteSupplier.ofNone();
//    }
}
