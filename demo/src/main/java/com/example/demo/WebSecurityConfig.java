//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.access.intercept.AuthorizationFilter;
//
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    Environment environment;
//
//    public WebSecurityConfig(Environment environment) {
//        this.environment = environment;
//    }
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .csrf().disable();
////    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers(HttpMethod.GET,"users-ws/users/status/check")
//                .antMatchers(HttpMethod.POST,"users-ws/users/h2-console/**")
//                .antMatchers(HttpMethod.POST,"users-ws/users/createUser")
//                .antMatchers(HttpMethod.POST,"users-ws/users/login");
//
//        //completely bypass the Spring Security Filter Chain.
//    }
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable();
////        http.headers().frameOptions().disable();
////        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////        http.authorizeRequests()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .addFilter(new AuthorizationFilter(authenticationManager(),environment));
////    }
//}
