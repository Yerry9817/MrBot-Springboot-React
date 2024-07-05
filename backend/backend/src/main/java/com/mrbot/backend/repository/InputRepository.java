package com.mrbot.backend.repository;

import com.mrbot.backend.entity.Input;
import com.mrbot.backend.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<Input, Long> {

    Input findByContent(String content);

    @Query("SELECT i.responses FROM Input i WHERE i.content = :content")
    Response findResponsesByInputContent(@Param("content") String content);
}
