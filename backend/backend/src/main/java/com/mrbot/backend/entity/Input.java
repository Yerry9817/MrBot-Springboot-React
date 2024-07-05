package com.mrbot.backend.entity;

import com.fasterxml.jackson.annotation.JsonMerge;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data //para no hacer get/set
@Entity
@Table(name="tbl_input")
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Content cannot be null")
    @Column(unique = true)
    private String content;

    @JsonMerge
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_input_responses",
            joinColumns = @JoinColumn(name = "input_id"),
            inverseJoinColumns = @JoinColumn(name = "response_id"))
    private Set<Response> responses = new HashSet<>();
}
