package com.secutity.securityprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class SecurityPrjApplicationBasicAuth {
        @GetMapping("/login")
        public String showLoginPage() {
            return "login";
        }

    @GetMapping("/register")
    public String welcomeRegis(){
        return  "login";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String welcomeSecured(){
        return  "admin";
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityPrjApplicationBasicAuth.class, args);
    }

}
