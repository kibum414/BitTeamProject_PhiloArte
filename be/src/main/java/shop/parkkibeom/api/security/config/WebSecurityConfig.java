package shop.parkkibeom.api.security.config;

import shop.parkkibeom.api.security.domain.SecurityProvider;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// 인터셉터 (Bean 덩어리들 돌아다님)
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final SecurityProvider provider;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // csrf 사용 안 함
        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/users/signin").permitAll() // 토큰이 없지만 예외적으로 접근을 허용하기 위해 (로그인, 회원가입 한 사람들)
                .antMatchers("/users/signup").permitAll()
                .antMatchers("/users/fetch").permitAll()
                .antMatchers("/h2-console/**/**").permitAll() // ant 표기법 (** : 0개 이상의 폴더, * : 0개 이상의 파일)
                .anyRequest().authenticated(); // 나머지 요청들은 인증된 사용자만 접근 허용
        http.exceptionHandling().accessDeniedPage("/login"); // 실패했을 때 뜨는 화면
        http.apply(new SecurityConfig(provider));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "*/**")
                .antMatchers("/", "/h2-console/**");
    }
}
