package com.jangjangyi.chatprogram.chatingprogram.stompchat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
/*
    Stomp를 사용하기 위해 @EnalbeWebSocketMessageBroker을 선언하고 WebSocketMessageBrokerConfigurer를 상속
    받아 configureMessageBroker를 구현합니다. pub/sub 메시징을 구현하기 위해 메시지를 발행하는 요청의 prefix는
    /pub로 시작하도록 설정하고 메시지를 구독하는 요청의 prefix는 /sub로 시작하도록 설정.
    그리고 stomp websocket의 연결 endpoint는 /ws-stomp로 설정합니다. 따라서 개발서버의 접속 주소는 다음과 같이 됩니다.
    ws://localhost:8080/ws-stomp
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSockConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub");
        registry.setApplicationDestinationPrefixes("/pub");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp").setAllowedOrigins("*")
                .withSockJS();
    }
}
