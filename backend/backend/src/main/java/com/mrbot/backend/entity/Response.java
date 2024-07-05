package com.mrbot.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data //para no hacer get/set
@Entity
@Table(name="tbl_response")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Content cannot be null")
    @Column(unique = true)
    private String content;

    @ManyToMany(mappedBy = "responses", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Input> inputs = new HashSet<>();
}
