package prometheus.KhuT.Config;

/**
 * @author : sblim
 * @version : 1.0.0
 * @package : com.karim.jwt.config
 * @name : spring-basic-server
 * @date : 2023. 04. 26. 026 오후 2:24
 * @modifyed :
 * @description :
 **/

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import prometheus.KhuT.jwt.JwtAccessDeniedHandler;
import prometheus.KhuT.jwt.JwtAuthenticationEntryPoint;
import prometheus.KhuT.jwt.JwtSecurityConfig;
import prometheus.KhuT.jwt.TokenProvider;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true) // @PreAuthorize을 메소드 단위로 추가하기 위해 적용
public class SecurityConfig {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    // PasswordEncoder는 BCryptPasswordEncoder를 사용
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // token을 사용하는 방식이기 때문에 csrf를 disable합니다.
                .csrf().disable()

                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                // 세션을 사용하지 않기 때문에 STATELESS로 설정
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeHttpRequests() // HttpServletRequest를 사용하는 요청들에 대한 접근제한을 설정하겠다.
                .requestMatchers("/api/authenticate").permitAll() // 로그인 api
                .requestMatchers("/api/signup").permitAll() // 회원가입 api
                .requestMatchers("/api/access-token").permitAll()
                .anyRequest().authenticated() // 그 외 인증 없이 접근X

                .and()
                .apply(new JwtSecurityConfig(tokenProvider)); // JwtFilter를 addFilterBefore로 등록했던 JwtSecurityConfig class 적용

        return httpSecurity.build();
    }

}
