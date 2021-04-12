package com.jangjangyi.chatprogram.chatingprogram.basicchat;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final RedisPublisher redisPublisher;
    private final ChatRoomRepository chatRoomRepository;

    /**
     * websocket "/pub/chat/message"로 들어오는 메시지를 처리한다.
     */

    @MessageMapping("/chat/message")
    public void message(ChatMessage chatMessage) {
        if (chatMessage.getType().equals(ChatMessage.MessageType.JOIN.toString())) {
            chatRoomRepository.enterChatRoom(chatMessage.getRoomId());
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장하셨습니다.");
        }
        //websocket에 발행된 메시지를 redis로 발행한다.(publish)
        redisPublisher.publish(chatRoomRepository.getTopic(chatMessage.getRoomId()), chatMessage);


    }
}
