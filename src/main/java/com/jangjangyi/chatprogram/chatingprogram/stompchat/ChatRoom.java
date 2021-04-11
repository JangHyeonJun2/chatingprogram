package com.jangjangyi.chatprogram.chatingprogram.stompchat;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/*
    pub/sub방식을 이용하면 구독자 관리가 알아서 되므로 웹소켓 세션 관리가 필요 없다. 또한 방송의 구현도 알아서 해결되므로 일일이 클라이언트들에게
    메세지를 방송하는 구현이 필요 없어진다. 따라서 채팅방 DTO는 저번 DTO보다 간소화된다.
 */
@Getter
@Setter
public class ChatRoom {
    private String roomId;
    private String name;

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
}
