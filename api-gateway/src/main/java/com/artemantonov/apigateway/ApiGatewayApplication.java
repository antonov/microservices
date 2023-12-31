package com.artemantonov.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
		serverHttpSecurity
				.csrf().disable()
				.authorizeExchange(exchange ->
						exchange.pathMatchers("/eureka/**")
								.permitAll()
								.anyExchange()
								.authenticated())
				.oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
		return serverHttpSecurity.build();
	}
}
