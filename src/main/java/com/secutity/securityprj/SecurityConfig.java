package com.secutity.securityprj;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}



























//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth->{
//            auth.requestMatchers("/login","/register").permitAll();
//            auth.requestMatchers("/admin/**").authenticated();
////            auth.requestMatchers("/admin/**").hasAnyRole("ADMIN");
//        });
//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    CommandLineRunner initDatabase(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder encoder) {
//        return args -> {
//            Role adminRole = new Role(); adminRole.setName("ROLE_ADMIN");
//            Role userRole = new Role(); userRole.setName("ROLE_USER");
//            roleRepo.saveAll(List.of(adminRole, userRole));
//
//            User admin = new User();
//            admin.setUsername("admin");
//            admin.setPassword(encoder.encode("admin123"));
//            admin.setRoles(Set.of(adminRole));
//            userRepo.save(admin);
//        };
//    }
//
//}






















//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/login", "/register").permitAll()
//                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login").permitAll()
//                )
//                .logout(logout -> logout.permitAll());
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
















//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth->{
//            auth.requestMatchers("/login","/register").permitAll();
//            auth.requestMatchers("/admin/**").authenticated();
////            auth.requestMatchers("/admin/**").hasAnyRole("ADMIN");
//        });
//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    CommandLineRunner initDatabase(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder encoder) {
//        return args -> {
//            Role adminRole = new Role(); adminRole.setName("ROLE_ADMIN");
//            Role userRole = new Role(); userRole.setName("ROLE_USER");
//            roleRepo.saveAll(List.of(adminRole, userRole));
//
//            User admin = new User();
//            admin.setUsername("admin");
//            admin.setPassword(encoder.encode("admin123"));
//            admin.setRoles(Set.of(adminRole));
//            userRepo.save(admin);
//        };
//    }
//
//}