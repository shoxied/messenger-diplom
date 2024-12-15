package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Chats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private ChatType chat_type;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id", nullable = false)
    private Users creator;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "chats")
    private List<Space> spaces;

    @ManyToMany(mappedBy = "chats")
    private List<UserChatGroups> userChatGroups;

    @ManyToMany
    @JoinTable(
            name = "chat_members",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Users> users;
}
