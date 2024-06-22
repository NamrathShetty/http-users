package com.example.http_users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.example.http_users.http.UserHttpClient;

@SpringBootApplication
public class HttpUsersApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext apc = SpringApplication.run(HttpUsersApplication.class, args);
		for(String s : apc.getBeanDefinitionNames()) {
			System.out.println(s);
		}
	}


	@Bean
	UserHttpClient userHttpClient() {

		RestClient restClient = RestClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHttpClient.class);
	}
}
