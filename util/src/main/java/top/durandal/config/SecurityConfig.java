package top.durandal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailService customUserDetailService;
    @Resource
    SuccessHandler successHandler;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        return new JwtAuthenticationFilter(authenticationManager());
    }

    /**
     * 将Spring security设置成可以接收json用户名密码的登录验证的过滤器
     * @return
     * @throws Exception
     */
    @Bean
    public UserAuthenticationFilter userAuthenticationFilter() throws Exception {
        UserAuthenticationFilter userAuthenticationFilter = new UserAuthenticationFilter();
        userAuthenticationFilter.setAuthenticationManager(super.authenticationManager());
        userAuthenticationFilter.setAuthenticationSuccessHandler(successHandler);
        return userAuthenticationFilter;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/user/login").permitAll()
//                .antMatchers("/user/save").permitAll()
//                .antMatchers("/user/change").permitAll()
//                .antMatchers("/user/ban")
//                //.hasRole("ROLE_SYS")
//                .permitAll()
//                .antMatchers("/user/relieve").permitAll()
                .anyRequest().authenticated()
                .and()
                .cors()
                .and()
                .addFilter(jwtAuthenticationFilter())
                .addFilter(userAuthenticationFilter())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().successHandler(successHandler);
                //.permitAll()
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }
}
