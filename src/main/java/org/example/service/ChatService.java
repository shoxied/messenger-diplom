package org.example.service;

import org.example.entity.Chats;

public interface ChatService {

    Chats createChat(String name, String description);
}
