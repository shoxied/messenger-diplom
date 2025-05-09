package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.ChatType;
import org.example.entity.Chats;
import org.example.service.ChatService;
import org.springframework.stereotype.Service;

import static org.example.entity.ChatType.CHAT;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    @Override
    public Chats createChat(String name, String description) {
        return null;
    }
}
