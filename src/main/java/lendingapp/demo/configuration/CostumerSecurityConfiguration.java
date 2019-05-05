package lendingapp.demo.configuration;

import lendingapp.demo.service.Role;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(100)
@Configuration
public class CostumerSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**")
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/sign-in", "/api/register").permitAll()
                .anyRequest().hasAnyRole(Role.USER.name(), "USER")
                .and().logout().logoutUrl("/api/log-out");
    }
}
