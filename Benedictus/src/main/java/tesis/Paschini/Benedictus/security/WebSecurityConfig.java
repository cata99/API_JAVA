package tesis.Paschini.Benedictus.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tesis.Paschini.Benedictus.security.jwt.AuthEntryPointJwt;
import tesis.Paschini.Benedictus.security.jwt.AuthTokenFilter;
import tesis.Paschini.Benedictus.security.services.UserDetailsServiceImpl;


@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true)
public class WebSecurityConfig {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/**").permitAll()
                /*TODO esto se descomenta para despues
                //Authentication controller
                .authorizeRequests().antMatchers("/api/auth/signin").permitAll()
                .antMatchers(HttpMethod.POST,"/api/signup").permitAll()
                //Attribute Controller
                .antMatchers("/api/attributes/**").permitAll()
                //Authority Controller
                .antMatchers("/api/authorities/**").permitAll()
                // Delivery Controller
                .antMatchers(HttpMethod.GET, "/api/deliveries/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/deliveries/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/deliveries/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/deliveries/**").hasRole("ADMIN")
                //Disease Controller
                .antMatchers("/api/diseases/**").permitAll()
                // Donation Controller
                .antMatchers(HttpMethod.GET, "/api/donations/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/donations/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/donations/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/donations/**").hasRole("ADMIN")
                // Donation Product Controller
                .antMatchers(HttpMethod.GET, "/api/donations_products/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/donations_products/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/donations_products/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/donations_products/**").hasRole("ADMIN")
                // Group Controller
                .antMatchers(HttpMethod.GET, "/api/groups/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/groups/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/groups/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/groups/**").hasRole("ADMIN")
                // Institution Controller
                .antMatchers(HttpMethod.GET, "/api/institutions/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/institutions/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/institutions/**").hasAnyRole("ADMIN", "REFERENTE")
                .antMatchers(HttpMethod.DELETE,"/api/institutions/**").hasRole("ADMIN")
                // Institution Disease Controller
                .antMatchers("/api/institutions_disease/**").permitAll()
                //Life Event Controller
                .antMatchers("/api/life_events/**").permitAll()
                // Personal Information Controller
                .antMatchers(HttpMethod.GET,"/api/personal_information/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/personal_information/{\\d+}").hasAnyRole("REFERENTE", "ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/personal_information/{\\d+}").hasAnyRole("REFERENTE", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/personal_information/{\\d+}").hasAnyRole("REFERENTE", "ADMIN")
                // Product Controller
                .antMatchers("/api/products/**").permitAll()
                // Product Type Controller
                .antMatchers("/api/product_types/**").permitAll()
                // Reports Controller
                .antMatchers(HttpMethod.GET,"/api/reports/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/reports/{\\d+}").hasAnyRole("REFERENTE", "ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/reports/{\\d+}").hasAnyRole("REFERENTE", "ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/reports/{\\d+}").hasRole( "ADMIN")
                // Users Controller
                .antMatchers(HttpMethod.GET, "/api/users/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/users/**").hasRole("ADMIN")*/

                .anyRequest().authenticated();

        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}