package com.mrbot.backend.repository;

import com.mrbot.backend.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
    Optional<Response> findByContent(String content);
}
