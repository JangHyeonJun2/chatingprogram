package com.jangjangyi.chatprogram.chatingprogram.stompchat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    //메시지 타입 : 입장, 채팅
    public enum MessageType {
        ENTER, TALK, JOIN
    }

    private String type; //메세지 타입
    private String roomId; // 방 번호
    private String sender;  // 메시지 보낸사람
    private String message; // 메시지
}