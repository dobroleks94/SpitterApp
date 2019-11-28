package springapp.spittr.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER").and()
                .withUser("dobroshtan").password("{noop}oleksii").roles("SPITTER").and()
                .withUser("jason").password("{noop}bulinin").authorities("ROLE_SPITTER");*/
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin().loginPage("/login").permitAll()
            .and()
            .logout().logoutSuccessUrl("/").logoutUrl("/signout")
            .and()
            .authorizeRequests()
                .antMatchers("/spitter/me").access("hasRole('ROLE_SPITTER')")
                .antMatchers("/", "/**").access("permitAll()")
            .and()
            .requiresChannel()
                .antMatchers("/spitter/form").requiresSecure()
            .and()
                .rememberMe()
                .tokenValiditySeconds(2419200)
                .key("spittrKey")
            .and()
                .csrf().disable();

    }

    /*@Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/assets/**","/fonts/**","/dis/**","/vendor1/**");
    }*/
}
