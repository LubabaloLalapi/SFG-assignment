package com.eparkingchallan.eparkingchallan;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker//To enable webSocket in our application
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    //To route or send the message received from one client to the other client.
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/lesson");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    //For registering the WebSocket endpoints or API which the client used to connect WebSocket Server
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

}
