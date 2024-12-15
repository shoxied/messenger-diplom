package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chats chat;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false, unique = true)
    private String text;

    @Column(nullable = false, unique = true)
    private OffsetDateTime date;

    @Column(nullable = false, unique = true)
    private boolean is_read;

    @ManyToMany(mappedBy = "messages")
    private List<Tags> tags;

    @ManyToMany(mappedBy = "messages")
    private List<Files> files;
}
