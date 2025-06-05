package com.umcspring.umc8thstudy.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        // ─── 여기에 Swagger 관련 경로를 permitAll에 추가 ───
                        .requestMatchers(
                                "/",
                                "/home",
                                "/signup",
                                "/members/signup",
                                "/css/**",
                                "/swagger-ui/**",         // Swagger UI 정적 리소스
                                "/v3/api-docs/**",        // OpenAPI JSON 문서
                                "/swagger-ui.html",       // (필요 시) 예전 버전 호환
                                "/swagger-resources/**",  // (필요 시) springfox 호환
                                "/webjars/**"             // (필요 시) WebJar 리소스
                        ).permitAll()

                        // ADMIN 권한이 필요한 경로
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // 그 외 모든 요청은 인증 필요
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}