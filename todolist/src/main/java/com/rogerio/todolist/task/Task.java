package com.rogerio.todolist.task;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import java.util.UUID;

@Entity(name = "tb_tasks")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String priority;

    @Column(nullable = false)
    private LocalDateTime startAt;

    @Column(nullable = false)
    private LocalDateTime endsAt;

    private UUID userId;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creatAt;




    public void setTitle(String title) throws Exception {
        if (title.length() > 50) {
            throw new Exception("The title field must contain a maximum of 50 characters");
        }
        this.title = title;
    }

}
