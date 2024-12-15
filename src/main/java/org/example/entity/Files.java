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
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String file_url;

    @ManyToMany
    @JoinTable(
            name = "file_messages",
            joinColumns = @JoinColumn(name = "file_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id"))
    private List<Users> users;

    @ManyToMany
    @JoinTable(
            name = "description_file",
            joinColumns = @JoinColumn(name = "file_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> task;

    @ManyToMany
    @JoinTable(
            name = "commentary_file",
            joinColumns = @JoinColumn(name = "file_id"),
            inverseJoinColumns = @JoinColumn(name = "commentary_id"))
    private List<Commentaries> commentaries;
}
