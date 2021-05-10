package shop.parkkibeom.api.security.config;

import shop.parkkibeom.api.security.aop.SecurityFilter;
import shop.parkkibeom.api.security.domain.SecurityProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// 필터
@RequiredArgsConstructor
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final SecurityProvider provider;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        SecurityFilter filter = new SecurityFilter(provider);
        // Controller Request 들어오기 전에 얘를 찾아라
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
