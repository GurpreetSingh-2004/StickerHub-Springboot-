package com.eazybytes.eazystore.security.EazyStoreSecurityConfig;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class EazyStoreSecurityConfig {

    private final List<String> publicPathConfig;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(@NonNull HttpSecurity http) throws Exception{
        http.csrf((csrfConfig)->csrfConfig.disable())
                .cors(corsConfig->corsConfig.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests((requests)->{
                publicPathConfig.forEach(path ->
                        requests.requestMatchers(path).permitAll()
                        );
                requests.anyRequest().authenticated();
                }
        );

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());

        return http.build();
    }
// Users created in inMemory
    @Bean
    public UserDetailsService userDetailsService() {
        var user1 = User.builder().username("Gurpreet").password("{noop}show").roles("USER").build();//change needed
        var user2 = User.builder().username("admin").password("{noop}show").roles("USER", "ADMIN").build();//change needed
        return new InMemoryUserDetailsManager(user1, user2);
    }
// Password Encoder for the password entered by the user(already registered user)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
