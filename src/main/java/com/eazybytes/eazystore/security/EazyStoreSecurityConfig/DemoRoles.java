//package com.eazybytes.eazystore.security.EazyStoreSecurityConfig;
//
//import org.jspecify.annotations.NonNull;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class DemoRoles {
//    @Bean
//    public SecurityFilterChain filterchain(@NonNull HttpSecurity http) throws Exception {
//        http.csrf(csrf-> csrf.disable());
//
//        http.authorizeHttpRequests(requests->
//           requests.requestMatchers("HttpMethod.GET", "/swagger-ui/**").hasRole("EMPLOYEE").
//           requestMatchers("HttpMethod.GET", "/actuator/**").hasAnyRole("EMPLOYEE", "ADMIN").
//           anyRequest().authenticated()
//        );
//        http.httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//    @Bean
////    public InMemoryUserDetailsManager
//    public UserDetailsService userDetailsManager() {
//        UserDetails john = User.builder().username("john").roles("EMPLOYEE").password("{noop}abc").build();
//        UserDetails admin = User.builder().username("admin").roles("ADMIN").password("{noop}abc").build();
//        return new InMemoryUserDetailsManager(john, admin);
//    }
//}
