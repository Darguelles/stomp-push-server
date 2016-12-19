package com.verizon.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Value("${routes.endpointRegistry}")
	private String endpointRegistry;

	@Value("${routes.urlsBroker}")
	private String urlsBroker;

	@Value("${routes.applicationPrefix}")
	private String applicationPrefix;

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker(urlsBroker);
		registry.setApplicationDestinationPrefixes(applicationPrefix);
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		stompEndpointRegistry.addEndpoint(endpointRegistry).setAllowedOrigins("*").withSockJS();
	}

}
