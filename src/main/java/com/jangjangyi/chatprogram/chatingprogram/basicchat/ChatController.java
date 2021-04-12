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
    private final SimpMessageSendingOperations messagingTemplate;


    @MessageMapping("/chat/message")
    public void message(ChatMessage chatMessage) {
        System.out.println(chatMessage.getSender());
        System.out.println("-------------------");
        System.out.println(chatMessage.getType());
        System.out.println("-------------------");
        if (chatMessage.getType().equals(ChatMessage.MessageType.JOIN.toString()))
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장하셨습니다.");
        System.out.println(chatMessage.getMessage());
        messagingTemplate.convertAndSend("/sub/chat/room/" + chatMessage.getRoomId(), chatMessage);

    }
}
