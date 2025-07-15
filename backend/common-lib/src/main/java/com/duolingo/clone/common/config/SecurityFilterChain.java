//package com.duolingo.clone.common.config;
//
//import com.duolingo.clone.common.security.ClerkAuthenticationFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Bean
//public org.springframework.security.web.SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    return http
//            .csrf(csrf -> csrf.disable())
//            .authorizeHttpRequests(auth -> auth
//                    .requestMatchers("/api/public/**").permitAll()
//                    .anyRequest().authenticated()
//            )
//            .formLogin(AbstractHttpConfigurer::disable) //  Disable form login
//            .httpBasic(AbstractHttpConfigurer::disable) //  Disable basic auth (nếu không dùng)
//            .addFilterBefore(new ClerkAuthenticationFilter(clerkPublicKey), UsernamePasswordAuthenticationFilter.class)
//            .build();
//}