package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private int priority;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false)
    private Users author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "executor_id")
    private Users executor;

    @Column(nullable = false)
    private OffsetDateTime create_date;

    @Column(nullable = false)
    private OffsetDateTime deadline;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Commentaries> commentaries = new ArrayList<>();

    @PrePersist
    public void preUpdate() {
        if (commentaries != null) {
            commentaries.forEach(commentaries -> commentaries.setTask(this));
        }
    }

    @ManyToMany(mappedBy = "tasks")
    private List<Space> spaces;
}
